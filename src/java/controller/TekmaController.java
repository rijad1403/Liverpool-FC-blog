package controller;

import entity.Tekma;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Tekma_dao;

@ManagedBean
@SessionScoped
public class TekmaController {
    private Tekma tekma = new Tekma();
    private List<Tekma> sveTekme;
    
    public TekmaController() {
    
    }
    
    public Tekma getTekma() {
        return this.tekma;
    }
    
    public void setTekma(Tekma tekma) {
        this.tekma = tekma;
    }
    
    public List<Tekma> getSveTekme() {
        Tekma_dao dao = new Tekma_dao();
        this.sveTekme = dao.getSveTekme();
        return this.sveTekme;
    }
    
    public void dodajTekmu() {
        if(this.tekma.getDomaciGosti().equals("domaci")) {
            this.tekma.setStadion("Anfield");
            Tekma_dao dao = new Tekma_dao();
            dao.dodajTekmu(this.tekma);
        } else {
            Tekma_dao dao = new Tekma_dao();
            dao.dodajTekmu(this.tekma);
        }
        this.tekma = new Tekma();
    }
    
    public void obrisiTekmu(Tekma tekma) {
        Tekma_dao dao = new Tekma_dao();
        dao.obrisiTekmu(tekma);
    }
      
    public void urediTekmu() {
        if(this.tekma.getDomaciGosti().equals("domaci")) {
            this.tekma.setStadion("Anfield");
            Tekma_dao dao = new Tekma_dao();
            dao.azurirajTekmu(this.tekma);
        } else {
            Tekma_dao dao = new Tekma_dao();
            dao.azurirajTekmu(this.tekma);
        }     
        this.tekma = new Tekma();
    }
    
    public void ponisti() {
        this.tekma = new Tekma();
    }
    
    public void dodajRezultat() {
        Tekma_dao dao = new Tekma_dao();
        dao.azurirajTekmu(this.tekma);
        this.tekma = new Tekma();
        
    }
    
}
