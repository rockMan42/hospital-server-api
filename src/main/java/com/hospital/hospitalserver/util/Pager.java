package com.hospital.hospitalserver.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页工具类
 * @author 李耀华
 * @date 2023年6月14日
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pager {
    //    private String user_loginname; // 用户名（用于登录） //搜索用户名
//    private String user_code; //身份证号
    private Integer startIndex;
    private Integer pageSize;
    private Integer currentPage;
}