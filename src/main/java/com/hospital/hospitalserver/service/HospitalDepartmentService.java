package com.hospital.hospitalserver.service;

import com.hospital.hospitalserver.domain.dto.request.HospitalGetDepartmentPageReqDtp;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetDepartmentPageRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetDepartmentRespDto;
import com.hospital.hospitalserver.mapper.HospitalDepartmentMapper;
import com.hospital.hospitalserver.mapping.HospitalDepartmentMapping;
import com.hospital.hospitalserver.util.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class HospitalDepartmentService {

    @Autowired
    private HospitalDepartmentMapper hospitalDepartmentMapper;

    @Autowired
    private HospitalDepartmentMapping hospitalDepartmentMapping;
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
}
