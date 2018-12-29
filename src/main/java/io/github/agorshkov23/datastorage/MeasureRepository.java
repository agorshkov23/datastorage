package io.github.agorshkov23.datastorage;

import io.github.agorshkov23.datastorage.domain.Measure;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MeasureRepository extends PagingAndSortingRepository<Measure, Long> {
}
