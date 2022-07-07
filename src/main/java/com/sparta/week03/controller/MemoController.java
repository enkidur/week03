package com.sparta.week03.controller;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.service.MemoService;
import com.sparta.week03.domain.MemoRepository;
import com.sparta.week03.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;
    private String username;


    //@RequestBody -> 바디라는 녀석이 들어오면 여기에 넣어줘.
    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @GetMapping("/api/memos")
    public List<Memo> getMemos() {
        return memoRepository.findAllByOrderByDateDesc();
    }

    @GetMapping("/api/memos/title/{title}")
    public List<Memo> getMemos_title(@PathVariable String title) {
        return memoRepository.findMemoByTitleOrderByDateDesc(title);
    }

    @GetMapping("/api/memos/contents/{contents}")
    public List<Memo> getMemos_cont(@PathVariable String contents) {
        return memoRepository.findMemoByContentsOrderByDateDesc(contents);
    }

    @GetMapping("/api/memos/username/{username}")
    public List<Memo> getMemos_user(@PathVariable String username) {
        return memoRepository.findMemoByUsernameOrderByDateDesc(username);
    }

    @GetMapping("/api/memos/date/{date}")
    public List<Memo> getMemos_date(@PathVariable String date) {
        return memoRepository.findMemoByDateOrderByDateDesc(date);
    }





    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        memoService.update(id,requestDto);
        return id;
    }
}