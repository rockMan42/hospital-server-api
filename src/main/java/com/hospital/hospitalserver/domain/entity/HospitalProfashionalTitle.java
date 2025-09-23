package com.hospital.hospitalserver.domain.entity;

import com.hospital.hospitalserver.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 医生职称
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalProfashionalTitle extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 职称名称：主任医师，副主任医师，主治医师，住院医师
     */
    private String professionTitle;
}
