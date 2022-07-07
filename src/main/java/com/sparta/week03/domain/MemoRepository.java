package com.sparta.week03.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByOrderByDateDesc();
    List<Memo> findMemoByTitleOrderByDateDesc(String title);
    List<Memo> findMemoByUsernameOrderByDateDesc(String Username);
    List<Memo> findMemoByDateOrderByDateDesc(String Date);
    List<Memo> findMemoByContentsOrderByDateDesc(String Contents);
    }