package com.hospital.hospitalserver.service;


import com.hospital.hospitalserver.domain.BaseUser;
import com.hospital.hospitalserver.domain.dto.request.HospitalCreateUser;
import com.hospital.hospitalserver.domain.entity.HospitalUser;
import com.hospital.hospitalserver.domain.enums.ResultCodeEnum;
import com.hospital.hospitalserver.mapper.HospitalDoctorMapper;
import com.hospital.hospitalserver.mapper.HospitalManagerMapper;
import com.hospital.hospitalserver.mapper.HospitalNurseMapper;
import com.hospital.hospitalserver.mapper.HospitalUserMapper;
import com.hospital.hospitalserver.util.EncryptHelper;
import com.hospital.hospitalserver.util.Response;
import com.hospital.hospitalserver.util.TokenUtils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户模块实现类
 */
@Service
@Slf4j
public class HospitalUserService {

    @Autowired
    private HospitalUserMapper hospitalUserMapper;

    @Autowired
    private HospitalDoctorMapper hospitalDoctorMapper;

    @Autowired
    private HospitalManagerMapper hospitalManagerMapper;

    @Autowired
    private HospitalNurseMapper hospitalNurseMapper;
    /**
     * 定义方法
     * 用户登录
     */
    public Response login(HospitalUser user) {
        // 1.validate exist
        HospitalUser u = hospitalUserMapper.validateUserExist(user);

        if (u == null) {
            log.error("用户不存在");
            return Response.error(ResultCodeEnum.LOGIN_ERROR);
        }

        //2. validate active
        if (Boolean.FALSE.equals(u.getIsActive())) {
            log.error("该用户处于未激活的状态");
            return Response.error(ResultCodeEnum.LOGIN_ERROR);
        }

        //3. validate password
        String encodePassword = EncryptHelper.SHA(user.getPassword());
        if (!encodePassword.equals(u.getPassword())) {
            log.error("密码不正确");
            return Response.error(ResultCodeEnum.LOGIN_ERROR);
        }

        //4. generate token
        String token = TokenUtils.sign(user);

        //get user detail by role
        Object userData = null;
        BaseUser baseUser = hospitalUserMapper.getBaseUserByUsername(user);
        String roleName = baseUser.getRoleName();
        switch (roleName) {
            case "doctor":
                userData = hospitalDoctorMapper.getDoctorDetailByUsername(user);
                break;
            case "nurse":
                userData = hospitalNurseMapper.getNurseDetailByUsername(user);
                break;
            case "manager":
                userData = hospitalManagerMapper.getManagerDetailByUsername(user);
                break;
            default:
                userData = baseUser;
        }

        log.info("username:{},登录成功",user.getUsername());
        Map<Object, Object> response = new HashMap<>();
        response.put("token",token);
        response.put("user",userData);
        response.put("role",roleName);

        return Response.success(ResultCodeEnum.LOGIN_SUCCESS,response);
    }

    /**
     * 创建用户
     * @param createUser
     * @return
     */
    public Integer createUser(HospitalCreateUser createUser) {
        // validate user exist
        HospitalUser hospitalUser = hospitalUserMapper.validateUserExistByUsername(createUser);
        if (hospitalUser != null){
            log.info("username:{}已存在",hospitalUser.getUsername());
            return hospitalUser.getId();
        }

        String encodePassword = EncryptHelper.SHA(createUser.getPassword());
        createUser.setPassword(encodePassword);
        Integer id = hospitalUserMapper.createUser(createUser);
        return id;
    }
}
