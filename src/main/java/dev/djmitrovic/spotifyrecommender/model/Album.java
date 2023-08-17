package dev.djmitrovic.spotifyrecommender.model;

import dev.djmitrovic.spotifyrecommender.model.enumeration.AlbumType;

import java.util.List;

public class Album {
    private AlbumType albumType;
    private int totalTracks;
    private List<String> availableMarkets;
    private String href;
    private List<ImageObject> images;
    private String name;
    private String releaseDate;
    private String releaseDatePrecision;
    private String type;
    private String url;
    private List<String> genres;

}
