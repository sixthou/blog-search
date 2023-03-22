package com.sixthou.blogsearchstandalone.dto.common;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class KeywordRanksResponse {
    List<KeywordRankResponse> ranking;

    public static KeywordRanksResponse from(List<KeywordRankResponse> keywordRankResponses) {
        return KeywordRanksResponse.builder()
                .ranking(keywordRankResponses)
                .build();
    }
}
