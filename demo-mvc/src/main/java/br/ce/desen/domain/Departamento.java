package br.ce.desen.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


/**Projeto rh-software
 * Desenvolvedor: Antonio Halyson - email:halisonsc5@gmail.com
 * Data: 07/03/2021 
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamento extends AbstractEntity<Long> {

	@NotBlank(message = "Informe um nome")
	@Size(min = 3, max = 80, message = "O nome departamento deve ter entre {min} e {max} caracteres.")
	@Column(name = "nome", nullable = false, unique = true, length = 80)
	private String nome;

	@OneToMany(mappedBy = "departamento")
	private List<Cargo> cargos;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
	
	

	
}
