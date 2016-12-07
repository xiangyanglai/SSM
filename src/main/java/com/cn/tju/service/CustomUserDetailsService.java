package com.cn.tju.service;

import com.cn.tju.pojo.Role;
import com.cn.tju.pojo.User;
import com.cn.tju.service.impl.RoleServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.*;

/**
 * 一个自定义的service用来和数据库进行操作. 即以后我们要通过数据库保存权限.则需要我们继承UserDetailsService
 *
 * @author liukai
 */
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    @Resource
    private UserService userServiceImpl;
    @Resource
    private RoleService roleServiceImpl;

    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {

        UserDetails user = null;

        try {

            // 搜索数据库以匹配用户登录名.
            // 我们可以通过dao使用JDBC来访问数据库
            log.info(new Date().getTime()+":try to login the system and username is:"+username);

            User dbUser = this.userServiceImpl.selectLogin(username);

            // Populate the Spring User object with details from the dbUser
            // Here we just pass the username, password, and access level
            // getAuthorities() will translate the access level to the correct
            // role type
            List<GrantedAuthority> userAuthoritySet = new ArrayList<GrantedAuthority>();
            if(dbUser==null)
                throw new UsernameNotFoundException("用户" + username + " 不存在");
            userAuthoritySet = getAuthorities(dbUser.getUserId());
            user = buildUserForAuthentication(dbUser,userAuthoritySet);

        } catch (Exception e) {
            log.error("登录出现错误:"+username+":"+e.toString());
            throw new UsernameNotFoundException("Error in retrieving user");
        }

        return user;
    }

    /**
     * 获得访问角色权限
     *
     * @param userId
     * @return
     */
    public List<GrantedAuthority> getAuthorities(int userId) {

        List<Role> roles = roleServiceImpl.selectRolesByUserId(userId);
        Set<GrantedAuthority> userAuthSet = new HashSet<GrantedAuthority>();
        for(Role userRole : roles)
        {
            userAuthSet.add(new SimpleGrantedAuthority(userRole.getRoleName()));
        }
        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(userAuthSet);
        return result;
    }


    /**
     * 返回验证用户
     * @param user
     * @param authorities
     * @return
     */
    private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user,List<GrantedAuthority> authorities){
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getUserPwd(),true,true,true,true,authorities);
    }
}
