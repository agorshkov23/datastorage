package io.github.agorshkov23.datastorage.mapper;

import io.github.agorshkov23.datastorage.api.model.ApiPage;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class PageMapper {

    public <T> ApiPage<T> toApiPage(Page<T> page) {
        if (page == null) return null;
        return ApiPage.<T>builder()
            .content(page.getContent())
            .page(page.getPageable().getPageNumber())
            .size(page.getPageable().getPageSize())
            .pages(page.getTotalPages())
            .elements(page.getTotalElements())
            .last(page.isLast())
            .build();
    }
}
