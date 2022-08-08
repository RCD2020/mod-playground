package net.fabricmc.example;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.sound.SoundEvents;

public class SlipperyItem extends Item {

    public SlipperyItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.playSound(SoundEvents.ENTITY_SLIME_SQUISH_SMALL, 1.0f, 1.0f);
        ItemStack squishy = playerEntity.getStackInHand(hand);
        ItemStack squishy2 = squishy.copy();
        squishy2.setCount(1);
        playerEntity.dropItem(squishy2, true,  false);
        squishy.decrement(1);
        return TypedActionResult.success(squishy);
    }
}
