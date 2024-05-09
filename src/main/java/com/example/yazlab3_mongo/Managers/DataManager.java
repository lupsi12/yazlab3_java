package com.example.yazlab3_mongo.Managers;

import com.example.yazlab3_mongo.Repository.DataRepo;
import com.example.yazlab3_mongo.Repository.UserRepo;
import com.example.yazlab3_mongo.Requests.DataCreateRequest;
import com.example.yazlab3_mongo.Responses.DataResponse;
import com.example.yazlab3_mongo.Responses.UserResponse;
import com.example.yazlab3_mongo.Services.DataService;
import com.example.yazlab3_mongo.Services.SequenceGeneratorService;
import com.example.yazlab3_mongo.entities.Data;
import com.example.yazlab3_mongo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataManager implements DataService {
    private DataRepo dataRepo;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public DataManager(DataRepo dataRepo) {
        this.dataRepo = dataRepo;
    }

    @Override
    public List<DataResponse> getAllData() {
        List<Data> dataList = null;
        dataList = dataRepo.findAll();
        return dataList.stream().map(p -> new DataResponse(p)).collect(Collectors.toList());
    }

    @Override
    public DataResponse getDataById(Long dataId) {
        Data data = dataRepo.findById(dataId).orElse(null);
        DataResponse dataResponse = new DataResponse(data);
        return dataResponse;
    }

    @Override
    public Data addData(DataCreateRequest dataCreateRequest) {
        Data data = new Data();
        data.setId(sequenceGeneratorService.getSquenceNumber(dataCreateRequest.SEQUENCE_NAME));
        data.setName(dataCreateRequest.getName());
        data.setTitle(dataCreateRequest.getTitle());
        data.setAbstract_(dataCreateRequest.getAbstract_());
        data.setFulltext(dataCreateRequest.getFulltext());
        data.setKeywords(dataCreateRequest.getKeywords());
        return dataRepo.save(data);
    }

    @Override
    public void deleteData(Long id) {
        dataRepo.findById(id);
    }

    @Override
    public void deleteAllDatas() {
        dataRepo.deleteAll();
    }
}
