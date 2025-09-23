package com.hospital.hospitalserver.domain;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageAndSizeDto {
    @NotNull(message = "page不能为空")
    private Integer page;

    @NotNull(message = "size不能为空")
    private Integer size;
}
