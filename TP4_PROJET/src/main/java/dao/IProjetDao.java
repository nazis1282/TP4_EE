package dao;

import java.util.List;
import metier.entities.Projet;

public interface IProjetDao {
	public Projet save(Projet p);

	public List<Projet> projetsParMC(String mc);

	public Projet getProjet(Long id);

	public Projet updateProjet(Projet p);

	public void deleteProjet(Long id);
}