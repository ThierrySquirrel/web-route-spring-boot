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
package io.github.thierrysquirrel.web.route.netty.server.handler.core.thread;

import io.github.thierrysquirrel.web.route.netty.server.handler.core.factory.domain.RelayHttpRequest;
import io.netty.channel.Channel;

/**
 * ClassName: AbstractWebRouteBusinessThread
 * Description:
 * date: 2021/5/21 23:50
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public abstract class AbstractWebRouteBusinessThread implements Runnable {

	private final String headerRouteKey;
	private final RelayHttpRequest request;
	private final int maxContentLength;
	private final Channel serverChannel;

	protected AbstractWebRouteBusinessThread(String headerRouteKey, RelayHttpRequest request, int maxContentLength, Channel serverChannel) {
		this.headerRouteKey = headerRouteKey;
		this.request = request;
		this.maxContentLength = maxContentLength;
		this.serverChannel = serverChannel;
	}

	/**
	 * route
	 *
	 * @param headerRouteKey   headerRouteKey
	 * @param request          request
	 * @param maxContentLength maxContentLength
	 * @param serverChannel    serverChannel
	 */
	protected abstract void route(String headerRouteKey, RelayHttpRequest request, int maxContentLength, Channel serverChannel);

	@Override
	public void run() {
		route(this.headerRouteKey, this.request,
				this.maxContentLength, this.serverChannel);
	}
}
