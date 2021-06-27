package br.com.gelinfo.bean;


import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import br.com.gelinfo.DAO.SecretariaDAO;
import br.com.gelinfo.domain.Secretaria;
import br.com.gelinfo.util.JSFUtil;

@ManagedBean(name = "MBSecretaria")
@ViewScoped
public class SecretariaBean {
	
	private Secretaria secretaria;
	private ArrayList<Secretaria>itens;
	private ArrayList<Secretaria>itensFiltrados;
	
public Secretaria getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(Secretaria secretaria) {
		this.secretaria = secretaria;
	}

public ArrayList<Secretaria> getItens() {
	return itens;
}

public void setItens(ArrayList<Secretaria> itens) {
	this.itens = itens;
}

public ArrayList<Secretaria> getItensFiltrados() {
	return itensFiltrados;
}

public void setItensFiltrados(ArrayList<Secretaria> itensFiltrados) {
	this.itensFiltrados = itensFiltrados;
}



@PostConstruct
public void preparaPesquisa() {	
	
	try {
	SecretariaDAO sdao = new SecretariaDAO();
		itens = (ArrayList<Secretaria>) sdao.listar();
	
	} catch (RuntimeException e) {
		JSFUtil.adicionarMensagemErro(e.getMessage());
		e.printStackTrace();
	}
	
	
}

public void inserir() {
	secretaria = new Secretaria();
}

public void salvar() {
	
	try {
		SecretariaDAO sdao = new SecretariaDAO();
		sdao.salvar(secretaria);
		
		//itens = sdao.listar();
	
		JSFUtil.adicionarMensagemSucesso("Secretaria salvo com sucesso!");
	} catch (RuntimeException e) {
		JSFUtil.adicionarMensagemErro(e.getMessage());
		e.printStackTrace();
	}
}



//public void excluir() {
//
//	try {
//		SecretariaDAO sdao = new SecretariaDAO();
//		sdao.deletar(secretaria);
//		
//		itens = dao.listar();
//	
//		JSFUtil.adicionarMensagemSucesso("Secretaria excluida com sucesso!");
//	} catch (RuntimeException e) {
//		JSFUtil.adicionarMensagemErro(e.getMessage());
//		e.printStackTrace();
//	}
//}
//
//
//
//public void editar() {
//
//	try {
//		SecretariaDAO sdao = new SecretariaDAO();
//		sdao.editar(secretaria);
//		
//		itens = sdao.listar();
//		
//		JSFUtil.adicionarMensagemSucesso("Secretaria editada com sucesso!");
//	} catch (RuntimeException e){
//		JSFUtil.adicionarMensagemErro(e.getMessage());
//		
//		e.printStackTrace();
//	}
//}

}
