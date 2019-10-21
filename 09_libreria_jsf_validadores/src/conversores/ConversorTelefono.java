package conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter (value = "convTfno")
public class ConversorTelefono implements Converter {
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (arg2 == null || arg2.equals("")) {
			return 10000;
		}
		return Integer.parseInt(arg2);
	}

	// Lo que queremos es que si el mb tiene un cero en una de sus propiedades, pues que en el xhtml no muestre un cero, sino nada.
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Integer valor = (Integer)arg2;
		if (valor.equals(0)) {
			return "";
		}
		return valor.toString();
	}
}
