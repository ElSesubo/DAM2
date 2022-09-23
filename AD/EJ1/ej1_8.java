package es.florida.ejT1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
 
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ej1_8 {
	
	public boolean copyFile(String fromFile, String toFile) {
        File origin = new File(fromFile);
        File destination = new File(toFile);
        if (origin.exists()) {
            try {
                InputStream in = new FileInputStream(origin);
                OutputStream out = new FileOutputStream(destination);
                // Usamos un buffer para la copia.
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();
                return true;
            } catch (IOException ioe) {
                ioe.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ej1_8 javaIOUtils = new ej1_8();
        String fromFile = "C:/Users/gaarag/Desktop/hola.txt";
        String toFile = "C:/Users/gaarag/Documents/hola.txt";
        boolean result = javaIOUtils.copyFile(fromFile, toFile);
        System.out.println(result?
            "Fichero copiado":
                "No se ha podido copiar el fichero");
	}

}
