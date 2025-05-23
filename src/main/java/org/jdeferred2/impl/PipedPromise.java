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

public class PipedPromise<D, F, P, D_OUT, F_OUT, P_OUT> extends DeferredObject<D_OUT, F_OUT, P_OUT> implements Promise<D_OUT, F_OUT, P_OUT>{
	public PipedPromise(final Promise<D, F, P> promise,
						final DonePipe<? super D, ? extends D_OUT, ? extends F_OUT, ? extends P_OUT> doneFilter,
						final FailPipe<? super F, ? extends D_OUT, ? extends F_OUT, ? extends P_OUT> failFilter,
						final ProgressPipe<? super P, ? extends D_OUT, ? extends F_OUT, ? extends P_OUT> progressFilter) {
		promise.done(new DoneCallback<D>() {
			@SuppressWarnings("unchecked")
			@Override
			public void onDone(D result) {
				if (doneFilter != null) pipe(doneFilter.pipeDone(result));
				else PipedPromise.this.resolve((D_OUT) result);
				
			}
		}).fail(new FailCallback<F>() {
			@SuppressWarnings("unchecked")
			@Override
			public void onFail(F result) {
				if (failFilter != null)  pipe(failFilter.pipeFail(result));
				else PipedPromise.this.reject((F_OUT) result);
			}
		}).progress(new ProgressCallback<P>() {
			@SuppressWarnings("unchecked")
			@Override
			public void onProgress(P progress) {
				if (progressFilter != null) pipe(progressFilter.pipeProgress(progress));
				else PipedPromise.this.notify((P_OUT) progress);
			}
		});
	}
	
	protected Promise<? extends D_OUT, ? extends F_OUT, ? extends P_OUT> pipe(
			Promise<? extends D_OUT, ? extends F_OUT, ? extends P_OUT> promise) {
		promise.done(new DoneCallback<D_OUT>() {
			@Override
			public void onDone(D_OUT result) {
				PipedPromise.this.resolve(result);
			}
		}).fail(new FailCallback<F_OUT>() {
			@Override
			public void onFail(F_OUT result) {
				PipedPromise.this.reject(result);
			}
		}).progress(new ProgressCallback<P_OUT>() {
			@Override
			public void onProgress(P_OUT progress) {
				PipedPromise.this.notify(progress);
			}
		});

		return promise;
	}

	public PipedPromise(final Promise<D, F, P_OUT> promise,
						final AlwaysPipe<? super D, ? super F, ? extends D_OUT, ? extends F_OUT, ? extends P_OUT> alwaysFilter) {
		promise.always(new AlwaysCallback<D, F>() {
			@SuppressWarnings("unchecked")
			@Override
			public void onAlways(State state, D resolved, F rejected) {
				pipe(alwaysFilter.pipeAlways(state, resolved, rejected));
			}
		}).progress(new ProgressCallback<P_OUT>() {
			@Override
			public void onProgress(P_OUT progress) {
				PipedPromise.this.notify(progress);
			}
		});
	}
}