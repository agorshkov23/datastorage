package io.github.agorshkov23.datastorage.api.service;

import io.github.agorshkov23.datastorage.api.model.ApiMeasure;
import io.github.agorshkov23.datastorage.api.model.ApiPage;
import io.github.agorshkov23.datastorage.domain.Measure;
import io.github.agorshkov23.datastorage.mapper.MeasureMapper;
import io.github.agorshkov23.datastorage.mapper.PageMapper;
import io.github.agorshkov23.datastorage.service.MeasureService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("api/ds/measures")
public class MeasureApiController {

    private final MeasureService measureService;

    private final MeasureMapper measureMapper;
    private final PageMapper pageMapper;

    @GetMapping
    public ResponseEntity<ApiPage<ApiMeasure>> get(
        @RequestParam(defaultValue = "0") Integer page,
        @RequestParam(defaultValue = "5") Integer size
    ) {
        Page<Measure> measures = measureService.getMeasures(page, size);
        Page<ApiMeasure> apiMeasurePage = measures.map(measureMapper::toApiMeasure);
        return ResponseEntity.ok(pageMapper.toApiPage(apiMeasurePage));
    }

    @PostMapping
    public ResponseEntity<ApiMeasure> save(
        @Valid @RequestBody ApiMeasure apiMeasure
    ) {
        Measure measure = measureMapper.toMeasure(apiMeasure);
        measure = measureService.saveMeasure(measure);
        apiMeasure = measureMapper.toApiMeasure(measure);
        return ResponseEntity.ok(apiMeasure);
    }
}
