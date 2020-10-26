package com.dao;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Utilisateur;

@Remote
public interface IUtilisateurRemote {
	
	public int add(Utilisateur utilisateur);
    public List<Utilisateur> listUtilisateur();
    public Utilisateur getUserById(String idUser);
    public Utilisateur getUserByLogin(String email, String password);

}
