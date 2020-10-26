package com.dao;

import java.util.List;

import javax.ejb.Local;

import com.entities.Utilisateur;

@Local
public interface IUtilisateurLocal {
	
	public int add(Utilisateur utilisateur);
    public List<Utilisateur> listUtilisateur();
    public Utilisateur getUserById(String idUser);
    public Utilisateur getUserByLogin(String email, String password);

}
