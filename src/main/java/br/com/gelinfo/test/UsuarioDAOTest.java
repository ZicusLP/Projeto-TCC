package br.com.gelinfo.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;


import br.com.gelinfo.DAO.PerfilDAO;
import br.com.gelinfo.DAO.UsuarioDAO;

import br.com.gelinfo.domain.Perfil;
import br.com.gelinfo.domain.Usuario;

public class UsuarioDAOTest {


	@Test
	@Ignore
	public void salvar() {
		
		PerfilDAO dao = new PerfilDAO();
		Perfil perfil = dao.buscarPorCodigo(1);
		
		Usuario s1 = new Usuario();
		
		s1.setNome("HHH");
		s1.setLogin("HHH.cunha");
		s1.setSenha("123");
		s1.setTelefone(444);
		s1.setPerfil(perfil);
		
		UsuarioDAO udao = new UsuarioDAO();
		
		udao.salvar(s1);
	}
	
	@Test
	@Ignore
	public void listar() {
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> usuario = dao.listar();
		
		for(Usuario s1 : usuario) {
			System.out.println(s1);
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario s1 = dao.buscarPorCodigo(3);
		Usuario s2 = dao.buscarPorCodigo(4);
		
			System.out.println(s1);
			System.out.println(s2);
	}
	
	@Test
	@Ignore
	public void excluir() {
		UsuarioDAO dao = new UsuarioDAO();
		
		Usuario usuario = dao.buscarPorCodigo(5);
		
		
		dao.excluir(usuario);
		
	}
	
	@Test
	@Ignore
	public void editar() {
		
		PerfilDAO pdao = new PerfilDAO();
		Perfil perfil = pdao.buscarPorCodigo(1);
		
		UsuarioDAO dao = new UsuarioDAO();
		
		Usuario usuario = dao.buscarPorCodigo(1);
		usuario.setNome("Lucas");
		usuario.setLogin("lucas.santos");
		usuario.setSenha("0208");
		usuario.setTelefone(999);
		usuario.setPerfil(perfil);
		
		dao.editar(usuario);
		
	}
}
