package br.com.gelinfo.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.gelinfo.domain.Marca;
import br.com.gelinfo.util.HibernateUtil;

public class MarcaDAO {

	public void salvar(Marca marca)  {
		Session sessao = HibernateUtil.getSessionFactory().openSession(); //abrindo sessao
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrindo transacao
			
			sessao.save(marca);
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
	public List<Marca> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession(); //abrindo sessao
		
		List<Marca> marca = null;
		
		try {
			
			Query consulta = sessao.getNamedQuery("Marca.listar");
			marca = consulta.list();
		
		}catch(RuntimeException ex) {
			throw ex;
	
		}
		
		finally{
			sessao.close(); //encerra sessao
		}
		
		return marca;
	}


	public Marca buscarPorCodigo(int codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession(); //abrindo sessao
		
		Marca marca = null;
		
		try {
			
			Query consulta = sessao.getNamedQuery("Marca.buscarPorCodigo");
			consulta.setInteger("codigo", codigo);
			marca = (Marca) consulta.uniqueResult();
		
		}catch(RuntimeException ex) {
			throw ex;
	
		}
		
		finally{
			sessao.close(); //encerra sessao
		}
		
		return marca;
	}
	
	public void excluir(Marca marca)  {
		Session sessao = HibernateUtil.getSessionFactory().openSession(); //abrindo sessao
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrindo transacao
			
			sessao.delete(marca);
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
	
	public void editar(Marca marca)  {
		Session sessao = HibernateUtil.getSessionFactory().openSession(); //abrindo sessao
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrindo transacao
			Marca marcaEditar = buscarPorCodigo(marca.getCodigo());
			marcaEditar.setNome(marca.getNome());
			
			sessao.update(marcaEditar);
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
