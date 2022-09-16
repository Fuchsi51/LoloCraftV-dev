
package net.foxinc.lolocraftv.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.foxinc.lolocraftv.itemgroup.LoloCraftVItemGroup;
import net.foxinc.lolocraftv.LolocraftvModElements;

@LolocraftvModElements.ModElement.Tag
public class GalaxyPickaxeItem extends LolocraftvModElements.ModElement {
	@ObjectHolder("lolocraftv:galaxy_pickaxe")
	public static final Item block = null;

	public GalaxyPickaxeItem(LolocraftvModElements instance) {
		super(instance, 26);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 500;
			}

			public float getEfficiency() {
				return 12f;
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
		}.setRegistryName("galaxy_pickaxe"));
	}
}
