package yehzi.servantsummon.client;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IModelHandler {
	@SideOnly(Side.CLIENT)
	void registeryModel();
}
