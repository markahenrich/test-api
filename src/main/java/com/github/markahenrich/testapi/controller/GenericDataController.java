package com.github.markahenrich.testapi.controller;

import com.github.markahenrich.testapi.model.GenericData;
import com.github.markahenrich.testapi.service.GenericDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GenericDataController {
    GenericDataService genericDataService;

    public GenericDataController(GenericDataService genericDataService) {
        this.genericDataService = genericDataService;
    }

    @GetMapping("/data")
    public ResponseEntity<List<GenericData>> getData() {
        List<GenericData> data = genericDataService.getData();

        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/data/{id}")
    public ResponseEntity<GenericData> getDataById(@PathVariable Long id) {
        GenericData data = genericDataService.getDataById(id);

        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PutMapping("/data/{id}")
    public ResponseEntity updateData(@PathVariable Long id, @RequestBody GenericData data) {
        GenericData updatedData;
        try {
            updatedData = genericDataService.updateData(data, id);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(updatedData, HttpStatus.OK);
    }

    @PostMapping("/data")
    public ResponseEntity addData(@RequestBody GenericData data) {
        try {
            genericDataService.addData(data);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/data/list")
    public ResponseEntity addDataList(@RequestBody List<GenericData> dataList) {
        genericDataService.addDataList(dataList);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/data/{id}")
    public ResponseEntity deleteDataById(@PathVariable Long id) {
        genericDataService.deleteDataById(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/data/clearlist")
    public ResponseEntity clearDataList() {
        genericDataService.clearData();

        return new ResponseEntity(HttpStatus.OK);
    }
}
