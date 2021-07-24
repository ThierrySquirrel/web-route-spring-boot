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
package com.github.thierrysquirrel.web.route.netty.server.handler.core.factory;

import com.github.thierrysquirrel.web.route.core.template.container.WebRelayTemplateContainer;
import com.github.thierrysquirrel.web.route.core.template.domain.WebRelayMessage;
import com.github.thierrysquirrel.web.route.core.template.domain.builder.HttpRequestMessageBuilder;
import com.github.thierrysquirrel.web.route.netty.server.handler.core.factory.domain.RelayHttpRequest;
import com.github.thierrysquirrel.web.route.netty.server.handler.core.factory.domain.builder.utils.RelayHttpRequestUtils;

/**
 * ClassName: RelayFactory
 * Description:
 * date: 2021/5/21 22:17
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public class RelayFactory {

	private RelayFactory() {
	}

	public static WebRelayMessage relay(RelayHttpRequest request, String headerRouteKey) {
		String headerRouteValue = request.getHeaders().get(headerRouteKey);
		var webRelayTemplate = WebRelayTemplateContainer.getWebRelayTemplate(headerRouteValue);
		var httpRequestMessage = HttpRequestMessageBuilder.builderHttpRequestMessage(request.getUri(), request.getHeaders());

		var webRelayMessage = webRelayTemplate.relay(httpRequestMessage);

		RelayHttpRequestUtils.convertRelayHttpRequest(request, webRelayMessage);

		return webRelayMessage;
	}

}
