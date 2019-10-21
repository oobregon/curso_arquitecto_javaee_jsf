package utilidades;

import java.security.MessageDigest;
import java.util.Base64;

public class Util {

		public static String encriptarSha256(String dato) {
			try {
				// El método de encriptación es SHA-256
				MessageDigest md=MessageDigest.getInstance("SHA-256");
				md.update(dato.getBytes());
				byte[] enc=md.digest();
				
				//codificamos el array resultante en base 64
				//y creamos una cadena a partir del mismo
				// Esta cadena ya 
				return new String(Base64.getEncoder().encode(enc));
			}
			catch(Exception ex) {
				ex.printStackTrace();
				return null;
			}
		}
}
