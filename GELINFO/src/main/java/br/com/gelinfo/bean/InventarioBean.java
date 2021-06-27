package br.com.gelinfo.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import br.com.gelinfo.DAO.InventarioDAO;

import br.com.gelinfo.domain.Inventario;

import br.com.gelinfo.util.JSFUtil;

@ManagedBean(name = "MBInventario")
@ViewScoped
public class InventarioBean {

	private Inventario inventario;
	private ArrayList<Inventario>itens;
	private ArrayList<Inventario>itensFiltrados;
	public Inventario getInventario() {
		return inventario;
	}
	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}
	public ArrayList<Inventario> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Inventario> itens) {
		this.itens = itens;
	}
	public ArrayList<Inventario> getItensFiltrados() {
		return itensFiltrados;
	}
	public void setItensFiltrados(ArrayList<Inventario> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	
	
	@PostConstruct
	public void preparaPesquisa() {
		
		
		
		try {
			InventarioDAO sedao = new InventarioDAO();
			itens = (ArrayList<Inventario>) sedao.listar();
			
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
		
		
	}



	public void prepararInserir() {

		try {
			inventario = new Inventario();
			
	
			
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}

	public void salvar() {
		
		try {
			InventarioDAO sedao = new InventarioDAO();
			sedao.salvar(inventario);
			
			
			JSFUtil.adicionarMensagemSucesso("Inventario iniciado com sucesso!");
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}



	public void excluir() {

		try {
			InventarioDAO sedao = new InventarioDAO();
			sedao.excluir(inventario);
			
			
			JSFUtil.adicionarMensagemSucesso("Inventario finalizado com sucesso!");
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}



	public void editar() {

		try {
			InventarioDAO sedao = new InventarioDAO();
			sedao.editar(inventario);
			
			
			
			JSFUtil.adicionarMensagemSucesso("Informações registradas com sucesso!");
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			
			e.printStackTrace();
		}
	}
}
