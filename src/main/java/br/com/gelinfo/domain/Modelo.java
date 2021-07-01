package br.com.gelinfo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_modelos")
@NamedQueries({
@NamedQuery(name = "Modelo.listar", query = "SELECT modelo FROM Modelo modelo"),
@NamedQuery(name = "Modelo.buscarPorCodigo", query = "SELECT modelo FROM Modelo modelo WHERE modelo.codigo = :codigo")
})
public class Modelo {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "md_codigo")
	private int codigo;
	@Column(name = "md_nome", length = 50, nullable = false)
	private String nome;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_marcas_m_codigo", referencedColumnName = "m_codigo", nullable = false)
	private Marca marca;

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

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Modelo [codigo=" + codigo + ", nome=" + nome + ", marca=" + marca + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modelo other = (Modelo) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	

}
