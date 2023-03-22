package com.sixthou.blogsearchstandalone.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ClientType {
    KAKAO(Constant.KAKAO),
    NAVER(Constant.NAVER);

    private final String name;

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Constant {
        public static final String KAKAO = "KAKAO";
        public static final String NAVER = "NAVER";
    }
}
