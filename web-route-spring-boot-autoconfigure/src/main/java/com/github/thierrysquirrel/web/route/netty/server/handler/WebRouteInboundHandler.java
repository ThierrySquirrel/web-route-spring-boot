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
package com.github.thierrysquirrel.web.route.netty.server.handler;

import com.github.thierrysquirrel.web.route.netty.common.handler.AbstractInboundHandler;
import com.github.thierrysquirrel.web.route.netty.server.handler.core.factory.domain.builder.utils.RelayHttpRequestUtils;
import com.github.thierrysquirrel.web.route.netty.server.handler.core.factory.execution.WebRouteBusinessExecution;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.timeout.IdleState;

/**
 * ClassName: WebRouteInboundHandler
 * Description:
 * date: 2021/5/21 21:18
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public class WebRouteInboundHandler extends AbstractInboundHandler<FullHttpRequest> {
	private final int maxContentLength;
	private final String headerRouteKey;

	public WebRouteInboundHandler(int maxContentLength, String headerRouteKey) {
		super(IdleState.READER_IDLE);
		this.maxContentLength = maxContentLength;
		this.headerRouteKey = headerRouteKey;
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) {
		WebRouteBusinessExecution.business(headerRouteKey, RelayHttpRequestUtils.convertRelayHttpRequest(msg), maxContentLength, ctx.channel());
	}
}
