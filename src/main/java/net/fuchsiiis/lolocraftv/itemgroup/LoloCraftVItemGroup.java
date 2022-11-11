
package net.fuchsiiis.lolocraftv.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.fuchsiiis.lolocraftv.block.GalaxydirtBlock;
import net.fuchsiiis.lolocraftv.LolocraftvModElements;

@LolocraftvModElements.ModElement.Tag
public class LoloCraftVItemGroup extends LolocraftvModElements.ModElement {
	public LoloCraftVItemGroup(LolocraftvModElements instance) {
		super(instance, 21);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tablolo_craft_v") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(GalaxydirtBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
