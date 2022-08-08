package net.fabricmc.example;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class SpeedMaterial implements ToolMaterial {

    public static final SpeedMaterial INSTANCE = new SpeedMaterial();

    @Override
    public int getDurability() {
        return 2000;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 40.0f;
    }

    @Override
    public float getAttackDamage() {
        return 1.0f;
    }

    @Override
    public int getMiningLevel() {
        return 1;
    }

    @Override
    public int getEnchantability() {
        return 5;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(RegisterItems.SPEED_INGOT);
    }
}
