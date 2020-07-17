package controller;

import entity.Menadzer;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import model.Menadzer_dao;

@ManagedBean
@SessionScoped
public class MenadzerController {
    
    private Menadzer menadzer = new Menadzer();
    @ManagedProperty (value = "#{upload}")
    private Upload upload = new Upload();
    private List<Menadzer> sviMenadzeri;

    public MenadzerController() {
    
    }
    
    public Menadzer getMenadzer() {
        return this.menadzer;
    }
    
    public void setMenadzer(Menadzer menadzer) {
        this.menadzer = menadzer;
        this.upload.setFileName(this.menadzer.getMenadzerSlika());
    }
    
    public Upload getUpload() {
        return this.upload;
    }
    
    public void setUpload(Upload upload) {
        this.upload = upload;
    }
    
    public List<Menadzer> getSviMenadzeri() {
        Menadzer_dao dao = new Menadzer_dao();
        this.sviMenadzeri = dao.getSveMenadzere();
        return sviMenadzeri;
    } 
    
    
    public void dodajMenadzera(){
        this.menadzer.setMenadzerSlika(this.upload.getFileName());
        Menadzer_dao dao = new Menadzer_dao();
        dao.dodajMenadzera(this.menadzer);
        this.menadzer = new Menadzer();
        this.upload.setFileName(null);
    }
    
    public void azurirajMenadzera() {
        this.menadzer.setMenadzerSlika(this.upload.getFileName());
        Menadzer_dao dao = new Menadzer_dao();
        dao.azurirajMenadzera(this.menadzer);       
        this.menadzer = new Menadzer();
        this.upload.setFileName(null);
    }
    
    public void obrisiMenadzera(Menadzer menadzer) {
        Menadzer_dao dao = new Menadzer_dao();
        dao.obrisiMenadzera(menadzer);
    }
    
    public void ponisti() {
        this.menadzer = new Menadzer();
        this.upload.setFileName(null);
    }
}
