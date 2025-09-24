package com.hospital.hospitalserver;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.hospital.hospitalserver.util.EncryptHelper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SheQuServeApplicationTests {

    @Test
    void contextLoads() {
        String sha = EncryptHelper.SHA("12345678");
        System.out.println(sha);
    }

}
