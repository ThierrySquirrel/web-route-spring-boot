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
package com.github.thierrysquirrel.web.route.init.core.factory.execution;

import com.github.thierrysquirrel.web.route.core.builder.constant.ThreadPoolExecutorConstant;
import com.github.thierrysquirrel.web.route.netty.server.init.core.thread.execute.WebRouteInitThreadExecute;

/**
 * ClassName: WebRouteServerInitExecution
 * Description:
 * date: 2021/5/21 21:49
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public class WebRouteServerInitExecution {
	private WebRouteServerInitExecution() {
	}

	public static void init(String webRouteServerUrl, int maxContentLength, String headerRouteKey) {
		var webRouteInitThreadExecute = new WebRouteInitThreadExecute(webRouteServerUrl, maxContentLength, headerRouteKey);
		ThreadPoolExecutorConstant.WEB_ROUTE_SERVER_INIT.execute(webRouteInitThreadExecute);
	}
}
