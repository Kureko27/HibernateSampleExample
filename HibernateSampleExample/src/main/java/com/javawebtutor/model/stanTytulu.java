/*CREATE TABLE stanTytulu(
	id_stanTytulu INTEGER NOT NULL PRIMARY KEY,
	nazwa VARCHAR(20) NOT NULL,
	opis VARCHAR(50) NOT NULL
);*/

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
@Table(name = "stanTytulu",
  uniqueConstraints = {@UniqueConstraint(columnNames = {"id_stanTytulu"})})
public class stanTytulu {
  private Integer id_stanTytulu;
  private String nazwa;
  private String opis;
  private Set<stanTytulu> stanTytulu= new HashSet<stanTytulu>(0);

  public stanTytulu(){}

    public stanTytulu(Integer id_stanTytulu, String nazwa, String opis){
      this.id_stanTytulu = id_stanTytulu;
      this.nazwa = nazwa;
      this.opis = opis;
    }

  @Id
  @Column(name = "id_stanTytulu")
  public Integer getid_stanTytulu(){
    return id_stanTytulu;
  }
  public void setid_stanTytulu(Integer id_stanTytulu){
    this.id_stanTytulu = id_stanTytulu;
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
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "id_stanTytulu")
  public Set<stanTytulu> get_idstanTytulu1(){
    return stanTytulu;
  }

  public void setstanTytulu(Set<stanTytulu> stanTytulu){
    this.stanTytulu = stanTytulu;
  }
}
