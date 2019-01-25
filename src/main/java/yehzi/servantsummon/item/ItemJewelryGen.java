package yehzi.servantsummon.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import yehzi.servantsummon.ServantSummonCreativeTab;
import static yehzi.servantsummon.lib.Properties.*;

public class ItemJewelryGen extends ItemBase{
	public ItemJewelryGen() {
		super("jewelrygen");
		this.setHasSubtypes(true);
	}

	@Override
	public String getTranslationKey(ItemStack stack) {
		return super.getTranslationKey(stack)+"."+Size.byMetadata(stack.getMetadata()).getName();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if(tab.equals(this.getCreativeTab())) {
			items.add(new ItemStack(this,1,0));
			items.add(new ItemStack(this,1,1));
			items.add(new ItemStack(this,1,2));
		}
	}
	

}
