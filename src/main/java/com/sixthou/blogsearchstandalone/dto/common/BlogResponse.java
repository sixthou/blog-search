package com.sixthou.blogsearchstandalone.dto.common;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BlogResponse {
    String title;
    String contents;
    String url;
    String blogName;
    LocalDateTime datetime;
}
