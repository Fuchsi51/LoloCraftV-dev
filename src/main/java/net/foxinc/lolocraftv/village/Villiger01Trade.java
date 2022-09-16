
package net.foxinc.lolocraftv.village;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicTrade;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.entity.merchant.villager.VillagerProfession;

import net.foxinc.lolocraftv.item.GalaxydustItem;
import net.foxinc.lolocraftv.item.GalaxySwordItem;
import net.foxinc.lolocraftv.item.GalaxyPickaxeItem;

import java.util.List;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Villiger01Trade {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
		if (event.getType() == VillagerProfession.TOOLSMITH) {
			trades.get(2).add(new BasicTrade(new ItemStack(Items.EMERALD, (int) (30)), new ItemStack(GalaxyPickaxeItem.block), 2, 20, 0.1f));
			trades.get(2).add(new BasicTrade(new ItemStack(GalaxydustItem.block, (int) (5)), new ItemStack(Items.EMERALD), 200, 5, 0.05f));
		}
		if (event.getType() == VillagerProfession.WEAPONSMITH) {
			trades.get(2).add(new BasicTrade(new ItemStack(Items.EMERALD, (int) (30)), new ItemStack(GalaxySwordItem.block), 10, 20, 0.05f));
		}
	}
}
