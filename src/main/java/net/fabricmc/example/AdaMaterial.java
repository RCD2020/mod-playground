package net.fabricmc.example;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class AdaMaterial implements ToolMaterial {

    public static final AdaMaterial INSTANCE = new AdaMaterial();

    @Override
    public int getDurability() { return 2500; }

    @Override
    public float getMiningSpeedMultiplier() { return 12.0f; }

    @Override
    public float getAttackDamage() { return 4.0f; }

    @Override
    public int getMiningLevel() { return 5; }

    @Override
    public int getEnchantability() { return 22; }

    @Override
    public Ingredient getRepairIngredient() { return Ingredient.ofItems(ExampleMod.ADAMANTIUM); }
}
