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
@Table(name = "tb_marcas")
@NamedQueries({
@NamedQuery(name = "Marca.listar", query = "SELECT marca FROM Marca marca"),
@NamedQuery(name = "Marca.buscarPorCodigo", query = "SELECT marca FROM Marca marca WHERE marca.codigo = :codigo")
})
public class Marca {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "m_codigo")
	private int codigo;
	@Column(name = "m_nome", length = 30, nullable = false)
	private String nome;
	
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
	@Override
	public String toString() {
		return "Marca [codigo=" + codigo + ", nome=" + nome + "]";
	}
	
	
}
