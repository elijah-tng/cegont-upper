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
class AllValuesDeferredObject extends DeferredObject<AllValues, Throwable, MasterProgress> implements Promise<AllValues, Throwable, MasterProgress> {
	private final MutableAllValues values;
	private final int numberOfPromises;
	private final AtomicInteger doneCount = new AtomicInteger();
	private final AtomicInteger failCount = new AtomicInteger();

	AllValuesDeferredObject(Promise<?, ?, ?>[] promises) {
		this.numberOfPromises = promises.length;
		this.values = new DefaultMutableAllValues(promises.length);

		for (int i = 0; i < numberOfPromises; i++) {
			configurePromise(i, promises[i]);
		}
	}

	protected <D, F, P> void configurePromise(final int index, final Promise<D, F, P> promise) {
		promise.fail(new FailCallback<F>() {
			public void onFail(F result) {
				synchronized (AllValuesDeferredObject.this) {
					if (!AllValuesDeferredObject.this.isPending())
						return;

					values.set(index, new OneReject<F>(index, promise, result));
					final int fail = failCount.incrementAndGet();
					final int done = doneCount.get();

					AllValuesDeferredObject.this.notify(new MasterProgress(
						doneCount.get(),
						fail,
						numberOfPromises));

					if (fail + done == numberOfPromises) {
						AllValuesDeferredObject.this.resolve(values);
					}
				}
			}
		}).progress(new ProgressCallback<P>() {
			public void onProgress(P progress) {
				synchronized (AllValuesDeferredObject.this) {
					if (!AllValuesDeferredObject.this.isPending())
						return;

					AllValuesDeferredObject.this.notify(new OneProgress<P>(
						doneCount.get(),
						failCount.get(),
						numberOfPromises, index, promise, progress));
				}
			}
		}).done(new DoneCallback<D>() {
			public void onDone(D result) {
				synchronized (AllValuesDeferredObject.this) {
					if (!AllValuesDeferredObject.this.isPending())
						return;

					values.set(index, new OneResult<D>(index, promise, result));
					final int fail = failCount.get();
					final int done = doneCount.incrementAndGet();

					AllValuesDeferredObject.this.notify(new MasterProgress(
						done,
						failCount.get(),
						numberOfPromises));

					if (fail + done == numberOfPromises) {
						AllValuesDeferredObject.this.resolve(values);
					}
				}
			}
		});
	}
}
