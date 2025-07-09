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

import io.github.thierrysquirrel.web.route.init.WebRelayTemplateContainerInit;
import io.github.thierrysquirrel.web.route.init.WebRouteServerInit;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: WebRouteAutoConfiguration
 * Description:
 * date: 2021/5/21 21:10
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
@Configuration
@EnableConfigurationProperties(WebRouteProperties.class)
public class WebRouteAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean(WebRouteServerInit.class)
	public WebRouteServerInit webRouteServerInit(){
		return new WebRouteServerInit();
	}

	@Bean
	@ConditionalOnMissingBean(WebRelayTemplateContainerInit.class)
	public WebRelayTemplateContainerInit webRelayTemplateContainerInit(){
		return new WebRelayTemplateContainerInit();
	}

}
