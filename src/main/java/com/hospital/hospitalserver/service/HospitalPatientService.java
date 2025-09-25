package com.hospital.hospitalserver.service;

import com.hospital.hospitalserver.domain.dto.request.HospitalCreatePatientReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetPatientReqDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetPatientPageRespDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetPatientDetailReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalUpdatePatientReqDto;
import com.hospital.hospitalserver.domain.entity.HospitalPatient;
import com.hospital.hospitalserver.mapper.HospitalPatientMapper;
import com.hospital.hospitalserver.mapping.HospitalPatientMapping;
import com.hospital.hospitalserver.util.PageUtils;
import com.hospital.hospitalserver.util.Response;
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

    /**
     * 查询患者详情
     * @param reqDto
     * @return
     */
    public HospitalGetPatientPageRespDto getPatientDetail(HospitalGetPatientDetailReqDto reqDto) {
        return hospitalPatientMapper.getPatientDetail(reqDto);
    }

    /**
     * 修改患者信息
     * @param reqDto
     * @return 受影响行数
     */
    @Transactional
    public Response updatePatient(HospitalUpdatePatientReqDto reqDto) {
        Integer count = hospitalPatientMapper.updatePatient(reqDto);
        return (count != null && count > 0) ? Response.success("更新成功") : Response.error("更新失败");
    }

    /**
     * 批量删除患者
     * @param ids 患者ID集合
     */
    @Transactional
    public Response deletePatientByIds(List<Integer> ids) {
        Integer count = hospitalPatientMapper.deletePatientByIds(ids);
        return (count != null && count > 0) ? Response.success("删除成功") : Response.error("删除失败");
    }
}
