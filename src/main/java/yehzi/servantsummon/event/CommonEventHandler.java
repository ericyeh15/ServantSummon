package yehzi.servantsummon.event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeOcean;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.world.ChunkDataEvent;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import yehzi.servantsummon.ModInfo;
import yehzi.servantsummon.ServantSummon;
import yehzi.servantsummon.capability.CapabilityChunk;
import yehzi.servantsummon.capability.CapabilityLoader;
import yehzi.servantsummon.capability.IEECapability;


public class CommonEventHandler {
	public CommonEventHandler() {
		MinecraftForge.EVENT_BUS.register(this);
	}
	@SubscribeEvent
	public void  onAttachCapabilitiesEvent(AttachCapabilitiesEvent<Chunk> event) {
		if(event.getObject() instanceof Chunk) {
			event.addCapability(new ResourceLocation(ModInfo.modid), new CapabilityChunk.ProviderChunk());
		}
	}



	@SubscribeEvent
	public void settingEarthEssence(WorldEvent event){
		World world=event.getWorld();
		Long wSeed=world.getSeed();
		if (ServantSummon.worldseedcase != wSeed) {
			ServantSummon.posList.clear();
			ServantSummon.posListMap.clear();
			ServantSummon.worldseedcase = wSeed;
		}
		Random r=new Random();
		r.setSeed(wSeed);
		for(int i =0;i<5;i++) {
			int xStart = (r.nextInt(251) - 125) << 4;
			int zStart = (r.nextInt(251) - 125) << 4;
			int length = 160;
			int width = 160;
			int count = 0;
			int trytime = 0;
			while (true) {
				Biome[] biomelist = world.getBiomeProvider().getBiomes(null, xStart, zStart, width, length, false);
				for (Biome biome : biomelist) {
					if (biome instanceof BiomeOcean) {
						count++;
					}
				}
				if (count >= (width * length * 0.8) && trytime >= 10) {
					ServantSummon.logger.info("It seems that charector is in  a ocean map, set mid point at (0,0)");
					xStart = 0;
					zStart = 0;
					break;
				} else if (count > (width * length * 0.4)) {
					trytime++;
					ServantSummon.logger.info("These's to many ocean biome in this area,try it again" + "(" + xStart + "," + zStart + ")");
					xStart += width;
					continue;
				} else {
					break;
				}
			}
			ChunkPos midChunk=new ChunkPos(xStart >> 4, zStart >> 4);
			ServantSummon.posList.add(midChunk);

			for(int j=0;j<7;j++){
				int dx=r.nextInt(21)-10;
				int dz=r.nextInt(21)-10;

			}
		}
	}
}
