package com.coffee.life.service;

import com.coffee.life.common.model.response.Page;
import com.coffee.life.log.api.Log;

import java.util.Map;

public interface LogService {

	/**
	 * 保存日志
	 *
	 * @param log
	 */
	void save(Log log);

	Page<Log> findLogs(Map<String, Object> params);

}
