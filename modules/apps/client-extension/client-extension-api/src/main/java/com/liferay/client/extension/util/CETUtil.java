package com.liferay.client.extension.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Binh Tran
 */
public class CETUtil {

	public static String normalizeExternalReferenceCodeForPortletId(
		String externalReferenceCode) {

		if (Validator.isNotNull(externalReferenceCode)) {
			return externalReferenceCode.replaceAll(
				"\\W", StringPool.UNDERLINE);
		}

		return externalReferenceCode;
	}

}