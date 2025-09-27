package com.hospital.hospitalserver.service;

import com.hospital.hospitalserver.domain.dto.request.HospitalCreateDoctorReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetDoctorPageReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetDoctorFullPageReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetDoctorDetailReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalUpdateDoctorReqDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetDoctorPageRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetDoctorFullPageRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetProfessionTitleRespDto;
import com.hospital.hospitalserver.mapper.HospitalClinicRoomMapper;
import com.hospital.hospitalserver.mapper.HospitalDoctorMapper;
import com.hospital.hospitalserver.mapping.HospitalDoctorMapping;
import com.hospital.hospitalserver.util.PageUtils;
import com.hospital.hospitalserver.util.Response;
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
    public Response createDoctor(HospitalCreateDoctorReqDto reqDto) {
        //添加医生
        Integer id =  hospitalDoctorMapper.createDoctor(reqDto);

        if (id != null) {
            //将医生与诊室绑定
            Integer bindCount = hospitalClinicRoomMapper.bindDoctorAndClinicRoom(reqDto);
            if (bindCount != null) {
                return Response.success("新增并绑定成功");
            }else {
                return Response.success("绑定失败");
            }
        }else {
            return Response.error("新增失败");
        }

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
    public Response updateDoctor(HospitalUpdateDoctorReqDto reqDto) {
        // 更新医生基本信息
        Integer count = hospitalDoctorMapper.updateDoctor(reqDto);
        
        // 如果传入了诊室ID，则更新医生与诊室的绑定关系
        if (reqDto.getClinicRoomId() != null && count != null) {
            Integer updatedCount = hospitalClinicRoomMapper.updateDoctorClinicRoomBinding(reqDto.getId(), reqDto.getClinicRoomId());
            if (updatedCount != null) {
                return Response.success("更新成功");
            }else {
                return Response.error("解绑失败");
            }
        }else{
            return Response.error("更新失败");
        }
    }

    /**
     * 删除医生
     * @param ids
     */
    @Transactional
    public Response deleteDoctorByIds(List<Integer> ids) {
        //删除医生
        Integer count = hospitalDoctorMapper.deleteDoctorByIds(ids);

        if (count != null) {
            //解绑医生和诊室
            Integer unBindCount = hospitalClinicRoomMapper.unBindDoctorAndClinicRoom(ids);
            if (unBindCount != null) {
                return Response.success("更新并解绑成功");
            }else {
                return Response.error("解绑失败");
            }
        }else{
            Response.error("更新失败");
        }

        return null;
    }

    /**
     * 查询所有职称列表
     * @return
     */
    public List<HospitalGetProfessionTitleRespDto> getProfessionTitleList() {
        return hospitalDoctorMapper.getProfessionTitleList();
    }
}
