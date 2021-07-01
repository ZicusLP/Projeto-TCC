package br.com.gelinfo.bean;


import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gelinfo.DAO.PerfilDAO;
import br.com.gelinfo.domain.Perfil;
import br.com.gelinfo.util.JSFUtil;

@ManagedBean(name = "MBPerfil")
@ViewScoped
public class PerfilBean {
	
	private Perfil perfil;
	private ArrayList<Perfil>itens;
	private ArrayList<Perfil>itensFiltrados;
	
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	public ArrayList<Perfil> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Perfil> itens) {
		this.itens = itens;
	}
	public ArrayList<Perfil> getItensFiltrados() {
		return itensFiltrados;
	}
	public void setItensFiltrados(ArrayList<Perfil> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	
	@PostConstruct
	public void preparaPesquisa() {
		
		
		
		try {
			PerfilDAO pdao = new PerfilDAO();
			itens = (ArrayList<Perfil>) pdao.listar();
			
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
		
		
	}

	public void prepararInserir() {
		perfil = new Perfil();
	}

	public void salvar() {
		
		try {
			PerfilDAO pdao = new PerfilDAO();
			pdao.salvar(perfil);
			
			//itens = pdao.listar();
		
			JSFUtil.adicionarMensagemSucesso("Perfil salvo com sucesso!");
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}



	public void excluir() {

		try {
			PerfilDAO pdao = new PerfilDAO();
			pdao.excluir(perfil);
			
			//itens = pdao.listar();
		
			JSFUtil.adicionarMensagemSucesso("Perfil excluido com sucesso!");
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}



	public void editar() {

		try {
			PerfilDAO pdao = new PerfilDAO();
			pdao.editar(perfil);
			
			//itens = pdao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Perfil editado com sucesso!");
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			
			e.printStackTrace();
		}
	}

}
