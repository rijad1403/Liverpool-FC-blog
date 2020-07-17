package controller;

import entity.Igrac;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import model.Igrac_dao;

@ManagedBean
@SessionScoped
public class IgracController {
    private Igrac igrac = new Igrac();
    private List<Igrac> sviIgraci;
    private List<Igrac> filterIgraci;
    @ManagedProperty (value = "#{upload}")
    Upload upload = new Upload();

    public Igrac getIgrac() {
        return igrac;
    }

    public void setIgrac(Igrac igrac) {
        this.igrac = igrac;
    }

    public List<Igrac> getSviIgraci() {
        Igrac_dao dao = new Igrac_dao();
        this.sviIgraci = dao.getSveIgrace();
        return this.sviIgraci;
    }
    
    public List<Igrac> getFilterIgraci() {
        return this.filterIgraci;
    }
    
    public void setFilterIgraci(List<Igrac> filterIgraci) {
        this.filterIgraci = filterIgraci;
    }

    public Upload getUpload() {
        return upload;
    }

    public void setUpload(Upload upload) {
        this.upload = upload;
    }

    public void dodajIgraca() {
        this.igrac.setIgracSlika(upload.getFileName());
        Igrac_dao dao = new Igrac_dao();
        dao.dodajIgraca(igrac);
        this.igrac = new Igrac();
        this.upload.setFileName(null);
    }
    
    public void obrisiIgraca(Igrac igrac) {
        Igrac_dao dao = new Igrac_dao();
        dao.obrisiIgraca(igrac);
    }
    
    public void izaberiIgraca(Igrac igrac) {
        this.igrac = igrac;
        upload.setFileName(this.igrac.getIgracSlika());
    }
    
    public void urediIgraca() {
        this.igrac.setIgracSlika(upload.getFileName());
        Igrac_dao dao = new Igrac_dao();
        dao.urediIgraca(this.igrac);
        this.igrac = new Igrac();
        this.upload.setFileName(null);
    }
    
    public void ponisti() {
        this.igrac = new Igrac();
        this.upload.setFileName(null);       
    }
    
}
