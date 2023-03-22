package com.sixthou.blogsearchstandalone.common;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CacheType {
    RANK(Constant.RANK, 5);

    private final String name;
    private final int expireAfterWriteMinutes;

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Constant {
        public static final String RANK = "RANK";
    }
}
