package quizme.demo.configurations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @EnableAuthorizationServer enables an Authorization Server (i.e. an AuthorizationEndpoint and a TokenEndpoint) in the current application context.
 * class AuthorizationServerConfigurerAdapter implements AuthorizationServerConfigurer which provides all the necessary methods to configure an Authorization server.
 */
@Configuration
@RequiredArgsConstructor
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    //provides persistence for tokens
    private final TokenStore tokenStore;

    //Basic interface for determining whether a given client authentication request has been approved by the current user.
    private final UserApprovalHandler userApprovalHandler;

    @Qualifier("authenticationManagerBean")
    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {



        clients.inMemory()

                .withClient("my-trusted-client")
                .authorizedGrantTypes("authorization_code", "refresh_token", "password")
                .authorities("ROLE_CLIENT,ROLE_TRUSTED_CLIENT")
                .scopes("read,write,trust")
                .secret(passwordEncoder.encode("secret"))
                .accessTokenValiditySeconds(600)
                .refreshTokenValiditySeconds(1200);
    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {

        security.passwordEncoder(passwordEncoder);
    }




    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {

        endpoints.tokenStore(tokenStore).userApprovalHandler(userApprovalHandler).authenticationManager(authenticationManager)
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);

        endpoints.addInterceptor(new HandlerInterceptorAdapter() {
            @Override
            public boolean preHandle(HttpServletRequest hsr, HttpServletResponse rs, Object o)  {

               /* endpoints.tokenStore(tokenStore).userApprovalHandler(userApprovalHandler).authenticationManager(authenticationManager)
                        .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);*/

                rs.setHeader("Access-Control-Allow-Origin", "*");
                rs.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS");
                rs.setHeader("Access-Control-Max-Age", "3600");
                rs.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
                return true;
            }
        });
    }


}
