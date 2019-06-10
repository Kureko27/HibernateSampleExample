/*
 * CREATE TABLE egzemplarz(
	id_egzemplarz INTEGER NOT NULL PRIMARY KEY,
	id_tytul INTEGER UNIQUE NOT NULL REFERENCES tytul(id_tytul),
	id_nosnik INTEGER UNIQUE NOT NULL REFERENCES nosnik(id_nosnik),
	id_jezyk INTEGER UNIQUE NOT NULL REFERENCES jezyk(id_jezyk),
	ilosc INTEGER
);
 */

package com.javawebtutor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "egzemplarz",
  uniqueConstraints = {@UniqueConstraint(columnNames = {"id_egzemplarz"})})
  public class Egzemplarz{
    private Integer id_egzemplarz;
    private Integer ilosc;
    private Tytul id_tytul;
    private Nosnik id_nosnik;
    private Jezyk id_jezyk;
    
    public Egzemplarz(){}

      public Egzemplarz(Integer id_egzemplarz, Integer ilosc, Tytul id_tytul, Nosnik id_nosnik, Jezyk id_jezyk){
  			this.id_egzemplarz = id_egzemplarz;
  			this.ilosc = ilosc;
  			this.id_tytul = id_tytul;
  			this.id_nosnik = id_nosnik;
  			this.id_jezyk = id_jezyk;
  		}
      
      @Id
      @Column(name = "id_egzemparz")
      public Integer getid_egzemplarz(){
        return id_egzemplarz;
      }
      public void setid_egzemplarz(Integer id_egzemplarz){
        this.id_egzemplarz = id_egzemplarz;
      }

      @Column(name = "ilosc", nullable = false)
      public Integer getilosc(){
        return ilosc;
      }
      public void setilosc(Integer ilosc){
        this.ilosc = ilosc;
      }
      
      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "id_tytul", nullable = false)
      public Tytul getid_tytul(){
        return id_tytul;
      }
      public void settytul(Tytul id_tytul){
        this.id_tytul = id_tytul;
      }
      
      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "id_nosnik", nullable = false)
      public Nosnik getnosnik(){
        return id_nosnik;
      }
      public void setnosnik(Nosnik id_nosnik){
        this.id_nosnik = id_nosnik;
      }
      
      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "id_jezyk", nullable = false)
      public Jezyk getjezyk(){
        return id_jezyk;
      }
      public void setjezyk(Jezyk id_jezyk){
        this.id_jezyk= id_jezyk;
      }
      
}


