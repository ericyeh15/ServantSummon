package yehzi.servantsummon.block;

import static yehzi.servantsummon.lib.Properties.*;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.SoundType;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import yehzi.servantsummon.client.ClientRegitryHandler;
import yehzi.servantsummon.item.ItemLoader;

import static yehzi.servantsummon.lib.Properties.*;

public class BlockJewelryOre extends BlockOreBase{
	public BlockJewelryOre() {
		super("jewelry_ore");
		this.setDefaultState(this.blockState.getBaseState().withProperty(SIZE, Size.Large));
		
		setSoundType(SoundType.STONE);
		setHardness(5.0F);
		setResistance(1.0F);
		setHarvestLevel("pickaxe", 1);
		setHarvestLevel("pickaxe", 1, getStateFromMeta(0));
		setHarvestLevel("pickaxe", 2, getStateFromMeta(1));
		setHarvestLevel("pickaxe", 3, getStateFromMeta(2));
	}
	
	
	@Override
	public ItemBlock createIBlock() {
		return new ItemMultiTexture(this,this,new String[] {"large","mid","small"});
	}

	@Override
	public void registeryModel() {
		ClientRegitryHandler.registerRenderBlockState(this.getIBlock(),0, "jewelry_ore", "size=large");
		ClientRegitryHandler.registerRenderBlockState(this.getIBlock(),1, "jewelry_ore", "size=mid");
		ClientRegitryHandler.registerRenderBlockState(this.getIBlock(),2, "jewelry_ore", "size=small");
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, SIZE);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
	Size size = Size.values()[meta];
		return this.getDefaultState().withProperty(SIZE, size);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int size = state.getValue(SIZE).getMetadata();
		return size;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		if (itemIn.equals(this.getCreativeTab())) {
			items.add(new ItemStack(this, 1, 0));
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 2));
		}
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return new ItemLoader().jewelrygen;
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return this.getMetaFromState(state);
	}

	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		ItemStack i=new ItemStack(this.getItemDropped(state, RANDOM, fortune), 1, this.damageDropped(state));
		drops.add(i);
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(BlockLoader.jewelryore), 1, state.getValue(SIZE).getMetadata());
	}

}
