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
package io.github.thierrysquirrel.web.route.netty.client.init.core.factory.execution;

import io.github.thierrysquirrel.web.route.netty.client.init.core.container.RouteClientInitCacheConstant;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.*;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassName: RouteClientRequestExecution
 * Description:
 * date: 2021/5/21 23:15
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
@Slf4j
public class RouteClientRequestExecution {
	private RouteClientRequestExecution() {
	}
	public static void request(String url, int maxContentLength, String headerRouteValue, DefaultFullHttpRequest request, Channel serverChannel, String relayErrorMessage) {
		try {
			DefaultFullHttpResponse response = RouteClientInitCacheConstant
					.getRouteClientInit(url, maxContentLength, headerRouteValue)
					.request(request);
			serverChannel.writeAndFlush(response);
		} catch (Exception e) {
			DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
			byte[] respContent = relayErrorMessage.getBytes();
			response.headers().add(HttpHeaderNames.CONTENT_LENGTH, respContent.length);
			response.content().writeBytes(respContent);
			serverChannel.writeAndFlush(response);
			log.error(relayErrorMessage, e);
		}

	}
}
