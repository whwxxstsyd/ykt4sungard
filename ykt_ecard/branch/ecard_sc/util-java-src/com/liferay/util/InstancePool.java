/**
 * Copyright (c) 2000-2005 Liferay, LLC. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.util;

import java.util.Map;

/**
 * <a href="InstancePool.java.html"><b><i>View Source</i></b></a>
 *
 * @author  Brian Wing Shun Chan
 * @version $Revision: 1.5 $
 *
 */
public class InstancePool {

	public static Object get(String className) {
		return _instance._get(className);
	}

	public static void put(String className, Object obj) {
		_instance._put(className, obj);
	}

	private InstancePool() {
		_classPool = CollectionFactory.getSyncHashMap();
	}

	private Object _get(String className) {
		className = className.trim();

		Object obj = _classPool.get(className);

		if (obj == null) {
			try {
				obj = Class.forName(className).newInstance();
				_put(className, obj);
			}
			catch (ClassNotFoundException cnofe) {
				cnofe.printStackTrace();
			}
			catch (InstantiationException ie) {
				ie.printStackTrace();
			}
			catch (IllegalAccessException iae) {
				iae.printStackTrace();
			}
		}

		return obj;
	}

	private void _put(String className, Object obj) {
		_classPool.put(className, obj);
	}

	private static InstancePool _instance = new InstancePool();

	private Map _classPool;

}