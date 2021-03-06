package com.aoexe.discuz.system.modular.notification.service.impl;

import com.aoexe.discuz.system.modular.notification.mapper.NotificationMapper;
import com.aoexe.discuz.system.modular.notification.model.entity.Notification;
import com.aoexe.discuz.system.modular.notification.service.INotificationService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenyuxian
 * @since 2021-08-30
 */
@Service
public class NotificationServiceImpl extends ServiceImpl<NotificationMapper, Notification> implements INotificationService {

	@Override
	public IPage<Notification> list(HttpServletRequest request) throws Exception {
		
		return null;
	}

}
