package br.com.gelinfo.DAO;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.gelinfo.domain.Usuario;
import br.com.gelinfo.util.HibernateUtil;

public class UsuarioDAO {

	public void salvar(Usuario usuario)  {
		Session sessao = HibernateUtil.getSessionFactory().openSession(); //abrindo sessao
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrindo transacao
			
			sessao.save(usuario);
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
	public List<Usuario> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession(); //abrindo sessao
		
		List<Usuario> usuario = null;
		
		try {
			
			Query consulta = sessao.getNamedQuery("Usuario.listar");
			usuario = consulta.list();
		
		}catch(RuntimeException ex) {
			throw ex;
	
		}
		
		finally{
			sessao.close(); //encerra sessao
		}
		
		return usuario;
	}


	public Usuario buscarPorCodigo(int codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession(); //abrindo sessao
		
		Usuario usuario = null;
		
		try {
			
			Query consulta = sessao.getNamedQuery("Usuario.buscarPorCodigo");
			consulta.setInteger("codigo", codigo);
			usuario = (Usuario) consulta.uniqueResult();
		
		}catch(RuntimeException ex) {
			throw ex;
	
		}
		
		finally{
			sessao.close(); //encerra sessao
		}
		
		return usuario;
	}
	
	public void excluir(Usuario usuario)  {
		Session sessao = HibernateUtil.getSessionFactory().openSession(); //abrindo sessao
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrindo transacao
			
			sessao.delete(usuario);
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
	
	public void editar(Usuario usuario)  {
		Session sessao = HibernateUtil.getSessionFactory().openSession(); //abrindo sessao
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrindo transacao
			Usuario usuarioEditar = buscarPorCodigo(usuario.getCodigo());
			usuarioEditar.setNome(usuario.getNome());
			usuarioEditar.setLogin(usuario.getLogin());
			usuarioEditar.setTelefone(usuario.getTelefone());
			usuarioEditar.setSenha(usuario.getSenha());
			
			sessao.update(usuarioEditar);
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
	


//public Usuario login (String login, String senha) {
//		
//	Session sessao = HibernateUtil.getSessionFactory().openSession(); //abrindo sessao
//	
//	Usuario usuario = null;
//	
//  try {
//		Query consulta = sessao.getNamedQuery("Usuario.login");
//		consulta.setString("login", login);
//		consulta.setString("senha", senha);
//		usuario = (Usuario) consulta.uniqueResult();
//	
//	}catch(RuntimeException ex) {
//		throw ex;
//
//	}
//	
//	finally{
//		sessao.close(); //encerra sessao
//	}
//	
//	return usuario;
//}
}
