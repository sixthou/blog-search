package com.sixthou.blogsearchstandalone.dto.kakao;

import com.sixthou.blogsearchstandalone.dto.common.BlogPagingResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class KakaoBlogSearchResponse {
    private Meta meta;
    private List<Document> documents;

    public BlogPagingResponse toBlogPagingResponse(int size, int page) {
        return BlogPagingResponse.builder()
                .size(size)
                .page(page)
                .totalPage((int) Math.ceil(meta.getPageableCount()/(double)size))
                .totalSize(meta.getPageableCount())
                .documents(documents.stream()
                        .map(Document::toBlogResponse)
                        .collect(Collectors.toList()))
                .build();
    }
}

