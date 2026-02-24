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
package io.github.thierrysquirrel.web.route.netty.client.init;

import io.github.thierrysquirrel.web.route.netty.client.handler.RouteClientInitializer;
import io.github.thierrysquirrel.web.route.netty.client.init.core.constant.RouteClientInitConstant;
import io.github.thierrysquirrel.web.route.netty.client.init.core.container.RouteClientEventLoopGroupContainer;
import io.github.thierrysquirrel.web.route.netty.client.init.core.utils.ChannelUtils;
import io.github.thierrysquirrel.web.route.netty.common.utils.SocketAddressUtils;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import lombok.Data;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * ClassName: RouteClientInit
 * Description:
 * date: 2021/5/21 22:40
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
@Data
public class RouteClientInit {
	private final String url;
	private final int maxContentLength;
	private final String headerRouteValue;
	private Channel channel;
	private CompletableFuture<DefaultFullHttpResponse> response;

	public RouteClientInit(String url, int maxContentLength, String headerRouteValue) {
		this.url = url;
		this.maxContentLength = maxContentLength;
		this.headerRouteValue = headerRouteValue;
	}
	public DefaultFullHttpResponse request(DefaultFullHttpRequest defaultFullHttpRequest) throws InterruptedException, ExecutionException, TimeoutException {
		init().writeAndFlush(defaultFullHttpRequest);
		return response.get(RouteClientInitConstant.REQUEST_TIME_OUT, TimeUnit.MILLISECONDS);
	}

	public void call(DefaultFullHttpResponse defaultFullHttpResponse) {
		response.complete(defaultFullHttpResponse);
	}

	private Channel init() throws InterruptedException {
		response = new CompletableFuture<>();
		if (ChannelUtils.channelIsActive(channel)) {
			return channel;
		}
		channel = new Bootstrap().group(RouteClientEventLoopGroupContainer.getEventLoopGroup(url))
				.channel(NioSocketChannel.class)
				.handler(new RouteClientInitializer(this))
				.connect(SocketAddressUtils.getInetSocketAddress(url))
				.sync()
				.channel();
		return channel;
	}


}
