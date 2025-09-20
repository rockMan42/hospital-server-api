package com.hospital.hospitalserver.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private Integer userId;
    private String username;
    private String password;
}
