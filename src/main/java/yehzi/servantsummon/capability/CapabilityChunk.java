package yehzi.servantsummon.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import yehzi.servantsummon.ModInfo;
import yehzi.servantsummon.ServantSummon;
import yehzi.servantsummon.capability.CapabilityServantSummon.Implementation;

public class CapabilityChunk {
	public static class Storage implements Capability.IStorage<IEECapability> {

		@Override
		public NBTBase writeNBT(Capability<IEECapability> capability, IEECapability instance,
				EnumFacing side) {
			return instance.serializeNBT();
		}

		@Override
		public void readNBT(Capability<IEECapability> capability, IEECapability instance, EnumFacing side,
				NBTBase nbt) {
			instance.deserializeNBT((NBTTagCompound) nbt);

		}

	}

	public static class Implementation implements IEECapability {
		private int EE=10;
		private boolean flag=false;
		private boolean oreCreative=false;
		

		@Override
		public boolean hasSet() {
			return this.flag;
		}

		@Override
		public void setFlag() {
			this.flag=true;
		}

		@Override
		public void setEE(int EE) {
			this.EE=EE;
		}

		@Override
		public int getEE() {
			return this.EE;
		}

		@Override
		public NBTTagCompound serializeNBT() {
			NBTTagCompound compound = new NBTTagCompound();
			compound.setInteger(ModInfo.EEname,this.getEE());
			compound.setBoolean("flag", this.flag);
			return compound;
		}

		@Override
		public void deserializeNBT(NBTTagCompound nbt) {
			this.EE=nbt.getInteger(ModInfo.EEname);
			this.flag=nbt.getBoolean("flag");
		}

		@Override
		public boolean oreCreate() {
			return this.oreCreative;
		}

		@Override
		public void oreSet() {
			this.oreCreative=true;
		}
		
	}
	
	public static class ProviderChunk implements ICapabilitySerializable<NBTTagCompound> {

		private IEECapability ee = new Implementation();
		private IStorage<IEECapability> storage = CapabilityLoader.EEcapability.getStorage();

		@Override
		public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
			return CapabilityLoader.EEcapability.equals(capability);
		}

		@Override
		public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
			if (CapabilityLoader.EEcapability.equals(capability)) {
				T result = (T) ee;
				return result;
			}
			return null;
		}

		@Override
		public NBTTagCompound serializeNBT() {
			return (NBTTagCompound) storage.writeNBT(CapabilityLoader.EEcapability, ee, null);
		}

		@Override
		public void deserializeNBT(NBTTagCompound nbt) {
			storage.readNBT(CapabilityLoader.EEcapability, ee, null, nbt);
		}

	}


}
