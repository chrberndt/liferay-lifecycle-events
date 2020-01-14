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
 *         The "servlet.service.events.pre" event is fired before the
 *         MainServlet's service() method is executed.
 *
 */
@Component(
	immediate = true, 
	property = "key=" + PropsKeys.SERVLET_SERVICE_EVENTS_PRE,
	service = LifecycleAction.class
)
public class ServletServicePreAction implements LifecycleAction {
	
	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent)
		throws ActionException {

		System.out.println(PropsKeys.SERVLET_SERVICE_EVENTS_PRE + StringPool.SPACE + lifecycleEvent);

		if (_log.isInfoEnabled()) {
			_log.info("ServletServicePreAction.processLifecycleEvent()");
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(ApplicationStartupAction.class);

}
