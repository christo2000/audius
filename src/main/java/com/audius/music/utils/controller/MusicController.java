package com.audius.music.utils.controller;

import com.audius.music.utils.entity.TrackEntity;
import com.audius.music.utils.repository.TrackRepository;
import com.audius.music.utils.service.MusicService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/music")
public class MusicController {

    final TrackRepository trackRepository;
    final MusicService musicService;

    MusicController(TrackRepository trackRepository){
        this.trackRepository = trackRepository;
        this.musicService = new MusicService(trackRepository);
    }

    @GetMapping("/csvUpload")
    public void csvToDb(@RequestParam String csvPath) throws Exception {

        MusicService csvFileService = new MusicService(trackRepository);
        String csvFilePath = csvPath;
        csvFileService.readAndPersistCsv(csvFilePath);
    }



    @GetMapping("/trackData/fetch10")
    public List<TrackEntity> fetch10Rows(){
        return trackRepository.findAll().stream().limit(10).toList();
    }

    @GetMapping("/trackData")
    public Page<TrackEntity> getTrackData(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int pageSize
    ) {
        return musicService.paginatedTrackData(page, pageSize);
    }
}
