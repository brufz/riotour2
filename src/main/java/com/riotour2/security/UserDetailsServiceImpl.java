package com.riotour2.security;

import com.riotour2.model.UsuarioModel;
import com.riotour2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String nomeUsuario) throws UsernameNotFoundException {


        Optional<UsuarioModel> usuario = usuarioRepository.findByNomeUsuario(nomeUsuario);

        usuario.orElseThrow(() -> new UsernameNotFoundException(nomeUsuario + " not found."));

        return usuario.map(UserDetailsImpl::new).get();
    }
}