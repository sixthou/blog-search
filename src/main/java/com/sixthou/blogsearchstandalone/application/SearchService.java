package com.sixthou.blogsearchstandalone.application;

import com.sixthou.blogsearchstandalone.client.BlogSearchClient;
import com.sixthou.blogsearchstandalone.domain.BlogSearchParam;
import com.sixthou.blogsearchstandalone.domain.ClientType.Constant;
import com.sixthou.blogsearchstandalone.dto.common.BlogPagingResponse;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class SearchService {

    private final Map<String, BlogSearchClient> blogSearchClientMap;

    @Retryable(maxAttempts = 1, backoff = @Backoff(delay = 300))
    public BlogPagingResponse search(BlogSearchParam blogSearchParam) {
        log.info("kakao");
        return blogSearchClientMap.get(Constant.KAKAO).search(blogSearchParam);
    }

    @Recover
    public BlogPagingResponse recover(RuntimeException e, BlogSearchParam blogSearchParam) {
        log.info("naver");
        return blogSearchClientMap.get(Constant.NAVER).search(blogSearchParam);
    }
}
