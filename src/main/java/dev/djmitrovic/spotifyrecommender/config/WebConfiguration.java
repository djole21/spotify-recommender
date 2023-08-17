package dev.djmitrovic.spotifyrecommender.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.InMemoryReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.core.AuthenticationMethod;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConfiguration {

    @Bean
    public WebClient webClient(ReactiveClientRegistrationRepository clientRegistrationRepo,
                               ServerOAuth2AuthorizedClientRepository authorizedClientRepo) {
        ServerOAuth2AuthorizedClientExchangeFilterFunction filter =
                new ServerOAuth2AuthorizedClientExchangeFilterFunction(clientRegistrationRepo, authorizedClientRepo);
        return WebClient.builder()
                .baseUrl("https://api.spotify.com")
                .filter(filter)
                .build();
    }


//    @Bean
    public ReactiveClientRegistrationRepository reactiveClientRegistrationRepository() {
        return new InMemoryReactiveClientRegistrationRepository(spotify());
    }

    private ClientRegistration spotify() {
        return ClientRegistration.withRegistrationId("spotify")
                .clientId("06eeeab4bd3f483d8fa584cd329cbef9")
                .clientSecret("be39941fb06f48b1a4c88241fb8c6354")
                .tokenUri("https://accounts.spotify.com/api/token")
//                .userInfoAuthenticationMethod(AuthenticationMethod.FORM)
//                .userNameAttributeName(IdTokenClaimNames.SUB)
                .redirectUri("http://localhost:8080/authorize/oauth2/code/spotify")
                .authorizationUri("https://accounts.spotify.com/authorize")
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .build();
    }
}
