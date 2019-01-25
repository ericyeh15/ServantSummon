package yehzi.servantsummon.event;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import yehzi.servantsummon.ModInfo;
import yehzi.servantsummon.ServantSummon;
import yehzi.servantsummon.block.BlockLoader;
import yehzi.servantsummon.item.ItemLoader;
import yehzi.servantsummon.world.biome.BiomeEELoc;

@Mod.EventBusSubscriber(modid=ModInfo.modid)
public class RegistryEventHandler {
	@SubscribeEvent
	public static void registryBlocks(RegistryEvent.Register<Block> evt) {
		new BlockLoader();
		IForgeRegistry<Block> r=evt.getRegistry();
		for(Block b:ServantSummon.blockList) {
			r.register(b);
		}
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> evt) {
		new ItemLoader();
		IForgeRegistry<Item> r = evt.getRegistry();
		for(Item i:ServantSummon.itemList) {
			r.register(i);
		}
	}
	
	@SubscribeEvent
	public static void registerBiome(RegistryEvent.Register<Biome> evt) {
		IForgeRegistry<Biome> r=evt.getRegistry();
		
	}
	
	
}
