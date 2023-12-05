package com.ChristianEmmanuel.usuarios.servicio;


import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ChristianEmmanuel.usuarios.controlador.dto.UsuarioRegistroDTO;
import com.ChristianEmmanuel.usuarios.modelo.Usuario;

public interface UsuarioServicio extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios();
	
	void guardarUser(Usuario usuario);

	Usuario buscarPorId(Long idUsuario);

	void eliminar(Long idUsuario);

	Usuario buscarPorId(int idUsuario);
}
