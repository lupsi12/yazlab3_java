package com.example.yazlab3_mongo.Services;

import com.example.yazlab3_mongo.Requests.CalcCreateRequest;
import com.example.yazlab3_mongo.Responses.CalcResponse;
import com.example.yazlab3_mongo.entities.Calc;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CalcService {
    List<CalcResponse> getAllCalc(Optional<Long> userId);
    CalcResponse getCalcById(Long calcId);
    Calc addCalc(CalcCreateRequest calcCreateRequest);
    void deleteCalc(Long calcId);
    void deleteAllCalc();
}
