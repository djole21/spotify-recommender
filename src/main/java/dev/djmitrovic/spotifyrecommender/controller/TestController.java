package dev.djmitrovic.spotifyrecommender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class TestController {

    private static final String artistUri = "https://api.spotify.com/v1/artists/4Z8W4fKeB5YxbusRsdQVPb";
    private static final String search = "https://api.spotify.com/v1/search";

    @Autowired
    private WebClient webClient;

    @GetMapping("/artist")
    Mono<String> useOauthWithAuthCode(@RegisteredOAuth2AuthorizedClient("spotify") OAuth2AuthorizedClient client) {
        Mono<String> retrievedResource = webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/v1/artists/{artistId}").build("0kbYTNQb4Pb1rPbbaF0pT4"))
                .attributes(ServerOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient(client))
                .retrieve()
                .bodyToMono(String.class);
        return retrievedResource.map(string ->  string);
    }

    @GetMapping("/search/{query}")
    Mono<String> search(@RegisteredOAuth2AuthorizedClient("spotify") OAuth2AuthorizedClient client, @PathVariable String query) {
        Mono<String> retrievedResource = webClient.get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("/v1/search")
                                .queryParam("q", query)
                                .queryParam("type", List.of("track", "album", "artist"))
                                .build())
                .attributes(ServerOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient(client))
                .retrieve()
                .bodyToMono(String.class);
        return retrievedResource.map(string ->  string);
    }

    @GetMapping("/recommend")
    Mono<String> recommend(@RegisteredOAuth2AuthorizedClient("spotify") OAuth2AuthorizedClient client) {
        Mono<String> retrievedResource = webClient.get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("/v1/recommendations")
//                                .queryParam("seed_tracks", "7h5xn0Olvx2p0eQcSt1Osy,59WN2psjkt1tyaxjspN8fp")
                                .queryParam("seed_genres", "singer-songwriter,rock")
                                .queryParam("limit", 10)
                                .build())
                .attributes(ServerOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient(client))
                .retrieve()
                .bodyToMono(String.class);
        return retrievedResource.map(string ->  string);
    }

    @GetMapping("/genre-seeds")
    Mono<String> genreSeeds(@RegisteredOAuth2AuthorizedClient("spotify") OAuth2AuthorizedClient client) {
        Mono<String> retrievedResource = webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/v1/recommendations/available-genre-seeds").build())
                .attributes(ServerOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient(client))
                .retrieve()
                .bodyToMono(String.class);
        return retrievedResource.map(string -> string);
    }
}
