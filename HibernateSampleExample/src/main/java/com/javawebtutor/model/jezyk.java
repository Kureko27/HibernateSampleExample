/*CREATE TABLE jezyk(
	id_jezyk INTEGER NOT NULL PRIMARY KEY,
	nazwa VARCHAR(20) NOT NULL
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
@Table(name = "jezyk",
  uniqueConstraints = {@UniqueConstraint(columnNames = {"id_jezyk"})})
  public class jezyk{
    private Integer id_jezyk;
    private String nazwa;
    private Set<jezyk> jezyk= new HashSet<jezyk>(0);

    public jezyk(){}

      public jezyk(Integer id_jezyk, String nazwa, String opis){
  			this.id_jezyk = id_jezyk;
  			this.nazwa = nazwa;
  		}

    @Id
    @Column(name = "id_jezyk")
    public Integer getid_jezyk(){
      return id_jezyk;
    }
    public void setid_jezyk(Integer id_jezyk){
      this.id_jezyk = id_jezyk;
    }

    @Column(name = "nazwa", nullable = false)
    public String getnazwa(){
      return nazwa;
    }
    public void setnazwa(String nazwa){
      this.nazwa = nazwa;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id_jezyk")
    public Set<jezyk> getid_jezyk1(){
      return jezyk;
    }

    public void setjezyk(Set<jezyk> jezyk){
      this.jezyk = jezyk;
    }
    
  }
