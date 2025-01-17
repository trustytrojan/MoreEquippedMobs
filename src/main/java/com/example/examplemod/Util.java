package com.example.examplemod;

import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

class Util
{
	static <T> T randomElement(final T[] array)
	{
		return array[(int) (Math.random() * array.length)];
	}

	static <T> T randomElement(final List<T> list)
	{
		return list.get((int) (Math.random() * list.size()));
	}

	static ItemStack singleItem(Item item)
	{
		return new ItemStack(item, 1);
	}
}
