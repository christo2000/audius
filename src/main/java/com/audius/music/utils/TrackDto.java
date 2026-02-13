package com.audius.music.utils;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TrackDto {
    private Long id;
    private String track;
    private String albumName;
    private String artist;
    private String releaseDate;
    private String isrc;
    private Integer allTimeRank;
    private Double trackScore;
    private Long spotifyStreams;
    private Long spotifyPlaylistCount;
    private Long spotifyPlaylistReach;
    private Integer spotifyPopularity;
    private Long youTubeViews;
    private Long youTubeLikes;
    private Long tikTokPosts;
    private Long tikTokLikes;
    private Long tikTokViews;
    private Long youTubePlaylistReach;
    private Long appleMusicPlaylistCount;
    private Long airPlaySpins;
    private Long siriusXMSpins;
    private Long deezerPlaylistCount;
    private Long deezerPlaylistReach;
    private Long amazonPlaylistCount;
    private Long pandoraStreams;
    private Long pandoraTrackStations;
    private Long soundcloudStreams;
    private Long shazamCounts;
    private Integer tidalPopularity;
    private Integer explicitTrack;
    private String trackPath;
}

