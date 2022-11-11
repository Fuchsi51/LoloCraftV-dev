package net.fuchsiiis.lolocraftv.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.particles.ParticleTypes;

import net.fuchsiiis.lolocraftv.LolocraftvMod;

import java.util.Map;

public class GalaxydustPlayerFinishesUsingItemProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LolocraftvMod.LOGGER.warn("Failed to load dependency world for procedure GalaxydustPlayerFinishesUsingItem!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LolocraftvMod.LOGGER.warn("Failed to load dependency x for procedure GalaxydustPlayerFinishesUsingItem!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LolocraftvMod.LOGGER.warn("Failed to load dependency y for procedure GalaxydustPlayerFinishesUsingItem!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LolocraftvMod.LOGGER.warn("Failed to load dependency z for procedure GalaxydustPlayerFinishesUsingItem!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		for (int index0 = 0; index0 < (int) (10); index0++) {
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos(x, y, z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.tnt.primed")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.tnt.primed")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
		}
		new Object() {
			private int ticks = 0;
			private float waitTicks;
			private IWorld world;

			public void start(IWorld world, int waitTicks) {
				this.waitTicks = waitTicks;
				MinecraftForge.EVENT_BUS.register(this);
				this.world = world;
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					this.ticks += 1;
					if (this.ticks >= this.waitTicks)
						run();
				}
			}

			private void run() {
				if (world instanceof World && !((World) world).isRemote) {
					((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 100, Explosion.Mode.DESTROY);
				}
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.EXPLOSION, x, y, z, (int) 50, 3, 3, 3, 1);
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 20);
	}
}
