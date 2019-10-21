package validadores;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;

@FacesValidator (value = "vContra")
public class ValidadorContraseña implements Validator {

	@Override
	public void validate(FacesContext fc, UIComponent arg1, Object arg2) throws ValidatorException {
		// Esta es la contraseña repetida que ha introducido el usuario. Es este valor el 
		// que tenemos que validar.
		String contraRep = (String)arg2;
		String contra;
		
		UIInput componenteContraseña = (UIInput)arg1.findComponent("contrase");
		// Dos formas de recuperar el valor del primer campo de contraseña
		contra = ((HttpServletRequest)fc.getExternalContext().getRequest()).getParameter("contrase");
		contra = (String)componenteContraseña.getValue();

		if (!contra.equals(contraRep)) {
			ResourceBundle res = fc.getApplication().getResourceBundle(fc,"valIgualContras");
			throw new ValidatorException(new FacesMessage(res.getString("error.contras.igualdad")));			
		}			
	}
}
