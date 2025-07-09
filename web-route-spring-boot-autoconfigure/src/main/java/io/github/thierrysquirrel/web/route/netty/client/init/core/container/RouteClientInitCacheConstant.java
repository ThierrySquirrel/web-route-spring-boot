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
package io.github.thierrysquirrel.web.route.netty.client.init.core.container;

import io.github.thierrysquirrel.web.route.netty.client.init.RouteClientInit;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * ClassName: RouteClientInitCacheConstant
 * Description:
 * date: 2021/5/21 23:00
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public class RouteClientInitCacheConstant {
	private static final Map<String, RouteClientInitThreadLocalConstant> CLIENT_INIT_CACHE_MAP = Maps.newConcurrentMap();

	private RouteClientInitCacheConstant() {
	}

	public static RouteClientInit getRouteClientInit(String url, int maxContentLength, String headerRouteValue) {
		return CLIENT_INIT_CACHE_MAP.computeIfAbsent(url, key -> new RouteClientInitThreadLocalConstant())
				.getRouteClientInit(url, maxContentLength, headerRouteValue);
	}
}
