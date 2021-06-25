package br.com.gelinfo.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.gelinfo.domain.TipoEquipamento;
import br.com.gelinfo.util.HibernateUtil;

public class TipoEquipamentoDAO {

	public void salvar(TipoEquipamento tipo)  {
		Session sessao = HibernateUtil.getSessionFactory().openSession(); //abrindo sessao
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrindo transacao
			
			sessao.save(tipo);
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
	public List<TipoEquipamento> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession(); //abrindo sessao
		
		List<TipoEquipamento> tipo = null;
		
		try {
			
			Query consulta = sessao.getNamedQuery("TipoEquipamento.listar");
			tipo = consulta.list();
		
		}catch(RuntimeException ex) {
			throw ex;
	
		}
		
		finally{
			sessao.close(); //encerra sessao
		}
		
		return tipo;
	}


	public TipoEquipamento buscarPorCodigo(int codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession(); //abrindo sessao
		
		TipoEquipamento tipo = null;
		
		try {
			
			Query consulta = sessao.getNamedQuery("TipoEquipamento.buscarPorCodigo");
			consulta.setInteger("codigo", codigo);
			tipo = (TipoEquipamento) consulta.uniqueResult();
		
		}catch(RuntimeException ex) {
			throw ex;
	
		}
		
		finally{
			sessao.close(); //encerra sessao
		}
		
		return tipo;
	}
	
	public void excluir(TipoEquipamento tipo)  {
		Session sessao = HibernateUtil.getSessionFactory().openSession(); //abrindo sessao
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrindo transacao
			
			sessao.delete(tipo);
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
	
	public void editar(TipoEquipamento tipo)  {
		Session sessao = HibernateUtil.getSessionFactory().openSession(); //abrindo sessao
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrindo transacao
			TipoEquipamento tipoEditar = buscarPorCodigo(tipo.getCodigo());
			tipoEditar.setNome(tipo.getNome());
			
			sessao.update(tipoEditar);
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
