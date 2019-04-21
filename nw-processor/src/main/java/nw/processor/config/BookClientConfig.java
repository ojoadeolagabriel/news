package nw.processor.config;

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

import java.util.Collections;

@Configuration
public class BookClientConfig {

	@Bean
	public RequestInterceptor requestInterceptor() {
		return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), resource());
	}

	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.valueOf("FULL");
	}

	@Bean
	protected OAuth2ProtectedResourceDetails resource() {
		ClientCredentialsResourceDetails resource = new ClientCredentialsResourceDetails();
		resource.setAccessTokenUri("http://localhost:5053/bouncer/oauth/token");
		resource.setClientId("my-trusted-client");
		resource.setClientSecret("secret");
		resource.setScope(Collections.singletonList("trust"));
		return resource;
	}
}