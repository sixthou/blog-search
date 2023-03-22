package com.sixthou.blogsearchstandalone.dto.naver;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sixthou.blogsearchstandalone.dto.common.BlogResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@NoArgsConstructor
@Getter
public class Item {
    private String title;
    private String link;
    private String description;
    private String bloggername;
    @DateTimeFormat(iso = ISO.DATE)
    @JsonFormat(pattern = "yyyyMMdd")
    private LocalDate postdate;

    public BlogResponse toBlogResponse() {
        return BlogResponse.builder()
                .title(this.title)
                .contents(this.description)
                .blogName(this.bloggername)
                .url(this.link)
                .datetime(LocalDateTime.of(this.postdate, LocalTime.MIN))
                .build();
    }
}
