package br.com.gelinfo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gelinfo.DAO.SetorDAO;
import br.com.gelinfo.domain.Setor;

@FacesConverter("setorConverter")
public class SetorConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent componente, String valor) {
		try {

			int codigo = Integer.parseInt(valor);
			SetorDAO dao = new SetorDAO();
			Setor setor = dao.buscarPorCodigo(codigo);
			
			return setor;
			
		} catch (RuntimeException ex) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent componente, Object objeto) {
		try {
			
			Setor setor = (Setor)objeto;
			Integer codigo = setor.getCodigo();
			return codigo.toString();

		} catch (RuntimeException ex) {
			return null;
		} 	
	}

}
