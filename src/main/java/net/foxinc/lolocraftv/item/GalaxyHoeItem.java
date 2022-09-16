
package net.foxinc.lolocraftv.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

import net.foxinc.lolocraftv.itemgroup.LoloCraftVItemGroup;
import net.foxinc.lolocraftv.LolocraftvModElements;

@LolocraftvModElements.ModElement.Tag
public class GalaxyHoeItem extends LolocraftvModElements.ModElement {
	@ObjectHolder("lolocraftv:galaxy_hoe")
	public static final Item block = null;

	public GalaxyHoeItem(LolocraftvModElements instance) {
		super(instance, 30);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 1000;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 0f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(GalaxyingotItem.block));
			}
		}, 0, -3f, new Item.Properties().group(LoloCraftVItemGroup.tab)) {
		}.setRegistryName("galaxy_hoe"));
	}
}
