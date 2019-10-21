package principal;

public class Pruebas {

	public static void main(String[] args) {
		String correoElect = "nombre.obregon.dominio";
		System.out.println(correoElect.indexOf("@"));
		String cadDominio = correoElect.substring(correoElect.indexOf("@"));		
		System.out.println(cadDominio);
		if (cadDominio.indexOf(".") == -1) {
			System.out.println("Dominio mal formado");
		}		
	}
}