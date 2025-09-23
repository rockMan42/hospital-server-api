package com.hospital.hospitalserver.service;

import com.hospital.hospitalserver.domain.dto.request.HospitalCreateDoctorReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetDoctorPageReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetDoctorFullPageReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetDoctorDetailReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalUpdateDoctorReqDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetDoctorPageRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetDoctorFullPageRespDto;
import com.hospital.hospitalserver.mapper.HospitalClinicRoomMapper;
import com.hospital.hospitalserver.mapper.HospitalDoctorMapper;
import com.hospital.hospitalserver.mapping.HospitalDoctorMapping;
import com.hospital.hospitalserver.util.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class HospitalDoctorService {

    @Autowired
    private HospitalDoctorMapper hospitalDoctorMapper;

    @Autowired
    private HospitalDoctorMapping hospitalDoctorMapping;

    @Autowired HospitalClinicRoomMapper hospitalClinicRoomMapper;
    /**
     * 新增医生
     * @param reqDto
     */
    @Transactional
    public void createDoctor(HospitalCreateDoctorReqDto reqDto) {
        //添加医生
        hospitalDoctorMapper.createDoctor(reqDto);

        //将医生与诊室绑定
        hospitalClinicRoomMapper.bindDoctorAndClinicRoom(reqDto);
    }

    /**
     * 获取医生列表
     * @param reqDtp
     * @return
     */
    public List<HospitalGetDoctorPageRespDto> getDoctorPageList(HospitalGetDoctorPageReqDto reqDtp) {
        return hospitalDoctorMapper.getDoctorPageList(reqDtp);
    }

    /**
     * 获取医生完整分页列表
     * @param reqDtp
     * @return
     */
    public PageUtils getDoctorFullPageList(HospitalGetDoctorFullPageReqDto reqDtp) {
        List<HospitalGetDoctorFullPageRespDto> list = null;
        reqDtp.setStart((reqDtp.getPage() - 1) * reqDtp.getSize());

        Integer count = hospitalDoctorMapper.getDoctorFullPageListCount(reqDtp);
        if (count != null && count > 0) {
            list = hospitalDoctorMapper.getDoctorFullPageList(reqDtp);
        }

        return new PageUtils(list, count, reqDtp.getPage(), reqDtp.getSize());
    }

    /**
     * 查询医生详情
     * @param reqDto
     * @return
     */
    public HospitalGetDoctorFullPageRespDto getDoctorDetail(HospitalGetDoctorDetailReqDto reqDto) {
        return hospitalDoctorMapper.getDoctorDetail(reqDto);
    }

    /**
     * 修改医生信息
     * @param reqDto
     */
    @Transactional
    public void updateDoctor(HospitalUpdateDoctorReqDto reqDto) {
        // 更新医生基本信息
        hospitalDoctorMapper.updateDoctor(reqDto);
        
        // 如果传入了诊室ID，则更新医生与诊室的绑定关系
        if (reqDto.getClinicRoomId() != null) {
            hospitalClinicRoomMapper.updateDoctorClinicRoomBinding(reqDto.getId(), reqDto.getClinicRoomId());
        }
    }

    /**
     * 删除医生
     * @param ids
     */
    @Transactional
    public void deleteDoctorByIds(List<Integer> ids) {
        //删除医生
        hospitalDoctorMapper.deleteDoctorByIds(ids);

        //解绑医生和诊室
        hospitalClinicRoomMapper.unBindDoctorAndClinicRoom(ids);
    }
}
