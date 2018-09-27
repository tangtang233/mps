package cn.net.pwai.mps.permission.service;

import cn.net.pwai.mps.permission.entity.SysUser;
import cn.net.pwai.mps.permission.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author tangwei [toby911115@gmail.com]
 * @date 2018/9/27
 */
public class CustomUserService implements UserDetailsService {
    @Autowired
    SysUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser user = userRepository.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        System.out.println("s:" + s);
        System.out.println("username:" + user.getUsername() + ";password:" + user.getPassword());
        return user;
    }
}
