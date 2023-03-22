package com.sixthou.blogsearchstandalone.domain;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeywordInfoRepository extends JpaRepository<KeywordInfo, Long> {

    List<KeywordInfo> findTop10ByOrderByCountDesc();
    Optional<KeywordInfo> findByKeyword(String keyword);

}
