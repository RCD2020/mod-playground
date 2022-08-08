package net.fabricmc.example;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class LifeStealEnchant extends Enchantment {

    public LifeStealEnchant() {
        super(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) { return level * 10; }

    @Override
    public int getMaxPower(int level) { return this.getMinPower(level) + 15; }

    @Override
    public int getMaxLevel() { return 3; }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity) {
            user.heal(0.5f * level);
        }

        super.onTargetDamaged(user, target, level);
    }
}
