package org.eclipse.sed.ifl.control.monitor;

import org.eclipse.sed.ifl.control.ViewlessControl;
import org.eclipse.sed.ifl.ide.accessor.gui.PartAccessor;
import org.eclipse.sed.ifl.model.monitor.ActivityMonitorModel;
import org.eclipse.sed.ifl.model.monitor.LogOnlyModeModel;
import org.eclipse.sed.ifl.model.monitor.PartMonitorModel;
import org.eclipse.sed.ifl.model.monitor.event.ModeEvent;

public class LogOnlyModeControl extends ViewlessControl<LogOnlyModeModel> {
	
	public static String NAME = "log-only";
		
	private PartAccessor partAccessor;

	public LogOnlyModeControl(LogOnlyModeModel model, PartAccessor accessor) {
		super(model);
		this.partAccessor = accessor;
	}
	
	private PartMonitorControl partMonitor;
	
	private ActivityMonitorControl activityMonitor;
	
	@Override
	public void init() {
		partMonitor = new PartMonitorControl(new PartMonitorModel(), partAccessor);
		addSubControl(partMonitor);
		activityMonitor = new ActivityMonitorControl(new ActivityMonitorModel());
		addSubControl(activityMonitor);
		super.init();
		
		activityMonitor.log(new ModeEvent(NAME, ModeEvent.State.ACTIVATED));
	}
	
	@Override
	public void teardown() {
		activityMonitor.log(new ModeEvent(NAME, ModeEvent.State.DEACTIVATED));
		super.teardown();
	}
	
	public void logDenied() {
		activityMonitor.log(new ModeEvent(NAME, ModeEvent.State.DENIED));
	}
}
