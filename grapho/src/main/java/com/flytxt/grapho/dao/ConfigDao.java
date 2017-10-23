package com.flytxt.grapho.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flytxt.grapho.repository.ConfigRepository;
/**
 * 
 * @author shiju.john
 *
 * @param <ConfigData>
 */
@Component
public class ConfigDao<ConfigData> extends FlyDao<ConfigData> {

	@Autowired
	public ConfigDao(ConfigRepository configRepo) {
		super(configRepo);
	}
}