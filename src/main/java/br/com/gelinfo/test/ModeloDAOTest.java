package br.com.gelinfo.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.gelinfo.DAO.MarcaDAO;
import br.com.gelinfo.DAO.ModeloDAO;
import br.com.gelinfo.domain.Marca;
import br.com.gelinfo.domain.Modelo;

public class ModeloDAOTest {

	@Test
	@Ignore
	public void salvar() {
		
		MarcaDAO dao = new MarcaDAO();
		Marca marca = dao.buscarPorCodigo(3);
		
		Modelo s1 = new Modelo();
		
		s1.setNome("8952");
		s1.setMarca(marca);
		
		ModeloDAO mdao = new ModeloDAO();
		
		mdao.salvar(s1);
	}
	
	@Test
	@Ignore
	public void listar() {
		ModeloDAO dao = new ModeloDAO();
		List<Modelo> modelo = dao.listar();
		
		for(Modelo s1 : modelo) {
			System.out.println(s1);
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		ModeloDAO dao = new ModeloDAO();
		Modelo s1 = dao.buscarPorCodigo(3);
		Modelo s2 = dao.buscarPorCodigo(4);
		
			System.out.println(s1);
			System.out.println(s2);
	}
	
	@Test
	@Ignore
	public void excluir() {
		ModeloDAO dao = new ModeloDAO();
		
		Modelo modelo = dao.buscarPorCodigo(5);
		
		
		dao.excluir(modelo);
		
	}
	
	@Test
	@Ignore
	public void editar() {
		
		MarcaDAO pdao = new MarcaDAO();
		Marca marca = pdao.buscarPorCodigo(2);
		
		ModeloDAO dao = new ModeloDAO();
		
		Modelo modelo = dao.buscarPorCodigo(1);
		modelo.setNome("4063");
		modelo.setMarca(marca);
		
		dao.editar(modelo);
		
	}
}
