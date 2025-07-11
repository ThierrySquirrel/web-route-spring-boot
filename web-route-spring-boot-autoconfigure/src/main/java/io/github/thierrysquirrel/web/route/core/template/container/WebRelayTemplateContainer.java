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
package io.github.thierrysquirrel.web.route.core.template.container;

import io.github.thierrysquirrel.web.route.core.template.WebRelayTemplate;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * ClassName: WebRelayTemplateContainer
 * Description:
 * date: 2021/5/21 22:01
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public class WebRelayTemplateContainer {

	private static final Map<String, WebRelayTemplate> WEB_RELAY_TEMPLATE_MAP = Maps.newConcurrentMap();

	private WebRelayTemplateContainer() {
	}

	public static void putWebRelayTemplate(String headerRouteValue, WebRelayTemplate webRelayTemplate) {
		WEB_RELAY_TEMPLATE_MAP.put(headerRouteValue, webRelayTemplate);
	}

	public static WebRelayTemplate getWebRelayTemplate(String headerRouteValue) {
		return WEB_RELAY_TEMPLATE_MAP.get(headerRouteValue);
	}

}
