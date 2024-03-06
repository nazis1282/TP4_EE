package metier.entities;

import java.io.Serializable;

public class Projet implements Serializable {
    private Long idProjet;
    private String nomProjet;
    private double cout;

    // Default constructor
    public Projet() {
        super();
    }

    // Constructor with parameters
    public Projet(String nomProjet, double cout) {
        super();
        this.nomProjet = nomProjet;
        this.cout = cout;
    }

    // Getter and setter methods
    public Long getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(Long idProjet) {
        this.idProjet = idProjet;
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }

    // toString method for displaying project details
    @Override
    public String toString() {
        return "Projet [idProjet=" + idProjet + ", nomProjet=" + nomProjet + ", cout=" + cout + "]";
    }
}
