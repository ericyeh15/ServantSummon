package yehzi.servantsummon.capability;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

public interface IServantCapability extends INBTSerializable<NBTTagCompound>{
	
	//mana
	public void setMana(int mana);
	public int getMana();
	
	public void setMaxMana(int maxMana);
	public int getMaxMana();
	
	public void setManaRegeneration(int re);
	public int getManaRegeneration();
}
