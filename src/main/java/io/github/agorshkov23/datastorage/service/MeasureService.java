package io.github.agorshkov23.datastorage.service;

import io.github.agorshkov23.datastorage.MeasureRepository;
import io.github.agorshkov23.datastorage.config.DataStorageProperties;
import io.github.agorshkov23.datastorage.domain.Measure;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class MeasureService {

    private final MeasureRepository measureRepository;
    private final DataStorageProperties properties;

    public Page<Measure> getMeasures(int page, int size) {
        try {
            size = properties.getService().getMeasure().fixPageSize(size);
            Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "timestamp"));
            Page<Measure> measurePage = measureRepository.findAll(pageable);
            log.debug("get measures page={}, size={}, returned={}", measurePage);
            return measurePage;
        } catch (Exception e) {
            log.warn("failed get measures page={}, size={}, error={}", page, size, e.getMessage(), e);
            throw e;
        }
    }

    public Measure saveMeasure(Measure measure) {
        try {
            measure = measureRepository.save(measure);
            log.info("saved measure={}", measure);
            return measure;
        } catch (Exception e) {
            log.warn("failed save measure={}, error={}", measure, e.getMessage(), e);
            throw e;
        }
    }
}
