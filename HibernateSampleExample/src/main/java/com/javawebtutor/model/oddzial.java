/*CREATE TABLE oddzial(
	id_oddzial INTEGER NOT NULL PRIMARY KEY,
	kraj VARCHAR(20) NOT NULL,
	id_adres INTEGER NOT NULL UNIQUE REFERENCES adres(id_adres)
);*/

package com.javawebtutor.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Oddzial",
	  uniqueConstraints = {@UniqueConstraint(columnNames = {"id_oddzial"})})
	public class oddzial {
	  private Integer id_oddzial;
	  private String kraj;
	  private adres id_adres;
	  private Set<oddzial> oddzialy = new HashSet<oddzial>(0);
	
	public oddzial() {}
	
	public oddzial(Integer id_oddzial, String kraj, adres id_adres){
	  this.id_oddzial = id_oddzial;
	  this.kraj = kraj;
	  this.id_adres = id_adres;
	}

	@Id
	@Column(name = "id_oddzial")
	public Integer getid_oddzial(){
	  return id_oddzial;
	}
	public void setid_oddzial(Integer id_oddzial){
	  this.id_oddzial = id_oddzial;
	}
	
	@Column(name = "kraj", nullable = false)
	public String getkraj(){
	  return kraj;
	}
	public void setkraj(String kraj){
	  this.kraj = kraj;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_adres", nullable = false)
	public adres getAdres(){
	  return id_adres;
	}
	
	public void setAdres(adres id_adres){
	  this.id_adres = id_adres;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id_oddzial")
	public Set<oddzial> getoddzial(){
	  return oddzialy;
	}
	
	public void setoddzial(Set<oddzial> oddzialy){
	  this.oddzialy = oddzialy;
	}

}

