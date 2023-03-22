package com.sixthou.blogsearchstandalone.dto.common;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BlogPagingResponse {
    private List<BlogResponse> documents;
    private int totalSize;
    private int totalPage;
    private int size;
    private int page;
}
