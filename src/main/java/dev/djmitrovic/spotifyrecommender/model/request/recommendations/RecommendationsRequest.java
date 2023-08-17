package dev.djmitrovic.spotifyrecommender.model.request.recommendations;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.jetbrains.annotations.Nullable;

@Data
public class RecommendationsRequest {
    @Min(1) @Max(100) @Nullable
    private Integer limit;
    private String market;
    //A comma separated list of Spotify IDs for seed artists.
    // Up to 5 seed values may be provided in any combination of seed_artists, seed_tracks and seed_genres.
    @NotNull private String seedArtists;
    @NotNull private String seedGenres;
    @NotNull private String seedTracks;

    @Min(0) @Max(1) @Nullable private Double minAcousticness;
    @Min(0) @Max(1) @Nullable private Double maxAcousticness;
    @Min(0) @Max(1) @Nullable private Double targetAcousticness;
    @Min(0) @Max(1) @Nullable private Double minDanceability;
    @Min(0) @Max(1) @Nullable private Double maxDanceability;
    @Min(0) @Max(1) @Nullable private Double targetDanceability;
    @Nullable private Integer minDurationMs;
    @Nullable private Integer maxDurationMs;
    @Nullable private Integer targetDurationMs;
    @Min(0) @Max(1) @Nullable private Double minEnergy;
    @Min(0) @Max(1) @Nullable private Double maxEnergy;
    @Min(0) @Max(1) @Nullable private Double targetEnergy;
    @Min(0) @Max(1) @Nullable private Double minInstrumentalness;
    @Min(0) @Max(1) @Nullable private Double maxInstrumentalness;
    @Min(0) @Max(1) @Nullable private Double targetInstrumentalness;
    @Min(0) @Max(11) @Nullable private Integer minKey;
    @Min(0) @Max(11) @Nullable private Integer maxKey;
    @Min(0) @Max(11) @Nullable private Integer targetKey;
    @Min(0) @Max(1) @Nullable private Double minLiveness;
    @Min(0) @Max(1) @Nullable private Double maxLiveness;
    @Min(0) @Max(1) @Nullable private Double targetLiveness;
    @Nullable private Double minLoudness;
    @Nullable private Double maxLoudness;
    @Nullable private Double targetLoudness;
    @Min(0) @Max(1) @Nullable private Double minMode;
    @Min(0) @Max(1) @Nullable private Double maxMode;
    @Min(0) @Max(1) @Nullable private Double targetMode;
    @Min(0) @Max(100) @Nullable private Integer minPopularity;
    @Min(0) @Max(100) @Nullable private Integer maxPopularity;
    @Min(0) @Max(100) @Nullable private Integer targetPopularity;
    @Min(0) @Max(1) @Nullable private Double minSpeechiness;
    @Min(0) @Max(1) @Nullable private Double maxSpeechiness;
    @Min(0) @Max(1) @Nullable private Double targetSpeechiness;
    @Nullable private Double minTempo;
    @Nullable private Double maxTempo;
    @Nullable private Double targetTempo;
    @Nullable private Integer minTimeSignature;
    @Nullable private Integer maxTimeSignature;
    @Nullable private Integer targetTimeSignature;
    @Min(0) @Max(1) @Nullable private Double minValence;
    @Min(0) @Max(1) @Nullable private Double maxValence;
    @Min(0) @Max(1) @Nullable private Double targetValence;

}
