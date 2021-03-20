package br.ce.desen.dao;

import java.util.List;

import br.ce.desen.domain.Usuario;

public interface UsuarioDao {
	
	void save(Usuario user);
	
	void update(Usuario user);
	
	void delete(Long id);
	
	Usuario findById(Long id);
	
	List<Usuario> findAll();	

}
