package com.hospital.hospitalserver.controller.department;

import com.hospital.hospitalserver.domain.dto.request.*;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetDepartmentDetailRespDto;
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

import java.util.List;

@RestController
@Slf4j
public class HospitalDepartmentController {

    @Autowired
    private HospitalDepartmentService hospitalDepartmentService;

    /**
     * 删除科室
     * @param reqDto
     * @return
     */
    @PostMapping("/hospital/department/deleteDepartment")
    private Response deleteDepartmentByIds(@RequestBody @Validated HospitalDeleteDepartmentReqDto reqDto) {
        List<Integer> ids = reqDto.getIds();
        hospitalDepartmentService.deleteDepartmentByIds(ids);
        return Response.success();
    }
    /**
     * 新增科室
     * @param reqDto
     * @return
     */
    @PostMapping("/hospital/department/createDepartment")
    public Response createDepartment(@RequestBody @Validated HospitalCreateDepartmentReqDto reqDto) {
        hospitalDepartmentService.createDepartment(reqDto);
        return Response.success();
    }

    /**
     * 查询科室详情
     * @param reqDto
     * @return
     */
    @PostMapping("/hospital/department/getDepartmentDetail")
    public Response getDepartmentDetail(@RequestBody @Validated HospitalGetDepartmentDetailReqDto reqDto) {
        HospitalGetDepartmentDetailRespDto departmentDetail = hospitalDepartmentService.getDepartmentDetail(reqDto);
        return Response.success(departmentDetail);
    }

    /**
     * 修改科室信息
     * @param reqDto
     * @return
     */
    @PostMapping("/hospital/department/updateDepartment")
    public Response updateDepartment(@RequestBody @Validated HospitalUpdateDepartmentReqDto reqDto) {
        hospitalDepartmentService.updateDepartment(reqDto);
        return Response.success();
    }

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
