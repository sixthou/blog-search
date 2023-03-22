package com.sixthou.blogsearchstandalone.client;

import com.sixthou.blogsearchstandalone.domain.BlogSearchParam;
import com.sixthou.blogsearchstandalone.dto.common.BlogPagingResponse;

public interface BlogSearchClient {

    BlogPagingResponse search(BlogSearchParam blogSearchParam);

}
