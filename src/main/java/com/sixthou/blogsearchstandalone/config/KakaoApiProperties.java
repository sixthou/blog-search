package com.sixthou.blogsearchstandalone.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@ConfigurationProperties("search.kakao.api")
@RequiredArgsConstructor
public class KakaoApiProperties {

    private final String url;
    private final String key;
}
