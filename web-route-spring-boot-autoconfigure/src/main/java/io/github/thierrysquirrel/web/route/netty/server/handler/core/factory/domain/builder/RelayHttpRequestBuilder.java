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
package io.github.thierrysquirrel.web.route.netty.server.handler.core.factory.domain.builder;

import io.github.thierrysquirrel.web.route.netty.server.handler.core.factory.domain.RelayHttpRequest;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpVersion;

/**
 * ClassName: RelayHttpRequestBuilder
 * Description:
 * date: 2021/5/21 22:19
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public class RelayHttpRequestBuilder {

	private RelayHttpRequestBuilder() {
	}

	public static RelayHttpRequest builderRelayHttpRequest(HttpVersion httpVersion, HttpMethod method, String uri,
	                                                       ByteBuf content, HttpHeaders headers, HttpHeaders trailingHeader) {
		var request = new RelayHttpRequest();
		request.setHttpVersion(httpVersion);
		request.setMethod(method);
		request.setUri(uri);
		request.setContent(content);
		request.setHeaders(headers);
		request.setTrailingHeader(trailingHeader);
		return request;
	}

}
