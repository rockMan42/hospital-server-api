package com.hospital.hospitalserver.mapper;

import com.hospital.hospitalserver.domain.dto.request.HospitalCreateDoctorReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetDoctorPageReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetDoctorFullPageReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetDoctorDetailReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalUpdateDoctorReqDto;
import com.hospital.hospitalserver.domain.dto.response.GetDoctorDetailByUsername;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetDoctorPageRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetDoctorFullPageRespDto;
import com.hospital.hospitalserver.domain.entity.HospitalDoctor;
import com.hospital.hospitalserver.domain.entity.HospitalUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HospitalDoctorMapper {

    /**
     * 新增医生
     */
    Integer createDoctor(HospitalCreateDoctorReqDto reqDto);

    /**
     * 查询医生列表
     */
    List<HospitalGetDoctorPageRespDto> getDoctorPageList(HospitalGetDoctorPageReqDto reqDtp);

    /**
     * 查询医生完整分页列表
     */
    List<HospitalGetDoctorFullPageRespDto> getDoctorFullPageList(HospitalGetDoctorFullPageReqDto reqDtp);

    /**
     * 查询医生完整分页列表总数
     */
    Integer getDoctorFullPageListCount(HospitalGetDoctorFullPageReqDto reqDtp);

    /**
     * 查询医生详情
     */
    HospitalGetDoctorFullPageRespDto getDoctorDetail(HospitalGetDoctorDetailReqDto reqDto);

    /**
     * 修改医生信息
     */
    Integer updateDoctor(HospitalUpdateDoctorReqDto reqDto);

    void deleteDoctorByIds(List<Integer> ids);

    GetDoctorDetailByUsername getDoctorDetailByUsername(HospitalUser user);
}
