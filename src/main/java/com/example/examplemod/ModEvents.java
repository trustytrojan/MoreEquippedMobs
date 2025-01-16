package com.example.examplemod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = ExampleMod.MODID)
public class ModEvents {
	static final double HELMET_CHANCE = 0.1,
						CHESTPLATE_CHANCE = 0.1,
						LEGGINGS_CHANCE = 0.1,
						BOOTS_CHANCE = 0.1,
						WEAPON_CHANCE = 0.1;
						// SHIELD_CHANCE = 0.1;

	@SubscribeEvent
	public static void randomlyEquipMonster(EntityJoinWorldEvent event) {
		final Entity entity = event.getEntity();

		if (entity == null) {
			ExampleMod.logger.info("entity is somehow null");
			return;
		}

		final boolean entityIsMob = entity instanceof EntityMob;
		final boolean entityIsMonster = entity.isCreatureType(EnumCreatureType.MONSTER, false);

		if (!entityIsMob) {
			ExampleMod.logger.info("entity is not a mob");
		} else {
			ExampleMod.logger.info("entity is a mob");
		}

		final EntityMob monster = (EntityMob) entity;
		if (Math.random() < HELMET_CHANCE)
			monster.setItemStackToSlot(EntityEquipmentSlot.HEAD, RandomArmor.helmet());
		if (Math.random() < CHESTPLATE_CHANCE)
			monster.setItemStackToSlot(EntityEquipmentSlot.CHEST, RandomArmor.chestplate());
		if (Math.random() < LEGGINGS_CHANCE)
			monster.setItemStackToSlot(EntityEquipmentSlot.LEGS, RandomArmor.leggings());
		if (Math.random() < BOOTS_CHANCE)
			monster.setItemStackToSlot(EntityEquipmentSlot.FEET, RandomArmor.boots());
		if (Math.random() < WEAPON_CHANCE)
			monster.setHeldItem(EnumHand.MAIN_HAND, Util.randomElement(RandomWeapon.values()).get());
		// if (Math.random() < SHIELD_CHANCE)
		// 	monster.setHeldItem(EnumHand.OFF_HAND, Util.singleItem(Items.SHIELD));
	}
}
