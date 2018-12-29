package io.github.agorshkov23.datastorage.api.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiMeasureTest {

    @Test
    public void constructorTest() {
        ApiMeasure apiMeasure = new ApiMeasure();
        assertNotNull(apiMeasure, "apiMeasure");
    }
}