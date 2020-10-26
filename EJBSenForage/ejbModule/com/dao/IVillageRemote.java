package com.dao;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Village;

@Remote
public interface IVillageRemote {
	
	public int add(Village village);
    public List<Village> listVillage();
    public Village getVillageById(String idVillage);

}
