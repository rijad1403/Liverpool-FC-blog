package model;

import entity.Vijest;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;


public class Vijest_dao {
    
    public static List<Vijest> getSveVijest() {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            List<Vijest> sveVijesti = session.createCriteria(Vijest.class).list();
            session.getTransaction().commit();
            return sveVijesti;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }   
    }
    
    public static boolean dodajVijest(Vijest v) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            List<Vijest> sveVijesti = session.createCriteria(Vijest.class).list();
            for(int i = 0; i < sveVijesti.size(); i++) {
                if(v.getNaslov().equals(sveVijesti.get(i).getNaslov())) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Postoji vijest sa istim naslovom!", "Izaberite drugi naslov vijesti."));
                    return false;
                }
            }
            session.save(v);
            session.getTransaction().commit();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspješno.", "Vijest dodana."));
            return true;            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }   
    }
    
    public void obrisiVijest(Vijest v) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            session.delete(v);
            session.getTransaction().commit();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspješno.", "Vijest obrisana."));
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public boolean urediVijest(Vijest v) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM Vijest WHERE vijestId NOT LIKE:integer");
            query.setParameter("integer", v.getVijestId());
            List <Vijest> vijesti = query.list();
            for(int i = 0; i < vijesti.size(); i++) {
                if(vijesti.get(i).getNaslov().equals(v.getNaslov())) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Postoji vijest sa istim naslovom!", "Izaberite drugi naslov vijesti."));
                    return false;
                }
            }
            session.update(v);
            session.getTransaction().commit();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Uspješno.","Vijest ažurirana."));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }    
    }
    
    public Vijest getVijestById(Integer Id) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM Vijest WHERE vijestId LIKE:Id");
            query.setParameter("Id", Id);
            List <Vijest> vijesti = query.list();
            Vijest vijest = vijesti.get(0);
            session.getTransaction().commit();;
            return vijest;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    } 
    
}
