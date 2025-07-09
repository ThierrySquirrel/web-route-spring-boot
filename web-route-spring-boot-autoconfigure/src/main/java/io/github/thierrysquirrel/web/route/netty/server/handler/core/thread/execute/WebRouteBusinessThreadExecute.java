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
package io.github.thierrysquirrel.web.route.netty.server.handler.core.thread.execute;

import io.github.thierrysquirrel.web.route.netty.server.handler.core.factory.domain.RelayHttpRequest;
import io.github.thierrysquirrel.web.route.netty.server.handler.core.factory.execution.RouteFactoryExecution;
import io.github.thierrysquirrel.web.route.netty.server.handler.core.thread.AbstractWebRouteBusinessThread;
import io.netty.channel.Channel;

/**
 * ClassName: WebRouteBusinessThreadExecute
 * Description:
 * date: 2021/5/21 23:53
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public class WebRouteBusinessThreadExecute extends AbstractWebRouteBusinessThread {

	public WebRouteBusinessThreadExecute(String headerRouteKey, RelayHttpRequest request, int maxContentLength, Channel serverChannel) {
		super(headerRouteKey, request, maxContentLength, serverChannel);
	}

	@Override
	protected void route(String headerRouteKey, RelayHttpRequest request, int maxContentLength, Channel serverChannel) {
		RouteFactoryExecution.route(headerRouteKey, request, maxContentLength, serverChannel);
	}
}
