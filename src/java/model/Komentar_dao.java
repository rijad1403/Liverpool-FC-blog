package model;

import entity.Komentar;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;


public class Komentar_dao {
    
    private Komentar komentar = new Komentar();
    
    public Komentar getKomentar() {
        return komentar;
    }
    
    public void setKomentar(Komentar komentar) {
        this.komentar = komentar;
    }
    
    public static List<Komentar> getSveKomentare(Integer vijestId) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM Komentar k WHERE k.vijest.vijestId LIKE :vijestId");
            query.setParameter("vijestId", vijestId);
            List<Komentar> sviKomentariOdabraneVijesti = query.list();
            session.getTransaction().commit();
            return sviKomentariOdabraneVijesti;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
        
    }
    
    public void obrisiSveKomentare(Integer vijestId) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM Komentar k WHERE k.vijest.vijestId LIKE :vijestId");
            query.setParameter("vijestId", vijestId);
            int result = query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public void obrisiSveKomentareJednogKorisnika(Integer korisnikId) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM Komentar k WHERE k.korisnik.korisnikId LIKE :korisnikId");
            query.setParameter("korisnikId", korisnikId);
            int result = query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public void dodajKomentar(Komentar k) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            session.save(k);
            session.getTransaction().commit();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspješno.", "Komentar dodan."));        
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public void obrisiKomentar(Komentar k) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            session.delete(k);
            session.getTransaction().commit();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspješno.", "Komentar obrisan."));
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public void urediKomentar(Komentar k) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            session.update(k);
            session.getTransaction().commit();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspješno.", "Komentar uređen."));
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public List<Komentar> getSviKomentariJednogKorisnika(Integer ID) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM Komentar k WHERE k.korisnik.korisnikId LIKE:ID");
            query.setParameter("ID", ID);
            List <Komentar> komentari = query.list();
            session.getTransaction().commit();
            return komentari;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    
    
    
    }
}
