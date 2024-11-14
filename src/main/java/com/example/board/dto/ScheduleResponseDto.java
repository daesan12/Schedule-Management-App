package com.example.board.dto;

import com.example.board.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private final Long id;
    private final String title;
    private final String content;

    public ScheduleResponseDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public static ScheduleResponseDto toDto(Schedule board) {
        return new ScheduleResponseDto(board.getId(), board.getTitle(), board.getContents());
    }
}
