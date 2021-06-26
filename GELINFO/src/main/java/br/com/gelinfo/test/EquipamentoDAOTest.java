package br.com.gelinfo.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.gelinfo.DAO.TipoEquipamentoDAO;
import br.com.gelinfo.DAO.ModeloDAO;
import br.com.gelinfo.DAO.SetorDAO;
import br.com.gelinfo.DAO.EquipamentoDAO;

import br.com.gelinfo.domain.Setor;
import br.com.gelinfo.domain.Modelo;
import br.com.gelinfo.domain.TipoEquipamento;
import br.com.gelinfo.domain.Equipamento;

public class EquipamentoDAOTest {

	@Test
	@Ignore
	public void salvar() {
		
		TipoEquipamentoDAO dao = new TipoEquipamentoDAO();
		TipoEquipamento tipo = dao.buscarPorCodigo(2);
		
		ModeloDAO mdao = new ModeloDAO();
		Modelo modelo = mdao.buscarPorCodigo(6);
		
		SetorDAO sdao = new SetorDAO();
		Setor setor = sdao.buscarPorCodigo(1);
		
		Equipamento s1 = new Equipamento();
		
		s1.setPatrimonio("MXSAO");
		s1.setNpatrimonio("MLP555");
		s1.setNserie("AG5268");
		s1.setModelo(modelo);
		s1.setSetor(setor);
		s1.setTipo(tipo);
		
		EquipamentoDAO udao = new EquipamentoDAO();
		
		udao.salvar(s1);
	}
	
	@Test
	@Ignore
	public void listar() {
		EquipamentoDAO dao = new EquipamentoDAO();
		List<Equipamento> equipamento = dao.listar();
		
		for(Equipamento s1 : equipamento) {
			System.out.println(s1);
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		EquipamentoDAO dao = new EquipamentoDAO();
		Equipamento s1 = dao.buscarPorCodigo(5);
		Equipamento s2 = dao.buscarPorCodigo(4);
		
			System.out.println(s1);
			System.out.println(s2);
	}
	
	@Test
	//@Ignore
	public void excluir() {
		EquipamentoDAO dao = new EquipamentoDAO();
		
		Equipamento usuario = dao.buscarPorCodigo(5);
		
		
		dao.excluir(usuario);
		
	}
	
	@Test
	@Ignore
	public void editar() {
		
		TipoEquipamentoDAO dao = new TipoEquipamentoDAO();
		TipoEquipamento tipo = dao.buscarPorCodigo(2);
		
		ModeloDAO mdao = new ModeloDAO();
		Modelo modelo = mdao.buscarPorCodigo(6);
		
		SetorDAO sdao = new SetorDAO();
		Setor setor = sdao.buscarPorCodigo(1);
		
		EquipamentoDAO edao = new EquipamentoDAO();
		
		Equipamento equipamento = edao.buscarPorCodigo(5);
		equipamento.setPatrimonio("Lucas");
		equipamento.setNpatrimonio("KKK666");
		equipamento.setNserie("LP0208");
		equipamento.setTipo(tipo);
		equipamento.setModelo(modelo);
		equipamento.setSetor(setor);
		
		edao.editar(equipamento);
		
	}
}
