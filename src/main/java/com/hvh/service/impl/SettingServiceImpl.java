package com.hvh.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvh.dao.SettingDAO;
import com.hvh.entity.Setting;
import com.hvh.model.SettingDTO;
import com.hvh.service.SettingService;

@Service
public class SettingServiceImpl implements SettingService {
	
	@Autowired
	SettingDAO settingDAO;

	@Override
	public void addSetting(SettingDTO settingDTO) {
		settingDAO.addSetting(convert(settingDTO));		
	}

	@Override
	public void updateSetting(SettingDTO settingDTO) {
		settingDAO.updateSetting(convert(settingDTO));
	}

	@Override
	public void deleteSetting(int id) {
		settingDAO.deleteSetting(id);
	}

	@Override
	public SettingDTO getSettingById(int id) {		
		Setting setting = settingDAO.getSettingById(id);		
		return convert(setting);
	}

	@Override
	public List<SettingDTO> searchSetting(Map<String, String> params, int page, int limit) {
		List<SettingDTO> settingDTOs = new ArrayList<SettingDTO>();
		List<Setting> settings = settingDAO.searchSetting(params, page, limit);
		for(Setting setting : settings) {
			settingDTOs.add(convert(setting));
		}
		return settingDTOs;
	}

	@Override
	public SettingDTO getSettingByName(String setting_name) {
		Setting setting = settingDAO.getSettingByName(setting_name);
		return convert(setting);
	}

	@Override
	public List<SettingDTO> getListSetting(int page, int limit) {
		List<SettingDTO> settingDTOs = new ArrayList<SettingDTO>();
		List<Setting> settings = settingDAO.getListSetting(page, limit);
		for(Setting setting : settings) {
			settingDTOs.add(convert(setting));
		}
		return settingDTOs;
	}
	private SettingDTO convert(Setting setting) {
		SettingDTO settingDTO = new SettingDTO();
		settingDTO.setId(setting.getId());
		settingDTO.setSetting_name(setting.getSetting_name());
		settingDTO.setValue(setting.getValue());
		settingDTO.setCreated_at(setting.getCreated_at());
		settingDTO.setUpdated_at(setting.getUpdated_at());
		return settingDTO;
	}
	private Setting convert(SettingDTO settingDTO) {
		Setting setting = new Setting();
		setting.setId(settingDTO.getId());
		setting.setSetting_name(settingDTO.getSetting_name());
		setting.setValue(settingDTO.getValue());
		setting.setCreated_at(settingDTO.getCreated_at());
		setting.setUpdated_at(settingDTO.getUpdated_at());
		return setting;
	}
}
