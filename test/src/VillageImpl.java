

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.entities.Village;

@Stateless
public class VillageImpl implements IVillageLocal, IVillageRemote {
	
	//@PersistenceContext escanne le fichier persistence.xml pour établir la connexion avec la base de données
	@PersistenceContext(unitName = "SenForage_UP")
	//on déclare ensuite une variable EntityManager et le reste sera géré par le serveur d'application
	private EntityManager em;

	@Override
	public int add(Village village) {
		try {
			//les transaction sont gérées par l'EJB de manières implicite
            //em.getTransaction().begin();
            em.persist(village);
            //em.getTransaction().commit();
            return 1;

        }catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
	}

	@Override
	public List<Village> listVillage() {
		Query query = em.createQuery("SELECT v FROM Village v");
		return query.getResultList();
	}

	@Override
	public Village getVillageById(String idVillage) {
		Village village = (Village) em.createQuery("SELECT v FROM Village v WHERE v.idVillage=:n")
                .setParameter("n",idVillage).getSingleResult();

        return village;
	}

}
