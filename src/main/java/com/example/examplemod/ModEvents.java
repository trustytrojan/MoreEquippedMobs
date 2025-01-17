package com.example.examplemod;

import java.util.Random;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = ExampleMod.MODID)
public class ModEvents
{
    @SubscribeEvent
    public void onConfigChangedEvent(OnConfigChangedEvent event)
    {
        if (event.getModID().equals(ExampleMod.MODID))
        {
            ConfigManager.sync(ExampleMod.MODID, Type.INSTANCE);
        }
    }

	@SubscribeEvent
	public static void randomlyEquipMonster(final EntityJoinWorldEvent event)
	{
		final Entity entity = event.getEntity();

		if (entity == null)
		{
			ExampleMod.logger.debug("entity is somehow null, returning");
			return;
		}

		final String entityName = entity.getName();

		if (!(entity instanceof EntityMob))
		{
			ExampleMod.logger.debug("entity {} is not a mob, returning", entityName);
			return;
		}
		else
		{
			ExampleMod.logger.debug("entity {} is a mob", entityName);
		}

		if (!entity.isCreatureType(EnumCreatureType.MONSTER, false))
		{
			ExampleMod.logger.debug("entity {} is not a monster, returning", entityName);
			return;
		}
		else
		{
			ExampleMod.logger.debug("entity {} is a monster", entityName);
		}

		final EntityMob monster = (EntityMob) entity;

		if (Math.random() < Configs.helmetChance)
		{
			monster.setItemStackToSlot(EntityEquipmentSlot.HEAD, RandomEquipment.helmet());
			ExampleMod.logger.debug("gave entity {} a helmet", entityName);
		}

		if (Math.random() < Configs.chestplateChance)
		{
			monster.setItemStackToSlot(EntityEquipmentSlot.CHEST, RandomEquipment.chestplate());
			ExampleMod.logger.debug("gave entity {} a chestplate", entityName);
		}

		if (Math.random() < Configs.leggingsChance)
		{
			monster.setItemStackToSlot(EntityEquipmentSlot.LEGS, RandomEquipment.leggings());
			ExampleMod.logger.debug("gave entity {} leggings", entityName);
		}

		if (Math.random() < Configs.bootsChance)
		{
			monster.setItemStackToSlot(EntityEquipmentSlot.FEET, RandomEquipment.boots());
			ExampleMod.logger.debug("gave entity {} boots", entityName);
		}

		if (Math.random() < Configs.weaponChance)
		{
			if (monster instanceof EntityZombie)
			{
				ExampleMod.logger.debug("entity {} is a zombie", entityName);
				((EntityZombie) monster)
					.setHeldItem(EnumHand.MAIN_HAND, (Math.random() > 0.5) ? RandomEquipment.sword() : RandomEquipment.axe());
				ExampleMod.logger.debug("gave entity {} a weapon", entityName);
			}
			else if (monster instanceof EntitySkeleton)
			{
				ExampleMod.logger.debug("entity {} is a skeleton", entityName);
				final ItemStack bow = ((EntitySkeleton) monster).getHeldItemMainhand();
				bow.getItem().setRegistryName("");
				EnchantmentHelper.addRandomEnchantment(new Random(), bow, (int) (Math.random() * 5), true);
				// enchant its bow, give it tipped arrows, etc
				ExampleMod.logger.debug("gave entity {}'s bow an enchantment", entityName);
			}
			else if (monster instanceof EntityCreeper)
			{
				monster.onStruckByLightning(null); // null is fine, the code behind never accesses the object
				// onStruckByLighting sets the entity on fire and deals 5 damage, so revert those actions
				monster.extinguish();
				monster.heal(5);
			}
		}

		if (Math.random() < Configs.shieldChance)
		{
			monster.setHeldItem(EnumHand.OFF_HAND, Util.singleItem(Items.SHIELD));
			ExampleMod.logger.debug("gave entity {} a shield", entityName);
		}
	}
}
