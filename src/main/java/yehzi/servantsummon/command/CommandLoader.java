package yehzi.servantsummon.command;

import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class CommandLoader {
	 public CommandLoader(FMLServerStartingEvent event)
	    {
	        event.registerServerCommand(new CommandEE());
	    }

}
