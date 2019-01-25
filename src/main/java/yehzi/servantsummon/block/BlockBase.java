package yehzi.servantsummon.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import yehzi.servantsummon.ModInfo;
import yehzi.servantsummon.ServantSummon;
import yehzi.servantsummon.ServantSummonCreativeTab;
import yehzi.servantsummon.client.ClientRegitryHandler;
import yehzi.servantsummon.client.IModelHandler;

public abstract class BlockBase extends Block implements IModelHandler{
	public BlockBase(String name) {
		super(Material.CAKE);
		ServantSummon.blockList.add(this);
		this.setCreativeTab(ServantSummonCreativeTab.instance);
		this.setRegistryName(new ResourceLocation(ModInfo.modid,name));
		this.setTranslationKey(name);
		ServantSummon.itemList.add(this.getIBlock().setRegistryName(this.getRegistryName()));
	}
	
	protected ItemBlock itemBlock=null;
	
	protected ItemBlock createIBlock() {
		return new ItemBlock(this);
	}

	public ItemBlock getIBlock() {
		if(this.itemBlock==null) {
			itemBlock=this.createIBlock();
		}
		return this.itemBlock;
	}
	
}
