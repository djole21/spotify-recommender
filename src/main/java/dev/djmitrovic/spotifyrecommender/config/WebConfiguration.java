package dev.djmitrovic.spotifyrecommender.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthenticationMethod;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConfiguration {

    @Bean
    public WebClient webClient(ReactiveClientRegistrationRepository clientRegistrationRepository) {
        return WebClient.builder().baseUrl("https://api.spotify.com").filter();
    }

    @Bean
    public OAuth2AuthorizedClient oAuth2AuthorizedClient() {
        return new OAuth2AuthorizedClient()
    }

    @Bean
    public ReactiveClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryReactiveClientRegistrationRepository(spotify());
    }

    private ClientRegistration spotify() {
        return ClientRegistration.withRegistrationId("spotify")
                .clientId("06eeeab4bd3f483d8fa584cd329cbef9")
                .clientSecret("be39941fb06f48b1a4c88241fb8c6354")
                .tokenUri("https://accounts.spotify.com/api/token")
                .userInfoAuthenticationMethod(AuthenticationMethod.FORM)
                .userNameAttributeName(IdTokenClaimNames.SUB)
                .redirectUri("http://localhost:8888")
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                .build();
    }
}
