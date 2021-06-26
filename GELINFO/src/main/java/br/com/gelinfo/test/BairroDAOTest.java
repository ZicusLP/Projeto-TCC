package br.com.gelinfo.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.gelinfo.DAO.BairroDAO;
import br.com.gelinfo.domain.Bairro;

public class BairroDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		Bairro s1 = new Bairro();
		s1.setNome("Centro");
		s1.setEndereco("R, da Conceição, 100");
		
		BairroDAO dao = new BairroDAO();
		
		dao.salvar(s1);
	}
	
	@Test
	@Ignore
	public void listar() {
		BairroDAO dao = new BairroDAO();
		List<Bairro> bairro = dao.listar();
		
		for(Bairro s1 : bairro) {
			System.out.println(s1);
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		BairroDAO dao = new BairroDAO();
		Bairro s1 = dao.buscarPorCodigo(3);
		Bairro s2 = dao.buscarPorCodigo(4);
		
			System.out.println(s1);
			System.out.println(s2);
	}
	
	@Test
	@Ignore
	public void excluir() {
		BairroDAO dao = new BairroDAO();
		
		Bairro bairro = dao.buscarPorCodigo(4);
		
		
		dao.excluir(bairro);
		
	}
	
	@Test
	@Ignore
	public void editar() {
		BairroDAO dao = new BairroDAO();
		
		Bairro bairro = dao.buscarPorCodigo(1);
		
		bairro.setNome("Centro");
		bairro.setEndereco("R Visconde de Sepetiba, 987");
		
		
		dao.editar(bairro);
		
	}

}
