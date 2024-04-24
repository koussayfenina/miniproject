package com.koussay.joueur.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.koussay.joueur.entities.Joueur;

public interface JoueurService {
	
	Joueur saveJoueur(Joueur p);
	Joueur updateJoueur(Joueur p);
	void deleteJoueur(Joueur p);
	void deleteJoueurById(Long id);
	Joueur getJoueur(Long id);
	List<Joueur> getAllJoueurs();
	Page<Joueur> getAllJoueursParPage(int page, int size);

}
