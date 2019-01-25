package yehzi.servantsummon.capability;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

public interface IEECapability extends INBTSerializable<NBTTagCompound> {
	void setEE(int EE);
	int getEE();
	boolean hasSet();
	void setFlag();
	boolean oreCreate();
	void oreSet();
}
