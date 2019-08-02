package com.coffee.life.log.center.service;

import com.coffee.life.framework.domain.log.Log;
import com.coffee.life.framework.model.response.Page;

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
