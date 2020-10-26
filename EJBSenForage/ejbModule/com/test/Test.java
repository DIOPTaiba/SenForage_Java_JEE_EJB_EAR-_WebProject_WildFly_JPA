package com.test;

import com.dao.IUtilisateurLocal;
import com.dao.UtilisateurImpl;
import com.entities.Utilisateur;

public class Test {

	public static void main(String[] args){


        IUtilisateurLocal utilisateurdao = new UtilisateurImpl();

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setIdUser("773511003");
        utilisateur.setNom("DIOP");
        utilisateur.setPrenom("Mor");
        utilisateur.setEmail("mor@gmail.com");
        utilisateur.setPassword("passer");
        utilisateur.setUrlPhoto("public/img/mortaiba.png");

        int ok = utilisateurdao.add(utilisateur);
        System.out.println(ok);
        
	}
}
