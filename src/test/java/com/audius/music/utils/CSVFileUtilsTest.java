//package com.audius.music.fileutils;
//
//import javax.sql.DataSource;
//
//import com.audius.music.fileutils.repository.TrackRepository;
//import lombok.RequiredArgsConstructor;
//import org.junit.jupiter.api.Test;
//
//import com.audius.music.fileutils.service.MusicService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import static org.mockito.Mockito.mock;
//
//public class CSVFileUtilsTest {
//
//    TrackRepository trackRepository;
//
//    CSVFileUtilsTest(TrackRepository trackRepository){
//        this.trackRepository = trackRepository;
//    }
//    @Test
//    public void dbUploadTest() throws Exception {
//
//        MusicService csvFileService = new MusicService(trackRepository);
//        csvFileService.readAndPersistCsv("/home/christopher.paulraj@zucisystems.com/java/audius/src/main/resources/Most Streamed Spotify Songs 2024 (copy).xlsx");
//
////        org.mockito.Mockito.verify(trackRepository, org.mockito.Mockito.atLeastOnce()).save(org.mockito.Mockito.any());
//    }
//}
