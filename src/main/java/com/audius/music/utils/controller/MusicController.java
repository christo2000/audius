package com.audius.music.utils.controller;

import com.audius.music.utils.TrackDto;
import com.audius.music.utils.entity.TrackEntity;
import com.audius.music.utils.repository.TrackRepository;
import com.audius.music.utils.service.MusicService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/music")
public class MusicController {

    final TrackRepository trackRepository;
    final MusicService musicService;

    // let Spring inject both repository and service
    public MusicController(TrackRepository trackRepository, MusicService musicService){
        this.trackRepository = trackRepository;
        this.musicService = musicService;
    }

    @GetMapping("/csvUpload")
    public void csvToDb(@RequestParam String csvPath) throws Exception {
        // use the injected service so @Transactional and DataSource are properly wired
        musicService.readAndPersistCsv(csvPath);
    }



    @GetMapping("/trackData/fetch10")
    public
    List
            <TrackDto> fetch10Rows(){
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").ascending());
        List<TrackDto> allTracks = new ArrayList<>();
        musicService.setTrackEntity(pageable, allTracks);
        return allTracks;
    }

    @GetMapping("/trackData")
    public  List<TrackDto> getTrackData(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int pageSize
    ) {
        return musicService.paginatedTrackData(page, pageSize);
    }
}
