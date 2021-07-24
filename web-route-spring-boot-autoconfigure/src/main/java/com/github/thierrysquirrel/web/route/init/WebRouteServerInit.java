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
package com.github.thierrysquirrel.web.route.init;

import com.github.thierrysquirrel.web.route.autoconfigure.WebRouteProperties;
import com.github.thierrysquirrel.web.route.init.core.factory.execution.WebRouteServerInitExecution;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.Resource;

/**
 * ClassName: WebRouteServerInit
 * Description:
 * date: 2021/5/21 21:27
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public class WebRouteServerInit implements InitializingBean {

	@Resource
	private WebRouteProperties webRouteProperties;

	@Override
	public void afterPropertiesSet() {
		WebRouteServerInitExecution.init(webRouteProperties.getUrl(), webRouteProperties.getMaxFramePayloadLength(), webRouteProperties.getHeaderRouteKey());
	}
}
