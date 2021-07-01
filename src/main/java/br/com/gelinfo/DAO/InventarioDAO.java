package br.com.gelinfo.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.gelinfo.domain.Inventario;
import br.com.gelinfo.util.HibernateUtil;

public class InventarioDAO {


	public void salvar(Inventario inventario)  {
		Session sessao = HibernateUtil.getSessionFactory().openSession(); //abrindo sessao
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrindo transacao
			
			sessao.save(inventario);
			transacao.commit(); //confirmando transacao
		
		}catch(RuntimeException ex) {
			if(transacao !=null) {
				transacao.rollback(); //desfaz transacao
			}
	
		}
		
		finally{
			sessao.close(); //encerra sessao
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Inventario> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession(); //abrindo sessao
		
		List<Inventario> inventario = null;
		
		try {
			
			Query consulta = sessao.getNamedQuery("Inventario.listar");
			inventario = consulta.list();
		
		}catch(RuntimeException ex) {
			throw ex;
	
		}
		
		finally{
			sessao.close(); //encerra sessao
		}
		
		return inventario;
	}


	public Inventario buscarPorCodigo(int codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession(); //abrindo sessao
		
		Inventario inventario = null;
		
		try {
			
			Query consulta = sessao.getNamedQuery("Inventario.buscarPorCodigo");
			consulta.setInteger("codigo", codigo);
			inventario = (Inventario) consulta.uniqueResult();
		
		}catch(RuntimeException ex) {
			throw ex;
	
		}
		
		finally{
			sessao.close(); //encerra sessao
		}
		
		return inventario;
	}
	
	public void excluir(Inventario inventario)  {
		Session sessao = HibernateUtil.getSessionFactory().openSession(); //abrindo sessao
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrindo transacao
			
			sessao.delete(inventario);
			transacao.commit(); //confirmando transacao
		
		}catch(RuntimeException ex) {
			if(transacao !=null) {
				transacao.rollback(); //desfaz transacao
			}
	
		}
		
		finally{
			sessao.close(); //encerra sessao
		}
		
	}
	
	public void editar(Inventario inventario)  {
		Session sessao = HibernateUtil.getSessionFactory().openSession(); //abrindo sessao
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrindo transacao
			Inventario inventarioEditar = buscarPorCodigo(inventario.getCodigo());
			inventarioEditar.setStatus(inventario.getStatus());
			
			sessao.update(inventarioEditar);
			transacao.commit(); //confirmando transacao
		
		}catch(RuntimeException ex) {
			if(transacao !=null) {
				transacao.rollback(); //desfaz transacao
			}
	
		}
		
		finally{
			sessao.close(); //encerra sessao
		}
		
	}
}
