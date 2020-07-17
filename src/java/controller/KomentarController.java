package controller;

import entity.Komentar;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import model.Komentar_dao;

@ManagedBean
@SessionScoped
public class KomentarController {
    private Komentar komentar = new Komentar();
    private List<Komentar> sviKomentariOdabraneVijesti;
    @ManagedProperty(value = "#{vijestController}")
    private VijestController vijestController = new VijestController();
    @ManagedProperty(value = "#{prijava}")
    private Prijava prijava = new Prijava();
    private List<Komentar> sviKomentariJednogKorisnika;
    
    public KomentarController() {
    
    }
    
    public Komentar getKomentar() {
        return komentar;
    }

    public void setKomentar(Komentar komentar) {
        this.komentar = komentar;
    }
   
    public void setPrijava(Prijava prijava) {
        this.prijava = prijava;
    }
    
    public Prijava getPrijava() {
        return prijava;
    }

    public VijestController getVijestController() {
        return vijestController;
    }

    public void setVijestController(VijestController vijestController) {
        this.vijestController = vijestController;
    }
    
    public List<Komentar> getSviKomentariOdabraneVijesti(Integer citanaVijestId) {
        this.sviKomentariOdabraneVijesti = Komentar_dao.getSveKomentare(citanaVijestId);
        return sviKomentariOdabraneVijesti;
    }
  
    public List<Komentar> getSviKomentariJednogKorisnika(Integer korisnikId) {
        Komentar_dao dao = new Komentar_dao();
        this.sviKomentariJednogKorisnika = dao.getSviKomentariJednogKorisnika(korisnikId);
        return this.sviKomentariJednogKorisnika;
    
    }
    
    public void dodajKomentar(Integer citanaVijestId) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dateobj = new Date();
        this.komentar.setVrijemeDatumkomentara(dateobj);
        this.komentar.setVijest(vijestController.getVijestById(citanaVijestId));
        this.komentar.setKorisnik(prijava.getKorisnik());
        Komentar_dao dao = new Komentar_dao();
        dao.dodajKomentar(komentar);
        this.komentar = new Komentar();  
    }
    
    public void obrisiKomentar(Komentar k) {
        Komentar_dao dao = new Komentar_dao();
        dao.obrisiKomentar(k);
    }    
    
    public void izaberiKomentar(Komentar k) {
        this.komentar = k;
    }
   
    public void urediKomentar() {
        Komentar_dao dao = new Komentar_dao();
        dao.urediKomentar(this.komentar);
        this.komentar = new Komentar();      
    }
    
}
