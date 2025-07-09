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
package io.github.thierrysquirrel.web.route.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * ClassName: WebRouteProperties
 * Description:
 * date: 2021/5/21 21:10
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
@Data
@ConfigurationProperties(prefix = WebRouteProperties.WEB_ROUTE_PREFIX)
public class WebRouteProperties {
	public static final String WEB_ROUTE_PREFIX="web.route";
	/**
	 * ServerUrl
	 */
	private String url;
	/**
	 * MaxFramePayloadLength
	 */
	private int maxFramePayloadLength = 65536;

	/**
	 * headerRouteKey
	 */
	private String headerRouteKey="Web-Route";
	/**
	 * Relays
	 */
	private List<Relay> relays;

}