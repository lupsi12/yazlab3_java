package com.example.yazlab3_mongo.Controllers;

import com.example.yazlab3_mongo.Requests.DataCreateRequest;
import com.example.yazlab3_mongo.Requests.UserCreateRequest;
import com.example.yazlab3_mongo.Responses.DataResponse;
import com.example.yazlab3_mongo.Responses.UserResponse;
import com.example.yazlab3_mongo.Services.DataService;
import com.example.yazlab3_mongo.Services.UserService;
import com.example.yazlab3_mongo.entities.Data;
import com.example.yazlab3_mongo.entities.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/data")
@AllArgsConstructor
@NoArgsConstructor
public class DataController {
    @Autowired
    private DataService dataService;
    @GetMapping
    public List<DataResponse> getAllDatas(){
        return dataService.getAllData();
    }
    @GetMapping("/{dataId}")
    public DataResponse getOneData(@PathVariable Long dataId){
        return dataService.getDataById(dataId);
    }
    @PostMapping
    public Data addData(@RequestBody DataCreateRequest dataCreateRequest){
        return dataService.addData(dataCreateRequest);
    }
    @DeleteMapping("/{dataId}")
    public void deleteOneData(@PathVariable Long dataId){
        dataService.deleteData(dataId);
    }
    @DeleteMapping
    public void deleteAllDatas(){
        dataService.deleteAllDatas();
    }
}
