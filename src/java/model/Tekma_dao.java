package model;

import entity.Tekma;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;


public class Tekma_dao {
    private Tekma tekma = new Tekma();
   
    public List<Tekma> getSveTekme() {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            List<Tekma> sveTekme = session.createCriteria(Tekma.class).list();
            session.getTransaction().commit();
            return sveTekme;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    public boolean dodajTekmu(Tekma tekma) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            List<Tekma> sveTekme = session.createCriteria(Tekma.class).list();
            for(int i = 0; i < sveTekme.size(); i++) {
                if(tekma.getVrijeme().equals(sveTekme.get(i).getVrijeme())) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Termin igranja tekme je zauzet!", "Izaberite drugi termin."));
                    return false;
                }
            }
            session.save(tekma);
            session.getTransaction().commit();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspješno.", "Tekma dodana."));
            return true;         
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }            
    }
    
    public boolean azurirajTekmu(Tekma tekma) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM Tekma WHERE tekmaRasporedId NOT LIKE:integer");          
            query.setParameter("integer", tekma.getTekmaRasporedId());          
            List<Tekma> tekme = query.list();          
            for(int i = 0; i < tekme.size(); i++) {
                if(tekma.getVrijeme().equals(tekme.get(i).getVrijeme())) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Termin igranja tekme je zauzet!", "Izaberite drugi termin."));
                    return false;
                }
            }
            session.update(tekma);
            session.getTransaction().commit();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspješno.", "Tekma ažurirana."));  
            return true;         
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }            
    }

    public void obrisiTekmu(Tekma tekma) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            session.delete(tekma);
            session.getTransaction().commit();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspješno.","Tekma obrisana."));
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public void dodajRezultat(Tekma tekma) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        try {
            session.beginTransaction();
            session.update(tekma);
            session.getTransaction().commit();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Uspješno.","Rezultat dodan."));
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
