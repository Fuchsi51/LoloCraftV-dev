package net.fuchsiiis.lolocraftv.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

import net.fuchsiiis.lolocraftv.block.MegagalaxydustbombBlock;
import net.fuchsiiis.lolocraftv.LolocraftvMod;

import java.util.Map;

public class NucleaGalaxyTNTRedstoneAnProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LolocraftvMod.LOGGER.warn("Failed to load dependency world for procedure NucleaGalaxyTNTRedstoneAn!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LolocraftvMod.LOGGER.warn("Failed to load dependency x for procedure NucleaGalaxyTNTRedstoneAn!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LolocraftvMod.LOGGER.warn("Failed to load dependency y for procedure NucleaGalaxyTNTRedstoneAn!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LolocraftvMod.LOGGER.warn("Failed to load dependency z for procedure NucleaGalaxyTNTRedstoneAn!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		LolocraftvMod.LOGGER.debug("[LoloCraftV] Galaxy TNT Typ: Nuclea was ignited. ");
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
				world.setBlockState(new BlockPos(x, y, z), MegagalaxydustbombBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos(x, y + 1, z), MegagalaxydustbombBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos(x, y + 2, z), MegagalaxydustbombBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos(x, y + 3, z), MegagalaxydustbombBlock.block.getDefaultState(), 3);
				for (int index0 = 0; index0 < (int) (10); index0++) {
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, (World) world);
						entityToSpawn.setLocationAndAngles(x, y, z, (float) 0, (float) 0);
						entityToSpawn.setRenderYawOffset((float) 0);
						entityToSpawn.setRotationYawHead((float) 0);
						entityToSpawn.setMotion(0, 0, 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
				}
				if (world instanceof World && !((World) world).isRemote) {
					((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 50, Explosion.Mode.BREAK);
				}
				if (world instanceof World && !((World) world).isRemote) {
					((World) world).createExplosion(null, (int) (x + 1), (int) (y + 1), (int) (z + 1), (float) 50, Explosion.Mode.BREAK);
				}
				if (world instanceof World && !((World) world).isRemote) {
					((World) world).createExplosion(null, (int) (x + 2), (int) (y + 1), (int) (z + 2), (float) 50, Explosion.Mode.BREAK);
				}
				if (world instanceof World && !((World) world).isRemote) {
					((World) world).createExplosion(null, (int) (x + 3), (int) (y + 1), (int) (z + 3), (float) 50, Explosion.Mode.BREAK);
				}
				if (world instanceof World && !((World) world).isRemote) {
					((World) world).createExplosion(null, (int) (x + 4), (int) (y + 1), (int) (z + 4), (float) 50, Explosion.Mode.BREAK);
				}
				if (world instanceof World && !((World) world).isRemote) {
					((World) world).createExplosion(null, (int) (x + 5), (int) (y + 1), (int) (z + 5), (float) 50, Explosion.Mode.BREAK);
				}
				if (world instanceof World && !((World) world).isRemote) {
					((World) world).createExplosion(null, (int) (x + 6), (int) (y + 1), (int) (z + 6), (float) 50, Explosion.Mode.BREAK);
				}
				if (world instanceof World && !((World) world).isRemote) {
					((World) world).createExplosion(null, (int) (x + 7), (int) (y + 1), (int) (z + 7), (float) 50, Explosion.Mode.BREAK);
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 600);
	}
}
