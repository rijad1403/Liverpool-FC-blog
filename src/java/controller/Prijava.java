package controller;

import entity.Korisnik;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import model.Korisnik_dao;

@SessionScoped
@ManagedBean
public class Prijava {
    private Korisnik korisnik = new Korisnik();
    private boolean prijavljen;
    @ManagedProperty(value = "#{upload}")
    private Upload upload = new Upload();
    
    public Prijava() {
        this.prijavljen = false;
    }
    
    public Korisnik getKorisnik() {
        return this.korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
    
    public boolean getPrijavljen() {
        return prijavljen;
    }

    public void setPrijavljen(boolean prijavljen) {
        this.prijavljen = prijavljen;
    }

    public Upload getUpload() {
        return this.upload;
    }
    
    public void setUpload(Upload upload) {
        this.upload = upload;
    }
        
    public String prijava() {
        Korisnik prijavljeniKorisnik = Korisnik_dao.getKorisnikByKorisnickoImeIlozinka(this.korisnik.getKorisnickoIme(),this.korisnik.getLozinka());
        if(prijavljeniKorisnik != null) {
            this.korisnik = prijavljeniKorisnik;
            this.prijavljen = true;
            if("Admin".equals(prijavljeniKorisnik.getTipKorisnika())) {
                return "admin?faces-redirect=true";
            } else {
                return "korisnik?faces-redirect=true";
            }
        } else {
            this.prijavljen = false;
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Podaci nisu validni!", "Unesite tačne podatke"));
            return null;
        } 
    }
    
    public String odjava() {
        this.prijavljen = false;
        this.korisnik = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "prijava?faces-redirect=true";
    }
    
    public void azurirajProfil() {
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
       
    public void isAdmin(ComponentSystemEvent event) {
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().getSessionMap().put("tipKorisnika", this.korisnik.getTipKorisnika());
        if(!"Admin".equals(fc.getExternalContext().getSessionMap().get("tipKorisnika"))) {
            ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
            nav.performNavigation("index?faces-redirect=true");
        }      
    }
    
    public void isUser(ComponentSystemEvent event) {
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().getSessionMap().put("tipKorisnika", this.korisnik.getTipKorisnika());
        if(!"Korisnik".equals(fc.getExternalContext().getSessionMap().get("tipKorisnika"))) {
            ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
            nav.performNavigation("index?faces-redirect=true");
        }      
    }
    
    public void isNotLogged() {
        this.prijavljen = false;
        this.korisnik = new Korisnik();
    }
    
}
