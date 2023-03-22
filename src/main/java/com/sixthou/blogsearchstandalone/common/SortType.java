package com.sixthou.blogsearchstandalone.common;

import java.util.Arrays;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum SortType {
    ACCURACY("ACCURACY", "sim"),
    RECENCY("RECENCY", "date");

    private final String kakaoName;
    private final String naverName;

    public static SortType of(String type) {
        return Arrays.stream(SortType.values())
                .filter(v -> v.name().equals(type))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
