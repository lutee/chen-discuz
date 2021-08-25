package cn.chenyuxian.discuz.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.chenyuxian.discuz.core.annotion.BusinessLog;
import cn.chenyuxian.discuz.core.util.IpUtil;

@RestController
@RequestMapping("/test")
public class HelloController {
	
	@GetMapping("/aop")
	@BusinessLog(value = "demo")
	public String demo(HttpServletRequest request) {
		String ip = IpUtil.getIp(request);
		return IpUtil.getCityInfo(ip);
	}
	
}
