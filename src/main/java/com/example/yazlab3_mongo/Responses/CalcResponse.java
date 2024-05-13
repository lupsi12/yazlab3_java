package com.example.yazlab3_mongo.Responses;

import com.example.yazlab3_mongo.entities.Calc;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalcResponse {
    private Long id;
    private float cosine_similarity;
    private Long user_id;
    private Long data_id;

    public CalcResponse(Calc calcEntity) {
        this.id = calcEntity.getId();
        this.cosine_similarity = calcEntity.getCosine_similarity();
        this.user_id = calcEntity.getUser().getId();
        this.data_id = calcEntity.getData().getId();
    }
}
