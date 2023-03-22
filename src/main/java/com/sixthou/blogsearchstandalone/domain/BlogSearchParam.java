package com.sixthou.blogsearchstandalone.domain;

import com.sixthou.blogsearchstandalone.common.SortType;
import lombok.Getter;

@Getter
public class BlogSearchParam {

    private String query;
    private SortType sortType;
    private Integer page;
    private Integer size;

    private BlogSearchParam(String query, SortType sortType, Integer page, Integer size) {
        this.query = query;
        this.sortType = sortType;
        this.page = page;
        this.size = size;
    }

    public static BlogSearchParam of(String query, String sortType, Integer page, Integer size) {
        return new BlogSearchParam(query, SortType.of(sortType), page, size);
    }

}
