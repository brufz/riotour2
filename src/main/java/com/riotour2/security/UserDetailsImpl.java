package com.riotour2.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.riotour2.model.PermissoesModel;
import com.riotour2.model.UsuarioModel;

public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;
    private String email;
    private String password;
    private List<GrantedAuthority> authorities;

    public UserDetailsImpl(UsuarioModel user) {
        this.email = user.getEmail();
        this.password = user.getSenha();
//        List<PermissoesModel> permissoes = user.getPermissoes();
//        for (PermissoesModel permissao: permissoes ) {
//        	GrantedAuthorityDefaults authority = new GrantedAuthorityDefaults("admin");
//        }
    }

    public UserDetailsImpl() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
