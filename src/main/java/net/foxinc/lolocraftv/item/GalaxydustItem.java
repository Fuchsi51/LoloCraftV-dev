
package net.foxinc.lolocraftv.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.block.BlockState;

import net.foxinc.lolocraftv.itemgroup.LoloCraftVItemGroup;
import net.foxinc.lolocraftv.LolocraftvModElements;

@LolocraftvModElements.ModElement.Tag
public class GalaxydustItem extends LolocraftvModElements.ModElement {
	@ObjectHolder("lolocraftv:galaxydust")
	public static final Item block = null;

	public GalaxydustItem(LolocraftvModElements instance) {
		super(instance, 50);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(LoloCraftVItemGroup.tab).maxStackSize(16).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(20).saturation(0.3f)

							.build()));
			setRegistryName("galaxydust");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.NONE;
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
