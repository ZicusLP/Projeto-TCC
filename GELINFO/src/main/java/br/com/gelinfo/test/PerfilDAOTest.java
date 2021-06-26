package br.com.gelinfo.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.gelinfo.DAO.PerfilDAO;
import br.com.gelinfo.domain.Perfil;

public class PerfilDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Perfil s1 = new Perfil();
		
		
		s1.setFuncao("Jovem Aprendiz");
	
		
		
		PerfilDAO dao = new PerfilDAO();
		
		dao.salvar(s1);
	
	}
	
	@Test
	@Ignore
	public void listar() {
		PerfilDAO dao = new PerfilDAO();
		List<Perfil> perfil = dao.listar();
		
		for(Perfil s1 : perfil) {
			System.out.println(s1);
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		PerfilDAO dao = new PerfilDAO();
		Perfil s1 = dao.buscarPorCodigo(3);
		Perfil s2 = dao.buscarPorCodigo(4);
		
			System.out.println(s1);
			System.out.println(s2);
	}
	
	@Test
	@Ignore
	public void excluir() {
		PerfilDAO dao = new PerfilDAO();
		
		Perfil perfil = dao.buscarPorCodigo(5);
		
		
		dao.excluir(perfil);
		
	}
	
	@Test
	@Ignore
	public void editar() {
		PerfilDAO dao = new PerfilDAO();
		
		Perfil perfil = dao.buscarPorCodigo(5);
		
		perfil.setFuncao("Estagiário");
		
		
		
		dao.editar(perfil);
		
	}

}
