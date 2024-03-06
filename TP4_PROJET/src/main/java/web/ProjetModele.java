package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Projet;

public class ProjetModele {
	private String motCle;
	List<Projet> projets = new ArrayList<>();
	public String getMotCle() {
	return motCle;
	}
	public void setMotCle(String motCle) {
	this.motCle = motCle;
	}
	public List<Projet> getProjets() {
	return projets;
	}
	public void setProjets(List<Projet> projets) {
	this.projets = projets;
	}

}
