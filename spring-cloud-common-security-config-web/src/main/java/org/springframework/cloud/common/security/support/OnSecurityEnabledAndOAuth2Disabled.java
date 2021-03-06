/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.cloud.common.security.support;

import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.Conditional;

/**
 * {@link Condition} that is only valid if {@code security.basic.enabled} is {@code true}
 * and the property {@code security.oauth2.client.client-id} does NOT exists.
 *
 * @author Gunnar Hillert
 * @since 1.1.0
 */
public class OnSecurityEnabledAndOAuth2Disabled extends AllNestedConditions {

	public OnSecurityEnabledAndOAuth2Disabled() {
		super(ConfigurationPhase.REGISTER_BEAN);
	}

	@ConditionalOnProperty("security.basic.enabled")
	static class BasicSecurityEnabledEnabled {
	}

	@Conditional(OnOAuth2Disabled.class)
	static class OauthEnabled {
	}
}
