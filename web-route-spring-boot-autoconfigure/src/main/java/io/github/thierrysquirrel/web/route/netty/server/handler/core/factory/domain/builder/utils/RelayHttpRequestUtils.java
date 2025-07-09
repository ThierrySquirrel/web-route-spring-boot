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
package io.github.thierrysquirrel.web.route.netty.server.handler.core.factory.domain.builder.utils;

import io.github.thierrysquirrel.web.route.core.template.domain.WebRelayMessage;
import io.github.thierrysquirrel.web.route.netty.server.handler.core.factory.domain.RelayHttpRequest;
import io.github.thierrysquirrel.web.route.netty.server.handler.core.factory.domain.builder.RelayHttpRequestBuilder;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;

/**
 * ClassName: RelayHttpRequestUtils
 * Description:
 * date: 2021/5/21 22:23
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public class RelayHttpRequestUtils {

	private RelayHttpRequestUtils() {
	}

	public static RelayHttpRequest convertRelayHttpRequest(FullHttpRequest fullHttpRequest) {
		return RelayHttpRequestBuilder
				.builderRelayHttpRequest(fullHttpRequest.protocolVersion(), fullHttpRequest.method(),
						fullHttpRequest.uri(), fullHttpRequest.content().retain(),
						fullHttpRequest.headers(), fullHttpRequest.trailingHeaders());
	}

	public static void convertRelayHttpRequest(RelayHttpRequest request, WebRelayMessage webRelayMessage) {
		String path = webRelayMessage.getPath();
		request.setUri(path);
		HttpHeaders headers = webRelayMessage.getHeaders();
		request.setHeaders(headers);
	}

	public static DefaultFullHttpRequest convertDefaultFullHttpRequest(RelayHttpRequest request) {
		return new DefaultFullHttpRequest(request.getHttpVersion(), request.getMethod(),
				request.getUri(), request.getContent(),
				request.getHeaders(), request.getTrailingHeader());
	}

}
