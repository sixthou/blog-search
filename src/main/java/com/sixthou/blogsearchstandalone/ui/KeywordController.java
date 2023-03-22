package com.sixthou.blogsearchstandalone.ui;

import com.sixthou.blogsearchstandalone.application.KeywordService;
import com.sixthou.blogsearchstandalone.dto.common.KeywordRanksResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/keyword")
public class KeywordController {
    private final KeywordService keywordService;

    @GetMapping("/rank")
    public ResponseEntity<KeywordRanksResponse> findRank() {
        return ResponseEntity.ok(keywordService.searchRank());
    }

}
