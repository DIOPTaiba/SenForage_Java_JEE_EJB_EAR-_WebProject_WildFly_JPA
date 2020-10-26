package com.dao;

import java.util.List;

import javax.ejb.Local;

import com.entities.Client;

@Local
public interface IClientLocal {
	
	public int add(Client client);
    public List<Client> listClient();	

}
