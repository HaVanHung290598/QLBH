package com.hvh.dao;

import java.util.List;
import java.util.Map;

import com.hvh.entity.Setting;

public interface SettingDAO {
	public void addSetting(Setting setting);
	public void updateSetting(Setting setting);
	public void deleteSetting(int id);
	public Setting getSettingById(int id);
	public Setting getSettingByName(String setting_name);
	public List<Setting> getListSetting(int page, int limit);
	public List<Setting> searchSetting(Map<String,String> params, int page, int limit);
}
