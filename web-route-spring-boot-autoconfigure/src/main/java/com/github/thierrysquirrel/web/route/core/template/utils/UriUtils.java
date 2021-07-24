/**
 * Copyright 2020 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.thierrysquirrel.web.route.core.template.utils;

import com.google.common.collect.Maps;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

/**
 * ClassName: UriUtils
 * Description:
 * date: 2021/5/22 0:02
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
@Slf4j
public class UriUtils {
	private UriUtils() {
	}

	private static String decodeUri(String requestUri) throws UnsupportedEncodingException {
		try {
			return URLDecoder.decode(requestUri, CharsetUtil.UTF_8.toString());
		} catch (UnsupportedEncodingException e) {
			log.error("Uri Decoder Error", e);
			throw e;
		}
	}


	public static Map<String, String> uriConvertMap(String requestUri) throws UnsupportedEncodingException {
		requestUri = decodeUri(requestUri);
		if (!requestUri.contains(UriUtilsConstant.QUESTION_MARK)) {
			return Maps.newConcurrentMap();
		}
		int index = requestUri.indexOf(UriUtilsConstant.QUESTION_MARK);
		var filterUri = requestUri.substring(index + 1);
		String[] splitUri = filterUri.split(UriUtilsConstant.AMPERSAND);
		Map<String, String> paramMap = Maps.newConcurrentMap();
		for (String uriParam : splitUri) {
			int substringIndex = uriParam.indexOf(UriUtilsConstant.IS_EQUAL_TO);
			var key = uriParam.substring(0, substringIndex);
			var value = uriParam.substring(substringIndex + 1);
			paramMap.put(key, value);
		}
		return paramMap;
	}

	public static String mapConvertUri(String requestUri, Map<String, String> uriParamMap) {
		if (!requestUri.contains(UriUtilsConstant.QUESTION_MARK)) {
			return requestUri;
		}

		int index = requestUri.indexOf(UriUtilsConstant.QUESTION_MARK);
		var filterUri = requestUri.substring(0, index);

		var stringBuilder = new StringBuilder();
		stringBuilder.append(filterUri);
		var offset = 0;
		for (Map.Entry<String, String> entry : uriParamMap.entrySet()) {
			if (offset > 0) {
				stringBuilder.append(UriUtilsConstant.AMPERSAND);
			} else {
				stringBuilder.append(UriUtilsConstant.QUESTION_MARK);
			}
			stringBuilder.append(entry.getKey());
			stringBuilder.append(UriUtilsConstant.IS_EQUAL_TO);
			stringBuilder.append(entry.getValue());
			offset++;
		}
		return stringBuilder.toString();
	}

}
