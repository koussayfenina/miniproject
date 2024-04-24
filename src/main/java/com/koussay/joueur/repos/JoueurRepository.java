package com.koussay.joueur.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koussay.joueur.entities.Joueur;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {

}
