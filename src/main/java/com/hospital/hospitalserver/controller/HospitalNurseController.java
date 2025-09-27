package com.hospital.hospitalserver.controller;

import com.hospital.hospitalserver.domain.dto.request.HospitalCreateNurseReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalDeleteNurseReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetNurseDetailReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetNurseFullPageReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalUpdateNurseReqDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetNurseFullPageRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetNurseProfessionTitleRespDto;
import com.hospital.hospitalserver.service.HospitalNurseService;
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
public class HospitalNurseController {

    @Autowired
    private HospitalNurseService hospitalNurseService;

    /**
     * 新增护士
     * @param reqDto
     * @return
     */
    @PostMapping("/hospital/nurse/createNurse")
    public Response createNurse(@RequestBody @Validated HospitalCreateNurseReqDto reqDto) {
        return hospitalNurseService.createNurse(reqDto);
    }

    /**
     * 获取护士完整分页列表
     * @param reqDto
     * @return
     */
    @PostMapping("/hospital/nurse/getNurseFullPage")
    public Response getNurseFullPageList(@RequestBody @Validated HospitalGetNurseFullPageReqDto reqDto) {
        PageUtils pageUtils = hospitalNurseService.getNurseFullPageList(reqDto);
        return Response.success(pageUtils);
    }

    /**
     * 查询护士详情
     * @param reqDto
     * @return
     */
    @PostMapping("/hospital/nurse/getNurseDetail")
    public Response getNurseDetail(@RequestBody @Validated HospitalGetNurseDetailReqDto reqDto) {
        HospitalGetNurseFullPageRespDto nurseDetail = hospitalNurseService.getNurseDetail(reqDto);
        return Response.success(nurseDetail);
    }

    /**
     * 修改护士信息
     * @param reqDto
     * @return
     */
    @PostMapping("/hospital/nurse/updateNurse")
    public Response updateNurse(@RequestBody @Validated HospitalUpdateNurseReqDto reqDto) {
        return hospitalNurseService.updateNurse(reqDto);
    }

    /**
     * 批量删除护士
     * @param reqDto
     * @return
     */
    @PostMapping("/hospital/nurse/deleteNurse")
    public Response deleteNurse(@RequestBody @Validated HospitalDeleteNurseReqDto reqDto) {
        return hospitalNurseService.deleteNurse(reqDto);
    }

    /**
     * 查询所有护士职称列表
     * @return
     */
    @GetMapping("/hospital/nurse/getNurseProfessionTitleList")
    public Response getNurseProfessionTitleList() {
        List<HospitalGetNurseProfessionTitleRespDto> professionTitleList = hospitalNurseService.getNurseProfessionTitleList();
        return Response.success(professionTitleList);
    }
}
