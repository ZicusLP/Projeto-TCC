package br.com.gelinfo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gelinfo.DAO.SecretariaDAO;
import br.com.gelinfo.domain.Secretaria;

@FacesConverter("secretariaConverter")
public class SecretariaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent componente, String valor) {
		try {

			int codigo = Integer.parseInt(valor);
			SecretariaDAO dao = new SecretariaDAO();
			Secretaria secretaria = dao.buscarPorCodigo(codigo);
			
			return secretaria;
			
		} catch (RuntimeException ex) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent componente, Object objeto) {
		try {
			
			Secretaria secretaria = (Secretaria)objeto;
			Integer codigo = secretaria.getCodigo();
			return codigo.toString();

		} catch (RuntimeException ex) {
			return null;
		} 	
	}

}
