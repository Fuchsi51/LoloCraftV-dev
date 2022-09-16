
package net.foxinc.lolocraftv.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.foxinc.lolocraftv.itemgroup.LoloCraftVItemGroup;
import net.foxinc.lolocraftv.LolocraftvModElements;

@LolocraftvModElements.ModElement.Tag
public class GalaxySwordItem extends LolocraftvModElements.ModElement {
	@ObjectHolder("lolocraftv:galaxy_sword")
	public static final Item block = null;

	public GalaxySwordItem(LolocraftvModElements instance) {
		super(instance, 28);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 300;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 8f;
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
		}, 3, -2f, new Item.Properties().group(LoloCraftVItemGroup.tab)) {
		}.setRegistryName("galaxy_sword"));
	}
}
