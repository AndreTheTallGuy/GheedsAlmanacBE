package com.GheedsAlmanac.GheedsAlmanac.services;


import com.GheedsAlmanac.GheedsAlmanac.models.Record;
import com.GheedsAlmanac.GheedsAlmanac.repos.RecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RecordService {

    private RecordRepo recordRepo;

    @Autowired
    public RecordService(RecordRepo recordRepo){
        this.recordRepo = recordRepo;
    }

    public List<Record> getAll(){ return recordRepo.findAll();}

    public Set<Record> getItems(String itemName){ return recordRepo.getItems(itemName);}

    public String postRecord(Record recordObj){
        try {
            recordRepo.save(recordObj);
            return "Record saved successfully!";
        } catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
