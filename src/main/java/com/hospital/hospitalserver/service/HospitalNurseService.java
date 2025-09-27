package com.hospital.hospitalserver.service;

import com.hospital.hospitalserver.domain.dto.request.HospitalCreateNurseReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalDeleteNurseReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetNurseDetailReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalGetNurseFullPageReqDto;
import com.hospital.hospitalserver.domain.dto.request.HospitalUpdateNurseReqDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetNurseFullPageRespDto;
import com.hospital.hospitalserver.domain.dto.response.HospitalGetNurseProfessionTitleRespDto;
import com.hospital.hospitalserver.mapper.HospitalClinicRoomMapper;
import com.hospital.hospitalserver.mapper.HospitalNurseMapper;
import com.hospital.hospitalserver.util.PageUtils;
import com.hospital.hospitalserver.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class HospitalNurseService {

    @Autowired
    private HospitalNurseMapper hospitalNurseMapper;

    @Autowired
    private HospitalClinicRoomMapper hospitalClinicRoomMapper;

    /**
     * 新增护士
     * @param reqDto
     */
    @Transactional
    public Response createNurse(HospitalCreateNurseReqDto reqDto) {
        //添加护士
        Integer id = hospitalNurseMapper.createNurse(reqDto);

        if (id != null) {
            //将护士与诊室绑定
            Integer bindCount = hospitalClinicRoomMapper.bindNurseAndClinicRoom(reqDto);
            if (bindCount != null) {
                return Response.success("新增并绑定成功");
            } else {
                return Response.error("绑定失败");
            }
        } else {
            return Response.error("新增失败");
        }
    }

    /**
     * 获取护士完整分页列表
     * @param reqDto
     * @return
     */
    public PageUtils getNurseFullPageList(HospitalGetNurseFullPageReqDto reqDto) {
        List<HospitalGetNurseFullPageRespDto> list = null;
        reqDto.setStart((reqDto.getPage() - 1) * reqDto.getSize());

        Integer count = hospitalNurseMapper.getNurseFullPageListCount(reqDto);
        if (count != null && count > 0) {
            list = hospitalNurseMapper.getNurseFullPageList(reqDto);
        }

        return new PageUtils(list, count != null ? count : 0, reqDto.getPage(), reqDto.getSize());
    }

    /**
     * 查询护士详情
     * @param reqDto
     * @return
     */
    public HospitalGetNurseFullPageRespDto getNurseDetail(HospitalGetNurseDetailReqDto reqDto) {
        return hospitalNurseMapper.getNurseDetail(reqDto);
    }

    /**
     * 修改护士信息
     * @param reqDto
     */
    @Transactional
    public Response updateNurse(HospitalUpdateNurseReqDto reqDto) {
        // 更新护士基本信息
        Integer count = hospitalNurseMapper.updateNurse(reqDto);
        
        // 如果传入了诊室ID，则更新护士与诊室的绑定关系
        if (reqDto.getClinicRoomId() != null && count != null) {
            Integer updatedCount = hospitalClinicRoomMapper.updateNurseClinicRoomBinding(reqDto.getId(), reqDto.getClinicRoomId());
            if (updatedCount != null) {
                return Response.success("更新成功");
            } else {
                return Response.error("诊室绑定更新失败");
            }
        } else if (count != null) {
            return Response.success("更新成功");
        } else {
            return Response.error("更新失败");
        }
    }

    /**
     * 批量删除护士
     * @param reqDto
     */
    @Transactional
    public Response deleteNurse(HospitalDeleteNurseReqDto reqDto) {
        // 先解绑护士与诊室的关系
        Integer unbindCount = hospitalClinicRoomMapper.unBindNurseAndClinicRoom(reqDto.getIds());
        
        // 删除护士基本信息
        Integer deleteCount = hospitalNurseMapper.deleteNurse(reqDto);
        
        if (deleteCount != null && deleteCount > 0) {
            return Response.success("删除成功，共删除" + deleteCount + "条记录");
        } else {
            return Response.error("删除失败");
        }
    }

    /**
     * 查询所有护士职称列表
     * @return
     */
    public List<HospitalGetNurseProfessionTitleRespDto> getNurseProfessionTitleList() {
        return hospitalNurseMapper.getNurseProfessionTitleList();
    }
}
