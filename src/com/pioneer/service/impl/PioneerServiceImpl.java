package com.pioneer.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pioneer.dao.PioneerDAO;
import com.pioneer.model.Pioneer;
import com.pioneer.service.PioneerService;



@Service("PioneerService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
public class PioneerServiceImpl implements PioneerService {
	
	@Autowired
	private PioneerDAO PioneerDAO;
	

	public PioneerDAO getPioneerDAO() {
		return PioneerDAO;
	}

	public void setPioneerDAO(PioneerDAO pioneerDAO) {
		this.PioneerDAO = pioneerDAO;
	}

	@Override
	public Pioneer validatePioneerCredential(String email, String password) {
		Pioneer pioneer = getPioneerDAO().getPioneerDetailsByEmailAndPassword(email, password);
		return pioneer;
	}

	
	
	@Override
	public boolean registerPioneer(Pioneer pioneer) {
		boolean isRegister=false;
		boolean saveStudent = getPioneerDAO().savePioneer(pioneer);
		if(saveStudent)
			isRegister=true;
		return isRegister;
	}
/*
	@Override

	public void add(EtchingIT etchingit) {
		EtchingITDAO.add(etchingit);
	}
	
	@Override

	public void edit(EtchingIT etchingit) {
		
		EtchingITDAO.edit(etchingit);
	}

	@Override

	public void delete(int experienceid) {
		EtchingITDAO.delete(experienceid);
		
	}
	
	@Override

	public EtchingIT getetchingit(int etchingitid) {
		
		return EtchingITDAO.getetchingit(etchingitid);
	}

	@Override

	public List getAll() {
		
		return EtchingITDAO.getAll();
	}

*/

	@Override
	public void addPioneer(Pioneer pioneer) {
		// TODO Auto-generated method stub
		PioneerDAO.addPioneer(pioneer);
	}

	@Override
	public List<Pioneer> getAll() {
		// TODO Auto-generated method stub
		return PioneerDAO.getAll();
	}

	@Override
	public void deletePioneer(int pioneerid) {
		// TODO Auto-generated method stub
		PioneerDAO.deletePioneer(pioneerid);
	}

	@Override
	public Pioneer updatePioneer(Pioneer pioneer) {
		// TODO Auto-generated method stub
		return PioneerDAO.updatePioneer(pioneer);
	}

	@Override
	public Pioneer getPioneer(int pioneerid) {
		// TODO Auto-generated method stub
		return PioneerDAO.getPioneer(pioneerid);
	}	

}
