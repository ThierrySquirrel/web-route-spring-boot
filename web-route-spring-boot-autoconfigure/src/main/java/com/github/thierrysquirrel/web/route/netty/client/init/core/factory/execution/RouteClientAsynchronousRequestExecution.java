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
package com.github.thierrysquirrel.web.route.netty.client.init.core.factory.execution;

import com.github.thierrysquirrel.web.route.core.builder.constant.ThreadPoolExecutorConstant;
import com.github.thierrysquirrel.web.route.netty.client.init.core.thread.execute.RouteClientRequestThreadExecute;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.DefaultFullHttpRequest;

/**
 * ClassName: RouteClientAsynchronousRequestExecution
 * Description:
 * date: 2021/5/21 23:23
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public class RouteClientAsynchronousRequestExecution {
	private RouteClientAsynchronousRequestExecution() {
	}

	public static void asynchronousRequest(String url, int maxContentLength, String headerRouteValue, DefaultFullHttpRequest request, Channel serverChannel, String relayErrorMessage) {
		var requestThreadExecute = new RouteClientRequestThreadExecute(url, maxContentLength, headerRouteValue, request, serverChannel, relayErrorMessage);
		ThreadPoolExecutorConstant.ROUTE_CLIENT_REQUEST.execute(requestThreadExecute);
	}
}
