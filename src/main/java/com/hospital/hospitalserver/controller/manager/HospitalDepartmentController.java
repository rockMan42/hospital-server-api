package com.hospital.hospitalserver.controller.manager;

import com.hospital.hospitalserver.domain.dto.request.HospitalGetDepartmentPageReqDtp;
import com.hospital.hospitalserver.service.HospitalDepartmentService;
import com.hospital.hospitalserver.util.PageUtils;
import com.hospital.hospitalserver.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HospitalDepartmentController {

    @Autowired
    private HospitalDepartmentService hospitalDepartmentService;

    /**
     * 獲取部門列表
     *
     * @param reqDtp
     * @return
     */
    @PostMapping("/hospital/department/getDepartmentPage")
    public Response getDepartmentPage(@RequestBody @Validated HospitalGetDepartmentPageReqDtp reqDtp) {
        PageUtils pageUtils = hospitalDepartmentService.getDepartmentPageList(reqDtp);
        return Response.success(pageUtils);
    }

    /**
     * 獲取部門簡稱列表（名称）
     * @return
     */
    @GetMapping("/hospital/department/getDepartmentList")
    public Response getDepartmentSlimNameList() {
        return Response.success(hospitalDepartmentService.getDepartmentSlimNameList());
    }
}
