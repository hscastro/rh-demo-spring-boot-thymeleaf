package br.ce.desen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ce.desen.dao.DepartamentoDao;
import br.ce.desen.domain.Departamento;

/**Projeto Sistema de RH
 * Desenvolvedor: Antonio Halyson - email:halisonsc5@gmail.com
 * Data: 07/03/2021 as 10:21
 */

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private DepartamentoDao dao;
	
	@Transactional(readOnly = false)
	@Override
	public void salvar(Departamento departamento) {
		
		dao.save(departamento);
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Departamento departamento) {
		
		dao.update(departamento);
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {

		dao.delete(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Departamento buscarPorId(Long id) {
		
		return dao.findById(id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Departamento> buscarTodos() {
		
		return dao.findAll();
	}

	@Override
	public boolean departamentoTemCargo(Long id) {
		if(buscarPorId(id).getCargos().isEmpty()) {
			return false;
		}
		return true;
	}

}
