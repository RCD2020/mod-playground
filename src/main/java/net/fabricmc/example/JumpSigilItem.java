package net.fabricmc.example;

import net.minecraft.datafixer.fix.WallPropertyFix;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class JumpSigilItem extends Item {

    public JumpSigilItem(Settings settings) {
        super(settings.maxDamageIfAbsent(2000));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        ItemStack item = playerEntity.getStackInHand(hand);
        playerEntity.jump();

        if (playerEntity != null) {
            item.damage(1, playerEntity, (p) -> {
                p.sendToolBreakStatus(hand);
            });
        }

        return TypedActionResult.success(item);
    }
}
