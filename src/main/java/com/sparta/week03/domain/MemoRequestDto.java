package com.sparta.week03.domain;

import lombok.Getter;

import java.util.Date;

@Getter
public class MemoRequestDto {
    private String username; //작성자명
    private String password; //비밀번호
    private String title;    //제목
    private String contents; //내용
    private Date date; //작성날짜
}
