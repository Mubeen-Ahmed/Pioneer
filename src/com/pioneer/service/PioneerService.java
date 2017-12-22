package com.pioneer.service;

import java.util.List;


import com.pioneer.model.Pioneer;


public interface PioneerService {

	
	public abstract Pioneer validatePioneerCredential(String email,	String password);
	public abstract boolean registerPioneer(Pioneer pioneer);
	
	
	
	//public abstract boolean registerEtchingIT(EtchingIT etchingit);
/*
	public void add( EtchingIT etchingit);
	public void edit(EtchingIT etchingit);
	public void delete( int etchingitid);
	public EtchingIT getetchingit(int etchingitid);
	public List getAll();*/
	
	public void addPioneer(Pioneer pioneer);
	 
    public List<Pioneer> getAll();
 
    public void deletePioneer(int pioneerid);
 
    public Pioneer updatePioneer(Pioneer pioneer);
 
    public Pioneer getPioneer(int pioneerid);
}