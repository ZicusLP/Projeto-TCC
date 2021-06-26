package br.com.gelinfo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_bairros")
@NamedQueries({
@NamedQuery(name = "Bairro.listar", query = "SELECT bairro FROM Bairro bairro"),
@NamedQuery(name = "Bairro.buscarPorCodigo", query = "SELECT bairro FROM Bairro bairro WHERE bairro.codigo = :codigo")
})
public class Bairro {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "b_codigo")
	private int codigo;
	@Column(name = "b_nome", length = 30, nullable = false)
	private String nome;
	@Column(name = "b_endereco", length = 50, nullable = false)
	private String endereco;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	@Override
	public String toString() {
		return "Bairro [codigo=" + codigo + ", nome=" + nome + ", endereco=" + endereco + "]";
	}
	

	
}


