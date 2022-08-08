package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.datafixer.schema.IdentifierNormalizingSchema;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.ai.brain.task.FarmerVillagerTask;
import net.minecraft.item.*;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {

	// Item Group
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier("tutorial", "general"),
			() -> new ItemStack(ExampleMod.CUSTOM_ITEM)
	);

	public static final ItemGroup OTHER_GROUP = FabricItemGroupBuilder.create(
			new Identifier("tutorial", "other"))
					.icon(() -> new ItemStack(Items.BOWL))
			.appendItems(stacks -> {
				stacks.add(new ItemStack(Blocks.BONE_BLOCK));
				stacks.add(new ItemStack(Items.APPLE));
				stacks.add(PotionUtil.setPotion(new ItemStack(Items.POTION), Potions.LUCK));
				stacks.add(ItemStack.EMPTY);
				stacks.add(new ItemStack(Items.IRON_SHOVEL));
			})
					.build();

	// an instance of our new item
	public static final CustomItem CUSTOM_ITEM = new CustomItem(new FabricItemSettings().group(ExampleMod.ITEM_GROUP).maxCount(13));
	public static final Item KFC = new Item(new FabricItemSettings().group(ExampleMod.ITEM_GROUP).food(new FoodComponent.Builder().hunger(10).saturationModifier(5f).meat().alwaysEdible().snack().build()));
	public static final Item ADAMANTIUM = new Item(new FabricItemSettings().group(ExampleMod.ITEM_GROUP).rarity(Rarity.EPIC).fireproof());
	public static final SlipperyItem SOAP = new SlipperyItem(new FabricItemSettings().group(ExampleMod.ITEM_GROUP));
	public static final WaterItem SPLASHER = new WaterItem(new FabricItemSettings().group(ExampleMod.ITEM_GROUP));
	public static final ExplosiveItem SELFDESTRUCT = new ExplosiveItem(new FabricItemSettings().group(ExampleMod.ITEM_GROUP));
	public static final SacrificeBladeItem SACRIFICE_BLADE = new SacrificeBladeItem(new FabricItemSettings().group(ExampleMod.ITEM_GROUP));
	public static final SacrificeDamageSource SACRIFICE = (new SacrificeDamageSource("sacrifice")).setBypassesArmor();
	public static final JumpSigilItem JUMP_SIGIL = new JumpSigilItem(new FabricItemSettings().group(ExampleMod.ITEM_GROUP));
	public static final TestItem TEST_ITEM = new TestItem(new FabricItemSettings().group(ExampleMod.ITEM_GROUP));
	public static final PorcupineItem PORCUPINE = new PorcupineItem(new FabricItemSettings().group(ExampleMod.ITEM_GROUP).maxCount(1));



	// Enchantments
	public static Enchantment FROST = new FrostEnchantment();
	public static Enchantment LIFE_STEAL = new LifeStealEnchant();

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("tutorial");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(Registry.ITEM, new Identifier("tutorial", "custom_item"), CUSTOM_ITEM);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "kfc"), KFC);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "adamantium"), ADAMANTIUM);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "soap"), SOAP);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "splasher"), SPLASHER);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "selfdestruct"), SELFDESTRUCT);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "sacrifice_blade"), SACRIFICE_BLADE);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "jump_sigil"), JUMP_SIGIL);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "test_item"), TEST_ITEM);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "porcupine"), PORCUPINE);


		FuelRegistry.INSTANCE.add(CUSTOM_ITEM, 300); // one and a half operations
		CompostingChanceRegistry.INSTANCE.add(CUSTOM_ITEM, 1.0f); // 100% chance

		// Armor Initialization
		RegisterItems.register();

		// Enchantment Registration
		Registry.register(Registry.ENCHANTMENT, new Identifier("tutorial", "frost"), FROST);
		Registry.register(Registry.ENCHANTMENT, new Identifier("tutorial", "life_steal"), LIFE_STEAL);

		LOGGER.info("Hello Fabric world!");
	}
}

