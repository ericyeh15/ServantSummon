package yehzi.servantsummon.common;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import yehzi.servantsummon.ServantSummon;
import yehzi.servantsummon.capability.CapabilityLoader;
import yehzi.servantsummon.command.CommandEE;
import yehzi.servantsummon.command.CommandLoader;
import yehzi.servantsummon.event.CommonEventHandler;
import yehzi.servantsummon.world.worldgen.GeneratorJewelryOre;
import yehzi.servantsummon.world.worldgen.WorldGenHandler;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		new CapabilityLoader(event);
		System.err.println(Biome.REGISTRY.getClass().getName());
	}

	public void init(FMLInitializationEvent event) {
		new CommonEventHandler();
		new WorldGenHandler();
	}

	public void postInit(FMLPostInitializationEvent event) {
		
	}


}
