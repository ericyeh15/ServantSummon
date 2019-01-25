package yehzi.servantsummon.client;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import yehzi.servantsummon.ModInfo;
import yehzi.servantsummon.ServantSummon;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid=ModInfo.modid)
public class ClientRegitryHandler {
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent evt) {
		for(Block block : ServantSummon.blockList) {
			if(block instanceof IModelHandler)
				((IModelHandler) block).registeryModel();
		}

		for(Item item : ServantSummon.itemList) {
			if(item instanceof IModelHandler)
				((IModelHandler) item).registeryModel();
		}
	}

	public static void registerRenderBlockState(Item item, int meta, String name, String variantIn) {
		ResourceLocation location = new ResourceLocation(ModInfo.modid, name);
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(location, variantIn));
	}

	public static void registerItemRender(Item item) {
		ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(item.getRegistryName(),"inventory");
		final int DEFAULT_ITEM_SUBTYPE = 0;
		ModelLoader.setCustomModelResourceLocation(item, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
	}
}
