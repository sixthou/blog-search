package com.sixthou.blogsearchstandalone.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class KeywordInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String keyword;
    private Long count;

    public KeywordInfo() {
    }

    private KeywordInfo(String keyword, Long count) {
        this.keyword = keyword;
        this.count = count;
    }

    public static KeywordInfo from(String keyword) {
        return new KeywordInfo(keyword, 1L);
    }


    public void hit() {
        count++;
    }

}


