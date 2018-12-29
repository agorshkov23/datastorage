package io.github.agorshkov23.datastorage;

import io.github.agorshkov23.datastorage.domain.Measure;
import org.springframework.data.repository.CrudRepository;

public interface MeasureRepository extends CrudRepository<Measure, Long> {
}
