package com.hospital.hospitalserver.service;

import com.hospital.hospitalserver.domain.dto.request.*;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetClinicRoomDetailRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetClinicRoomPageRespDto;
import com.hospital.hospitalserver.domain.entity.HospitalClinicRoom;
import com.hospital.hospitalserver.domain.enums.ResultCodeEnum;
import com.hospital.hospitalserver.exception.CustomException;
import com.hospital.hospitalserver.mapper.HospitalClinicRoomMapper;
import com.hospital.hospitalserver.mapping.HospitalClinicRoomMapping;
import com.hospital.hospitalserver.util.PageUtils;
import com.hospital.hospitalserver.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class HospitalClinicRoomService {

    @Autowired
    private HospitalClinicRoomMapper hospitalClinicRoomMapper;

    @Autowired
    private HospitalClinicRoomMapping hospitalClinicRoomMapping;
    /**
     * 获取诊室列表(名称)
     * @param requestDto
     * @return
     */
    public List<HospitalGetClinicRoomPageRespDto> getClinicRoomSlimNameList(HospitalGetClinicRoomPageReqDto requestDto) {
        return hospitalClinicRoomMapper.getClinicRoomSlimNameList(requestDto);
    }

    /**
     * 获取诊室分页列表
     * @param reqDto
     * @return
     */
    public PageUtils getClinicRoomPageList(HospitalGetClinicRoomPageReqDto reqDto) {
        List<HospitalGetClinicRoomDetailRespDto> clinicRoomList = null;
        Integer total = null;
        try{
             total = hospitalClinicRoomMapper.getClinicRoomCount(reqDto);
            if (total != null && total > 0){
                reqDto.setStart((reqDto.getPage() - 1) * reqDto.getSize());
                clinicRoomList  = hospitalClinicRoomMapper.getClinicRoomPageList(reqDto);
            }
        }catch (Exception e){
            log.error("查询诊室列表时出错");
            throw new CustomException(ResultCodeEnum.ERROR, "查询诊室列表时出错");
        }

        return new PageUtils(clinicRoomList, total, reqDto.getPage(), reqDto.getSize());
    }

    /**
     * 查询诊室详情
     * @param reqDto
     * @return
     */
    public Response getClinicRoomDetail(HospitalGetClinicRoomDetailReqDto reqDto) {
        HospitalGetClinicRoomDetailRespDto clinicRoomDetail = hospitalClinicRoomMapper.getClinicRoomDetail(reqDto);
        return clinicRoomDetail != null ? Response.success(clinicRoomDetail) : Response.error("查询诊室详情失败");
    }

    /**
     * 新增诊室
     * @param reqDto
     * @return
     */
    @Transactional
    public Response createClinicRoom(HospitalCreateClinicRoomReqDto reqDto) {
        try{
           //检查诊室编号是否重复
            if (hospitalClinicRoomMapper.checkRoomNumberExists(reqDto.getRoomNumber()) > 0) {
                log.error("诊室编号重复");
                throw new CustomException(ResultCodeEnum.ERROR,"诊室编号重复");
            }

            //transfer
            HospitalClinicRoom hospitalClinicRoom = hospitalClinicRoomMapping.toHospitalClinicRoom(reqDto);
            Integer clinicRoomId = hospitalClinicRoomMapper.createClinicRoom(hospitalClinicRoom);
            return clinicRoomId != null ? Response.success(ResultCodeEnum.SUCCESS,"创建科室成功"): Response.error("创建诊室失败");
        }catch (Exception e){
            log.error("创建诊室失败");
            throw  new CustomException(ResultCodeEnum.ERROR,"创建科室失败");
        }
    }

    /**
     * 更新诊室信息
     * @param reqDto
     * @return
     */
    @Transactional
    public Response updateClinicRoom(HospitalUpdateClinicRoomReqDto reqDto) {
        try{
            //检查诊室是否存在（排除自己）
            if (hospitalClinicRoomMapper.checkRoomNumberExistsExcludeSelf(reqDto.getRoomNumber(), reqDto.getId()) > 0) {
                log.error("诊室重复");
                throw new CustomException(ResultCodeEnum.ERROR, "诊室重复");
            }

            //transfer
            HospitalClinicRoom hospitalUpdateClinicRoom = hospitalClinicRoomMapping.toHospitalUpdateClinicRoom(reqDto);

            //update
            Integer count = hospitalClinicRoomMapper.updateClinicRoom(hospitalUpdateClinicRoom);
            return count != null && count > 0 ? Response.success(ResultCodeEnum.SUCCESS, "更新诊室成功") : Response.error("更新诊室失败");
        }catch (Exception e){
            log.error("更新诊室时出错");
            return Response.error(ResultCodeEnum.ERROR);
        }
    }

    /**
     * 批量删除诊室
     * @param ids 诊室ID集合
     * @return
     */
    @Transactional
    public Response deleteClinicRoomByIds(List<Integer> ids) {
        try{
            List<Integer> roomIdList = new ArrayList<>();
            //检查诊室下是否关联医生
            ids.forEach(roomId -> {
                Integer doctorCount = hospitalClinicRoomMapper.checkDoctorsInClinicRooms(roomId);
                if (doctorCount > 0 && doctorCount != null){
                    log.error("roomId:{},下关联着医生,", roomId);
                    roomIdList.add(roomId);
                }

                if (!roomIdList.isEmpty()) {
                    throw new CustomException(ResultCodeEnum.ERROR, "部分诊室下有关联医生不能删除");
                }
            });
            //所有诊室无关联可删除
            Integer count = hospitalClinicRoomMapper.deleteClinicRoomByIds(ids);
            return count != null && count > 0 ? Response.success(ResultCodeEnum.SUCCESS) : Response.error(ResultCodeEnum.ERROR);
        }catch (Exception e){
                throw new CustomException(ResultCodeEnum.ERROR);
        }

    }
}
