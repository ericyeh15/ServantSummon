package yehzi.servantsummon.lib;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.IStringSerializable;

public class Properties {
	
	public static enum Size implements IStringSerializable {

		Large(0,"large"), Mid(1,"mid"), Small(2,"small");

		private String name;
		private final int metadata;
		
		private Size(int metadata, String name){
			this.metadata = metadata;
			this.name = name;
		}

		@Override
		public String getName() {
			return this.name;
		}
		
		@Override
		public String toString() {
			return this.name;
		}

		public int getMetadata() {
			return this.metadata;
		}
		
		public static Size byMetadata(int metadata) {
			if (metadata < 0 || metadata >= values().length) {
				metadata = 0;
			}
			return values()[metadata];
		}
	}

	public static final PropertyEnum<Size> SIZE=PropertyEnum.create("size", Size.class);

}

