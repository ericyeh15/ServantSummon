package yehzi.servantsummon.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class CapabilityServantSummon {
	public static class Storage implements Capability.IStorage<IServantCapability> {

		@Override
		public NBTBase writeNBT(Capability<IServantCapability> capability, IServantCapability instance,
				EnumFacing side) {
			return instance.serializeNBT();
		}

		@Override
		public void readNBT(Capability<IServantCapability> capability, IServantCapability instance, EnumFacing side,
				NBTBase nbt) {
			instance.deserializeNBT((NBTTagCompound) nbt);

		}

	}

	public static class Implementation implements IServantCapability {

		protected int mana = 0;
		protected int maxMana = 0;
		protected int manaRegeneration = 0;

		@Override
		public void setMana(int mana) {
			this.mana = mana;
		}

		@Override
		public int getMana() {
			return this.mana;
		}

		@Override
		public void setMaxMana(int maxMana) {
			this.maxMana = maxMana;
		}

		@Override
		public int getMaxMana() {
			return this.maxMana;
		}

		@Override
		public void setManaRegeneration(int re) {
			this.manaRegeneration = re;
		}

		@Override
		public int getManaRegeneration() {
			return this.manaRegeneration;
		}

		@Override
		public NBTTagCompound serializeNBT() {
			NBTTagCompound compound = new NBTTagCompound();
			compound.setInteger("Mana", this.getMana());
			compound.setInteger("ManaMax", this.getMaxMana());
			compound.setInteger("ManaRegeneration", this.getManaRegeneration());
			return compound;
		}

		@Override
		public void deserializeNBT(NBTTagCompound nbt) {
			this.setMana(nbt.getInteger("ManaMax"));
			this.setMaxMana(nbt.getInteger("ManaMax"));
			this.setManaRegeneration(nbt.getInteger("ManaRegeneration"));
		}

	}

	public static class ProviderPlayer implements ICapabilitySerializable<NBTTagCompound> {

		private IServantCapability mp = new Implementation();
		private IStorage<IServantCapability> storage = CapabilityLoader.capability.getStorage();

		@Override
		public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
			return CapabilityLoader.capability.equals(capability);
		}

		@Override
		public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
			if (CapabilityLoader.capability.equals(capability)) {
				T result = (T) mp;
				return result;
			}
			return null;
		}

		@Override
		public NBTTagCompound serializeNBT() {
			return (NBTTagCompound) storage.writeNBT(CapabilityLoader.capability, mp, null);
		}

		@Override
		public void deserializeNBT(NBTTagCompound nbt) {
			storage.readNBT(CapabilityLoader.capability, mp, null, nbt);
		}

	}

}
