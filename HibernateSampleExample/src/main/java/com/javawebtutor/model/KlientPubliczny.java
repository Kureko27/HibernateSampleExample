/*CREATE TABLE klientPubliczny(
	id_klientPubliczny INTEGER NOT NULL PRIMARY KEY,
	imie VARCHAR(20) NOT NULL,
	nazwisko VARCHAR(20) NOT NULL,
	pesel CHAR(12) NOT NULL,
	id_adres INTEGER NOT NULL UNIQUE REFERENCES adres(id_adres),
	id_oddzial INTEGER NOT NULL UNIQUE REFERENCES oddzial(id_oddzial),
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
	@NamedQuery(name = "klientPubliczny.all", query = "Select k from klientPubliczny k")
})

@Table(name = "klientPubliczny",
  uniqueConstraints = {@UniqueConstraint(columnNames = "id_klientPubliczny")})
public class KlientPubliczny{
  private Integer id_klientPubliczny;
  private String imie;
  private String nazwisko;
  private Integer pesel;
  private Adres id_adres;
  private Oddzial id_oddzial;
  private Set<KlientPubliczny> klientPubliczny= new HashSet<KlientPubliczny>(0);

  public KlientPubliczny(){}

  public KlientPubliczny(Integer id_klientPubliczny, String imie, String nazwisko,
  Integer pesel, Adres id_adres, Oddzial id_oddzial){
    this.id_klientPubliczny= id_klientPubliczny;
    this.imie = imie;
    this.nazwisko = nazwisko;
    this.pesel = pesel;
    this.id_adres = id_adres;
    this.id_oddzial = id_oddzial;
  }

  @Id
  @Column(name = "id_klientPubliczny")
  public Integer getid_klientPubliczny1(){ //Duplicate method again
    return id_klientPubliczny;
  }
  public void setid_klientPubliczny(Integer id_klientPubliczny){
    this.id_klientPubliczny= id_klientPubliczny;
  }

  @Column(name = "imie", nullable = false)
  public String getimie(){
    return imie;
  }
  public void setimie(String imie){
    this.imie = imie;
  }

  @Column(name = "nazwisko", nullable = false)
  public String getnazwisko(){
    return nazwisko;
  }
  public void setnazwisko(String nazwisko){
    this.nazwisko = nazwisko;
  }

  @Column(name = "pesel", length = 11, nullable = false)
  public Integer getpesel(){
    return pesel;
  }
  public void setpesel(Integer pesel){
    this.pesel = pesel;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_adres", nullable = false)
  public Adres getAdres(){
    return id_adres;
  }
  public void setAdres(Adres id_adres){
    this.id_adres = id_adres;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_oddzial", nullable = false)
  public Oddzial getOddzial(){
    return id_oddzial;
  }
  public void setOddzial(Oddzial id_oddzial){
    this.id_oddzial = id_oddzial;
  }

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "id_klientPubliczny")
  public Set<KlientPubliczny> getid_klientPubliczny(){
    return klientPubliczny;
  }
  public void setklientPubliczny(Set<KlientPubliczny> klientPubliczny){
    this.klientPubliczny= klientPubliczny;
  }


}
