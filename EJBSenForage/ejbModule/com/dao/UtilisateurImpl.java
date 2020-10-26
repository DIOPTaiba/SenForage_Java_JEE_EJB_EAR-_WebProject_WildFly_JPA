package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.entities.Utilisateur;

@Stateless
public class UtilisateurImpl implements IUtilisateurLocal {
	
	//@PersistenceContext escanne le fichier persistence.xml pour établir la connexion avec la base de données
	@PersistenceContext(unitName = "SenForage_UP")
	//on déclare ensuite une variable EntityManager et le reste sera géré par le serveur d'application
	private EntityManager em;
	
	@Override
	public int add(Utilisateur utilisateur) {
	
		try {
			//les transaction sont gérées par l'EJB de manières implicite
            //em.getTransaction().begin();
            em.persist(utilisateur);
            //em.getTransaction().commit();
            return 1;

        }catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
	}

	@Override
	public List<Utilisateur> listUtilisateur() {
		return em.createQuery("SELECT u FROM Utilisateur u").getResultList();
	}

	@Override
	public Utilisateur getUserById(String idUser) {
		
		Utilisateur utilisateur = (Utilisateur) em.createQuery("SELECT u FROM Utilisateur u WHERE u.idUser=:n")
                .setParameter("n",idUser).getSingleResult();
        return utilisateur;
	}

	@Override
	public Utilisateur getUserByLogin(String email, String password) {
		
		Query query =  em.createQuery("SELECT u FROM Utilisateur u WHERE u.email=:e AND u.password=:p");
        query.setParameter("e",email);
		query.setParameter("p",password);
		try {
		    return (Utilisateur) query.getSingleResult();
		} catch (Exception e){
		    return null;
		}
	}
	
	

}
