package model;

import entity.Korisnik;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;


public class Korisnik_dao {
    
    private Korisnik korisnik = new Korisnik();

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
    
    public static List<Korisnik> getSveKorisnike() {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            List<Korisnik> sviKorisnici = session.createCriteria(Korisnik.class).list();
            session.getTransaction().commit();
            return sviKorisnici;         
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    
    }
    
    public static Korisnik getKorisnikByKorisnickoImeIlozinka(String korisnickoIme, String lozinka) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM Korisnik WHERE korisnickoIme LIKE:korisnickoIme AND lozinka LIKE:lozinka");
            query.setParameter("lozinka", lozinka);
            query.setParameter("korisnickoIme", korisnickoIme);
            List<Korisnik> korisnik = query.list();
            Korisnik novi = korisnik.get(0);
            session.getTransaction().commit();
            return novi;          
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
            
        }
    } 
    
    public boolean dodajKorisnika(Korisnik k) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            List<Korisnik> sviKorisnici = session.createCriteria(Korisnik.class).list();
            for(int i = 0; i < sviKorisnici.size(); i++) {
                if(k.getKorisnickoIme().equals(sviKorisnici.get(i).getKorisnickoIme())) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Postoji korisnik sa tim korisničkim imenom!", "Izaberite drugo korisničko ime."));
                    return false;
                } 
            }           
            session.save(k);
            session.getTransaction().commit();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspješno.", "Korisnik dodan."));
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
    
    public boolean urediKorisnika(Korisnik korisnik) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            
            Query query = session.createQuery("FROM Korisnik WHERE korisnikId NOT LIKE:korisnikId");
            query.setParameter("korisnikId", korisnik.getKorisnikId());
            List <Korisnik> korisnici = query.list();
            for(int i = 0; i < korisnici.size(); i++) {
                if(korisnici.get(i).getKorisnickoIme().equals(korisnik.getKorisnickoIme())) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Postoji korisnik sa tim korisničkim imenom!", "Izaberite drugo korisničko ime."));
                    return false;                  
                }
            }
            session.update(korisnik);
            session.getTransaction().commit();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspješno.", "Korisnik ažuriran."));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
    
    public void obrisiKorisnika(Korisnik k) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();                  
            session.delete(k);
            session.getTransaction().commit();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspješno.", "Korisnik obrisan."));
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
   
    public Korisnik getKorisnikById(Integer id) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM Korisnik WHERE id LIKE:id");
            query.setParameter("id", id);
            List<Korisnik> korisnici = query.list();
            Korisnik korisnik = korisnici.get(0);
            session.getTransaction().commit();
            return korisnik;
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
}
