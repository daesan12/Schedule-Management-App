package com.example.board.Controller;

import com.example.board.dto.ScheduleResponseDto;
import com.example.board.dto.ScheduleWithAgeResponseDto;
import com.example.board.dto.CreateScheduleRequestDto;
import com.example.board.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleServiceService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody CreateScheduleRequestDto requestDto) {
        ScheduleResponseDto boardResponseDto =
                scheduleServiceService.save(requestDto.getTitle(), requestDto.getContents(), requestDto.getUsername());
        return new ResponseEntity<>(boardResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {
        List<ScheduleResponseDto> boardResponseDtoList = scheduleServiceService.findAll();

        return new ResponseEntity<>(boardResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleWithAgeResponseDto> findById(@PathVariable Long id) {
        ScheduleWithAgeResponseDto boardWithAgeResponseDto = scheduleServiceService.findById(id);

        return new ResponseEntity<>(boardWithAgeResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        scheduleServiceService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
