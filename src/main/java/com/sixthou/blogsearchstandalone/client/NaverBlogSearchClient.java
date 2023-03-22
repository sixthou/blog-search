package com.sixthou.blogsearchstandalone.client;

import com.sixthou.blogsearchstandalone.config.NaverApiProperties;
import com.sixthou.blogsearchstandalone.domain.BlogSearchParam;
import com.sixthou.blogsearchstandalone.dto.common.BlogPagingResponse;
import com.sixthou.blogsearchstandalone.dto.naver.NaverBlogSearchResponse;
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
@Component("NAVER")
public class NaverBlogSearchClient implements BlogSearchClient{

    private final NaverApiProperties naverApiProperties;
    private final RestTemplate restTemplate;
    
    @Override
    public BlogPagingResponse search(BlogSearchParam blogSearchParam) {
        return Optional.ofNullable(restTemplate.exchange(
                                createUri(blogSearchParam),
                                HttpMethod.GET,
                                new HttpEntity<>(createHttpHeaders()),
                                NaverBlogSearchResponse.class)
                        .getBody())
                .orElseThrow(() -> new RestClientException("NAVER-RestClientException"))
                .toBlogPagingResponse(blogSearchParam.getSize(), blogSearchParam.getPage());
    }


    private String createUri(BlogSearchParam blogSearchParam) {
        return UriComponentsBuilder.fromHttpUrl(naverApiProperties.getUrl())
                .queryParam("query", blogSearchParam.getQuery())
                .queryParam("sort", blogSearchParam.getSortType().getNaverName())
                .queryParam("start", blogSearchParam.getPage() * blogSearchParam.getSize() + 1)
                .queryParam("display", blogSearchParam.getSize())
                .encode()
                .toUriString();
    }

    private HttpHeaders createHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", naverApiProperties.getId());
        headers.add("X-Naver-Client-Secret", naverApiProperties.getSecret());
        return headers;
    }

}
