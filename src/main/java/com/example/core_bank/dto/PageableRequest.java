package com.example.core_bank.dto;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class PageableRequest {
//    @NotNull
//     @Min(1)
    Integer pageIndex = 0;

    Integer pageSize = 10;

    Long offset;
}
