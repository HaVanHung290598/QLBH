package com.hvh.service;

import java.util.List;
import java.util.Map;

import com.hvh.model.SettingDTO;

public interface SettingService {
	public void addSetting(SettingDTO settingDTO);
	public void updateSetting(SettingDTO settingDTO);
	public void deleteSetting(int id);
	public SettingDTO getSettingById(int id);
	public SettingDTO getSettingByName(String setting_name);
	public List<SettingDTO> getListSetting(int page, int limit);
	public List<SettingDTO> searchSetting(Map<String,String> params, int page, int limit);
}
