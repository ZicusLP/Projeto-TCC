package br.com.gelinfo.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gelinfo.DAO.EquipamentoDAO;

import br.com.gelinfo.domain.Equipamento;

import br.com.gelinfo.util.JSFUtil;


@ManagedBean(name = "MBEquipamento")
@ViewScoped

public class EquipamentoBean {

	private Equipamento equipamento;
	private ArrayList<Equipamento>itens;
	private ArrayList<Equipamento>itensFiltrados;
	public Equipamento getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	public ArrayList<Equipamento> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Equipamento> itens) {
		this.itens = itens;
	}
	public ArrayList<Equipamento> getItensFiltrados() {
		return itensFiltrados;
	}
	public void setItensFiltrados(ArrayList<Equipamento> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	
	
	@PostConstruct
	public void preparaPesquisa() {
		
		
		
		try {
			EquipamentoDAO sedao = new EquipamentoDAO();
			itens = (ArrayList<Equipamento>) sedao.listar();
			
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
		
		
	}



	public void prepararInserir() {

		try {
			equipamento = new Equipamento();
			
			
			
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}

	public void salvar() {
		
		try {
			EquipamentoDAO sedao = new EquipamentoDAO();
			sedao.salvar(equipamento);
			
			
			JSFUtil.adicionarMensagemSucesso("Equipamento salvo com sucesso!");
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}



	public void excluir() {

		try {
			EquipamentoDAO sedao = new EquipamentoDAO();
			sedao.excluir(equipamento);
			
			
			JSFUtil.adicionarMensagemSucesso("Equipamento excluido com sucesso!");
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}



	public void editar() {

		try {
			EquipamentoDAO sedao = new EquipamentoDAO();
			sedao.editar(equipamento);
			
			
			
			JSFUtil.adicionarMensagemSucesso("Equipamento editado com sucesso!");
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			
			e.printStackTrace();
		}
	}
}
