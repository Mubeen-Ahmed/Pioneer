package com.pioneer.dao;

import java.util.List;

import com.pioneer.model.Pioneer;


public interface PioneerDAO {
		public abstract boolean savePioneer(Pioneer pioneer);
		public Pioneer getPioneerDetailsByEmailAndPassword(String email,String password);
		
		/*public void add( EtchingIT etchingit);

		public void edit(EtchingIT etchingit);
		public void delete( int etchingitid);
		public EtchingIT getetchingit(int etchingitid);
		public List getAll();	*/
		public void addPioneer(Pioneer pioneer);
		 
	    public List<Pioneer> getAll();
	 
	    public void deletePioneer(int pioneerid);
	 
	    public Pioneer updatePioneer(Pioneer pioneer);
	 
	    public Pioneer getPioneer(int pioneerid);
		
		
		

	
	}


