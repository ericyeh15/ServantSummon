package yehzi.servantsummon.world.worldgen;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import yehzi.servantsummon.block.BlockLoader;
import yehzi.servantsummon.capability.CapabilityLoader;
import yehzi.servantsummon.capability.IEECapability;
import yehzi.servantsummon.lib.Properties;

import static yehzi.servantsummon.lib.Properties.*;

import java.util.Random;

import com.google.common.base.Predicate;

public class WorldGenHandler {
	public WorldGenHandler() {
		MinecraftForge.ORE_GEN_BUS.register(this);
	}
	
	
	protected WorldGenMinable GenJewelrySmall=new WorldGenMinable(BlockLoader.jewelryore.getDefaultState().withProperty(SIZE, Size.Small),16);
	protected WorldGenMinable GenJewelryMid=new WorldGenMinable(BlockLoader.jewelryore.getDefaultState().withProperty(SIZE, Size.Mid),4,new PredicateJewelryOre(Size.Small));
	protected WorldGenMinable GenJewelryLarge=new WorldGenMinable(BlockLoader.jewelryore.getDefaultState().withProperty(SIZE, Size.Large),2	, new PredicateJewelryOre(Size.Mid));
	
	@SubscribeEvent
	public void onWorldGenMinable(OreGenEvent.GenerateMinable event) {
		World world=event.getWorld();
		Random rand=event.getRand();
		BlockPos pos=event.getPos();
		Chunk chunk=world.getChunk(pos);
		IEECapability EEC=chunk.getCapability(CapabilityLoader.EEcapability, null);
		if(world.provider.getDimension() != 0) return;
		int posX=chunk.getPos().getXStart()+rand.nextInt(16);
		int posY=16+rand.nextInt(32);
		int posZ=chunk.getPos().getZStart()+rand.nextInt(16);
		BlockPos position=new BlockPos(posX,posY,posZ);
		int a=(int)Math.log(EEC.getEE());
		if(a>0) {
			for(int i=0;i<10;i++) {
				GenJewelrySmall.generate(world, rand, position);
			}
			if(a>7) {
				for(int j=0;j<10;j++) {
					GenJewelryMid.generate(world, rand, position);
				}
				if(a>8) {
					for(int k=0;k<20;k++) {
						GenJewelryLarge.generate(world, rand, position);
					}
				}
			}
		}
	}
	
	public class PredicateJewelryOre implements Predicate<IBlockState>{
		private Size check=null;
		public PredicateJewelryOre(Size size) {
			this.check=size;
		}
		
		@Override
		public boolean apply(IBlockState input) {
			if(input!=null && input.getBlock()==BlockLoader.jewelryore && input.getValue(SIZE)==check) {
				return true;
			}
			else {
				return false;
			}
		}
		
	}

}
