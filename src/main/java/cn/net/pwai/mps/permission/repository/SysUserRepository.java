package cn.net.pwai.mps.permission.repository;

import cn.net.pwai.mps.permission.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tangwei [toby911115@gmail.com]
 * @date 2018/9/27
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByUsername(String username);
}
