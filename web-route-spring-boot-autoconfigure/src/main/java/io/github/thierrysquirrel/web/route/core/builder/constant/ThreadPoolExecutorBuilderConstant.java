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

/**
 * ClassName: ThreadPoolExecutorBuilderConstant
 * Description:
 * date: 2021/5/21 21:30
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public final class ThreadPoolExecutorBuilderConstant {

	public static final int KEEP_ALIVE_TIME = 0;
	public static final String WEB_ROUTE_SERVER_INIT = "web-route-server-init-thread-%d";
	public static final int WEB_ROUTE_SERVER_INIT_CORE_POOL_SIZE = 1;
	public static final int WEB_ROUTE_SERVER_INIT_MAXIMUM_POOL_SIZE = 1;

	public static final String ROUTE_CLIENT_REQUEST = "route_client_request-thread-%d";
	public static final int ROUTE_CLIENT_REQUEST_CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors() * 2;
	public static final int ROUTE_CLIENT_REQUEST_MAXIMUM_POOL_SIZE = Runtime.getRuntime().availableProcessors() * 2;

	public static final String WEB_ROUTE_BUSINESS = "web_route_business-thread-%d";
	public static final int WEB_ROUTE_BUSINESS_CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors() * 2;
	public static final int WEB_ROUTE_BUSINESS_MAXIMUM_POOL_SIZE = Runtime.getRuntime().availableProcessors() * 2;


	private ThreadPoolExecutorBuilderConstant() {
	}

}
