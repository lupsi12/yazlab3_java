package com.example.yazlab3_mongo.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataResponse {
    private Long id;
    private String name;
    private String title;
    private String abstract_;
    private String fulltext;
    private String keywords;

    public DataResponse(com.example.yazlab3_mongo.entities.Data dataEntity) {
        this.id = dataEntity.getId();
        this.name = dataEntity.getName();
        this.title = dataEntity.getTitle();
        this.abstract_ = dataEntity.getAbstract_();
        this.fulltext = dataEntity.getFulltext();
        this.keywords = dataEntity.getKeywords();
    }
}
