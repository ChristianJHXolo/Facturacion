package com.ChristianEmmanuel.usuarios.servicio;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ChristianEmmanuel.usuarios.controlador.dto.UsuarioRegistroDTO;
import com.ChristianEmmanuel.usuarios.modelo.Rol;
import com.ChristianEmmanuel.usuarios.modelo.Usuario;
import com.ChristianEmmanuel.usuarios.repositorio.UsuarioRepositorio;

import com.ChristianEmmanuel.usuarios.modelo.Usuario;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

	
	
	private List<Usuario> list;
	
	@Autowired
    private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@PostConstruct
    private void init() {
        list = usuarioRepositorio.findAll();
    }
	
	public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
		super();
		this.usuarioRepositorio = usuarioRepositorio;
	}

	@Override
	public Usuario guardar(UsuarioRegistroDTO registroDTO) {
		Usuario usuario = new Usuario(registroDTO.getImagen(), registroDTO.getNombre(), 
				registroDTO.getApellido(),registroDTO.getEmail(), registroDTO.getFecha(),
				passwordEncoder.encode(registroDTO.getPassword()),Arrays.asList(new Rol("ROLE_USER")));
		return usuarioRepositorio.save(usuario);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.findByEmail(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario o password inválidos");
		}
		return new User(usuario.getEmail(),usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
	}
	
	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepositorio.findAll();
	}

	@Override
    public Usuario buscarPorId(int idUsuario) {
        for (Usuario v : list) {
            if (v.getId() == idUsuario) {
                return v;
            }
        }
        return null;
    }
	
	@Override
	public void eliminar(Long idUsuario) {
	    usuarioRepositorio.deleteById(idUsuario);
	}

	@Override
	public Usuario buscarPorId(Long idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardarUser(Usuario usuario) {
		list.add(usuario);
		
	}
}
