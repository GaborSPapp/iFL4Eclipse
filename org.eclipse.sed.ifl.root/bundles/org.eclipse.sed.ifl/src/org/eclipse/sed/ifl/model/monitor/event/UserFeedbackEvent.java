package org.eclipse.sed.ifl.model.monitor.event;

import java.util.HashMap;

import org.eclipse.sed.ifl.model.monitor.resource.CodeElement;
import org.eclipse.sed.ifl.model.monitor.resource.Option;
import org.eclipse.sed.ifl.model.monitor.resource.User;
import org.eclipse.sed.ifl.model.source.IMethodDescription;
import org.eclipse.sed.ifl.model.user.interaction.IUserFeedback;

public class UserFeedbackEvent extends Event {

	public UserFeedbackEvent(IUserFeedback feedback) {
		super(new HashMap<>());
		resources.put(new User(feedback.getUser().getUserID()), "user");
<<<<<<< HEAD
		resources.put(new Option(feedback.getChoise().getId(), feedback.getChoise().getTitle()), "choise");
		for (IMethodDescription subject : feedback.getSubjects().keySet()) {
=======
		resources.put(new Option(feedback.getChoice().getId(), feedback.getChoice().getTitle()), "choise");
		for (IMethodDescription subject : feedback.getSubjects()) {
>>>>>>> feature/Dhorvath1294/update-logging-system
			resources.put(new CodeElement(subject.getId().getKey()), "subject");
		}
	}

}
