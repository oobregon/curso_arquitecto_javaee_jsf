package validadores;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;

import managed.RegistroBean;
import utilidades.ContextoApp;

@FacesValidator (value = "vContra")
public class ValidadorContraseña implements Validator {

	@Override
	public void validate(FacesContext fc, UIComponent arg1, Object arg2) throws ValidatorException {
		// Esta es la contraseña repetida que ha introducido el usuario
		String contraRep = (String)arg2;
		String contra;
		
		// Recuperamos el valor del primer campo de contraseña
		contra = ((HttpServletRequest)fc.getExternalContext().getRequest()).getParameter("contrase");

		if (!contra.equals(contraRep)) {
			ResourceBundle res = fc.getApplication().getResourceBundle(fc,"valIgualContras");
			throw new ValidatorException(new FacesMessage(res.getString("error.contras.igualdad")));			
		}			
	}
}
