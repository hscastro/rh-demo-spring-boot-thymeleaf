package br.ce.desen.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.ce.desen.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {


	@Override
	public List<Funcionario> findByName(String nome) {
		
		TypedQuery<Funcionario> query = getEntityManager()
			.createQuery("select f from Funcionario f where f.nome like :nome", Funcionario.class);
				query.setParameter("nome", "%"+ nome +"%");
				
		return query.getResultList();
	}

	@Override
	public List<Funcionario> findByCargo(Long id) {
		return createQuery("select f from Funcionario f where f.cargo.id = ?1", id);
	}

}
