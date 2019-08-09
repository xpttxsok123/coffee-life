package com.coffee.life.log.center.service;

import com.coffee.life.framework.model.response.Page;
import com.coffee.life.log.model.Log;

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
