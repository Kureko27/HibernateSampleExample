/*CREATE TABLE tytul(
	id_tytul INTEGER NOT NULL PRIMARY KEY,
	nazwa VARCHAR(50) NOT NULL,
	id_klientPubliczny INTEGER NOT NULL UNIQUE REFERENCES klientPubliczny(id_klientPubliczny),
	id_klientSamodzielny INTEGER NOT NULL UNIQUE REFERENCES klientSamodzielny(id_klientSamodzielny),
	id_stanTytulu INTEGER NOT NULL UNIQUE REFERENCES stanTytulu(id_stanTytulu)
); */

package com.javawebtutor.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@NamedQueries({
	@NamedQuery(name = "tytul.all", query = "Select t from tytul t")
})

@Table(name = "tytul",
  uniqueConstraints = {@UniqueConstraint(columnNames = {"id_tytul"})})
  public class Tytul{
    private Integer id_tytul;
    private String nazwa;
    private KlientPubliczny id_klientPubliczny;
    private KlientSamodzielny id_klientSamodzielny;
    private StanTytulu id_stanTytulu;
    private Set<Tytul> tytul= new HashSet<Tytul>(0);

    public Tytul(){}

      public Tytul(Integer id_tytul, String nazwa, String opis, 
    		  	KlientPubliczny id_klientPubliczny, KlientSamodzielny id_klientSamodzielny, StanTytulu id_stanTytulu){
  			this.id_tytul= id_tytul;
  			this.nazwa = nazwa;
  			this.id_klientPubliczny = id_klientPubliczny;
  			this.id_klientSamodzielny = id_klientSamodzielny;
  			this.id_stanTytulu = id_stanTytulu;
  		}

    @Id
    @Column(name = "id_tytul")
    public Integer getid_tytul(){
      return id_tytul;
    }
    public void setid_tytul(Integer id_tytul){
      this.id_tytul= id_tytul;
    }

    @Column(name = "nazwa", nullable = false)
    public String getnazwa(){
      return nazwa;
    }
    public void setnazwa(String nazwa){
      this.nazwa = nazwa;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_klientPubliczny", nullable = false)
    public KlientPubliczny getklientPubliczny(){
      return id_klientPubliczny;
    }
    public void setklientPubliczny(KlientPubliczny id_klientPubliczny){
      this.id_klientPubliczny = id_klientPubliczny;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_klientSamodzielny", nullable = false)
    public KlientSamodzielny getklientSamodzielny(){
      return id_klientSamodzielny;
    }
    public void setklientSamodzielny(KlientSamodzielny id_klientSamodzielny){
      this.id_klientSamodzielny = id_klientSamodzielny;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_stanTytulu", nullable = false)
    public StanTytulu getstanTytulu(){
      return id_stanTytulu;
    }
    
    public void stanTytulu(StanTytulu id_stanTytulu){
      this.id_stanTytulu = id_stanTytulu;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id_tytul")
    public Set<Tytul> getid_tytul1(){
      return tytul;
    }

    public void settytul(Set<Tytul> tytul){
      this.tytul = tytul;
    }
    
  }
