package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Village implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    private String idVillage;
    private String nom;
    @OneToMany(mappedBy = "village", fetch = FetchType.LAZY)
    private List<Client> clients;
    @ManyToOne
    private Utilisateur utilisateur;

    public Village() {
    }

    public Village(String idVillage, String nom, Utilisateur utilisateur) {
        this.idVillage = idVillage;
        this.nom = nom;
        this.utilisateur = utilisateur;
    }

    public String getIdVillage() {
        return idVillage;
    }

    public void setIdVillage(String idVillage) {
        this.idVillage = idVillage;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

}
