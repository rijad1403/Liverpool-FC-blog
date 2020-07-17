package common;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.faces.context.FacesContext;
import javax.el.ELContext;

public class Funkcija {
    public static Object getBeanObject(String id) {
        ELContext fcCon = FacesContext.getCurrentInstance().getELContext();
        return fcCon.getELResolver().getValue(fcCon, null, id);
    }
     public static void inputStream2outputStream(InputStream is, OutputStream os) {
        if(is != null) {
            int read = 0;
            
            byte[] bytes = new byte[1024];
            
            try {
                while((read = is.read(bytes)) != -1) {
                    os.write(bytes, 0, read);
                }
            } catch(Exception ex) {
                
            }
        }
    }
     
    public static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}
