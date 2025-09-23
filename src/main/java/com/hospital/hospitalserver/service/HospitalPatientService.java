package com.hospital.hospitalserver.service;

import com.hospital.hospitalserver.domain.dto.request.HospitalCreatePatientReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetPatientReqDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetPatientPageRespDto;
import com.hospital.hospitalserver.domain.entity.HospitalPatient;
import com.hospital.hospitalserver.mapper.HospitalPatientMapper;
import com.hospital.hospitalserver.mapping.HospitalPatientMapping;
import com.hospital.hospitalserver.util.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class HospitalPatientService {
    @Autowired
    private HospitalPatientMapper hospitalPatientMapper;

    @Autowired
    private HospitalPatientMapping hospitalPatientMapping;
    /**
     * 新增患者
     * @param reqDto
     */
    @Transactional
    public void createPatient(HospitalCreatePatientReqDto reqDto){
        hospitalPatientMapper.createPatient(hospitalPatientMapping.toCreatePatient(reqDto));
    }

    /**
     * 获取患者列表
     * @param reqDto
     * @return
     */
    public PageUtils getPatientPage(HospitalGetPatientReqDto reqDto){
        List<HospitalPatient> list = null;
        reqDto.setStart((reqDto.getPage() - 1) * reqDto.getSize());

        Integer count = hospitalPatientMapper.getPatientCount(reqDto);
        if (count != null && count > 0){
            list = hospitalPatientMapper.getPatientPage(reqDto);
        }
        List<HospitalGetPatientPageRespDto> getPatientRespDto = hospitalPatientMapping.toGetPatientRespDto(list);

        return new PageUtils(getPatientRespDto,count, reqDto.getPage(), reqDto.getSize());
    }
}
