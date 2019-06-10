package com.javawebtutor.model;

/*CREATE TABLE nosnik(
	id_nosnik INTEGER NOT NULL PRIMARY KEY,
	nazwa VARCHAR(30) NOT NULL,
	opis VARCHAR(50) NOT NULL
); */

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
@Table(name = "nosnik",
	uniqueConstraints = {@UniqueConstraint(columnNames = {"id_nosnik"})})
public class Nosnik {
	private Integer id_nosnik;
	private String nazwa;
	private String opis;
	private Set<Nosnik> nosnik= new HashSet<Nosnik>(0);

	public Nosnik(){}

		public Nosnik(Integer id_nosnik, String nazwa, String opis){
			this.id_nosnik = id_nosnik;
			this.nazwa = nazwa;
			this.opis = opis;
		}

		@Id
		@Column(name = "id_nosnik")
		public Integer getid_nosnik(){
			return id_nosnik;
		}

		public void setid_nosnik(Integer id_nosnik){
			this.id_nosnik = id_nosnik;
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
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "id_nosnik")
		  public Set<Nosnik> getid_nosnik1(){
		    return nosnik;
		  }

		  public void setnosnik(Set<Nosnik> nosnik){
		    this.nosnik = nosnik;
		  }

}
