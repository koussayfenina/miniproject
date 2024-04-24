package com.koussay.joueur;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.koussay.joueur.entities.Joueur;
import com.koussay.joueur.service.JoueurService;

@SpringBootApplication
public class JoueurApplication implements CommandLineRunner {
	@Autowired
	JoueurService jService;

	public static void main(String[] args) {
		SpringApplication.run(JoueurApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		jService.saveJoueur(new Joueur("messi", 2600.0, new Date()));
		jService.saveJoueur(new Joueur("maradona", 2800.0, new Date()));
		jService.saveJoueur(new Joueur("pepe", 900.0, new Date()));
		
	}

}
