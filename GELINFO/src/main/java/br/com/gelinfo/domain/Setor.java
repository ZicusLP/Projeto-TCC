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
@Table(name = "tb_setores")
@NamedQueries({@NamedQuery(name = "Setor.listar", query = "SELECT setor FROM Setor setor")})
public class Setor {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "st_codigo")
	private int codigo;
	@Column(name = "st_nome", length = 50, nullable = false)
	private String nome;
	@Column(name = "st_sigla", length = 10, nullable = false)
	private String sigla;
	@Column(name = "st_andar", length = 8, nullable = false)
	private String andar;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_secretarias_sec_codigo", referencedColumnName = "sec_codigo", nullable = false)
	private Secretaria secretaria;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_bairros_b_codigo", referencedColumnName = "b_codigo", nullable = false)
	private Bairro bairro;

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

	public String getAndar() {
		return andar;
	}

	public void setAndar(String andar) {
		this.andar = andar;
	}

	public Secretaria getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(Secretaria secretaria) {
		this.secretaria = secretaria;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	
	
	
	
	
	
	
	

	
	
}
