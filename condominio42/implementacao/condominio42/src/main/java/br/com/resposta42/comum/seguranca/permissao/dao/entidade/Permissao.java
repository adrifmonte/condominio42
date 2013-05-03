package br.com.resposta42.comum.seguranca.permissao.dao.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.resposta42.util.GenericEntity;

@Entity
@Table(name = "cdm_permissao")
public class Permissao implements GenericEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gerador_de_permissao")
	@SequenceGenerator(name = "gerador_de_permissao", sequenceName = "seq_cdm_permissao", allocationSize = 1)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "descricao")
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
