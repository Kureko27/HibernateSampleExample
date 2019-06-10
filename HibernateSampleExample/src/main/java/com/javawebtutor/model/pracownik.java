/*CREATE TABLE pracownik(//
	id_pracownik INTEGER NOT NULL PRIMARY KEY,
	imie VARCHAR(20) NOT NULL,
	nazwisko VARCHAR(20) NOT NULL,
	pesel CHAR(12) NOT NULL,
	id_dzial INTEGER NOT NULL UNIQUE REFERENCES dzial(id_dzial),
	id_adres INTEGER NOT NULL UNIQUE REFERENCES adres(id_adres),
	id_oddzial INTEGER NOT NULL UNIQUE REFERENCES oddzial(id_oddzial)
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
@Table(name = "Pracownik",
  uniqueConstraints = {@UniqueConstraint(columnNames = {"id_pracownik"}) })
  public class pracownik {
    private Integer id_pracownik;
    private String imie;
    private String nazwisko;
    private Integer pesel;
    private dzial id_dzial;
    private adres id_adres;
    private oddzial id_oddzial;
    
    public pracownik(){}

  public pracownik(Integer id_pracownik, String imie, String nazwisko, Integer pesel, 
		  dzial id_dzial, adres id_adres, oddzial id_oddzial){
    this.id_pracownik = id_pracownik;
    this.imie = imie;
    this.nazwisko = nazwisko;
    this.pesel = pesel;
    this.id_dzial = id_dzial;
    this.id_adres = id_adres;
    this. id_oddzial = id_oddzial;
  }
  
  @Id
  @Column(name = "id_pracownik")
  public Integer getid_pracownik(){ 
    return id_pracownik;
  }
  public void setid_pracownik(Integer id_pracownik){
    this.id_pracownik= id_pracownik;
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
  public adres getAdres(){
    return id_adres;
  }
  public void setAdres(adres id_adres){
    this.id_adres = id_adres;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_oddzial", nullable = false)
  public oddzial getOdzial(){
    return id_oddzial;
  }
  public void setOddzial(oddzial id_oddzial){
    this.id_oddzial = id_oddzial;
  }
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_dzial", nullable = false)
  public dzial getdzial(){
    return id_dzial;
  }
  public void setdzial(dzial id_dzial){
    this.id_dzial= id_dzial;
  }
}
