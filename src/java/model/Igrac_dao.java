package model;

import entity.Igrac;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;


public class Igrac_dao {
    private Igrac igrac = new Igrac();
    
    public List<Igrac> getSveIgrace() {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            List<Igrac> sviIgraci = session.createCriteria(Igrac.class).list();
            session.getTransaction().commit();
            return sviIgraci;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public boolean dodajIgraca(Igrac igrac) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            List<Igrac> sviIgraci = session.createCriteria(Igrac.class).list();
            for(int i = 0; i < sviIgraci.size(); i++) {
                if(igrac.getBrojDresa().equals(sviIgraci.get(i).getBrojDresa())) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Postoji igrač sa tim brojem dresa!", "Izaberite drugi broj."));
                    return false;                    
                }                  
            }
            session.save(igrac);
            session.getTransaction().commit();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspješno.", "Igrač dodan."));
            return true;              
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }            
    }
    
    public void obrisiIgraca(Igrac igrac) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            session.delete(igrac);
            session.getTransaction().commit();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspješno.", "Igrač obrisan."));
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } 
    }
    
    public boolean urediIgraca(Igrac igrac) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM Igrac WHERE igracId NOT LIKE:integer");
            query.setParameter("integer", igrac.getIgracId());
            List <Igrac> sviIgraci = query.list();
            for(int i = 0; i < sviIgraci.size(); i++) {
                if(igrac.getBrojDresa().equals(sviIgraci.get(i).getBrojDresa())) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Postoji igrač sa tim brojem dresa!", "Izaberite drugi broj."));
                    return false;
                }
            }
            session.update(igrac);
            session.getTransaction().commit();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspješno.", "Igrač ažuriran."));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        } 
    }
    
}
