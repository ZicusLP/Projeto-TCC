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
@Table(name = "tb_usuarios")
@NamedQueries({@NamedQuery(name = "Usuario.listar", query = "SELECT usuario FROM Usuario usuario")})
public class Usuario {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "u_codigo")
	private int codigo;
	@Column(name = "u_nome", length = 50, nullable = false)
	private String nome;
	@Column(name = "u_login", length = 20, nullable = false)
	private String login;
	@Column(name = "u_senha", length = 8, nullable = false)
	private String senha;
	@Column(name = "u_telefone", length = 12, nullable = true)
	private int telefone;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_perfil_pf_codigo", referencedColumnName = "pf_codigo", nullable = false)
	private Perfil perfil;

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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	
}
