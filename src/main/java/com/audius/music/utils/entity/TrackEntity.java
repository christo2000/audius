package com.audius.music.utils.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "track_entity", schema = "tracks")
@Data
public class TrackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "track")
    private String track;

    @Column(name = "album_name")
    private String albumName;

    @Column(name = "artist")
    private String artist;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "isrc")
    private String isrc;

    @Column(name = "all_time_rank")
    private Integer allTimeRank;

    @Column(name = "track_score")
    private Double trackScore;

    @Column(name = "spotify_streams")
    private Long spotifyStreams;

    @Column(name = "spotify_playlist_count")
    private Long spotifyPlaylistCount;

    @Column(name = "spotify_playlist_reach")
    private Long spotifyPlaylistReach;

    @Column(name = "spotify_popularity")
    private Integer spotifyPopularity;

    @Column(name = "youtube_views")
    private Long youTubeViews;

    @Column(name = "youtube_likes")
    private Long youTubeLikes;

    @Column(name = "tiktok_posts")
    private Long tikTokPosts;

    @Column(name = "tiktok_likes")
    private Long tikTokLikes;

    @Column(name = "tiktok_views")
    private Long tikTokViews;

    @Column(name = "youtube_playlist_reach")
    private Long youTubePlaylistReach;

    @Column(name = "apple_music_playlist_count")
    private Long appleMusicPlaylistCount;

    @Column(name = "airplay_spins")
    private Long airPlaySpins;

    @Column(name = "siriusxm_spins")
    private Long siriusXMSpins;

    @Column(name = "deezer_playlist_count")
    private Long deezerPlaylistCount;

    @Column(name = "deezer_playlist_reach")
    private Long deezerPlaylistReach;

    @Column(name = "amazon_playlist_count")
    private Long amazonPlaylistCount;

    @Column(name = "pandora_streams")
    private Long pandoraStreams;

    @Column(name = "pandora_track_stations")
    private Long pandoraTrackStations;

    @Column(name = "soundcloud_streams")
    private Long soundcloudStreams;

    @Column(name = "shazam_counts")
    private Long shazamCounts;

    @Column(name = "tidal_popularity")
    private Integer tidalPopularity;

    @Column(name = "explicit_track")
    private Integer explicitTrack; // Using Integer based on "1" in CSV sample, likely 0/1

    @Column(name = "track_path")
    private String trackPath;
}
