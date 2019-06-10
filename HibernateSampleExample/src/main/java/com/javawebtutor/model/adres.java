/*CREATE TABLE adres(
	id_adres INTEGER NOT NULL PRIMARY KEY,
	ulica VARCHAR(50) NOT NULL,
	numer VARCHAR(10) NOT NULL,
	kod CHAR(11) NOT NULL,
	miejscowosc VARCHAR(30) NOT NULL
); */

package com.javawebtutor.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Adres",
  uniqueConstraints = {@UniqueConstraint(columnNames = {"id_adres"}) })
  public class adres {
    private Integer id_adres;
    private String ulica;
    private Integer numer;
    private String kod;
    private String miejscowosc;
    private Set<adres> adres= new HashSet<adres>(0);

    public adres(){}

  public adres(Integer id_adres, String ulica, Integer numer, String kod, String miejscowosc){
    this.id_adres = id_adres;
    this.ulica = ulica;
    this.numer = numer;
    this.kod = kod;
    this.miejscowosc = miejscowosc;
  }

  @Id
  @Column(name = "id_adres")
  public Integer getid_adres(){
    return id_adres;
  }

  public void setid_adres(Integer id_adres){
    this.id_adres = id_adres;
  }

  @Column(name = "ulica", length = 20, nullable = false)
  public String getulica(){
    return ulica;
  }

  public void setulica(String ulica){
    this.ulica = ulica;
  }

  @Column(name = "numer", nullable = false)
  public Integer getnumer(){
    return numer;
  }

  public void setnumer(Integer numer){
    this.numer = numer;
  }

  @Column(name = "kod", length = 11, nullable = false)
  public String getkod(){
    return kod;
  }

  public void setkod(String kod){
    this.kod = kod;
  }

  @Column(name = "miejscowosc", nullable = false)
  public String getmiejscowosc(){
    return miejscowosc;
  }
  
  public void setmiejscowosc(String miejscowosc){
    this.miejscowosc = miejscowosc;
  }

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "id_adres")
  public Set<adres> getid_adress(){
    return adres;
  }

  public void setadres(Set<adres> adres){
    this.adres = adres;
  }
}
