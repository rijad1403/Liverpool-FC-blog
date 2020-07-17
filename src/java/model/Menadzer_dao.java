package model;

import entity.Menadzer;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;


public class Menadzer_dao {
    private Menadzer menadzer = new Menadzer();
    
    
    public List<Menadzer> getSveMenadzere() {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            List<Menadzer> sviMenadzeri = session.createCriteria(Menadzer.class).list();
            session.getTransaction().commit();
            return sviMenadzeri;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public boolean dodajMenadzera(Menadzer menadzer) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM Menadzer WHERE tipMenadzera LIKE:string");
            query.setParameter("string", "Glavni trener");
            List<Menadzer> menadzeri = query.list();
            if(menadzeri.size() > 0 && menadzer.getTipMenadzera().equals("Glavni trener")) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Glavni trener je već unešen!", "Izaberite drugi tip trenera."));
                return false;
                }
            session.save(menadzer);
            session.getTransaction().commit();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspješno.", "Trener dodan."));
            return true;           
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
    
    public boolean azurirajMenadzera(Menadzer menadzer) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM Menadzer WHERE menadzerId NOT LIKE:integer AND tipMenadzera LIKE:string");
            query.setParameter("integer", menadzer.getMenadzerId());
            query.setParameter("string", "Glavni trener");
            List<Menadzer> menadzeri = query.list();
            System.out.println("jebaca ima "+menadzeri.size());
            if(menadzer.getTipMenadzera().equals("Glavni trener") && menadzeri.size() > 0) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Glavni trener je već unešen!", "Izaberite drugi tip trenera."));
                return false;
            }
            session.update(menadzer);
            session.getTransaction().commit();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspješno.", "Trener ažuriran."));
            return true;                          
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
   
    
    public void obrisiMenadzera(Menadzer menadzer) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            session.delete(menadzer);
            session.getTransaction().commit();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspješno.", "Trener obrisan."));
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
