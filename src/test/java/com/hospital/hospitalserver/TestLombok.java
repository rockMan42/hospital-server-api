package com.hospital.hospitalserver;

import com.hospital.hospitalserver.util.Response;

public class TestLombok {
    public static void main(String[] args) {
        Response response = new Response(200, "test", null);
        System.out.println(response.getMsg());
    }
}
