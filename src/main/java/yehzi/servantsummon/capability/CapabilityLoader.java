package yehzi.servantsummon.capability;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CapabilityLoader {
	@CapabilityInject(IServantCapability.class)
	public static Capability<IServantCapability> capability;
	@CapabilityInject(IEECapability.class)
	public static Capability<IEECapability> EEcapability;
	
	public CapabilityLoader(FMLPreInitializationEvent event){
		CapabilityManager.INSTANCE.register(IServantCapability.class, new CapabilityServantSummon.Storage(), () -> new CapabilityServantSummon.Implementation());
		CapabilityManager.INSTANCE.register(IEECapability.class, new CapabilityChunk.Storage(), () -> new CapabilityChunk.Implementation());
	}
}
