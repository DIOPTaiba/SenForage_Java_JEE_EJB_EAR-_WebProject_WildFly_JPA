

import java.util.List;

import javax.ejb.Local;

import com.entities.Village;

@Local
public interface IVillageLocal {
	
	public int add(Village village);
    public List<Village> listVillage();
    public Village getVillageById(String idVillage);

}
