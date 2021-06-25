package br.com.gelinfo.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.gelinfo.DAO.TipoEquipamentoDAO;
import br.com.gelinfo.domain.TipoEquipamento;

public class TipoEquipamentoDAOTest {

	@Test
	@Ignore
	public void salvar() {
		TipoEquipamento s1 = new TipoEquipamento();
		s1.setNome("Monitor");
	
		
		TipoEquipamentoDAO dao = new TipoEquipamentoDAO();
		
		dao.salvar(s1);
	}
	
	@Test
	@Ignore
	public void listar() {
		TipoEquipamentoDAO dao = new TipoEquipamentoDAO();
		List<TipoEquipamento> tipo = dao.listar();
		
		for(TipoEquipamento s1 : tipo) {
			System.out.println(s1);
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		TipoEquipamentoDAO dao = new TipoEquipamentoDAO();
		TipoEquipamento s1 = dao.buscarPorCodigo(1);
		TipoEquipamento s2 = dao.buscarPorCodigo(3);
		
			System.out.println(s1);
			System.out.println(s2);
	}
	
	@Test
	@Ignore
	public void excluir() {
		TipoEquipamentoDAO dao = new TipoEquipamentoDAO();
		
		TipoEquipamento tipo = dao.buscarPorCodigo(5);
		
		
		dao.excluir(tipo);
		
	}
	
	@Test
	//@Ignore
	public void editar() {
		TipoEquipamentoDAO dao = new TipoEquipamentoDAO();
		
		TipoEquipamento tipo = dao.buscarPorCodigo(3);
		
		tipo.setNome("Roteador");
		
		
		
		dao.editar(tipo);
		
	}
}
