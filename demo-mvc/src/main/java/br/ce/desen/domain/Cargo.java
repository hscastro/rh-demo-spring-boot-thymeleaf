package br.ce.desen.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**Projeto rh-software
 * Desenvolvedor: Antonio Halyson - email:halisonsc5@gmail.com
 * Data: 07/03/2021 
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "CARGOS")
public class Cargo extends AbstractEntity<Long> {


	@NotBlank(message = "O nome do cargo é obrigatório.")
	@Size(max = 60, message = "O nome Cargo deve ter entre {max} caracteres.")
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@NotNull(message = "Selecione um departamento relativo ao cargo")
	@ManyToOne
	@JoinColumn(name = "id_departamento_fk")
	private Departamento departamento;
	
	@OneToMany(mappedBy = "cargo")
	private List<Funcionario> funcionarios;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

    
		
}
