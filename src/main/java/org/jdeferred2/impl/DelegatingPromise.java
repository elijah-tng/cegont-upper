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

/**
 * Promise implementation of the Decorator Pattern.
 *
 * @param <D> Type used for {@link #done(DoneCallback)}
 * @param <F> Type used for {@link #fail(FailCallback)}
 * @param <P> Type used for {@link #progress(ProgressCallback)}
 *
 * @author Andres Almiray
 * @since 1.2.5
 */
public abstract class DelegatingPromise<D, F, P> implements Promise<D, F, P> {
	private final Promise<D, F, P> delegate;

	public DelegatingPromise(Promise<D, F, P> delegate) {
		if (null == delegate) {
			throw new NullPointerException("Argument 'delegate' must not be null");
		}
		this.delegate = delegate;
	}

	@Override
	public State state() {
		return getDelegate().state();
	}

	/**
	 * Returns the delegate Promise wrapped by this Promise.
	 *
	 * @return
	 */
	protected Promise<D, F, P> getDelegate() {
		return delegate;
	}

	@Override
	public boolean isPending() {
		return getDelegate().isPending();
	}

	@Override
	public boolean isResolved() {
		return getDelegate().isResolved();
	}

	@Override
	public boolean isRejected() {
		return getDelegate().isRejected();
	}

	@Override
	public Promise<D, F, P> then(DoneCallback<? super D> doneCallback) {
		return getDelegate().then(doneCallback);
	}

	@Override
	public Promise<D, F, P> then(DoneCallback<? super D> doneCallback, FailCallback<? super F> failCallback) {
		return getDelegate().then(doneCallback, failCallback);
	}

	@Override
	public Promise<D, F, P> then(DoneCallback<? super D> doneCallback, FailCallback<? super F> failCallback, ProgressCallback<? super P> progressCallback) {
		return getDelegate().then(doneCallback, failCallback, progressCallback);
	}

	@Override
	public <D_OUT> Promise<D_OUT, F, P> filter(DoneFilter<? super D, ? extends D_OUT> doneFilter) {
		return getDelegate().filter(doneFilter);
	}

	@Override
	public <D_OUT, F_OUT> Promise<D_OUT, F_OUT, P> filter(DoneFilter<? super D, ? extends D_OUT> doneFilter, FailFilter<? super F, ? extends F_OUT> failFilter) {
		return getDelegate().filter(doneFilter, failFilter);
	}

	@Override
	public <D_OUT, F_OUT, P_OUT> Promise<D_OUT, F_OUT, P_OUT> filter(DoneFilter<? super D, ? extends D_OUT> doneFilter, FailFilter<? super F, ? extends F_OUT> failFilter, ProgressFilter<? super P, ? extends P_OUT> progressFilter) {
		return getDelegate().filter(doneFilter, failFilter, progressFilter);
	}

	@Override
	public <D_OUT> Promise<D_OUT, F, P> pipe(DonePipe<? super D, ? extends D_OUT, ? extends F, ? extends P> donePipe) {
		return getDelegate().pipe(donePipe);
	}

	@Override
	public <D_OUT, F_OUT> Promise<D_OUT, F_OUT, P> pipe(DonePipe<? super D, ? extends D_OUT, ? extends F_OUT, ? extends P> donePipe, FailPipe<? super F, ? extends D_OUT, ? extends F_OUT, ? extends P> failPipe) {
		return getDelegate().pipe(donePipe, failPipe);
	}

	@Override
	public <D_OUT, F_OUT, P_OUT> Promise<D_OUT, F_OUT, P_OUT> pipe(DonePipe<? super D, ? extends D_OUT, ? extends F_OUT, ? extends P_OUT> donePipe, FailPipe<? super F, ? extends D_OUT, ? extends F_OUT, ? extends P_OUT> failPipe, ProgressPipe<? super P, ? extends D_OUT, ? extends F_OUT, ? extends P_OUT> progressPipe) {
		return getDelegate().pipe(donePipe, failPipe, progressPipe);
	}

	@Override
	public <D_OUT, F_OUT> Promise<D_OUT, F_OUT, P> pipeAlways(AlwaysPipe<? super D, ? super F, ? extends D_OUT, ? extends F_OUT, ? extends P> alwaysPipe) {
		return getDelegate().pipeAlways(alwaysPipe);
	}

	@Override
	public Promise<D, F, P> done(DoneCallback<? super D> callback) {
		return getDelegate().done(callback);
	}

	@Override
	public Promise<D, F, P> fail(FailCallback<? super F> callback) {
		return getDelegate().fail(callback);
	}

	@Override
	public Promise<D, F, P> always(AlwaysCallback<? super D, ? super F> callback) {
		return getDelegate().always(callback);
	}

	@Override
	public Promise<D, F, P> progress(ProgressCallback<? super P> callback) {
		return getDelegate().progress(callback);
	}

	@Override
	public void waitSafely() throws InterruptedException {
		getDelegate().waitSafely();
	}

	@Override
	public void waitSafely(long timeout) throws InterruptedException {
		getDelegate().waitSafely(timeout);
	}
}
