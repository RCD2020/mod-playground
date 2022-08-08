package net.fabricmc.example;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Set;

public class SacrificeBladeItem extends SwordItem {

    public SacrificeBladeItem(Settings settings) { super(ToolMaterials.IRON, 3, -2.4f, settings); }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.damage(ExampleMod.SACRIFICE, 2.0f);
        playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 20, 1));
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
