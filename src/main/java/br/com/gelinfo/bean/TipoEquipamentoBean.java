package br.com.gelinfo.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gelinfo.DAO.TipoEquipamentoDAO;
import br.com.gelinfo.domain.TipoEquipamento;
import br.com.gelinfo.util.JSFUtil;

@ManagedBean(name = "MBTipo")
@ViewScoped
public class TipoEquipamentoBean {

	private TipoEquipamento tipoequipamento;
	private ArrayList<TipoEquipamento>itens;
	private ArrayList<TipoEquipamento>itensFiltrados;
	
	
	


	public TipoEquipamento getTipoequipamento() {
		return tipoequipamento;
	}



	public void setTipoequipamento(TipoEquipamento tipoequipamento) {
		this.tipoequipamento = tipoequipamento;
	}



	public ArrayList<TipoEquipamento> getItens() {
		return itens;
	}



	public void setItens(ArrayList<TipoEquipamento> itens) {
		this.itens = itens;
	}



	public ArrayList<TipoEquipamento> getItensFiltrados() {
		return itensFiltrados;
	}



	public void setItensFiltrados(ArrayList<TipoEquipamento> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}



	@PostConstruct
	public void preparaPesquisa() {
		
		
		
		try {
			TipoEquipamentoDAO bdao = new TipoEquipamentoDAO();
			itens = (ArrayList<TipoEquipamento>) bdao.listar();
			
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
		
		
	}



	public void prepararInserir() {
		tipoequipamento = new TipoEquipamento();
	}
		

	public void salvar() {
		
		try {
			TipoEquipamentoDAO bdao = new TipoEquipamentoDAO();
			bdao.salvar(tipoequipamento);
			
			//itens = bdao.listar();
		
			JSFUtil.adicionarMensagemSucesso("Tipo salvo com sucesso!");
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}



	public void excluir() {

		try {
			TipoEquipamentoDAO bdao = new TipoEquipamentoDAO();
			bdao.excluir(tipoequipamento);
			
			//itens = bdao.listar();
		
			JSFUtil.adicionarMensagemSucesso("Tipo excluido com sucesso!");
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}



	public void editar() {

		try {
			TipoEquipamentoDAO bdao = new TipoEquipamentoDAO();
			bdao.editar(tipoequipamento);
			
			//itens = bdao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Tipo editado com sucesso!");
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			
			e.printStackTrace();
		}
	}
}
