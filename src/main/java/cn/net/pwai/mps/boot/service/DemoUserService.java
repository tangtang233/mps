package cn.net.pwai.mps.boot.service;

import org.springframework.stereotype.Service;

@Service
public class DemoUserService {
    public String getUserByMobile(String mobile) {
        return "调用了getUserByMobile方法！mobile:" + mobile;
    }
}
