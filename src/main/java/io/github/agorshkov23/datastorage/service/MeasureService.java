package io.github.agorshkov23.datastorage.service;

import io.github.agorshkov23.datastorage.MeasureRepository;
import io.github.agorshkov23.datastorage.domain.Measure;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@AllArgsConstructor
public class MeasureService {

    private final MeasureRepository measureRepository;

    public Measure save(Measure measure) {
        try {
            measure = measureRepository.save(measure);
            log.info("saved measure={}", measure);
            return measure;
        } catch (Exception e) {
            log.warn("failed save measure={}", measure);
            throw e;
        }
    }
}
