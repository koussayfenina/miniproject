package com.koussay.joueur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.koussay.joueur.entities.Joueur;
import com.koussay.joueur.repos.JoueurRepository;


@Service
public class JoueurServiceImpl implements JoueurService {
	
	
	@Autowired
	JoueurRepository jRepository;

	@Override
	public Joueur saveJoueur(Joueur p) {
		return jRepository.save(p);
	}

	@Override
	public Joueur updateJoueur(Joueur p) {
		return jRepository.save(p);
	}

	@Override
	public void deleteJoueur(Joueur p) {
		jRepository.delete(p);

		
	}

	@Override
	public void deleteJoueurById(Long id) {
		jRepository.deleteById(id);
	}

	@Override
	public Joueur getJoueur(Long id) {
		return jRepository.findById(id).get();

	}

	@Override
	public List<Joueur> getAllJoueurs() {
		return jRepository.findAll();
	}

	@Override
	public Page<Joueur> getAllJoueursParPage(int page, int size) {
		return jRepository.findAll(PageRequest.of(page, size));
	}

}
