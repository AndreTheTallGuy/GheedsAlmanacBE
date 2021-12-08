package com.GheedsAlmanac.GheedsAlmanac.controllers;

import com.GheedsAlmanac.GheedsAlmanac.models.Record;
import com.GheedsAlmanac.GheedsAlmanac.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/records")
public class RecordController {

    private RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService){
        this.recordService = recordService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Record>> getAllRecords(){
        List<Record> response = recordService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/query/{itemName}")
    public ResponseEntity<Set<Record>> getRecordsByItemName(@PathVariable String itemName){
        String queryName = "%" + itemName + "%";
        Set<Record> response = recordService.getItems(queryName);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/post")
    public ResponseEntity<String> postRecord(@RequestBody Record record){
        String response = recordService.postRecord(record);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
