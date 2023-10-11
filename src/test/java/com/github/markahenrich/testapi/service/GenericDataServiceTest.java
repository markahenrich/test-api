package com.github.markahenrich.testapi.service;

import com.github.markahenrich.testapi.model.GenericData;
import com.github.markahenrich.testapi.util.TestDataUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class GenericDataServiceTest {
    GenericDataService genericDataService;

    @BeforeEach
    public void setUp() {
        genericDataService = new GenericDataService();
        genericDataService.addDataList(TestDataUtil.generateGenericDataList());
    }

    @Test
    public void GetDataById_WhenCalledWithId_ReturnsCorrectEntity() {
        GenericData data = genericDataService.getDataById(2L);

        assertEquals(2L, data.getId());
    }

    @Test
    public void ClearList_WhenCalled_DeletesAllEntities() {
        genericDataService.clearData();

        assertEquals(0, genericDataService.getData().size());
    }

    @Test
    public void UpdateData_WhenCalled_CorrectlyUpdatesData() throws Exception {
        GenericData data = genericDataService.getDataById(1L);
        String updatedString = "Updated String";
        data.setStrData(updatedString);
        GenericData updatedData = genericDataService.updateData(data, 1L);

        assertEquals(updatedString, updatedData.getStrData());
    }

    @Test
    public void DeleteData_WhenCalledWithId_CorrectlyDeletesEntity() {
        genericDataService.deleteDataById(1L);
        List<GenericData> dataList = genericDataService.getData();
        GenericData filteredData = dataList.stream().filter(d -> d.getId().equals(1L)).findAny().orElse(null);

        assertNull(filteredData);
    }
}