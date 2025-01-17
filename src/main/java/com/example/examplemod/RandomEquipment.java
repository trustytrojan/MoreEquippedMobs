package com.example.examplemod;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;

public class RandomEquipment
{
	public static final List<Item> HELMETS     = new ArrayList<>(),
								   CHESTPLATES = new ArrayList<>(),
								   LEGGINGS    = new ArrayList<>(),
								   BOOTS       = new ArrayList<>(),
								   SWORDS      = new ArrayList<>(),
								   AXES        = new ArrayList<>();

	public static void registerEquipment()
	{
		final Set<Item> helmets     = new HashSet<>(),
						chestplates = new HashSet<>(),
						leggings    = new HashSet<>(),
						boots       = new HashSet<>(),
						swords      = new HashSet<>(),
						axes        = new HashSet<>();

		for (final Object value : Item.REGISTRY)
		{
			final Item item = (Item) value;
			final ResourceLocation itemName = item.getRegistryName();
			if (item instanceof ItemArmor)
				switch (((ItemArmor) item).getEquipmentSlot())
				{
				case HEAD:
					helmets.add(item);
					ExampleMod.logger.debug("added item {} to helmets", itemName);
					break;
				case CHEST:
					chestplates.add(item);
					ExampleMod.logger.debug("added item {} to chestplates", itemName);
					break;
				case LEGS:
					leggings.add(item);
					ExampleMod.logger.debug("added item {} to leggings", itemName);
					break;
				case FEET:
					boots.add(item);
					ExampleMod.logger.debug("added item {} to boots", itemName);
					break;
				default:
					ExampleMod.logger.debug("item {} can't go on armor slots", itemName);
					break;
				}
			else if (item instanceof ItemSword)
			{
				swords.add(item);
				ExampleMod.logger.debug("added item {} to swords", itemName);
			}
			else if (item instanceof ItemAxe)
			{
				axes.add(item);
				ExampleMod.logger.debug("added item {} to axes", itemName);
			}
		}

		HELMETS.clear();
		CHESTPLATES.clear();
		LEGGINGS.clear();
		BOOTS.clear();
		SWORDS.clear();
		AXES.clear();

		HELMETS.addAll(helmets);
		CHESTPLATES.addAll(chestplates);
		LEGGINGS.addAll(leggings);
		BOOTS.addAll(boots);
		SWORDS.addAll(swords);
		AXES.addAll(axes);
	}

	public static ItemStack helmet()
	{
		return Util.singleItem(Util.randomElement(HELMETS));
	}

	public static ItemStack chestplate()
	{
		return Util.singleItem(Util.randomElement(CHESTPLATES));
	}

	public static ItemStack leggings()
	{
		return Util.singleItem(Util.randomElement(LEGGINGS));
	}

	public static ItemStack boots()
	{
		return Util.singleItem(Util.randomElement(BOOTS));
	}

	public static ItemStack sword()
	{
		return Util.singleItem(Util.randomElement(SWORDS));
	}

	public static ItemStack axe()
	{
		return Util.singleItem(Util.randomElement(AXES));
	}
}
