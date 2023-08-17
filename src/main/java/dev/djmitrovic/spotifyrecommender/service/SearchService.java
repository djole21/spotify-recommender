package dev.djmitrovic.spotifyrecommender.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final WebClient webClient;

    public void search() {

    }
}
