package validadores;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator (value = "vCat")
public class ValidadorCategoria implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		// UIComponent: este es el componente 
		// Object arg2: es el valor del componente. Es este el valor que tenemos que validar
		String valor = (String)arg2;
		
		// Tenemos que preguntar si el valor no cumple con el criterio
		// Si la categoria no empieza por 9
		if (!valor.startsWith("9")) {
			ResourceBundle res = arg0.getApplication().getResourceBundle(arg0,"valPer");
			throw new ValidatorException(new FacesMessage(res.getString("error.categoria")));
			//throw new ValidatorException(new FacesMessage("Categoría no válida"));
		}
	}
}
