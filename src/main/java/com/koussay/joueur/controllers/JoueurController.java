package com.koussay.joueur.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import com.koussay.joueur.entities.Joueur;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koussay.joueur.service.JoueurService;

@Controller
public class JoueurController {
	@Autowired
	JoueurService jService;

	@RequestMapping("/listeJoueurs")
	public String listeJoueurs(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
		{
			Page<Joueur> prods = jService.getAllJoueursParPage(page, size);
			modelMap.addAttribute("joueurs", prods);
			 modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
			modelMap.addAttribute("currentPage", page);
			return "listeJoueurs";
		}
	

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createJoueur";
	}

	@RequestMapping("/saveJoueur")
	public String saveJoueur(@ModelAttribute("Joueur") Joueur joueur, @RequestParam("date") String date,ModelMap modelMap) throws ParseException {
//conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		joueur.setDateCreation(dateCreation);

		Joueur saveJoueur = jService.saveJoueur(joueur);
		String msg = "joueur enregistré avec Id " + saveJoueur.getIdJoueur();
		modelMap.addAttribute("msg", msg);
		return "createJoueur";
	}

	@RequestMapping("/supprimerJoueur")
	public String supprimerJoueur(@RequestParam("id") Long id,ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,@RequestParam (name="size", defaultValue = "2") int size)
		{
			jService.deleteJoueurById(id);
			Page<Joueur> prods = jService.getAllJoueursParPage(page,size);
					modelMap.addAttribute("joueurs", prods);
					modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
					modelMap.addAttribute("currentPage", page);
					modelMap.addAttribute("size", size);
					return "listeJoueurs";
		}
	@RequestMapping("/modifierJoueur")
	public String editerProduit(@RequestParam("id") Long id, ModelMap modelMap) {
		Joueur p = jService.getJoueur(id);
		modelMap.addAttribute("joueur", p);
		return "editerJoueur";
	}

	@RequestMapping("/updateJoueur")
	public String updateProduit(@ModelAttribute("produit") Joueur joueur, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
//conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		joueur.setDateCreation(dateCreation);

		jService.updateJoueur(joueur);
		List<Joueur> prods = jService.getAllJoueurs();
		modelMap.addAttribute("Joueurs", prods);
		return "listeJoueurs";
	}
}
