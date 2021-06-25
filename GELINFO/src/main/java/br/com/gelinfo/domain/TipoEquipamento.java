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
@Table(name = "tb_tipo")
@NamedQueries({
@NamedQuery(name = "TipoEquipamento.listar", query = "SELECT tipo FROM TipoEquipamento tipo"),
@NamedQuery(name = "TipoEquipamento.buscarPorCodigo", query = "SELECT tipo FROM TipoEquipamento tipo WHERE tipo.codigo = :codigo")
})
public class TipoEquipamento {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "tp_codigo")
	private int codigo;
	@Column(name = "tp_nome")
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
		return "TipoEquipamento [codigo=" + codigo + ", nome=" + nome + "]";
	}

	
	
}
