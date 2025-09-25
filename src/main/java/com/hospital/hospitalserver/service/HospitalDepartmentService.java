package com.hospital.hospitalserver.service;

import com.hospital.hospitalserver.domain.dto.request.HospitalCreateDepartmentReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetDepartmentDetailReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetDepartmentPageReqDtp;
import com.hospital.hospitalserver.domain.dto.request.HospitalUpdateDepartmentReqDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetDepartmentDetailRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetDepartmentPageRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetDepartmentRespDto;
import com.hospital.hospitalserver.domain.enums.ResultCodeEnum;
import com.hospital.hospitalserver.exception.CustomException;
import com.hospital.hospitalserver.exception.GlobalExceptionHandler;
import com.hospital.hospitalserver.mapper.HospitalDepartmentMapper;
import com.hospital.hospitalserver.mapping.HospitalDepartmentMapping;
import com.hospital.hospitalserver.util.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class HospitalDepartmentService {

    @Autowired
    private HospitalDepartmentMapper hospitalDepartmentMapper;

    @Autowired
    private HospitalDepartmentMapping hospitalDepartmentMapping;

    /**
     * 新增科室
     * @param reqDto
     */
    @Transactional
    public void createDepartment(HospitalCreateDepartmentReqDto reqDto) {
        hospitalDepartmentMapper.createDepartment(reqDto);
    }

    /**
     * 查询科室详情
     * @param reqDto
     * @return
     */
    public HospitalGetDepartmentDetailRespDto getDepartmentDetail(HospitalGetDepartmentDetailReqDto reqDto) {
        return hospitalDepartmentMapper.getDepartmentDetail(reqDto);
    }

    /**
     * 修改科室信息
     * @param reqDto
     */
    @Transactional
    public void updateDepartment(HospitalUpdateDepartmentReqDto reqDto) {
        hospitalDepartmentMapper.updateDepartment(reqDto);
    }

    /**
     * 获取部门列表
     * @param reqDtp
     * @return
     */
    public PageUtils getDepartmentPageList(HospitalGetDepartmentPageReqDtp reqDtp) {
        List<HospitalGetDepartmentPageRespDto> list = null;
        reqDtp.setStart((reqDtp.getPage() - 1) * reqDtp.getSize());

        Integer count = hospitalDepartmentMapper.getDepartmentPageListCount(reqDtp);
        if (count != null && count > 0){
            list = hospitalDepartmentMapper.getDepartmentPageList(reqDtp);
        }

        return new PageUtils(list,count, reqDtp.getPage(), reqDtp.getSize());
    }

    /**
     * 获取部门列表(名称)
     * @return
     */
    public List<HospitalGetDepartmentRespDto> getDepartmentSlimNameList() {
        List<HospitalGetDepartmentRespDto> list = hospitalDepartmentMapper.getDepartmentSlimNameList();
        return list;
    }

    /**
     * 删除科室
     * @param ids
     */
    @Transactional
    public void deleteDepartmentByIds(List<Integer> ids) {
        ids.forEach(id -> {
            //validate department doctor count
           Integer count = hospitalDepartmentMapper.getDepartmentDoctors(id);
           if (count == 0){
               //delete
               hospitalDepartmentMapper.deleteDepartmentByIds(id);
               log.info("科室:{}，删除成功",id);
           }else {
               log.error("科室：{}不能删除，该科室下有绑定医生",id);
           }
        });
    }
}
