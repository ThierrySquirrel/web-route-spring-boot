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
package io.github.thierrysquirrel.web.route.init;

import io.github.thierrysquirrel.web.route.autoconfigure.WebRouteProperties;
import io.github.thierrysquirrel.web.route.init.core.factory.execution.WebRelayTemplateContainerInitFactoryExecution;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;


/**
 * ClassName: WebRelayTemplateContainerInit
 * Description:
 * date: 2021/5/21 22:05
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public class WebRelayTemplateContainerInit implements ApplicationContextAware {

	@Autowired
	private WebRouteProperties webRouteProperties;

	@Override
	public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
		WebRelayTemplateContainerInitFactoryExecution.init(applicationContext, webRouteProperties.getRelays());
	}
}
