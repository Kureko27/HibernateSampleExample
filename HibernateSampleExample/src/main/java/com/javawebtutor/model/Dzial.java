/*CREATE TABLE dzial(
	id_dzial INTEGER NOT NULL PRIMARY KEY,
	nazwa VARCHAR(30) NOT NULL,
	opis VARCHAR(50) NOT NULL
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
@Table(name = "dzial",
  uniqueConstraints = {@UniqueConstraint(columnNames = {"id_dzial"})})
public class Dzial {
  private Integer id_dzial;
  private String nazwa;
  private String opis;
  private Set<Dzial> dzial= new HashSet<Dzial>(0);

  public Dzial(){}

    public Dzial(Integer id_dzial, String nazwa, String opis){
      this.id_dzial = id_dzial;
      this.nazwa = nazwa;
      this.opis = opis;
    }

  @Id
  @Column(name ="id_dzial")
  public Integer getid_dzial(){
    return id_dzial;
  }
  public void setid_dzial(Integer id_dzial){
    this.id_dzial = id_dzial;
  }

  @Column(name = "nazwa", nullable = false)
  public String getnazwa(){
    return nazwa;
  }
  public void setnazwa(String nazwa){
    this.nazwa = nazwa;
  }

  @Column(name = "opis", nullable = false)
  public String getopis(){
    return opis;
  }
  public void setopis(String opis){
    this.opis = opis;
  }
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "id_dzial")
  public Set<Dzial> getid_dzial1(){
    return dzial;
  }

  public void setdzial(Set<Dzial> dzial){
    this.dzial = dzial;
  }

}
