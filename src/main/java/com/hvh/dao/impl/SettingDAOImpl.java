package com.hvh.dao.impl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

	@Override
	public List<Setting> searchSetting(Map<String, String> params, int page, int limit) {
		String hql = "from Setting where";
		if(params.get("setting_name") != "") {
			hql += " setting_name like '%"+params.get("setting_name")+"' and";
 		}
		if(params.get("created_at_from") != "") {
			hql += " created_at>'"+params.get("created_at_from")+"' and";
		}
		if(params.get("created_at_to") != "") {
			hql += " created_at<'"+params.get("created_at_to")+"' and";
		}
		if(params.get("updated_at_from") != "") {
			hql += " updated_at>'"+params.get("updated_at_from")+"' and";
		}
		if(params.get("updated_at_to") != "") {
			hql += " updated_at<'"+params.get("updated_at_to")+"' and";
		}
		hql += " 1=1 order by id DESC";
		Session session = sessionFactory.getCurrentSession();
		Query<Setting> query = session.createQuery(hql, Setting.class);
		query.setFirstResult((page-1)*limit);
		query.setMaxResults(limit);
		return query.list();
	}

	@Override
	public Setting getSettingByName(String setting_name) {
		String hql = "from Setting where setting_name=:settingName";
		Session session = sessionFactory.getCurrentSession();
		Query<Setting> query = session.createQuery(hql, Setting.class);
		query.setParameter("settingName", setting_name);
		query.setFirstResult(0);
		query.setMaxResults(1);
		return query.getSingleResult();
	}

	@Override
	public List<Setting> getListSetting(int page, int limit) {
		String hql = "from Setting order by id DESC";
		Session session = sessionFactory.getCurrentSession();
		Query<Setting> query = session.createQuery(hql, Setting.class);
		query.setFirstResult((page-1)*limit);
		query.setMaxResults(limit);
		return query.list();
	}

}
