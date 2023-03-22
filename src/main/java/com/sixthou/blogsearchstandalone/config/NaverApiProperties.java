package com.sixthou.blogsearchstandalone.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@ConfigurationProperties("search.naver.api")
@RequiredArgsConstructor
public class NaverApiProperties {

    private final String url;
    private final String id;
    private final String secret;
}
