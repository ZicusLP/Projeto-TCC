package br.com.gelinfo.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.gelinfo.DAO.UsuarioDAO;
import br.com.gelinfo.domain.Usuario;

@ManagedBean(name = "LoginMB")
@ViewScoped
public class LoginBean {

	 private UsuarioDAO usuarioDAO = new UsuarioDAO();
	  private Usuario usuario = new Usuario();

	  public String envia() {

	    usuario = usuarioDAO.login(usuario.getLogin(), usuario.getSenha());
	    if (usuario == null) {
	      usuario = new Usuario();
	      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!","Erro no Login!"));
	      return null;
	    } else {
	          return "/pages/templates/layoutSystem.xhtml";
	    }


	  }

	  public Usuario getUsuario() {
	    return usuario;
	  }

	  public void setUsuario(Usuario usuario) {
	    this.usuario = usuario;
	  }
	
}
