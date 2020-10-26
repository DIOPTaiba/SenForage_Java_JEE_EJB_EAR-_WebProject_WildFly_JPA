package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.entities.Client;

@Stateless
public class ClientImpl implements IClientLocal, IClientRemote {
	
	//@PersistenceContext escanne le fichier persistence.xml pour établir la connexion avec la base de données
	@PersistenceContext(unitName = "SenForage_UP")
	//on déclare ensuite une variable EntityManager et le reste sera géré par le serveur d'application
	private EntityManager em;

	@Override
	public int add(Client client) {
		try {
			//les transaction sont gérées par l'EJB de manières implicite
            //em.getTransaction().begin();
            em.persist(client);
            //em.getTransaction().commit();
            return 1;

        }catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
	}

	@Override
	public List<Client> listClient() {
		return em.createQuery("SELECT c FROM Client c ORDER BY c.id desc ").getResultList();
	}

}
