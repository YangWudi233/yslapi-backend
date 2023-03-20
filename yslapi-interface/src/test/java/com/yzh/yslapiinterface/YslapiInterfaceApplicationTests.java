package com.yzh.yslapiinterface;

import com.yzh.yslapiclientsdk.client.YslApiClient;
import com.yzh.yslapiclientsdk.modal.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class YslapiInterfaceApplicationTests {
@Resource
private YslApiClient yslApiClient;

    @Test
    void contextLoads() {
        String result = yslApiClient.getNameByGet("yangzhenhao");
        User user = new User();
        user.setUsername("yangshulin");
        String usernameByPost = yslApiClient.getUsernameByPost(user);

        System.out.println(result);
        System.out.println(usernameByPost);
    }

}
