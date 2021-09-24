/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.search.experiences.internal.blueprint.condition;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.search.experiences.blueprint.parameter.SXPParameter;
import com.liferay.search.experiences.internal.blueprint.parameter.SXPParameterData;
import com.liferay.search.experiences.internal.blueprint.parameter.SXPParameterParser;

/**
 * @author Petteri Karttunen
 */
public class SXPConditionEvaluator {

	public static boolean evaluate(
		JSONObject jsonObject, SXPParameterData sxpParameterData) {

		if (jsonObject == null) {
			return true;
		}

		// TODO any_of and all_of

		for (String key : jsonObject.keySet()) {
			if (!_evaluate(
					jsonObject.getJSONObject(key), key, sxpParameterData)) {

				return false;
			}
		}

		return true;
	}

	private static boolean _evaluate(
		JSONObject jsonObject, String key, SXPParameterData sxpParameterData) {

		SXPParameter sxpParameter =
			sxpParameterData.getSXPParameterByTemplateVariable(
				jsonObject.getString("parameter_name"));

		if (key.equals("exists")) {
			if (sxpParameter != null) {
				return true;
			}

			return false;
		}
		else if (key.equals("not_exists")) {
			if (sxpParameter == null) {
				return true;
			}

			return false;
		}

		if (sxpParameter == null) {
			return false;
		}

		JSONObject valueJSONObject = SXPParameterParser.parse(
			jsonObject.getJSONObject("value"), sxpParameterData);

		if (valueJSONObject == null) {
			return false;
		}

		if (key.equals("contains")) {
			return sxpParameter.evaluateContains(valueJSONObject);
		}
		else if (key.equals("equals")) {
			return sxpParameter.evaluateEquals(valueJSONObject);
		}
		else if (key.equals("in")) {
			return sxpParameter.evaluateIn(valueJSONObject);
		}
		else if (key.equals("in_range")) {
			return sxpParameter.evaluateInRange(valueJSONObject);
		}
		else if (key.equals("greater_than")) {
			return sxpParameter.evaluateGreaterThan(false, valueJSONObject);
		}
		else if (key.equals("greater_than_equals")) {
			return sxpParameter.evaluateGreaterThan(true, valueJSONObject);
		}
		else if (key.equals("lower_than")) {

			// TODO Rename to less_than

			return !sxpParameter.evaluateGreaterThan(true, valueJSONObject);
		}
		else if (key.equals("lower_than_equals")) {

			// TODO Rename to less_than_equals

			return !sxpParameter.evaluateGreaterThan(false, valueJSONObject);
		}
		else if (key.equals("not_contains")) {
			return !sxpParameter.evaluateContains(valueJSONObject);
		}
		else if (key.equals("not_equals")) {
			return !sxpParameter.evaluateEquals(valueJSONObject);
		}
		else if (key.equals("not_in")) {
			return !sxpParameter.evaluateIn(valueJSONObject);
		}
		else if (key.equals("not_in_range")) {
			return !sxpParameter.evaluateInRange(valueJSONObject);
		}
		else {
			throw new IllegalArgumentException("Uknown key " + key);
		}
	}

}