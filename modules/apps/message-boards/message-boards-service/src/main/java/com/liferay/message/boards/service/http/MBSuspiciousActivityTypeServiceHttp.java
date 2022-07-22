/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.message.boards.service.http;

import com.liferay.message.boards.service.MBSuspiciousActivityTypeServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>MBSuspiciousActivityTypeServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MBSuspiciousActivityTypeServiceHttp {

	public static com.liferay.message.boards.model.MBSuspiciousActivityType
			addSuspiciousActivityType(
				HttpPrincipal httpPrincipal, String description)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				MBSuspiciousActivityTypeServiceUtil.class,
				"addSuspiciousActivityType",
				_addSuspiciousActivityTypeParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, description);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof Exception) {
					throw (Exception)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.message.boards.model.MBSuspiciousActivityType)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.message.boards.model.MBSuspiciousActivityType
			getSuspiciousActivityType(
				HttpPrincipal httpPrincipal, long suspiciousActivityTypeId)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				MBSuspiciousActivityTypeServiceUtil.class,
				"getSuspiciousActivityType",
				_getSuspiciousActivityTypeParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, suspiciousActivityTypeId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof Exception) {
					throw (Exception)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.message.boards.model.MBSuspiciousActivityType)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.message.boards.model.MBSuspiciousActivityType
			updateSuspiciousActivityType(
				HttpPrincipal httpPrincipal, long suspiciousActivityTypeId,
				String description)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				MBSuspiciousActivityTypeServiceUtil.class,
				"updateSuspiciousActivityType",
				_updateSuspiciousActivityTypeParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, suspiciousActivityTypeId, description);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof Exception) {
					throw (Exception)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.message.boards.model.MBSuspiciousActivityType)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void deleteSuspiciousActivityType(
			HttpPrincipal httpPrincipal, long suspiciousActivityTypeId)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				MBSuspiciousActivityTypeServiceUtil.class,
				"deleteSuspiciousActivityType",
				_deleteSuspiciousActivityTypeParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, suspiciousActivityTypeId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof Exception) {
					throw (Exception)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		MBSuspiciousActivityTypeServiceHttp.class);

	private static final Class<?>[] _addSuspiciousActivityTypeParameterTypes0 =
		new Class[] {String.class};
	private static final Class<?>[] _getSuspiciousActivityTypeParameterTypes1 =
		new Class[] {long.class};
	private static final Class<?>[]
		_updateSuspiciousActivityTypeParameterTypes2 = new Class[] {
			long.class, String.class
		};
	private static final Class<?>[]
		_deleteSuspiciousActivityTypeParameterTypes3 = new Class[] {long.class};

}