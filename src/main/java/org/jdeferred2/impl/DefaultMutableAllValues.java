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

import org.jdeferred2.multiple.*;

/**
 * Base implementation of {@link MutableAllValues}.
 *
 * @author Ray Tsang
 * @author Andres Almiray
 */
class DefaultMutableAllValues extends DefaultAllValues implements MutableAllValues {
	DefaultMutableAllValues(int size) {
		super(size);
	}

	public void set(int index, OneValue<?> reject) {
		values.set(index, reject);
	}
}
