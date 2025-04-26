package com.thedoggy.spice_girl_addon.action;

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.util.mod.JojoModUtil;
import com.thedoggy.spice_girl_addon.event.SoftBlockManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class SpiceGirlSoftBlock extends StandEntityAction {
    public static final StandPose SOFT_BLOCK = new StandPose("blockSoft");
    public SpiceGirlSoftBlock(StandEntityAction.Builder builder) {
        super(builder);
    }
    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide) {
            LivingEntity user = userPower.getUser();
            RayTraceResult ray = JojoModUtil.rayTrace(
                    user.getEyePosition(1.0F),
                    user.getLookAngle(),
                    standEntity.getMaxRange(),
                    world,
                    user,
                    e -> !e.is(standEntity) && !e.is(user),
                    0, 0
            );

            if (ray.getType() == RayTraceResult.Type.BLOCK) {
                BlockPos centerPos = ((BlockRayTraceResult) ray).getBlockPos();
                BlockPos.betweenClosedStream(centerPos.offset(-1, -1, -1), centerPos.offset(1, 1, 1))
                        .forEach(pos -> SoftBlockManager.addSoftBlock(world, pos));

                if (world instanceof ServerWorld) {
                    ServerWorld serverWorld = (ServerWorld) world;
                    BlockPos min = centerPos.offset(-1, -1, -1);
                    BlockPos max = centerPos.offset(1, 1, 1);

                    for (BlockPos pos : BlockPos.betweenClosed(min, max)) {
                        boolean isEdge = pos.getX() == min.getX() || pos.getX() == max.getX() ||
                                pos.getY() == min.getY() || pos.getY() == max.getY() ||
                                pos.getZ() == min.getZ() || pos.getZ() == max.getZ();

                        if (isEdge) {
                            double x = pos.getX() + 0.5;
                            double y = pos.getY() + 0.5;
                            double z = pos.getZ() + 0.5;
                            serverWorld.sendParticles(ParticleTypes.ITEM_SLIME, x, y, z, 3, 0.2, 0.2, 0.2, 0.02);
                        }
                    }
                    world.playSound(null, centerPos.getX() + 0.5, centerPos.getY() + 0.5, centerPos.getZ() + 0.5,
                            SoundEvents.SLIME_BLOCK_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
                }
            }
        }
    }
}
