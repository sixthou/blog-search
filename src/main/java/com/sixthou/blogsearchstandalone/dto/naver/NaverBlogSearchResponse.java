package com.sixthou.blogsearchstandalone.dto.naver;

import com.sixthou.blogsearchstandalone.dto.common.BlogPagingResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class NaverBlogSearchResponse {
    private List<Item> items;
    private Integer total;
    private Integer start;
    private Integer display;

    public BlogPagingResponse toBlogPagingResponse(int size, int page) {
        return BlogPagingResponse.builder()
                .size(size)
                .page(page)
                .totalPage(this.total/size)
                .totalSize(this.total)
                .documents(items.stream()
                        .map(Item::toBlogResponse)
                        .collect(Collectors.toList()))
                .build();
    }
}
