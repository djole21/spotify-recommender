package dev.djmitrovic.spotifyrecommender.model;

import lombok.Data;

@Data
public class RecommendationSeedObject {
    private int afterFilteringSize;
    private int afterRelinkingSize;
    private String href;
    private String id;
    private int initialPoolSize;
    private String type;
}
