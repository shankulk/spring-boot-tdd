package com.shankulk.dto;

import lombok.Data;

@Data
public class PursuitDto {

    private String pursuitName;
    private String objectiveName;
    private String metric;
    private String comparator;
    private Double value;

}
