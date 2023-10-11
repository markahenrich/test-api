package com.github.markahenrich.testapi.service;

import com.github.markahenrich.testapi.model.GenericData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenericDataService {
    List<GenericData> data;

    public GenericDataService() {
        data = new ArrayList<>();
    }

    public List<GenericData> getData() {
        return data;
    }

    public GenericData getDataById(Long id) {
        return data.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void deleteDataById(Long id) {
        GenericData foundData = getDataById(id);

        if (foundData != null) {
            data.remove(foundData);
        }
    }

    public void setData(List<GenericData> data) {
        this.data = data;
    }

    public void addData(GenericData dataEntity) throws Exception {
        GenericData existing = data.stream()
                .filter(d -> d.getId().equals(dataEntity.getId()))
                .findAny()
                .orElse(null);

        if (existing != null) {
            throw new Exception("Element already exists with Id");
        }

        data.add(dataEntity);
    }

    public void addDataList(List<GenericData> dataList) {
        data = dataList;
    }

    public void clearData() {
        data = new ArrayList<>();
    }

    public GenericData updateData(GenericData updatedData, Long id) throws Exception {
        GenericData foundData = getDataById(id);

        if (foundData == null) {
            throw new Exception("Entity to be updated could not be found");
        }

        foundData.setStrData(updatedData.getStrData());
        foundData.setNumData(updatedData.getNumData());
        foundData.setEnabled(updatedData.isEnabled());

        return foundData;
    }
}
