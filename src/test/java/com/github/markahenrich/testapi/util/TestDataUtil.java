package com.github.markahenrich.testapi.util;

import com.github.markahenrich.testapi.model.GenericData;

import java.util.ArrayList;
import java.util.List;

public class TestDataUtil {
    public static List<GenericData> generateGenericDataList() {

        return new ArrayList<>(List.of(
                new GenericData(1L, "test1", 1, true),
                new GenericData(2L, "test2", 2, true),
                new GenericData(3L, "test3", 3, true),
                new GenericData(4L, "test4", 4, true)
        ));
    }
}
