package com.sixthou.blogsearchstandalone.dto.common;

import com.sixthou.blogsearchstandalone.domain.KeywordInfo;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class KeywordRankResponse {
    private int rank;
    private String keyword;
    private long count;

    public static KeywordRankResponse of(KeywordInfo keywordInfo, int rank) {
        return KeywordRankResponse.builder()
                .rank(rank)
                .keyword(keywordInfo.getKeyword())
                .count(keywordInfo.getCount())
                .build();
    }
}
