package br.com.gelinfo.bean;


import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gelinfo.DAO.MarcaDAO;
import br.com.gelinfo.DAO.ModeloDAO;
import br.com.gelinfo.domain.Marca;
import br.com.gelinfo.domain.Modelo;
import br.com.gelinfo.util.JSFUtil;

@ManagedBean(name = "MBModelo")
@ViewScoped
public class ModeloBean {

	private Modelo modelos;
	private ArrayList<Modelo>itens;
	private ArrayList<Modelo>itensFiltrados;
	
	private ArrayList<Marca> comboMarcas;

	public Modelo getModelos() {
		return modelos;
	}

	public void setModelos(Modelo modelos) {
		this.modelos = modelos;
	}

	public ArrayList<Modelo> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Modelo> itens) {
		this.itens = itens;
	}

	public ArrayList<Modelo> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Modelo> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public ArrayList<Marca> getComboMarcas() {
		return comboMarcas;
	}

	public void setComboMarcas(ArrayList<Marca> comboMarcas) {
		this.comboMarcas = comboMarcas;
	}
	
	@PostConstruct
	public void preparaPesquisa() {
		
		
		
		try {
			ModeloDAO mdao = new ModeloDAO();
			itens = (ArrayList<Modelo>) mdao.listar();
			
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
		
		
	}



	public void prepararInserir() {

		try {
			modelos = new Modelo();
			
			MarcaDAO mdao = new MarcaDAO();
			comboMarcas = (ArrayList<Marca>) mdao.listar();
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}

	public void salvar() {
		
		try {
			ModeloDAO mdao = new ModeloDAO();
			mdao.salvar(modelos);
			
			
		
			JSFUtil.adicionarMensagemSucesso("Modelo salvo com sucesso!");
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}



	public void excluir() {

		try {
			ModeloDAO mdao = new ModeloDAO();
			mdao.excluir(modelos);
			
			
		
			JSFUtil.adicionarMensagemSucesso("Modelo excluido com sucesso!");
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}



	public void editar() {

		try {
			ModeloDAO mdao = new ModeloDAO();
			mdao.editar(modelos);
			
			
			
			JSFUtil.adicionarMensagemSucesso("Modelo editado com sucesso!");
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			
			e.printStackTrace();
		}
	}

}
