package com.vm.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vm.api.model.Usuario;
import com.vm.api.repository.UsuarioRepository;

@Service
public class ImplementacaoUserDetailsSercice implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepository.findUserByLogin(username);
		
		if (usuario == null) {
			
			throw new UsernameNotFoundException("Usuario nao foi encontrado");
			
		}
		
		return new User(usuario.getLogin(), usuario.getSenha(), usuario.getAuthorities());
	}
	
	

}
