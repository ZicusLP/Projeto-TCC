package br.com.gelinfo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gelinfo.DAO.PerfilDAO;
import br.com.gelinfo.domain.Perfil;

@FacesConverter("perfilConverter")
public class PerfilConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent componente, String valor) {
		try {

			int codigo = Integer.parseInt(valor);
			PerfilDAO dao = new PerfilDAO();
			Perfil perfil = dao.buscarPorCodigo(codigo);
			
			return perfil;
			
		} catch (RuntimeException ex) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent componente, Object objeto) {
		try {
			
			Perfil perfil = (Perfil)objeto;
			Integer codigo = perfil.getCodigo();
			return codigo.toString();

		} catch (RuntimeException ex) {
			return null;
		} 	
	}

}
