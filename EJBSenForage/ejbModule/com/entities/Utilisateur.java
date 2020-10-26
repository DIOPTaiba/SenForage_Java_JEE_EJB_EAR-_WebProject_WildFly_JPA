package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Utilisateur implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
    private String idUser;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String urlPhoto;
    @OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY)
    private List<Client> clients;
    @OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY)
    private List<Village> villages;

    public Utilisateur() {
    }

    public Utilisateur(String idUser, String nom, String prenom, String email, String password, String urlPhoto) {
        this.idUser = idUser;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.urlPhoto = urlPhoto;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public List<Client> getClients() { return clients; }
  
    public void setClients(List<Client> clients) { this.clients = clients; }
  
    public List<Village> getVillages() { return villages; }
  
    public void setVillages(List<Village> villages) { this.villages = villages; }
	 

}
