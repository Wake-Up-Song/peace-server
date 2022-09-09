package com.example.wakeUp.domain.song.presentation;

import com.example.wakeUp.domain.song.presentation.dto.request.CreateSongRequestDto;
import com.example.wakeUp.domain.song.presentation.dto.response.SongResponseDto;
import com.example.wakeUp.domain.song.service.DailyRankingService;
import com.example.wakeUp.domain.song.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/song")
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;
    private final DailyRankingService dailyRankingService;

    @PostMapping
    public void requestSong(
            @RequestBody CreateSongRequestDto dto
    ) {
        songService.requestSong(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteSong(
            @PathVariable Long id
    ) {
        songService.deleteSong(id);
    }

    @GetMapping
    public Set<SongResponseDto> getSongChart() {
        return dailyRankingService.getRankingList();
    }
}

