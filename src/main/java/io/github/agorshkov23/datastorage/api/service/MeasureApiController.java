package io.github.agorshkov23.datastorage.api.service;

import io.github.agorshkov23.datastorage.api.model.ApiMeasure;
import io.github.agorshkov23.datastorage.domain.Measure;
import io.github.agorshkov23.datastorage.mapper.MeasureMapper;
import io.github.agorshkov23.datastorage.service.MeasureService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("api/datastorage/measures")
public class MeasureApiController {

    private final MeasureService measureService;
    private final MeasureMapper measureMapper;

    @PostMapping
    public ResponseEntity<ApiMeasure> save(
        @Valid @RequestBody ApiMeasure apiMeasure
    ) {
        Measure measure = measureMapper.toMeasure(apiMeasure);
        measure = measureService.save(measure);
        apiMeasure = measureMapper.toApiMeasure(measure);
        return ResponseEntity.ok(apiMeasure);
    }
}
