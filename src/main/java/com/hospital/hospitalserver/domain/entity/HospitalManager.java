package com.hospital.hospitalserver.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 管理员
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalManager implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 管理员id
     */
    private Integer id;

    /**
     * 管理员姓名
     */
    private String name;

    /**
     * 工号
     */
    private String workId;


    /**
     * 医生职称ID
     */
    private Integer mptId;

    /**
     * 诊室id
     */
    private Integer clinicRoomId;


    /**
     * 联系电话
     */
    private String phone;

}
