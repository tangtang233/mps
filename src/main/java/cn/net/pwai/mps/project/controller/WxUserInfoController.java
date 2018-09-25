package cn.net.pwai.mps.project.controller;

import cn.net.pwai.mps.aop.LoggerManage;
import cn.net.pwai.mps.project.entity.WxUserInfo;
import cn.net.pwai.mps.project.repository.WxUserInfoRepository;
import cn.net.pwai.mps.project.service.WxUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tangwei
 * @date 2018/9/25
 */
@RestController
@RequestMapping("/wxUserInfo")
public class WxUserInfoController {
    @Autowired
    private WxUserInfoService wxUserInfoService;

    @Autowired
    private WxUserInfoRepository wxUserInfoRepository;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @LoggerManage(description = "微信用户信息新增")
    public Map<String,Object> save(@RequestBody WxUserInfo wxUserInfo) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("status","success");
        resultMap.put("content",wxUserInfoRepository.save(wxUserInfo));
        return resultMap;
    }

    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    @LoggerManage(description = "通过id查找微信用户信息")
    public Map<String,Object> findById(String id) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("status","success");
        resultMap.put("content",wxUserInfoRepository.findWxUserInfoById(id));
        return resultMap;
    }
}
