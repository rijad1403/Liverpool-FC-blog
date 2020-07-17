package controller;

import entity.Korisnik;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import model.Komentar_dao;
import model.Korisnik_dao;

@ManagedBean
@SessionScoped
public class KorisnikController{
    private List<Korisnik> sviKorisnici;
    private Korisnik korisnik = new Korisnik();
    @ManagedProperty(value = "#{upload}")
    private Upload upload = new Upload();
    @ManagedProperty (value = "#{prijava}")
    private Prijava prijava = new Prijava();
   
    public KorisnikController() {
        
    }
    
    public Prijava getPrijava() {
        return prijava;
    }

    public void setPrijava(Prijava prijava) {
        this.prijava = prijava;
    }

    public void setUpload(Upload upload) {
        this.upload = upload;
    }

     public Upload getUpload() {
        return upload;
    }
     
    public List<Korisnik> getSviKorisnici() {     
        return Korisnik_dao.getSveKorisnike();
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
    
    public void registracija() {  
        this.korisnik.setKorisnikSlika(upload.getFileName());
        this.korisnik.setTipKorisnika("Korisnik");       
        Korisnik_dao dao = new Korisnik_dao();
        dao.dodajKorisnika(this.korisnik);
        System.out.println(korisnik.getIme()+" "+korisnik.getPrezime()+" "+korisnik.getEmail()+" "+korisnik.getKorisnickoIme()+" "
        +korisnik.getLozinka()+" "+korisnik.getTipKorisnika()+" "+korisnik.getKorisnikId()+" "+korisnik.getKorisnikSlika());
        this.korisnik = new Korisnik();
        this.upload.setFileName(null);
    }
    
    public void dodajKorisnika() {
        this.korisnik.setKorisnikSlika(upload.getFileName());
        Korisnik_dao dao = new Korisnik_dao();
        dao.dodajKorisnika(this.korisnik);
        this.korisnik = new Korisnik();
        this.upload.setFileName(null);
    }
    
    public void obrisiKorisnika(Korisnik k) {
        Korisnik_dao dao = new Korisnik_dao();
        Komentar_dao dao1 = new Komentar_dao();
        if(prijava.getKorisnik().getKorisnikId().equals(k.getKorisnikId())) {
            dao1.obrisiSveKomentareJednogKorisnika(k.getKorisnikId());
            dao.obrisiKorisnika(k);
            prijava.odjava();                    
        } else {
            dao1.obrisiSveKomentareJednogKorisnika(k.getKorisnikId());
            dao.obrisiKorisnika(k);
        }
    }
    
    public void ponistiKorisnika() {
        this.korisnik = new Korisnik();
    }
    
    public Korisnik getKorisnikById(Integer id) {
        Korisnik_dao dao = new Korisnik_dao();
        Korisnik korisnik2 = dao.getKorisnikById(id);
        return korisnik2;
    }
    
    public void azurirajKorisnika() {
        if(this.upload.getFileName() == null) {
            Korisnik_dao dao = new Korisnik_dao();
            dao.urediKorisnika(this.korisnik);  
        } else {
            this.korisnik.setKorisnikSlika(this.upload.getFileName());
            Korisnik_dao dao = new Korisnik_dao();
            dao.urediKorisnika(this.korisnik);       
            this.upload.setFileName(null);
        }     
        
    }
    
  
    
}
