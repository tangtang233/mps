package cn.net.pwai.mps.boot.controller;

import cn.net.pwai.mps.boot.service.DemoService;
import cn.net.pwai.mps.boot.service.DemoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DemoController {
    @Autowired
    private DemoService demoService;

    @Autowired
    private DemoUserService demoCommonService;

    @RequestMapping("/demo")
    public Map<String,Object> index() {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("status","success");
        resultMap.put("content",demoService.getString());
        return resultMap;
    }

    @RequestMapping(value = "/mobile/{mobile:.+}", method = RequestMethod.GET)
    public Object getSingleLoanItem(@PathVariable("mobile") String mobile) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("status","success");
        resultMap.put("content",demoCommonService.getUserByMobile(mobile));
        return resultMap;
    }
}