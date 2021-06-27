package br.com.gelinfo.bean;



import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gelinfo.DAO.PerfilDAO;
import br.com.gelinfo.DAO.UsuarioDAO;
import br.com.gelinfo.domain.Perfil;

import br.com.gelinfo.domain.Usuario;
import br.com.gelinfo.util.JSFUtil;

@ManagedBean(name = "MBUsuario")
@ViewScoped
public class UsuarioBean {

	private Usuario usuario;
	private ArrayList<Usuario>itens;
	private ArrayList<Usuario>itensFiltrados;
	
	private ArrayList<Perfil>comboPerfil;
	
	
	
	public ArrayList<Perfil> getComboPerfil() {
		return comboPerfil;
	}
	public void setComboPerfil(ArrayList<Perfil> comboPerfil) {
		this.comboPerfil = comboPerfil;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public ArrayList<Usuario> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Usuario> itens) {
		this.itens = itens;
	}
	public ArrayList<Usuario> getItensFiltrados() {
		return itensFiltrados;
	}
	public void setItensFiltrados(ArrayList<Usuario> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	

@PostConstruct



public void preparaPesquisa() {
	
	
	
	try {
		UsuarioDAO udao = new UsuarioDAO();
		itens = (ArrayList<Usuario>) udao.listar();
		
	} catch (RuntimeException e) {
		JSFUtil.adicionarMensagemErro(e.getMessage());
		e.printStackTrace();
	}
	
	
}

public void prepararInserir() {
	
	try {
		
	usuario = new Usuario();
	
	PerfilDAO pdao = new PerfilDAO();
	comboPerfil = (ArrayList<Perfil>) pdao.listar();
	
	} catch (RuntimeException e) {
		JSFUtil.adicionarMensagemErro(e.getMessage());
		e.printStackTrace();
	}
}

public void salvar() {
	
	try {
		UsuarioDAO udao = new UsuarioDAO();
		udao.salvar(usuario);
		
		
		JSFUtil.adicionarMensagemSucesso("Usuario salvo com sucesso!");
	} catch (RuntimeException e) {
		JSFUtil.adicionarMensagemErro(e.getMessage());
		e.printStackTrace();
	}
}



public void excluir() {

	try {
		UsuarioDAO udao = new UsuarioDAO();
		udao.excluir(usuario);
		
	
	
		JSFUtil.adicionarMensagemSucesso("Usuario excluido com sucesso!");
	} catch (RuntimeException e) {
		JSFUtil.adicionarMensagemErro(e.getMessage());
		e.printStackTrace();
	}
}



public void editar() {

	try {
		UsuarioDAO udao = new UsuarioDAO();
		udao.editar(usuario);
		
		
		
		JSFUtil.adicionarMensagemSucesso("Usuario editado com sucesso!");
	} catch (RuntimeException e) {
		JSFUtil.adicionarMensagemErro(e.getMessage());
		
		e.printStackTrace();
	}
}
	
}
