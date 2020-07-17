package entity;
// Generated Nov 28, 2017 10:54:11 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Komentar generated by hbm2java
 */
@Entity
@Table(name="komentar"
    ,catalog="liverpoolfc"
)
public class Komentar  implements java.io.Serializable {


     private Integer komentarId;
     private Korisnik korisnik;
     private Vijest vijest;
     private String tekst;
     private Date vrijemeDatumkomentara;

    public Komentar() {
    }

	
    public Komentar(Korisnik korisnik, Vijest vijest, Date vrijemeDatumkomentara) {
        this.korisnik = korisnik;
        this.vijest = vijest;
        this.vrijemeDatumkomentara = vrijemeDatumkomentara;
    }
    public Komentar(Korisnik korisnik, Vijest vijest, String tekst, Date vrijemeDatumkomentara) {
       this.korisnik = korisnik;
       this.vijest = vijest;
       this.tekst = tekst;
       this.vrijemeDatumkomentara = vrijemeDatumkomentara;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="komentarId", unique=true, nullable=false)
    public Integer getKomentarId() {
        return this.komentarId;
    }
    
    public void setKomentarId(Integer komentarId) {
        this.komentarId = komentarId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="korisnik_korisnikId", nullable=false)
    public Korisnik getKorisnik() {
        return this.korisnik;
    }
    
    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="vijest_vijestId", nullable=false)
    public Vijest getVijest() {
        return this.vijest;
    }
    
    public void setVijest(Vijest vijest) {
        this.vijest = vijest;
    }

    
    @Column(name="tekst", length=16777215)
    public String getTekst() {
        return this.tekst;
    }
    
    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="vrijemeDatumkomentara", nullable=false, length=19)
    public Date getVrijemeDatumkomentara() {
        return this.vrijemeDatumkomentara;
    }
    
    public void setVrijemeDatumkomentara(Date vrijemeDatumkomentara) {
        this.vrijemeDatumkomentara = vrijemeDatumkomentara;
    }




}


