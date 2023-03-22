package com.sixthou.blogsearchstandalone.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class KeywordInfoRepositoryTest {

    @Autowired
    KeywordInfoRepository keywordInfoRepository;

    @DisplayName("KeywordInfo 를 저장할 수 있다.")
    @Test
    void save() {
        //given
        String query = "키워드";
        //when
        KeywordInfo actual = keywordInfoRepository.save(KeywordInfo.from(query));
        //then
        assertAll(
                () -> assertThat(actual.getId()).isNotNull(),
                () -> assertThat(actual.getKeyword()).isEqualTo(query),
                () -> assertThat(actual.getCount()).isEqualTo(1L));
    }

    @DisplayName("저장된 KeywordInfo 를 keyword 값으로 조회할 수 있다.")
    @Test
    void find() {
        //given
        String query = "키워드";
        keywordInfoRepository.save(KeywordInfo.from(query));
        //when
        Optional<KeywordInfo> actual = keywordInfoRepository.findByKeyword(query);
        //then
        assertThat(actual).isPresent();
    }

    //


    @DisplayName("저장된 KeywordInfo 중 검색횟수가 많은 상위 10개를 찾을 조회할 수 있다.")
    @Test
    void findTop10() {
        //given
        IntStream.iterate(1, i -> i + 1)
                .limit(20)
                .forEach(num ->{
                    KeywordInfo save = keywordInfoRepository.save(KeywordInfo.from(Integer.toString(num)));
                    IntStream.iterate(0, i -> i + 1)
                            .limit(num)
                            .forEach(t -> save.hit());
                        }
                );
        //when
        List<KeywordInfo> actual = keywordInfoRepository.findTop10ByOrderByCountDesc();

        //then
        assertAll(
                () -> assertThat(actual).hasSize(10),
                () -> assertThat(actual.get(0).getKeyword()).isEqualTo("20"));

    }
}
