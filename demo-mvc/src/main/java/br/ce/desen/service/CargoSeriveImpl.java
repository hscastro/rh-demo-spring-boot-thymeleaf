package br.ce.desen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ce.desen.dao.CargoDao;
import br.ce.desen.domain.Cargo;

/**Projeto Sistema de RH
 * Desenvolvedor: Antonio Halyson - email:halisonsc5@gmail.com
 * Data: 07/03/2021 
 */

@Service  @Transactional(readOnly = false)
public class CargoSeriveImpl implements CargoService {
	
	@Autowired
	private CargoDao dao;

	@Override
	public void salvar(Cargo cargo) {
		
		dao.save(cargo);
	}

	@Override
	public void editar(Cargo cargo) {
		
		dao.update(cargo);
	}

	@Override
	public void excluir(Long id) {
		
		dao.delete(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Cargo buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Cargo> buscarTodos() {
		
		return dao.findAll();
	}

//	@Override
//	public boolean cargoTemFuncionario(Long id) {
//		if(dao.findById(id).getFuncionarios().isEmpty()) {
//			return false;
//		}
//		return true;
//	}


}
