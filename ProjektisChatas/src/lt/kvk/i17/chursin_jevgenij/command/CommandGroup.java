package lt.kvk.i17.chursin_jevgenij.command;

import java.util.HashMap;
import java.util.Map;

public class CommandGroup {
	Map<String, Command> commands;
	
	public CommandGroup() {
		commands = new HashMap();
	}
	
	public void addCommand(String command, Command action) {
		commands.put(command, action);
	}
	
	public String activateCommand(String command) {
		if (commands.get(command.split(" ")[0]) == null) {
			return "No such command found!";
		} else {
			return commands.get(command.split(" ")[0]).execute(command.split(" ")[1]);
		}
	}
}
