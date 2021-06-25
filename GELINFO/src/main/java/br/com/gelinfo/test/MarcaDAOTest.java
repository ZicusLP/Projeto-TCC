package br.com.gelinfo.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.gelinfo.DAO.MarcaDAO;
import br.com.gelinfo.domain.Marca;

public class MarcaDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Marca s1 = new Marca();
		s1.setNome("Xerox");
		
		
		MarcaDAO dao = new MarcaDAO();
		
		dao.salvar(s1);
	}
	
	@Test
	@Ignore
	public void listar() {
		MarcaDAO dao = new MarcaDAO();
		List<Marca> marca = dao.listar();
		
		for(Marca s1 : marca) {
			System.out.println(s1);
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		MarcaDAO dao = new MarcaDAO();
		Marca s1 = dao.buscarPorCodigo(3);
		Marca s2 = dao.buscarPorCodigo(4);
		
			System.out.println(s1);
			System.out.println(s2);
	}
	
	@Test
	@Ignore
	public void excluir() {
		MarcaDAO dao = new MarcaDAO();
		
		Marca marca = dao.buscarPorCodigo(5);
		
		
		dao.excluir(marca);
		
	}
	
	@Test
	@Ignore
	public void editar() {
		MarcaDAO dao = new MarcaDAO();
		
		Marca marca = dao.buscarPorCodigo(4);
		
		marca.setNome("LG");
		
		
		
		dao.editar(marca);
		
	}
}
