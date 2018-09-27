package cn.net.pwai.mps.project.repository;

import cn.net.pwai.mps.project.entity.WxUserInfo;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author tangwei
 * @date 2018/9/25
 */
public interface WxUserInfoRepository extends JpaRepository<WxUserInfo, String> {
    WxUserInfo findWxUserInfoById(String id);

    WxUserInfo findWxUserInfoByOpenId(String openId);

    WxUserInfo findWxUserInfoByPhone(String phone);

    List<WxUserInfo> findAllByDelStatusOrderByAddTimeDesc(Integer delStatus);
}
