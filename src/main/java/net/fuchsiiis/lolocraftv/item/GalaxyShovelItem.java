
package net.fuchsiiis.lolocraftv.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.fuchsiiis.lolocraftv.itemgroup.LoloCraftVItemGroup;
import net.fuchsiiis.lolocraftv.LolocraftvModElements;

@LolocraftvModElements.ModElement.Tag
public class GalaxyShovelItem extends LolocraftvModElements.ModElement {
	@ObjectHolder("lolocraftv:galaxy_shovel")
	public static final Item block = null;

	public GalaxyShovelItem(LolocraftvModElements instance) {
		super(instance, 29);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 1700;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 0f;
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
		}.setRegistryName("galaxy_shovel"));
	}
}
