/*
 * Copyright 2013-2018 Ray Tsang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jdeferred2.impl;

import org.jdeferred2.*;
import org.jdeferred2.multiple.*;

import java.util.concurrent.atomic.*;

/**
 * @author Andres Almiray
 */
class AbstractMasterDeferredObject extends DeferredObject<MultipleResults, OneReject<?>, MasterProgress> implements Promise<MultipleResults, OneReject<?>, MasterProgress> {
	private final MutableMultipleResults results;
	private final int numberOfPromises;
	private final AtomicInteger doneCount = new AtomicInteger();
	private final AtomicInteger failCount = new AtomicInteger();

	AbstractMasterDeferredObject(MutableMultipleResults results) {
		this.results = results;
		this.numberOfPromises = results.size();
	}

	protected <D, F, P> void configurePromise(final int index, final Promise<D, F, P> promise) {
		promise.fail(new FailCallback<F>() {
			public void onFail(F result) {
				synchronized (AbstractMasterDeferredObject.this) {
					if (!AbstractMasterDeferredObject.this.isPending())
						return;

					final int fail = failCount.incrementAndGet();
					AbstractMasterDeferredObject.this.notify(new MasterProgress(
						doneCount.get(),
						fail,
						numberOfPromises));

					AbstractMasterDeferredObject.this.reject(new OneReject<F>(index, promise, result));
				}
			}
		}).progress(new ProgressCallback<P>() {
			public void onProgress(P progress) {
				synchronized (AbstractMasterDeferredObject.this) {
					if (!AbstractMasterDeferredObject.this.isPending())
						return;

					AbstractMasterDeferredObject.this.notify(new OneProgress<P>(
						doneCount.get(),
						failCount.get(),
						numberOfPromises, index, promise, progress));
				}
			}
		}).done(new DoneCallback<D>() {
			public void onDone(D result) {
				synchronized (AbstractMasterDeferredObject.this) {
					if (!AbstractMasterDeferredObject.this.isPending())
						return;

					results.set(index, new OneResult<D>(index, promise, result));
					int done = doneCount.incrementAndGet();

					AbstractMasterDeferredObject.this.notify(new MasterProgress(
						done,
						failCount.get(),
						numberOfPromises));

					if (done == numberOfPromises) {
						AbstractMasterDeferredObject.this.resolve(results);
					}
				}
			}
		});
	}
}
