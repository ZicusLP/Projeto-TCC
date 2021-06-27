package br.com.gelinfo.test;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;


import br.com.gelinfo.DAO.UsuarioDAO;
import br.com.gelinfo.DAO.EquipamentoDAO;
import br.com.gelinfo.DAO.InventarioDAO;
import br.com.gelinfo.DAO.SetorDAO;


import br.com.gelinfo.domain.Usuario;
import br.com.gelinfo.domain.Setor;
import br.com.gelinfo.domain.Equipamento;
import br.com.gelinfo.domain.Inventario;


public class InventarioDAOTest {
	@Test
	@Ignore
	public void salvar() {
		
		
		
		UsuarioDAO udao = new UsuarioDAO();
		Usuario usuario = udao.buscarPorCodigo(3);
		
		SetorDAO sdao = new SetorDAO();
		Setor setor = sdao.buscarPorCodigo(2);
		
		Inventario s1 = new Inventario();
		
		s1.setData(new Date());
		s1.setStatus("Aberto");
	
		s1.setUsuario(usuario);
		s1.setSetor(setor);
		
		
		InventarioDAO dao = new InventarioDAO();
		
		dao.salvar(s1);
	}
	
	@Test
	@Ignore
	public void listar() {
		InventarioDAO dao = new InventarioDAO();
		List<Inventario> inventario = dao.listar();
		
		
		
		for(Inventario s1 : inventario) {
			System.out.println(s1);
		}
	}
	
	@Test
	//@Ignore
	public void buscarPorCodigo() { //Busca os equipamentos inventariados
		InventarioDAO dao = new InventarioDAO();
		Inventario s1 = dao.buscarPorCodigo(1);
		
		EquipamentoDAO edao = new EquipamentoDAO();
		//Equipamento e1 = edao.buscarPorCodigo(1);
		List<Equipamento> equipamento = edao.listar();
		
			System.out.println(s1);
			System.out.println(equipamento);
	}
	
	@Test
	@Ignore
	public void excluir() {
		InventarioDAO dao = new InventarioDAO();
		
		Inventario inventario = dao.buscarPorCodigo(3);
		
		
		dao.excluir(inventario);
		
	}
	
	@Test
	@Ignore
	public void editar() {
		
		UsuarioDAO udao = new UsuarioDAO();
		Usuario usuario = udao.buscarPorCodigo(1);
		
		SetorDAO sdao = new SetorDAO();
		Setor setor = sdao.buscarPorCodigo(1);
					
		InventarioDAO dao = new InventarioDAO();
		Inventario inventario = dao.buscarPorCodigo(5);
		inventario.setStatus("Registrando");
		
		inventario.setUsuario(usuario);
		inventario.setSetor(setor);
		
		dao.editar(inventario);
		
	}

}
