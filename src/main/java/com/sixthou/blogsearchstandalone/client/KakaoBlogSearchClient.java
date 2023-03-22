package com.sixthou.blogsearchstandalone.client;

import com.sixthou.blogsearchstandalone.config.KakaoApiProperties;
import com.sixthou.blogsearchstandalone.domain.BlogSearchParam;
import com.sixthou.blogsearchstandalone.domain.ClientType.Constant;
import com.sixthou.blogsearchstandalone.dto.common.BlogPagingResponse;
import com.sixthou.blogsearchstandalone.dto.kakao.KakaoBlogSearchResponse;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RequiredArgsConstructor
@Component(Constant.KAKAO)
public class KakaoBlogSearchClient implements BlogSearchClient {

    private final KakaoApiProperties kakaoApiProperties;
    private final RestTemplate restTemplate;

    @Override
    public BlogPagingResponse search(BlogSearchParam blogSearchParam) {
        return Optional.ofNullable(restTemplate.exchange(
                                createUri(blogSearchParam),
                                HttpMethod.GET,
                                new HttpEntity<>(createHttpHeaders()),
                                KakaoBlogSearchResponse.class)
                        .getBody())
                .orElseThrow(() -> new RestClientException("KAKAO-RestClientException"))
                .toBlogPagingResponse(blogSearchParam.getSize(), blogSearchParam.getPage());
    }


    private String createUri(BlogSearchParam blogSearchParam) {
        return UriComponentsBuilder.fromHttpUrl(kakaoApiProperties.getUrl())
                .queryParam("query", blogSearchParam.getQuery())
                .queryParam("sort", blogSearchParam.getSortType().getKakaoName())
                .queryParam("page", blogSearchParam.getPage())
                .queryParam("size", blogSearchParam.getSize())
                .encode()
                .toUriString();
    }

    private HttpHeaders createHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", kakaoApiProperties.getKey());
        return headers;
    }

}
