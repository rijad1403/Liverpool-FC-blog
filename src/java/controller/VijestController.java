package controller;

import entity.Vijest;
import java.io.File;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import model.Komentar_dao;
import model.Vijest_dao;

@ManagedBean
@SessionScoped
public class VijestController {
    private Vijest vijest = new Vijest();
    private List<Vijest> sveVijesti = new ArrayList(); 
    @ManagedProperty(value = "#{upload}")
    private Upload upload = new Upload();
    @ManagedProperty(value = "#{prijava}")
    private Prijava prijava = new Prijava();
    private boolean azuriranjeVremenaDatuma;
    
    private Integer broj = 8;

    public Integer getBroj() {
        return broj;
    }

    public void setBroj(Integer broj) {
        this.broj = broj;
    }
    
    
    public VijestController() {
    
    }
    
    public Upload getUpload() {
        return upload;
    }

    public void setUpload(Upload upload) {
        this.upload = upload;
    }
    
    public List<Vijest> getSveVijesti() {
        this.sveVijesti = Vijest_dao.getSveVijest();
        return sveVijesti;
    }

    public void setSveVijesti(List<Vijest> sveVijesti) {
        this.sveVijesti = sveVijesti;
    }
    
    public Vijest getVijest() {
        return vijest;
    }

    public void setVijest(Vijest vijest) {
        this.vijest = vijest;
    }

    public Prijava getPrijava() {
        return prijava;
    }

    public void setPrijava(Prijava prijava) {
        this.prijava = prijava;
    }
    
    public void setAzuriranjeVremenaDatuma(boolean azuriranjeVremenaDatuma) {
        this.azuriranjeVremenaDatuma = azuriranjeVremenaDatuma;
    } 
    
    public boolean getAzuriranjeVremenaDatuma() {
        return azuriranjeVremenaDatuma;
    }
    
    public void dodajVijest() {        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dateobj = new Date();
        this.vijest.setVrijemeDatum(dateobj);
        this.vijest.setVijestSlika(upload.getFileName());
        Vijest_dao.dodajVijest(this.vijest);
        this.vijest = new Vijest();
        this.upload.setFileName(null);      
    }
    
    public void ponisti() {
        this.vijest = new Vijest();
        this.upload.setFileName(null);
    }
    
    public void obrisiVijest(Vijest v) {
        Vijest_dao dao = new Vijest_dao();
        Komentar_dao dao1 = new Komentar_dao();
        dao1.obrisiSveKomentare(v.getVijestId());
        dao.obrisiVijest(v);  
    }
    
    public void izaberiVijest(Vijest v) {
        this.vijest = v;      
        upload.setFileName(this.vijest.getVijestSlika());
    }
    
    public void urediVijest() {
        if(azuriranjeVremenaDatuma == true) {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date dateobj = new Date();
            this.vijest.setVrijemeDatum(dateobj);
            azuriranjeVremenaDatuma = false;
            
        }
        this.vijest.setVijestSlika(upload.getFileName());
        Vijest_dao dao = new Vijest_dao();
        dao.urediVijest(this.vijest);
        this.vijest = new Vijest();
        this.upload.setFileName(null);
    }    
    
    public Vijest getVijestById(Integer Id) {
        Vijest_dao dao = new Vijest_dao();
        Vijest vijest = dao.getVijestById(Id);
        return vijest;
    }
    
}
