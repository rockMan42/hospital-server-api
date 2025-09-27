package com.hospital.hospitalserver.mapper;

import com.hospital.hospitalserver.domain.dto.request.HospitalCreateNurseReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalDeleteNurseReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetNurseDetailReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetNurseFullPageReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalUpdateNurseReqDto;
import com.hospital.hospitalserver.domain.dto.response.GetNurseDetailByUsername;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetNurseFullPageRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetNurseProfessionTitleRespDto;
import com.hospital.hospitalserver.domain.entity.HospitalUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HospitalNurseMapper {

    /**
     * 新增护士
     */
    Integer createNurse(HospitalCreateNurseReqDto reqDto);

    /**
     * 查询护士完整分页列表
     */
    List<HospitalGetNurseFullPageRespDto> getNurseFullPageList(HospitalGetNurseFullPageReqDto reqDto);

    /**
     * 查询护士完整分页列表总数
     */
    Integer getNurseFullPageListCount(HospitalGetNurseFullPageReqDto reqDto);

    /**
     * 查询所有护士职称列表
     */
    List<HospitalGetNurseProfessionTitleRespDto> getNurseProfessionTitleList();

    /**
     * 查询护士详情
     */
    HospitalGetNurseFullPageRespDto getNurseDetail(HospitalGetNurseDetailReqDto reqDto);

    /**
     * 修改护士信息
     */
    Integer updateNurse(HospitalUpdateNurseReqDto reqDto);

    /**
     * 批量删除护士
     */
    Integer deleteNurse(HospitalDeleteNurseReqDto reqDto);

    /**
     * 根据用户名查询护士详情
     */
    GetNurseDetailByUsername getNurseDetailByUsername(HospitalUser user);
}
