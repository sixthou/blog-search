package com.sixthou.blogsearchstandalone.dto.kakao;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sixthou.blogsearchstandalone.dto.common.BlogResponse;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@NoArgsConstructor
@Getter
class Document {
    private String title;
    private String contents;
    private String url;
    private String blogname;
    @DateTimeFormat(iso = ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private LocalDateTime datetime;

    public BlogResponse toBlogResponse() {
        return BlogResponse.builder()
                .title(this.title)
                .contents(this.contents)
                .blogName(this.blogname)
                .url(this.url)
                .datetime(this.datetime)
                .build();
    }
}
