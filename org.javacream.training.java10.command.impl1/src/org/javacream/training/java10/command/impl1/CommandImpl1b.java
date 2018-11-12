package org.javacream.training.java10.command.impl1;

import org.javacream.training.java10.command.api.Command;

public class CommandImpl1b implements Command {

	@Override
	public String getDescription() {
		return "impl1b";
	}

	@Override
	public String execute() {
		return "executed impl1b";
	}

}
