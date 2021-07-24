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
package com.github.thierrysquirrel.web.route.core.builder;

import com.github.thierrysquirrel.web.route.core.builder.constant.ThreadPoolExecutorBuilderConstant;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: ThreadPoolExecutorBuilder
 * Description:
 * date: 2021/5/21 21:26
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public class ThreadPoolExecutorBuilder {

	private ThreadPoolExecutorBuilder() {
	}

	public static ThreadPoolExecutor builderWebRouteServerInitThreadPoolExecutor() {
		var threadFactory = new ThreadFactoryBuilder()
				.setNameFormat(ThreadPoolExecutorBuilderConstant.WEB_ROUTE_SERVER_INIT).build();
		return new ThreadPoolExecutor(ThreadPoolExecutorBuilderConstant.WEB_ROUTE_SERVER_INIT_CORE_POOL_SIZE,
				ThreadPoolExecutorBuilderConstant.WEB_ROUTE_SERVER_INIT_MAXIMUM_POOL_SIZE,
				ThreadPoolExecutorBuilderConstant.KEEP_ALIVE_TIME,
				TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<>(),
				threadFactory
		);
	}

	public static ThreadPoolExecutor builderRouteClientRequestThreadPoolExecutor() {
		var threadFactory = new ThreadFactoryBuilder()
				.setNameFormat(ThreadPoolExecutorBuilderConstant.ROUTE_CLIENT_REQUEST).build();
		return new ThreadPoolExecutor(ThreadPoolExecutorBuilderConstant.ROUTE_CLIENT_REQUEST_CORE_POOL_SIZE,
				ThreadPoolExecutorBuilderConstant.ROUTE_CLIENT_REQUEST_MAXIMUM_POOL_SIZE,
				ThreadPoolExecutorBuilderConstant.KEEP_ALIVE_TIME,
				TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<>(),
				threadFactory
		);
	}

	public static ThreadPoolExecutor builderWebRouteBusinessThreadPoolExecutor() {
		var threadFactory = new ThreadFactoryBuilder()
				.setNameFormat(ThreadPoolExecutorBuilderConstant.WEB_ROUTE_BUSINESS).build();
		return new ThreadPoolExecutor(ThreadPoolExecutorBuilderConstant.WEB_ROUTE_BUSINESS_CORE_POOL_SIZE,
				ThreadPoolExecutorBuilderConstant.WEB_ROUTE_BUSINESS_MAXIMUM_POOL_SIZE,
				ThreadPoolExecutorBuilderConstant.KEEP_ALIVE_TIME,
				TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<>(),
				threadFactory
		);
	}
}
