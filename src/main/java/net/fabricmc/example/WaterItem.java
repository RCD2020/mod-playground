package net.fabricmc.example;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.VibrationParticleEffect;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class WaterItem extends Item {

    public WaterItem(Settings settings) { super(settings); }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        float f = -MathHelper.sin(playerEntity.getYaw() * 0.017453292f) * MathHelper.cos(playerEntity.getPitch() * 0.017453292f);
        float g = -MathHelper.sin(playerEntity.getPitch() * 0.017453292f);
        float h = MathHelper.cos(playerEntity.getYaw() * 0.017453292f) * MathHelper.cos(playerEntity.getPitch() * 0.017453292f);
        world.addParticle(ParticleTypes.SPIT, playerEntity.getX(), playerEntity.getY() + 1.5f, playerEntity.getZ(), f, g, h);
        playerEntity.playSound(SoundEvents.ITEM_BUCKET_FILL, 1.0f, 1.0f);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
