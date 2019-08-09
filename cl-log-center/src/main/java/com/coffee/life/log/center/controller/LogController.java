package com.coffee.life.log.center.controller;

import com.coffee.life.framework.model.response.Page;
import com.coffee.life.log.center.service.LogService;
import com.coffee.life.log.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LogController {

	@Autowired
	private LogService logService;

	@PostMapping("/logs-anon/internal")
	public void save(@RequestBody Log log) {
		logService.save(log);
	}

	/**
	 * 日志模块<br>
	 * 2018.07.29作废
	 */
	@Deprecated
//	@PreAuthorize("hasAuthority('log:query')")
	@GetMapping("/logs-modules")
	public Map<String, String> logModule() {
		return null;
	}

	/**
	 * 日志查询
	 * 
	 * @param params
	 * @return
	 */
//	@PreAuthorize("hasAuthority('log:query')")
	@GetMapping("/logs")
	public Page<Log> findLogs(@RequestParam Map<String, Object> params) {
		return logService.findLogs(params);
	}

}
