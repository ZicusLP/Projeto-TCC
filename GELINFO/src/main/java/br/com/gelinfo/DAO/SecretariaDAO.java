package br.com.gelinfo.DAO;

import org.hibernate.Transaction;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.gelinfo.domain.Secretaria;
import br.com.gelinfo.util.HibernateUtil;

public class SecretariaDAO {

	public void salvar(Secretaria secretaria)  {
		Session sessao = HibernateUtil.getSessionFactory().openSession(); //abrindo sessao
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrindo transacao
			
			sessao.save(secretaria);
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
	public List<Secretaria> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession(); //abrindo sessao
		
		List<Secretaria> secretaria = null;
		
		try {
			
			Query consulta = sessao.getNamedQuery("Secretaria.listar");
			secretaria = consulta.list();
		
		}catch(RuntimeException ex) {
			throw ex;
	
		}
		
		finally{
			sessao.close(); //encerra sessao
		}
		
		return secretaria;
	}


	public Secretaria buscarPorCodigo(int codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession(); //abrindo sessao
		
		Secretaria secretaria = null;
		
		try {
			
			Query consulta = sessao.getNamedQuery("Secretaria.buscarPorCodigo");
			consulta.setInteger("codigo", codigo);
			secretaria = (Secretaria) consulta.uniqueResult();
		
		}catch(RuntimeException ex) {
			throw ex;
	
		}
		
		finally{
			sessao.close(); //encerra sessao
		}
		
		return secretaria;
	}
	
	public void excluir(Secretaria secretaria)  {
		Session sessao = HibernateUtil.getSessionFactory().openSession(); //abrindo sessao
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrindo transacao
			
			sessao.delete(secretaria);
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
	
	public void editar(Secretaria secretaria)  {
		Session sessao = HibernateUtil.getSessionFactory().openSession(); //abrindo sessao
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrindo transacao
			Secretaria secretariaEditar = buscarPorCodigo(secretaria.getCodigo());
			secretariaEditar.setNome(secretaria.getNome());
			secretariaEditar.setSigla(secretaria.getSigla());
			sessao.update(secretariaEditar);
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
