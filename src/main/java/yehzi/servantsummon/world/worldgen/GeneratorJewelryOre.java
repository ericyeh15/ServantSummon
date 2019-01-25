package yehzi.servantsummon.world.worldgen;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;

import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.ChunkDataEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import yehzi.servantsummon.ModInfo;
import yehzi.servantsummon.ServantSummon;
import yehzi.servantsummon.block.BlockLoader;
import yehzi.servantsummon.capability.CapabilityLoader;
import yehzi.servantsummon.capability.IEECapability;

public class GeneratorJewelryOre extends WorldGenerator {
	public GeneratorJewelryOre() {
	}
	
	

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		int chunkX=position.getX();
		int chunkZ=position.getZ();
		Chunk chunk=worldIn.getChunk(position);
		IEECapability EEC=chunk.getCapability(CapabilityLoader.EEcapability, null);
		if(!EEC.oreCreate()) {
			double EEvalue=EEC.getEE();
			int gentime=(int) ((float)Math.log10(EEvalue)*((int)Math.log(EEvalue)+1));
			int posx=chunk.getPos().getXStart()+rand.nextInt(16);
			int posy=32+rand.nextInt(32);
			int posz=chunk.getPos().getZStart()+rand.nextInt(16);
			int size=(int)((65-posy)/5+1);
			int vactor=(int)EEvalue;
			for(int a=0;a<gentime;a++) {
				for(int xsiz=0;xsiz<size;xsiz++) {
					int positionx=this.posset(posx, xsiz);
					for(int ysiz=0;ysiz<size;ysiz++) {
						int positiony=this.posset(posy, ysiz);
						for(int zsiz=0;zsiz<size;zsiz++) {
							int positionz=this.posset(posz, zsiz);
							BlockPos genpos=new BlockPos(positionx,positiony,positionz);
							
						}
					}
				}
			}
		}
		EEC.oreSet();
		return true;
	}
	
	private int posset(int base,int change) {
		int end=base>>4+16;
		int npos=base+change;
		return npos<end ? npos : base-npos+15;
	}
}
