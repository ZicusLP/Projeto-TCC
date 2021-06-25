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
@NamedQueries({@NamedQuery(name = "Modelo.listar", query = "SELECT modelo FROM Modelo modelo")})
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
	

}
