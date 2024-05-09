package com.example.yazlab3_mongo.Controllers;

import com.example.yazlab3_mongo.Services.SequenceGeneratorService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sequence")
@AllArgsConstructor
@NoArgsConstructor
public class SequenceController {
    @Autowired
    SequenceGeneratorService sequenceGeneratorService;
    @DeleteMapping
    public void deleteAllSequence(){
        sequenceGeneratorService.deleteAllSequence();
    }
}
