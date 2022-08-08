package net.fabricmc.example;

import net.minecraft.entity.damage.DamageSource;

public class SacrificeDamageSource extends DamageSource {

    public SacrificeDamageSource(String name) { super(name); }

    private boolean bypassesArmor;
    private float exhaustion = 0.1f;

    @Override
    protected SacrificeDamageSource setBypassesArmor() {
        this.bypassesArmor = true;
        this.exhaustion = 0.0f;
        return this;
    }
}
