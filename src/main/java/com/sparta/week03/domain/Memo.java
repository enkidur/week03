package com.sparta.week03.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Memo extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
    long mili = System.currentTimeMillis();
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    //작성자명
    @Column(nullable = false)
    private String username;

    //비밀번호
    @Column(nullable = false)
    private String password;

    //제목
    @Column(nullable = false)
    private String title;

    //내용
    @Column(nullable = false)
    private String contents;

    @Column//(nullable = false)
    private final String date = new SimpleDateFormat("yyyy-MM-dd").format(mili);

    public Memo(String username, String contents, String title, String password) {
        this.username   = username;
        this.password   = password;
        this.title      = title;
        this.contents   = contents;
    }

    public Memo(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }

    public void update(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }
}