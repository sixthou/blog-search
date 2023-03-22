package com.sixthou.blogsearchstandalone.ui;

import com.sixthou.blogsearchstandalone.application.KeywordService;
import com.sixthou.blogsearchstandalone.application.SearchService;
import com.sixthou.blogsearchstandalone.dto.common.BlogPagingResponse;
import com.sixthou.blogsearchstandalone.dto.common.BlogRequest;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;
    private final KeywordService keywordService;

    @GetMapping("/blog")
    public ResponseEntity<BlogPagingResponse> search(@ModelAttribute @Valid BlogRequest blogRequest) {
        keywordService.keywordSave(blogRequest.getQuery());
        return ResponseEntity.ok(searchService.search(blogRequest.toBlogRequestParam()));
    }
}
