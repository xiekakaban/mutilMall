package com.st.mall.service;

import com.st.mall.common.util.SecurityUtil;
import com.st.mall.model.vo.UserWithGrantVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bobo.
 * @date 12/26/2017
 * @email ruantianbo@163.com
 */
@Component
public class AuthenticationValidateProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserWithGrantVO user = validate(username,password);
        if(user == null){
            return null;
        }
        Set<SimpleGrantedAuthority> authoritySet = new HashSet<>();
        for(String role : user.getRoles()){
            authoritySet.add(new SimpleGrantedAuthority(role));
        }
        return new UsernamePasswordAuthenticationToken(username,password,authoritySet);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        //这个 provider只支持 username 和 password
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private UserWithGrantVO validate(String username, String password){
        UserWithGrantVO uGrant = userService.selectUserWithGrantByUsername(username);
        if(uGrant != null && uGrant.getPwd().equals(SecurityUtil.eccryptMD5(password))){
            return uGrant;
        }else{
            return null;
        }

    }
}
