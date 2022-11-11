
package net.fuchsiiis.lolocraftv.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.BlockState;

import net.fuchsiiis.lolocraftv.procedures.GalaxydustBeiRechtsklickProcedure;
import net.fuchsiiis.lolocraftv.itemgroup.LoloCraftVItemGroup;
import net.fuchsiiis.lolocraftv.LolocraftvModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

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
			super(new Item.Properties().group(LoloCraftVItemGroup.tab).maxStackSize(16).rarity(Rarity.COMMON));
			setRegistryName("galaxydust");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			GalaxydustBeiRechtsklickProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			return ar;
		}
	}
}
