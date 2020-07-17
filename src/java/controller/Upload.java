package controller; 

import common.Funkcija;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.File;
import java.io.FileOutputStream;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.FileUploadEvent;

@SessionScoped
@ManagedBean
public class Upload {
    private String fileName;
    private boolean uploaded = false;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
 
    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Uspješno. ","Slika "+ event.getFile().getFileName() + " je uploadana.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        if(event.getFile().getSize() > 0) {
            String fn = event.getFile().getFileName();
            String xfn = fn.contains(".")?fn.substring(0, fn.lastIndexOf(".")):fn;
            String yfn = fn.contains(".")?fn.substring(fn.lastIndexOf(".")):"";
            File f = new File("/home/rijad/Desktop/Objektno orjentirane baze podataka/LFC/uploads/" + fn);
            int i = 0;
            while(f.exists()) {
                fn = (xfn) + (i++) + yfn;
                f = new File("/home/rijad/Desktop/Objektno orjentirane baze podataka/LFC/uploads/" + fn);
            }            
            fileName = fn;                       
            try {
                FileOutputStream fos = new FileOutputStream(f);
                
                Funkcija.inputStream2outputStream(event.getFile().getInputstream(), fos);
                
                fos.flush();
                fos.close();
                event.getFile().getInputstream().close();
            } catch(Exception ex) {
                ex.printStackTrace(System.out);
            }
        }
        this.uploaded = true;        
    }
    
    
}