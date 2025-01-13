package io.github.ztoany.sample.springboot3.keycloak.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration(proxyBeanMethods = false)
public class SecurityConfig {
    @Value("${oidc.post-logout-redirect-uri}")
    private String postLogoutRedirectUri;

    @Value("${oidc.login-success-url}")
    private String loginSuccessUrl;

    private final ClientRegistrationRepository clientRegistrationRepository;

    private static final String[] PERMIT_ALL_REQUESTS = {
            "/",
            "/login",
            "/image/**"
    };

    public SecurityConfig(ClientRegistrationRepository clientRegistrationRepository) {
        this.clientRegistrationRepository = clientRegistrationRepository;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers(PERMIT_ALL_REQUESTS).permitAll()
                .anyRequest().authenticated()
        );
        http.cors(withDefaults());
        http.csrf(AbstractHttpConfigurer::disable);
        http.oauth2Login(login -> {
            login.loginPage("/login");
            login.defaultSuccessUrl(loginSuccessUrl, true);
        });
        http.logout(logout -> logout.logoutSuccessHandler(oidcLogoutSuccessHandler()));

        //remove ?continue
        HttpSessionRequestCache requestCache = new HttpSessionRequestCache();
        requestCache.setMatchingRequestParameterName(null);
        http.requestCache(cache -> cache.requestCache(requestCache));

        return http.build();
    }

    private LogoutSuccessHandler oidcLogoutSuccessHandler() {
        OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler =
                new OidcClientInitiatedLogoutSuccessHandler(this.clientRegistrationRepository);

        oidcLogoutSuccessHandler.setPostLogoutRedirectUri(postLogoutRedirectUri);

        return oidcLogoutSuccessHandler;
    }
}
