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
package io.github.thierrysquirrel.web.route.core.builder.constant;

import io.github.thierrysquirrel.web.route.core.builder.ThreadPoolExecutorBuilder;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * ClassName: ThreadPoolExecutorConstant
 * Description:
 * date: 2021/5/21 21:35
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public final class ThreadPoolExecutorConstant {

	public static final ThreadPoolExecutor WEB_ROUTE_SERVER_INIT = ThreadPoolExecutorBuilder.builderWebRouteServerInitThreadPoolExecutor();
	public static final ThreadPoolExecutor ROUTE_CLIENT_REQUEST = ThreadPoolExecutorBuilder.builderRouteClientRequestThreadPoolExecutor();
	public static final ThreadPoolExecutor WEB_ROUTE_BUSINESS = ThreadPoolExecutorBuilder.builderWebRouteBusinessThreadPoolExecutor();

	private ThreadPoolExecutorConstant() {
	}
}
