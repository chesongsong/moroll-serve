package com.moroll.server;

import com.moroll.server.controller.SysUserController;
import com.moroll.server.entity.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServerApplicationTests {
    @Autowired
    private SysUserController userController;

    @Test
    void getById() {
        SysUser user = userController.getById("05c19ef36db6e9a52c8cfe337c26d97e");
        System.out.println(user);
    }

}
