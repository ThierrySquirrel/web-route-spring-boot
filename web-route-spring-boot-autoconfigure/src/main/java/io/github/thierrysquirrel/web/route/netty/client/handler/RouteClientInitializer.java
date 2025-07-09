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
package io.github.thierrysquirrel.web.route.netty.client.handler;

import io.github.thierrysquirrel.web.route.netty.client.init.RouteClientInit;
import io.github.thierrysquirrel.web.route.netty.common.handler.constant.IdleStateHandlerConstant;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * ClassName: RouteClientInitializer
 * Description:
 * date: 2021/5/21 22:39
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public class RouteClientInitializer extends ChannelInitializer<SocketChannel> {
	private final RouteClientInit routeClientInit;

	public RouteClientInitializer(RouteClientInit routeClientInit) {
		this.routeClientInit = routeClientInit;
	}

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ch.pipeline()
				.addLast(new IdleStateHandler(IdleStateHandlerConstant.OTHER_TIMEOUT, IdleStateHandlerConstant.ROUTE_CLIENT_WRITE_TIMEOUT, IdleStateHandlerConstant.OTHER_TIMEOUT, TimeUnit.MILLISECONDS))
				.addLast(new HttpClientCodec())
				.addLast(new HttpObjectAggregator(routeClientInit.getMaxContentLength()))
				.addLast(new RouteClientInboundHandler(routeClientInit));
	}
}
