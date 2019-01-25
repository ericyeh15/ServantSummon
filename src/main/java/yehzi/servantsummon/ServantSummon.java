package yehzi.servantsummon;

import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import yehzi.servantsummon.common.CommonProxy;

@Mod(modid=ModInfo.modid , name=ModInfo.modname)
public class ServantSummon {

	@Instance(ModInfo.modid)
	public static ServantSummon instance;

	public static List<Item> itemList = Lists.newArrayList();
	public static List<Block> blockList = Lists.newArrayList();
	public static List<TileEntity> TEList = Lists.newArrayList();
	public static List<ChunkPos> posList = Lists.newArrayList();
	public static List<Biome> biomeList=Lists.newArrayList();
	public static long worldseedcase=0;
	public static ArrayListMultimap<ChunkPos, ChunkPos> posListMap = ArrayListMultimap.create();

	public static final Logger logger = LogManager.getLogger(ModInfo.modid);

	@SidedProxy(clientSide = "yehzi.servantsummon.client.ClientProxy", serverSide = "yehzi.servantsummon.client.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}

}
