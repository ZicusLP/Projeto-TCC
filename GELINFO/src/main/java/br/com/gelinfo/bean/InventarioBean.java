package br.com.gelinfo.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import br.com.gelinfo.DAO.InventarioDAO;
import br.com.gelinfo.DAO.SetorDAO;
import br.com.gelinfo.DAO.SecretariaDAO;
import br.com.gelinfo.domain.Equipamento;
import br.com.gelinfo.DAO.EquipamentoDAO;
import br.com.gelinfo.domain.Inventario;

import br.com.gelinfo.domain.Secretaria;
import br.com.gelinfo.domain.Setor;
import br.com.gelinfo.util.JSFUtil;

@ManagedBean(name = "MBInventario")
@ViewScoped
public class InventarioBean {

	private Inventario inventario;
	private ArrayList<Inventario>itens;
	private ArrayList<Inventario>itensFiltrados;
	
	private List<Secretaria>listaSecretaria;
	private List<Setor>listaSetor;
	
	private Equipamento equipamento;
	private List<Equipamento>equipamentos;
	private ArrayList<Equipamento>equipamentosFiltrados;
	
	
	
	
	public Equipamento getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}
	public void setEquipamentos(List<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}
	public ArrayList<Equipamento> getEquipamentosFiltrados() {
		return equipamentosFiltrados;
	}
	public void setEquipamentosFiltrados(ArrayList<Equipamento> equipamentosFiltrados) {
		this.equipamentosFiltrados = equipamentosFiltrados;
	}
	public List<Setor> getListaSetor() {
		return listaSetor;
	}
	public void setListaSetor(List<Setor> listaSetor) {
		this.listaSetor = listaSetor;
	}
	public List<Secretaria> getListaSecretaria() {
		return listaSecretaria;
	}
	public void setListaSecretaria(List<Secretaria> listaSecretaria) {
		this.listaSecretaria = listaSecretaria;
	}
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


	public List<Equipamento> equipamentosPesquisa() {
		
		try {
			EquipamentoDAO sedao = new EquipamentoDAO();
			List<Equipamento> equipamentos = sedao.listar();
			
			return equipamentos;
			
			
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
		return equipamentos;
		
	}

	public void prepararInserir() {

		try {
			inventario = new Inventario();
			
			SecretariaDAO pdao = new SecretariaDAO();
			listaSecretaria =  pdao.listar();
			
			SetorDAO dao = new SetorDAO();
			listaSetor =  dao.listar();
	
			
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


	public void carregarDadosInventario() {
		
		inventario.setData(new Date());
		
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
