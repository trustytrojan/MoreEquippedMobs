package com.example.examplemod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

class Util {
	static <T> T randomElement(final T[] array) {
		return array[(int) (Math.random() * array.length)];
	}

	static ItemStack singleItem(Item item) {
		return new ItemStack(item, 1);
	}
}
