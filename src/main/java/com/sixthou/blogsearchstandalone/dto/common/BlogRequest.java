package com.sixthou.blogsearchstandalone.dto.common;

import com.sixthou.blogsearchstandalone.common.SortType;
import com.sixthou.blogsearchstandalone.common.valid.SortTypeValid;
import com.sixthou.blogsearchstandalone.domain.BlogSearchParam;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BlogRequest {

    @NotBlank
    private String query;

    @SortTypeValid
    private String sort = SortType.ACCURACY.name();

    @Max(50)
    @Min(1)
    private Integer size = 10;

    @Max(50)
    @Min(1)
    private Integer page = 1;

    public BlogSearchParam toBlogRequestParam() {
        return BlogSearchParam.of(query, sort, page, size);
    }
}
