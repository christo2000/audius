package com.audius.music.utils.service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.Table;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.audius.music.utils.entity.TrackEntity;
import com.audius.music.utils.repository.TrackRepository;

@Service
public class MusicService {



    private final TrackRepository trackRepository;
    private final Logger logger = LoggerFactory.getLogger(MusicService.class);

    public MusicService(TrackRepository trackRepository) {

        this.trackRepository = trackRepository;

    }

    @Transactional
    public void readAndPersistCsv(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
                CSVParser csvParser = new CSVParser(reader,
                        CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

            List<TrackEntity> tracks = new ArrayList<>();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
            Table table = TrackEntity.class.getAnnotation(Table.class);
            logger.info("Table Name: "+table.name() + " Schema: "+table.schema());
            logger.info("Datasource URL: " );
            for (CSVRecord csvRecord : csvParser) {
                TrackEntity track = new TrackEntity();

                track.setTrack(csvRecord.get("Track"));
                track.setAlbumName(csvRecord.get("Album Name"));
                track.setArtist(csvRecord.get("Artist"));

                String releaseDateStr = csvRecord.get("Release Date");
                if (releaseDateStr != null && !releaseDateStr.isEmpty()) {
                    track.setReleaseDate(LocalDate.parse(releaseDateStr, dateFormatter));
                }

                track.setIsrc(csvRecord.get("ISRC"));
                track.setAllTimeRank(parseInt(csvRecord.get("All Time Rank")));
                track.setTrackScore(parseDouble(csvRecord.get("Track Score")));
                track.setSpotifyStreams(parseLong(csvRecord.get("Spotify Streams")));
                track.setSpotifyPlaylistCount(parseLong(csvRecord.get("Spotify Playlist Count")));
                track.setSpotifyPlaylistReach(parseLong(csvRecord.get("Spotify Playlist Reach")));
                track.setSpotifyPopularity(parseInt(csvRecord.get("Spotify Popularity")));
                track.setYouTubeViews(parseLong(csvRecord.get("YouTube Views")));
                track.setYouTubeLikes(parseLong(csvRecord.get("YouTube Likes")));
                track.setTikTokPosts(parseLong(csvRecord.get("TikTok Posts")));
                track.setTikTokLikes(parseLong(csvRecord.get("TikTok Likes")));
                track.setTikTokViews(parseLong(csvRecord.get("TikTok Views")));
                track.setYouTubePlaylistReach(parseLong(csvRecord.get("YouTube Playlist Reach")));
                track.setAppleMusicPlaylistCount(parseLong(csvRecord.get("Apple Music Playlist Count")));
                track.setAirPlaySpins(parseLong(csvRecord.get("AirPlay Spins")));
                track.setSiriusXMSpins(parseLong(csvRecord.get("SiriusXM Spins")));
                track.setDeezerPlaylistCount(parseLong(csvRecord.get("Deezer Playlist Count")));
                track.setDeezerPlaylistReach(parseLong(csvRecord.get("Deezer Playlist Reach")));
                track.setAmazonPlaylistCount(parseLong(csvRecord.get("Amazon Playlist Count")));
                track.setPandoraStreams(parseLong(csvRecord.get("Pandora Streams")));
                track.setPandoraTrackStations(parseLong(csvRecord.get("Pandora Track Stations")));
                track.setSoundcloudStreams(parseLong(csvRecord.get("Soundcloud Streams")));
                track.setShazamCounts(parseLong(csvRecord.get("Shazam Counts")));
                track.setTidalPopularity(parseInt(csvRecord.get("TIDAL Popularity")));
                track.setTrackPath(csvRecord.get("Track Path"));


                // Explicit Track logic
                String explicitStr = csvRecord.get("Explicit Track");
                track.setExplicitTrack(parseInt(explicitStr)); // assuming 0 or 1 based on request but safe parse int

                tracks.add(track);
            }
            trackRepository.saveAll(tracks);
            logger.info("Successfully saved " + tracks.size() + " tracks.");

        } catch (IOException e) {
            System.err.println("Failed to parse CSV file: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private Long parseLong(String value) {
        if (value == null || value.isEmpty() || value.equals("N/A"))
            return 0L;
        // Remove commas
        return Long.parseLong(value.replace(",", ""));
    }

    private Integer parseInt(String value) {
        if (value == null || value.isEmpty() || value.equals("N/A"))
            return 0;
        return Integer.parseInt(value.replace(",", ""));
    }

    private Double parseDouble(String value) {
        if (value == null || value.isEmpty() || value.equals("N/A"))
            return 0.0;
        return Double.parseDouble(value.replace(",", ""));
    }

    // pagination
    public Page<TrackEntity> paginatedTrackData(int page, int pageSize) {

        // 🔒 Validation
        if (page < 0) {
            throw new IllegalArgumentException("Page index must be >= 0");
        }

        if (pageSize <= 0 || pageSize > 100) {
            throw new IllegalArgumentException("Page size must be between 1 and 100");
        }

        Pageable pageable = PageRequest.of(page, pageSize, Sort.by("id").descending());

        // 📦 Data fetch (offset = page * pageSize handled internally)
        return trackRepository.findAll(pageable);
    }


}
