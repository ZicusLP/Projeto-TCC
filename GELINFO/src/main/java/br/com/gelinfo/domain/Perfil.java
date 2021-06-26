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
@Table(name = "tb_perfil")
@NamedQueries({
@NamedQuery(name = "Perfil.listar", query = "SELECT perfil FROM Perfil perfil"),
@NamedQuery(name = "Perfil.buscarPorCodigo", query = "SELECT perfil FROM Perfil perfil WHERE perfil.codigo = :codigo")
})
public class Perfil {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "pf_codigo")
	private int codigo;
	@Column(name = "pf_funcao", length = 30, nullable = false)
	private String funcao;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	@Override
	public String toString() {
		return "Perfil [codigo=" + codigo + ", funcao=" + funcao + "]";
	}
	
	
}
