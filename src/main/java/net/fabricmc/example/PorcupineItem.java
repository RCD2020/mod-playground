package net.fabricmc.example;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class PorcupineItem extends Item {

    public PorcupineItem(Settings settings) { super(settings); }

    int[] values = {0, 10, 50, 100, 250, 500, 1000, 2500, 5000, 10000};
    int selector = 0;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        if (!playerEntity.isInSneakingPose()) {
            playerEntity.setStuckArrowCount(values[selector]);
        } else {
            if (selector != 9) {
                selector += 1;
            } else {
                selector = 0;
            }
            playerEntity.sendMessage(Text.of("Needle Count: " + values[selector]), true);
        }

        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
