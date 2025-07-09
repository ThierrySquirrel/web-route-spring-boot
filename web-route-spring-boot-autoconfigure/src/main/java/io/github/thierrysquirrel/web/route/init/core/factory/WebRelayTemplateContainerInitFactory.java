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
package io.github.thierrysquirrel.web.route.init.core.factory;

import io.github.thierrysquirrel.web.route.autoconfigure.Relay;
import io.github.thierrysquirrel.web.route.core.template.WebRelayTemplate;
import io.github.thierrysquirrel.web.route.core.template.container.WebRelayTemplateContainer;
import org.springframework.context.ApplicationContext;

/**
 * ClassName: WebRelayTemplateContainerInitFactory
 * Description:
 * date: 2021/5/21 22:07
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public class WebRelayTemplateContainerInitFactory {

	private WebRelayTemplateContainerInitFactory() {
	}

	public static void putWebRelayTemplate(ApplicationContext applicationContext, Relay relay) {
		String relayBeanName = relay.getRelayBeanName();
		var webRelayTemplate = applicationContext.getBean(relayBeanName, WebRelayTemplate.class);
		String headerRouteValue = relay.getHeaderRouteValue();
		WebRelayTemplateContainer.putWebRelayTemplate(headerRouteValue, webRelayTemplate);
	}

}
