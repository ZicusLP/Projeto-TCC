package br.com.gelinfo.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.gelinfo.DAO.SecretariaDAO;
import br.com.gelinfo.DAO.BairroDAO;
import br.com.gelinfo.DAO.SetorDAO;
import br.com.gelinfo.domain.Secretaria;
import br.com.gelinfo.domain.Bairro;
import br.com.gelinfo.domain.Setor;

public class SetorDAOTest {

	@Test
	@Ignore
	public void salvar() {
		
		SecretariaDAO sdao = new SecretariaDAO();
		Secretaria secretaria = sdao.buscarPorCodigo(2);
		
		BairroDAO bdao = new BairroDAO();
		Bairro bairro = bdao.buscarPorCodigo(1);
		
		Setor s1 = new Setor();
		
		s1.setNome("SSS");
		s1.setSigla("SAsA");
		s1.setAndar("4");
		s1.setSecretaria(secretaria);
		s1.setBairro(bairro);
		
		SetorDAO dao = new SetorDAO();
		
		dao.salvar(s1);
	}
	
	@Test
	@Ignore
	public void listar() {
		SetorDAO dao = new SetorDAO();
		List<Setor> setor = dao.listar();
		
		for(Setor s1 : setor) {
			System.out.println(s1);
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		SetorDAO dao = new SetorDAO();
		Setor s1 = dao.buscarPorCodigo(3);
		Setor s2 = dao.buscarPorCodigo(4);
		
			System.out.println(s1);
			System.out.println(s2);
	}
	
	@Test
	@Ignore
	public void excluir() {
		SetorDAO dao = new SetorDAO();
		
		Setor setor = dao.buscarPorCodigo(4);
		
		
		dao.excluir(setor);
		
	}
	
	@Test
	//@Ignore
	public void editar() {
		
		SecretariaDAO sdao = new SecretariaDAO();
		Secretaria secretaria = sdao.buscarPorCodigo(2);
		
		BairroDAO bdao = new BairroDAO();
		Bairro bairro = bdao.buscarPorCodigo(1);
		
		SetorDAO dao = new SetorDAO();
		
		Setor s1 = dao.buscarPorCodigo(1);
		s1.setNome("Centro de Processamento de Dados");
		s1.setSigla("CPD");
		s1.setAndar("Sub-Solo");
		s1.setSecretaria(secretaria);
		s1.setBairro(bairro);
		
		dao.editar(s1);
		
	}
}
