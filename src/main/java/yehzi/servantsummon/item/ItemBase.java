package yehzi.servantsummon.item;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import yehzi.servantsummon.ModInfo;
import yehzi.servantsummon.ServantSummon;
import yehzi.servantsummon.ServantSummonCreativeTab;
import yehzi.servantsummon.client.ClientRegitryHandler;
import yehzi.servantsummon.client.IModelHandler;

public abstract class ItemBase extends Item implements IModelHandler{
	public ItemBase(String name) {
		super();
		ServantSummon.itemList.add(this);
		this.setCreativeTab(ServantSummonCreativeTab.instance);
		this.setRegistryName(new ResourceLocation(ModInfo.modid,name));
		this.setTranslationKey(name);
	}

	@Override
	public void registeryModel() {
		ClientRegitryHandler.registerItemRender(this);	
	}
	

}
