package com.chberndt.liferay.lifecycle.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsKeys;

import org.osgi.service.component.annotations.Component;

/**
 * 
 * @author Christian Berndt
 * 
 *         "application.startup.events" is fired once for the startup of every
 *         portal instance within Liferay.
 *
 */
@Component(
	immediate = true, 
	property = "key=" + PropsKeys.APPLICATION_STARTUP_EVENTS,
	service = LifecycleAction.class
)
public class ApplicationStartupAction implements LifecycleAction {
	
	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent)
		throws ActionException {

		System.out.println(PropsKeys.APPLICATION_STARTUP_EVENTS + StringPool.SPACE + lifecycleEvent);

		if (_log.isInfoEnabled()) {
			_log.info("ApplicationStartupAction.processLifecycleEvent()");
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(ApplicationStartupAction.class);

}