package com.dao;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Client;

@Remote
public interface IClientRemote {
	
	public int add(Client client);
    public List<Client> listClient();	

}
