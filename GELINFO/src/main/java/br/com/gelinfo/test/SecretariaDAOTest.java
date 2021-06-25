package br.com.gelinfo.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.gelinfo.DAO.SecretariaDAO;
import br.com.gelinfo.domain.Secretaria;

public class SecretariaDAOTest {
	
	@Test
	//@Ignore
	public void salvar() {
		Secretaria s1 = new Secretaria();
		s1.setNome("Secretaria Municipal Executiva");
		s1.setSigla("SEXEC");
		
		SecretariaDAO dao = new SecretariaDAO();
		
		dao.salvar(s1);
	}
	
	@Test
	@Ignore
	public void listar() {
		SecretariaDAO dao = new SecretariaDAO();
		List<Secretaria> secretaria = dao.listar();
		
		for(Secretaria s1 : secretaria) {
			System.out.println(s1);
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		SecretariaDAO dao = new SecretariaDAO();
		Secretaria s1 = dao.buscarPorCodigo(5);
		Secretaria s2 = dao.buscarPorCodigo(4);
		
			System.out.println(s1);
			System.out.println(s2);
	}
	
	@Test
	@Ignore
	public void excluir() {
		SecretariaDAO dao = new SecretariaDAO();
		
		Secretaria secretaria = dao.buscarPorCodigo(5);
		
		
		dao.excluir(secretaria);
		
	}
	
	@Test
	@Ignore
	public void editar() {
		SecretariaDAO dao = new SecretariaDAO();
		
		Secretaria secretaria = dao.buscarPorCodigo(5);
		
		secretaria.setNome("Secretaria Municipal Executiva");
		secretaria.setSigla("SEXEC");
		
		
		dao.editar(secretaria);
		
	}


}
