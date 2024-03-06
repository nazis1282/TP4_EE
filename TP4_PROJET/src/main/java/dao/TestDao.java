package dao;

import java.util.List;

import metier.entities.Projet;

public class TestDao {
	public static void main(String[] args) {
		ProjetDaoImpl pdao = new ProjetDaoImpl();
		Projet prod = pdao.save(new Projet("faculté privé", 158350));
		System.out.println(prod);
		List<Projet> prods = pdao.projetsParMC("site web");
		for (Projet p : prods)
			System.out.println(p);
	}
}
