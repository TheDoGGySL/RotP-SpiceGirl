package com.thedoggy.spice_girl_addon.mixin;

import com.thedoggy.spice_girl_addon.event.SoftBlockManager;
import com.thedoggy.spice_girl_addon.init.InitEffects;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public abstract class BlockMixin {

    private boolean shouldApplyBounce(Entity entity, World world, BlockPos pos) {
        return (SoftBlockManager.isInSoftArea(world, pos) ||
                (entity instanceof LivingEntity &&
                        ((LivingEntity) entity).hasEffect(InitEffects.BOUNCE_EFFECT.get())));
    }

    @Inject(method = "updateEntityAfterFallOn", at = @At("HEAD"), cancellable = true)
    private void onBounceAfterFall(IBlockReader world, Entity entity, CallbackInfo ci) {
        if (!(world instanceof World) || entity.isSuppressingBounce()) return;

        World realWorld = (World) world;
        BlockPos pos = entity.blockPosition();

        if (shouldApplyBounce(entity, realWorld, pos)) {
            this.bounceEntity(entity);
            ci.cancel();
        }
    }

    @Inject(method = "fallOn", at = @At("HEAD"), cancellable = true)
    private void onFallOn(World world, BlockPos pos, Entity entity, float height, CallbackInfo ci) {
        if (world.isClientSide || entity.isSuppressingBounce()) return;

        if (shouldApplyBounce(entity, world, pos)) {
            entity.causeFallDamage(height, 0.0F);
            ci.cancel();
        }
    }

    private void bounceEntity(Entity entity) {
        Vector3d motion = entity.getDeltaMovement();
        if (motion.y < 0.0D) {
            double multiplier = entity instanceof LivingEntity ? 1.0D : 0.8D;
            entity.setDeltaMovement(motion.x, -motion.y * multiplier, motion.z);
        }
    }
}

