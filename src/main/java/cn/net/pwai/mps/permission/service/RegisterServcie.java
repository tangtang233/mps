package cn.net.pwai.mps.permission.service;

import cn.net.pwai.mps.basic.wrapper.ResultCode;
import cn.net.pwai.mps.basic.wrapper.ResultJsonObject;
import cn.net.pwai.mps.permission.entity.SysUser;
import cn.net.pwai.mps.permission.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author tangwei [toby911115@gmail.com]
 * @date 2018/9/29
 */
@Service
public class RegisterServcie {
    @Autowired
    SysUserRepository userRepository;

    /**
     * 注册系统用户
     * @param sysUser
     * @return
     */
    public ResultJsonObject register(SysUser sysUser) {
        if (null != sysUser) {
            if (isExist(sysUser)) {
                return ResultJsonObject.getErrorResult(null, ResultCode.USER_HAS_EXISTED.message());
            }
            SysUser resultUser = userRepository.save(encryptPassword(sysUser));
            return ResultJsonObject.getDefaultResult(resultUser, ResultCode.SUCCESS.message());
        }
        return ResultJsonObject.getErrorResult(null);
    }

    /**
     * 用户名验重
     * @param sysUser
     * @return  true/false
     */
    private boolean isExist(SysUser sysUser) {
        String userName = sysUser.getUsername();
        SysUser user = userRepository.findByUsername(userName);
        if (null == user) {
            return false;
        }
        return true;
    }

    /**
     * 加密密码(BCrypt)
     */
    private SysUser encryptPassword(SysUser sysUser) {
        String password = sysUser.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        sysUser.setPassword(password);
        return sysUser;
    }
}
