package yehzi.servantsummon;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import yehzi.servantsummon.item.ItemLoader;

public class ServantSummonCreativeTab extends CreativeTabs{
	
	public static final ServantSummonCreativeTab instance=new ServantSummonCreativeTab();
	
	public ServantSummonCreativeTab() {
		super(ModInfo.modid);
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemLoader.jewelrygen);
	}

}
