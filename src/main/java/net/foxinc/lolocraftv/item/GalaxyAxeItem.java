
package net.foxinc.lolocraftv.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.foxinc.lolocraftv.itemgroup.LoloCraftVItemGroup;
import net.foxinc.lolocraftv.LolocraftvModElements;

@LolocraftvModElements.ModElement.Tag
public class GalaxyAxeItem extends LolocraftvModElements.ModElement {
	@ObjectHolder("lolocraftv:galaxy_axe")
	public static final Item block = null;

	public GalaxyAxeItem(LolocraftvModElements instance) {
		super(instance, 27);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 600;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 7f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 22;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(GalaxyingotItem.block));
			}
		}, 1, -3f, new Item.Properties().group(LoloCraftVItemGroup.tab)) {
		}.setRegistryName("galaxy_axe"));
	}
}
