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
    private float cosine_similarity_fasttext;
    private float cosine_similarity_scibert;
    private Long user_id;
    private Long data_id;
    private boolean like;

    public CalcResponse(Calc calcEntity) {
        this.id = calcEntity.getId();
        this.cosine_similarity_fasttext =calcEntity.getCosine_similarity_fasttext();
        this.cosine_similarity_scibert = calcEntity.getCosine_similarity_scibert();
        this.user_id = calcEntity.getUser().getId();
        this.data_id = calcEntity.getData().getId();
        this.like = calcEntity.isLike();
    }
}
