package com.sixthou.blogsearchstandalone.application;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.sixthou.blogsearchstandalone.client.BlogSearchClient;
import com.sixthou.blogsearchstandalone.client.KakaoBlogSearchClient;
import com.sixthou.blogsearchstandalone.client.NaverBlogSearchClient;
import com.sixthou.blogsearchstandalone.common.SortType;
import com.sixthou.blogsearchstandalone.domain.BlogSearchParam;
import com.sixthou.blogsearchstandalone.domain.ClientType.Constant;
import com.sixthou.blogsearchstandalone.dto.common.BlogPagingResponse;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SearchServiceTest {

    @Mock(name = Constant.KAKAO)
    KakaoBlogSearchClient kakaoBlogSearchClient;
    @Mock(name = Constant.NAVER)
    NaverBlogSearchClient naverBlogSearchClient;
    @Mock
    Map<String, BlogSearchClient> blogSearchClientMap;

    @InjectMocks
    SearchService searchService;

    @DisplayName("카카오 API로 검색할 수 있다.")
    @Test
    void searchKaKao() {
        //given
        BlogSearchParam param = BlogSearchParam.of("test", SortType.ACCURACY.name(), 10, 10);
        //when
        when(blogSearchClientMap.get(Constant.KAKAO)).thenReturn(kakaoBlogSearchClient);
        when(kakaoBlogSearchClient.search(any())).thenReturn(BlogPagingResponse.builder().totalPage(100).build());
        //then
        BlogPagingResponse search = searchService.search(param);
        Assertions.assertThat(search.getTotalPage()).isEqualTo(100);
    }

    @DisplayName("네이버 API로 검색할 수 있다.")
    @Test
    void recoverSearchNaver() {
        //given
        BlogSearchParam param = BlogSearchParam.of("test", SortType.ACCURACY.name(), 10, 10);
        //when
        when(blogSearchClientMap.get(Constant.NAVER)).thenReturn(naverBlogSearchClient);
        when(naverBlogSearchClient.search(any())).thenReturn(BlogPagingResponse.builder().totalPage(100).build());
        //then
        BlogPagingResponse search = searchService.recover(new RuntimeException(), param);
        Assertions.assertThat(search.getTotalPage()).isEqualTo(100);
    }
}
