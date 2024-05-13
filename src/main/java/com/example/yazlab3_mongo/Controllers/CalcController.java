package com.example.yazlab3_mongo.Controllers;

import com.example.yazlab3_mongo.Requests.CalcCreateRequest;
import com.example.yazlab3_mongo.Responses.CalcResponse;
import com.example.yazlab3_mongo.Services.CalcService;
import com.example.yazlab3_mongo.entities.Calc;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/calc")
@AllArgsConstructor
@NoArgsConstructor
public class CalcController {
    @Autowired
    CalcService calcService;
    @GetMapping
    public List<CalcResponse> getAllCalc(@RequestParam Optional<Long> userId){
        return calcService.getAllCalc(userId);
    }
    @GetMapping("/{calcId}")
    public CalcResponse getOneCalc(@PathVariable Long calcId){
        return calcService.getCalcById(calcId);
    }
    @PostMapping
    public Calc addCalc(@RequestBody CalcCreateRequest calcCreateRequest){
        return calcService.addCalc(calcCreateRequest);
    }
    @DeleteMapping("/{referansId}")
    public void deleteOneCalc(@PathVariable Long calcId){
        calcService.deleteCalc(calcId);
    }
    @DeleteMapping
    public void deleteAllCalc(){
        calcService.deleteAllCalc();
    }
}
