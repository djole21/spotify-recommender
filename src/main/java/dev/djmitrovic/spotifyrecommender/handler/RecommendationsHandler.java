package dev.djmitrovic.spotifyrecommender.handler;

import dev.djmitrovic.spotifyrecommender.model.request.recommendations.RecommendationsRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

@Component
public class RecommendationsHandler {

    public Mono<Object> getRecommendations(ServerRequest request) {
        return null;
    }
}
