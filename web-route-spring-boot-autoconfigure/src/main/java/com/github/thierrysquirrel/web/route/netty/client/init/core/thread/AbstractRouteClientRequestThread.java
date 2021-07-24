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
package com.github.thierrysquirrel.web.route.netty.client.init.core.thread;

import io.netty.channel.Channel;
import io.netty.handler.codec.http.DefaultFullHttpRequest;

/**
 * ClassName: AbstractRouteClientRequestThread
 * Description:
 * date: 2021/5/21 23:10
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public abstract class AbstractRouteClientRequestThread implements Runnable {

	private final String url;
	private final int maxContentLength;
	private final String headerRouteValue;
	private final DefaultFullHttpRequest request;
	private final Channel serverChannel;
	private final String relayErrorMessage;

	protected AbstractRouteClientRequestThread(String url, int maxContentLength, String headerRouteValue, DefaultFullHttpRequest request, Channel serverChannel, String relayErrorMessage) {
		this.url = url;
		this.maxContentLength = maxContentLength;
		this.headerRouteValue = headerRouteValue;
		this.request = request;
		this.serverChannel = serverChannel;
		this.relayErrorMessage = relayErrorMessage;
	}

	/**
	 * request
	 *
	 * @param url               url
	 * @param maxContentLength  maxContentLength
	 * @param headerRouteValue  headerRouteValue
	 * @param request           request
	 * @param serverChannel     serverChannel
	 * @param relayErrorMessage relayErrorMessage
	 */
	protected abstract void request(String url, int maxContentLength, String headerRouteValue, DefaultFullHttpRequest request, Channel serverChannel, String relayErrorMessage);

	@Override
	public void run() {
		request(this.url, this.maxContentLength,
				this.headerRouteValue, this.request,
				this.serverChannel, this.relayErrorMessage);
	}
}
