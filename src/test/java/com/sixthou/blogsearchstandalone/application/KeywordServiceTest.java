package com.sixthou.blogsearchstandalone.application;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.sixthou.blogsearchstandalone.domain.KeywordInfo;
import com.sixthou.blogsearchstandalone.domain.KeywordInfoRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class KeywordServiceTest {

    @Mock
    KeywordInfoRepository keywordInfoRepository;
    @InjectMocks
    KeywordService keywordService;

    @DisplayName("새로운 키워드를 입력하면 값이 저장된다.")
    @Test
    void newKeyword() {
        //given
        String query = "test";

        //when
        when(keywordInfoRepository.findByKeyword(query)).thenReturn(Optional.empty());
        when(keywordInfoRepository.save(any())).thenReturn(KeywordInfo.from(query));

        //then
        KeywordInfo keywordInfo = keywordService.keywordSave(query);
        Assertions.assertThat(keywordInfo.getKeyword()).isEqualTo(query);

    }

    @DisplayName("이미 등록된 키워드를 입력하면 검색횟수가 증가한다.")
    @Test
    void registeredKeyword() {
        //given
        String query = "test";

        //when
        when(keywordInfoRepository.findByKeyword(query)).thenReturn(Optional.of(KeywordInfo.from(query)));

        //then
        KeywordInfo keywordInfo = keywordService.keywordSave(query);
        Assertions.assertThat(keywordInfo.getCount()).isEqualTo(2);

    }


    @DisplayName("검색 횟수에 따른 인기 검색어를 검색할 수 있다.")
    @Test
    void ranking() {
        //given
        List<KeywordInfo> keywordInfos = IntStream.iterate(1, i -> i + 1)
                .limit(10)
                .mapToObj(i -> KeywordInfo.from(Integer.toString(i)))
                .collect(Collectors.toList());

        //when
        when(keywordInfoRepository.findTop10ByOrderByCountDesc()).thenReturn(keywordInfos);

        //then
        Assertions.assertThat(keywordService.searchRank().getRanking()).hasSize(10);

    }
}
