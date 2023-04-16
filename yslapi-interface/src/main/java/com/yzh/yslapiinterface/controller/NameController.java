package com.yzh.yslapiinterface.controller;

import com.yzh.yslapiclientsdk.modal.User;
import com.yzh.yslapiclientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 名称API
 * @author yzh
 */
@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/")
    public String getNameByGet(String name){

        return "Get 你的名字是"+ name;
    }

    @PostMapping("/")
    public String getNameByPost(@RequestParam String name){
        return "Post 你的名字是" + name;
    }
    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request){
        String accessKey = request.getHeader("accessKey");
        String nonce = request.getHeader("nonce");
        String body = request.getHeader("body");
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");
//to do最好去数据库查是否已分配给客户
        if (!accessKey.equals("yangzhenhao")){
            throw new RuntimeException("userInterfaceInfo");
        }
        if (Long.parseLong(nonce) > 10000){
            throw new RuntimeException("userInterfaceInfo");
        }
        //正常来说应该去数据空中拿secretKey
        String serverSign = SignUtils.getSign(body, "abcdefgh");
        if (!sign.equals(serverSign)){
            throw new RuntimeException("userInterfaceInfo");

        }
        return "Post 用户名字是" + user.getUsername();
    }





}
