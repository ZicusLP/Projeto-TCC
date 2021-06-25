package br.com.gelinfo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_secretarias")
@NamedQueries({
@NamedQuery(name = "Secretaria.listar", query = "SELECT secretaria FROM Secretaria secretaria"),
@NamedQuery(name = "Secretaria.buscarPorCodigo", query = "SELECT secretaria FROM Secretaria secretaria WHERE secretaria.codigo = :codigo")	

})
public class Secretaria implements Serializable {
	
	private static final long serialVersionUID=1L;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "sec_codigo")
	private int codigo;
	@Column(name = "sec_nome", length = 50, nullable = false)
	private String nome;
	@Column(name = "sec_sigla", length = 7, nullable = false)
	private String sigla;
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
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	@Override
	public String toString() {
		return "Secretaria [codigo=" + codigo + ", nome=" + nome + ", sigla=" + sigla + "]";
	}
	
	
	
	
	
}
