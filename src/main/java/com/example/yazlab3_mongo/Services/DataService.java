package com.example.yazlab3_mongo.Services;

import com.example.yazlab3_mongo.Requests.DataCreateRequest;
import com.example.yazlab3_mongo.Requests.UserCreateRequest;
import com.example.yazlab3_mongo.Responses.DataResponse;
import com.example.yazlab3_mongo.Responses.UserResponse;
import com.example.yazlab3_mongo.entities.Data;
import com.example.yazlab3_mongo.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface DataService {
    List<DataResponse> getAllData();
    DataResponse getDataById(Long dataId);
    List<DataResponse> getDataMatchKeyword(String keyword);
    Data addData(DataCreateRequest dataCreateRequest);
    void deleteData(Long id);
    void deleteAllDatas();
}
