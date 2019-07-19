package com.hvh.service.impl;

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
		Setting setting = new Setting();
		setting.setDescription(settingDTO.getDescription());
		setting.setKeywords(settingDTO.getKeywords());
		setting.setTitle(settingDTO.getTitle());
		setting.setAuthor(settingDTO.getAuthor());
		setting.setDiscount_amount(settingDTO.getDiscount_amount());
		setting.setTax(settingDTO.getTax());
		settingDAO.addSetting(setting);
	}

	@Override
	public void updateSetting(SettingDTO settingDTO) {
		Setting setting = new Setting();
		setting.setId(settingDTO.getId());
		setting.setDescription(settingDTO.getDescription());
		setting.setKeywords(settingDTO.getKeywords());
		setting.setTitle(settingDTO.getTitle());
		setting.setAuthor(settingDTO.getAuthor());
		setting.setDiscount_amount(settingDTO.getDiscount_amount());
		setting.setTax(settingDTO.getTax());
		settingDAO.updateSetting(setting);
	}

	@Override
	public void deleteSetting(int id) {
		settingDAO.deleteSetting(id);
	}

	@Override
	public SettingDTO getSettingById(int id) {
		Setting setting = settingDAO.getSettingById(id);
		SettingDTO settingDTO = new SettingDTO();
		settingDTO.setId(setting.getId());
		settingDTO.setTitle(setting.getTitle());
		settingDTO.setDescription(setting.getDescription());
		settingDTO.setKeywords(setting.getKeywords());
		settingDTO.setAuthor(setting.getAuthor());
		settingDTO.setDiscount_amount(setting.getDiscount_amount());
		settingDTO.setTax(setting.getTax());
		return settingDTO;
	}
}
