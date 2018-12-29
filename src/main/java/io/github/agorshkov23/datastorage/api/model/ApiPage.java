package io.github.agorshkov23.datastorage.api.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ApiPage<T> {

    /**
     * Содержимое страницы.
     */
    private List<T> content;

    /**
     * Номер страницы.
     */
    private int page;

    /**
     * Размер страницы.
     */
    private int size;

    /**
     * Количество страниц.
     */
    private int pages;

    /**
     * Количество элементов.
     */
    private long elements;

    /**
     * Признак последней страницы.
     */
    private boolean last;
}
