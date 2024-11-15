package com.example.board.service;

import com.example.board.dto.ScheduleResponseDto;
import com.example.board.dto.ScheduleWithAgeResponseDto;
import com.example.board.entity.Schedule;
import com.example.board.entity.Member;
import com.example.board.repository.ScheduleRepository;
import com.example.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final MemberRepository memberRepository;
    private final ScheduleRepository boardRepository;

    public ScheduleResponseDto save(String title, String contents, Long memberId) {
        Member findMember = memberRepository.findByIdOrElseThrow(memberId);

        Schedule board = new Schedule(title, contents);
        board.setMember(findMember);


        boardRepository.save(board);
        return new ScheduleResponseDto(board.getId(), board.getTitle(), board.getContents());
    }

    public List<ScheduleResponseDto> findAll() {
        return boardRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }


    public ScheduleWithAgeResponseDto findById(Long id) {
        Schedule findBoard = boardRepository.findByIdOrElseThrow(id);
        Member writer = findBoard.getMember();
        return new ScheduleWithAgeResponseDto(findBoard.getTitle(), findBoard.getContents(), writer.getEmail());
    }

    public void delete(Long id) {
        Schedule findBoard = boardRepository.findByIdOrElseThrow(id);
        boardRepository.delete(findBoard);
    }
}
