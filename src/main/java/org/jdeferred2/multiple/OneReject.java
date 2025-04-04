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
package org.jdeferred2.multiple;

import org.jdeferred2.*;

/**
 * Progress fail by one of the {@link Promise}.
 *
 * @author Ray Tsang
 */
@SuppressWarnings("rawtypes")
public class OneReject<F> extends AbstractOneValue<F> {
	private final Promise<?, F, ?> promise;
	private final F reject;

	public OneReject(int index, Promise<?, F, ?> promise, F reject) {
		super(index);
		this.promise = promise;
		this.reject = reject;
	}

	@Override
	public F getValue() {
		return getReject();
	}

	public F getReject() {
		return reject;
	}

	public Promise<?, F, ?> getPromise() {
		return promise;
	}

	@Override
	public String toString() {
		return "OneReject [index=" + index + ", promise=" + promise
			+ ", reject=" + reject + "]";
	}
}
