package cn.net.pwai.mps.boot.service;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

    public String getString() {
        return "调用了getString方法！";
    }
}
