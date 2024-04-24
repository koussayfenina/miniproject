package com.koussay.joueur.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Joueur {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idJoueur;
private String nomJoueur;
private Double prixJoueur;
private Date dateCreation;

public Joueur() {
super();
}

public Joueur(String nomJoueur, Double prixJoueur, Date dateCreation) {
	super();
	this.nomJoueur = nomJoueur;
	this.prixJoueur = prixJoueur;
	this.dateCreation = dateCreation;
}

public Long getIdJoueur() {
	return idJoueur;
}

public void setIdJoueur(Long idJoueur) {
	this.idJoueur = idJoueur;
}

public String getNomJoueur() {
	return nomJoueur;
}

public void setNomJoueur(String nomJoueur) {
	this.nomJoueur = nomJoueur;
}

public Double getPrixJoueur() {
	return prixJoueur;
}

public void setPrixJoueur(Double prixJoueur) {
	this.prixJoueur = prixJoueur;
}

public Date getDateCreation() {
	return dateCreation;
}

public void setDateCreation(Date dateCreation) {
	this.dateCreation = dateCreation;
}

@Override
public String toString() {
	return "Joueur [idJoueur=" + idJoueur + ", nomJoueur=" + nomJoueur + ", prixJoueur=" + prixJoueur
			+ ", dateCreation=" + dateCreation + "]";
}
}
