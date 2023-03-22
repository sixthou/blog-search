package com.sixthou.blogsearchstandalone.application;

import com.sixthou.blogsearchstandalone.common.CacheType.Constant;
import com.sixthou.blogsearchstandalone.domain.KeywordInfo;
import com.sixthou.blogsearchstandalone.domain.KeywordInfoRepository;
import com.sixthou.blogsearchstandalone.dto.common.KeywordRankResponse;
import com.sixthou.blogsearchstandalone.dto.common.KeywordRanksResponse;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class KeywordService {
    private final KeywordInfoRepository keywordInfoRepository;

    @Transactional
    public KeywordInfo keywordSave(String keyword) {
        Optional<KeywordInfo> keywordInfo = keywordInfoRepository.findByKeyword(keyword);
        if (keywordInfo.isPresent()) {
            keywordInfo.get().hit();
            return keywordInfo.get();
        }
        return keywordInfoRepository.save(KeywordInfo.from(keyword));
    }

    @Cacheable(cacheNames = Constant.RANK)
    @Transactional(readOnly = true)
    public KeywordRanksResponse searchRank() {
        List<KeywordInfo> ranking = keywordInfoRepository.findTop10ByOrderByCountDesc();
        return KeywordRanksResponse.from(IntStream.iterate(0, i -> i + 1)
                .limit(ranking.size())
                .mapToObj(i -> KeywordRankResponse.of(ranking.get(i), i + 1))
                .collect(Collectors.toList()));
    }
}

