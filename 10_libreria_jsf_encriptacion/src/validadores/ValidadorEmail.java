package validadores;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator (value = "valdCorrElec")
public class ValidadorEmail implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		String correoElect = (String)arg2;
		int posArroba = correoElect.indexOf("@");
		String cadDominio = (posArroba != -1)?correoElect.substring(posArroba):"";		
		if (posArroba == -1 || cadDominio.indexOf(".") == -1) {
			ResourceBundle res = arg0.getApplication().getResourceBundle(arg0,"validadorCorrElec");
			throw new ValidatorException(new FacesMessage(res.getString("error.correlec.malformado")));
		}
	}

}
