package com.example.yazlab3_mongo.Managers;

import com.example.yazlab3_mongo.Repository.CalcRepo;
import com.example.yazlab3_mongo.Requests.CalcCreateRequest;
import com.example.yazlab3_mongo.Responses.CalcResponse;
import com.example.yazlab3_mongo.Responses.DataResponse;
import com.example.yazlab3_mongo.Responses.UserResponse;
import com.example.yazlab3_mongo.Services.CalcService;
import com.example.yazlab3_mongo.Services.DataService;
import com.example.yazlab3_mongo.Services.SequenceGeneratorService;
import com.example.yazlab3_mongo.Services.UserService;
import com.example.yazlab3_mongo.entities.Calc;
import com.example.yazlab3_mongo.entities.Data;
import com.example.yazlab3_mongo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CalcManager implements CalcService {
    private CalcRepo calcRepo;
    private UserService userService;
    private DataService dataService;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public CalcManager(CalcRepo calcRepo, UserService userService,DataService dataService, SequenceGeneratorService sequenceGeneratorService) {
        this.calcRepo = calcRepo;
        this.userService = userService;
        this.dataService = dataService;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @Override
    public List<CalcResponse> getAllCalc(Optional<Long> userId) {
        List<Calc> calcList;
        if(userId.isPresent())
            calcList = calcRepo.findByUserId(userId);
        else
            calcList = calcRepo.findAll();
        return calcList.stream().map(p -> new CalcResponse(p)).collect(Collectors.toList());

    }

    @Override
    public CalcResponse getCalcById(Long calcId) {
        Calc calc = calcRepo.findById(calcId).orElse(null);
        CalcResponse calcResponse = new CalcResponse(calc);
        return calcResponse;
    }

    @Override
    public Calc addCalc(CalcCreateRequest calcCreateRequest) {
        UserResponse userResponse = userService.getUserById(calcCreateRequest.getUser_id());
        User user = new User(userResponse);
        if (userResponse == null)
            return null;
        DataResponse dataResponse = dataService.getDataById(calcCreateRequest.getData_id());
        Data data = new Data(dataResponse);
        if (dataResponse == null)
            return null;
        Calc calc = new Calc();
        calc.setUser(user);
        calc.setData(data);
        calc.setId(sequenceGeneratorService.getSquenceNumber(calcCreateRequest.SEQUENCE_NAME));
        calc.setCosine_similarity(calcCreateRequest.getCosine_similarity());
        return calcRepo.save(calc);
    }


    @Override
    public void deleteCalc(Long calcId) {
        calcRepo.deleteById(calcId);
    }

    @Override
    public void deleteAllCalc() {
        calcRepo.deleteAll();
    }
}
