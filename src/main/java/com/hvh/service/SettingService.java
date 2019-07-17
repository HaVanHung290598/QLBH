package com.hvh.service;

import com.hvh.model.SettingDTO;

public interface SettingService {
	public void addSetting(SettingDTO settingDTO);
	public void updateSetting(SettingDTO settingDTO);
	public void deleteSetting(int id);
	public SettingDTO getSettingById(int id);
}
