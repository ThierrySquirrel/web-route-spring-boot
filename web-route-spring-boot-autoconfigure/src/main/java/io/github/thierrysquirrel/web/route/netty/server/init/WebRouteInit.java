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
package io.github.thierrysquirrel.web.route.netty.server.init;

import io.github.thierrysquirrel.web.route.netty.common.utils.SocketAddressUtils;
import io.github.thierrysquirrel.web.route.netty.server.handler.WebRouteInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * ClassName: WebRouteInit
 * Description:
 * date: 2021/5/21 21:22
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public class WebRouteInit {
	private WebRouteInit() {
	}
	public static void init(String webRouteServerUrl, int maxContentLength, String headerRouteKey) {
		new ServerBootstrap()
				.group(new NioEventLoopGroup(), new NioEventLoopGroup())
				.channel(NioServerSocketChannel.class)
				.childHandler(new WebRouteInitializer(maxContentLength, headerRouteKey))
				.bind(SocketAddressUtils.getInetSocketAddress(webRouteServerUrl));
	}
}
