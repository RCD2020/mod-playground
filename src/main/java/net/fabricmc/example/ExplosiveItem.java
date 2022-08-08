package net.fabricmc.example;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class ExplosiveItem extends Item {
    float[] explosive = {0.1f, 0.5f, 1.0f, 2.5f, 5.0f, 10.0f, 25.0f, 50.0f, 100.0f};
    int selector = 0;

    public ExplosiveItem(Settings settings) {
        super(settings); }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        ItemStack explosive = playerEntity.getStackInHand(hand);

        if (!playerEntity.isInSneakingPose()) {
            world.createExplosion(null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), this.explosive[selector], Explosion.DestructionType.BREAK);
            if (!playerEntity.getAbilities().creativeMode) {
                explosive.decrement(1);
            }
        } else {
            if (selector != 8) {
                selector += 1;
            } else {
                selector = 0;
            }
            playerEntity.sendMessage(Text.of("Explosive Level: " + this.explosive[selector]), true);
        }
        return TypedActionResult.success(explosive);
    }
}
