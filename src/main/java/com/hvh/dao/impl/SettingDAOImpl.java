package com.hvh.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hvh.dao.SettingDAO;
import com.hvh.entity.Setting;

@Repository
@Transactional
public class SettingDAOImpl implements SettingDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addSetting(Setting setting) {
		sessionFactory.getCurrentSession().save(setting);
	}

	@Override
	public void updateSetting(Setting setting) {
		sessionFactory.getCurrentSession().merge(setting);
	}

	@Override
	public void deleteSetting(int id) {
		sessionFactory.getCurrentSession().delete(getSettingById(id));
	}

	@Override
	public Setting getSettingById(int id) {
		return sessionFactory.getCurrentSession().get(Setting.class, id);		
	}

}
