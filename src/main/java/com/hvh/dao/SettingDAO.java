package com.hvh.dao;

import com.hvh.entity.Setting;

public interface SettingDAO {
	public void addSetting(Setting setting);
	public void updateSetting(Setting setting);
	public void deleteSetting(int id);
	public Setting getSettingById(int id);
}
