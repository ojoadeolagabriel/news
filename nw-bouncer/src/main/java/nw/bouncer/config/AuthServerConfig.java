package nw.bouncer.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@RequiredArgsConstructor
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

	private final TokenStore tokenStore;

	private final UserApprovalHandler userApprovalHandler;

	@Qualifier("authenticationManagerBean")
	private final AuthenticationManager authenticationManager;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		clients.inMemory()
				.withClient("my-trusted-client")
				.authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit", "client_credentials")
				.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
				.scopes("read", "write", "trust")
				.secret(encoder.encode("secret"))
				.accessTokenValiditySeconds(120).
				refreshTokenValiditySeconds(600);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
		endpoints.tokenStore(tokenStore).userApprovalHandler(userApprovalHandler)
				.authenticationManager(authenticationManager);
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
		String REALM = "MY_OAUTH_REALM";
		oauthServer.realm(REALM +"/client");
	}
}
