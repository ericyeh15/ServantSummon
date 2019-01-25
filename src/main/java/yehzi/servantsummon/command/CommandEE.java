package yehzi.servantsummon.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.chunk.Chunk;
import yehzi.servantsummon.ServantSummon;
import yehzi.servantsummon.capability.CapabilityLoader;
import yehzi.servantsummon.capability.IEECapability;

public class CommandEE extends CommandBase{

	@Override
	public String getName() {		
		return "EE";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "command.ee.useage";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		try {
			if (args.length > 2) {
				Chunk c = sender.getEntityWorld().getChunk(Integer.valueOf(args[1]),
						Integer.valueOf(args[2]));
				IEECapability EEC = c.getCapability(CapabilityLoader.EEcapability, null);
				switch (args[0]) {
				case "set":
					EEC.setEE(Integer.valueOf(args[3]));
					sender.sendMessage(new TextComponentString("EE set "+EEC.getEE()));
					break;
				case "show":
					sender.sendMessage(new TextComponentString(""+EEC.getEE()));
					break;
				case "getlist":
					sender.sendMessage(new TextComponentString(ServantSummon.posList.toString()));
					break;
				}
			}
		}
		catch (Exception e) {
			throw new CommandException("!!");
		}
	}
}
