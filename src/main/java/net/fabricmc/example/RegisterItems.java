package net.fabricmc.example;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import org.checkerframework.checker.units.qual.Speed;

public class RegisterItems {
    // Adamantium
    public static final ArmorMaterial CUSTOM_ARMOR_MATERIAL = new CustomArmorMaterial();
    public static final Item CUSTOM_MATERIAL_HELMET = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(ExampleMod.ITEM_GROUP).fireproof().rarity(Rarity.EPIC));
    public static final Item CUSTOM_MATERIAL_CHESTPLATE = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(ExampleMod.ITEM_GROUP).fireproof().rarity(Rarity.EPIC));
    public static final Item CUSTOM_MATERIAL_LEGGINGS = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(ExampleMod.ITEM_GROUP).fireproof().rarity(Rarity.EPIC));
    public static final Item CUSTOM_MATERIAL_BOOTS = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(ExampleMod.ITEM_GROUP).fireproof().rarity(Rarity.EPIC));
    public static final ToolItem ADASWORD = new SwordItem(AdaMaterial.INSTANCE, 7, -2.0f, new Item.Settings().group(ExampleMod.ITEM_GROUP).fireproof().rarity(Rarity.EPIC));
    public static final ToolItem ADAAXE = new CustomAxeItem(AdaMaterial.INSTANCE, 9, -2.6f, new Item.Settings().group(ExampleMod.ITEM_GROUP).fireproof().rarity(Rarity.EPIC));

    // Speed
    public static final Item SPEED_INGOT = new Item(new FabricItemSettings().group(ExampleMod.ITEM_GROUP));
    public static final ToolItem SPEED_SHOVEL = new ShovelItem(SpeedMaterial.INSTANCE, 1.5f, -3.0f, new Item.Settings().group(ExampleMod.ITEM_GROUP));
    public static final ToolItem SPEED_PICK = new CustomPickaxeItem(SpeedMaterial.INSTANCE, 1, -2.8F, new Item.Settings().group(ExampleMod.ITEM_GROUP));
    public static final ToolItem SPEED_AXE = new CustomAxeItem(SpeedMaterial.INSTANCE, 7.0f, -3.2f, new Item.Settings().group(ExampleMod.ITEM_GROUP));
    public static final ToolItem SPEED_HOE = new CustomHoeItem(SpeedMaterial.INSTANCE, -1, -2.0f, new Item.Settings().group(ExampleMod.ITEM_GROUP));

    public static void register() {
        // Adamantium
        Registry.register(Registry.ITEM, new Identifier("tutorial", "adahelmet"), CUSTOM_MATERIAL_HELMET);
        Registry.register(Registry.ITEM, new Identifier("tutorial", "adachestplate"), CUSTOM_MATERIAL_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("tutorial", "adaleggings"), CUSTOM_MATERIAL_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("tutorial", "adaboots"), CUSTOM_MATERIAL_BOOTS);
        Registry.register(Registry.ITEM, new Identifier("tutorial", "adasword"), ADASWORD);
        Registry.register(Registry.ITEM, new Identifier("tutorial", "adaaxe"), ADAAXE);

        // Speed
        Registry.register(Registry.ITEM, new Identifier("tutorial", "speed_ingot"), SPEED_INGOT);
        Registry.register(Registry.ITEM, new Identifier("tutorial", "speed_shovel"), SPEED_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("tutorial", "speed_pick"), SPEED_PICK);
        Registry.register(Registry.ITEM, new Identifier("tutorial", "speed_axe"), SPEED_AXE);
        Registry.register(Registry.ITEM, new Identifier("tutorial", "speed_hoe"), SPEED_HOE);

    }
}