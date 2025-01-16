package com.example.examplemod;

import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;

class RandomArmor {
	static ItemStack helmet() {
		final ArmorMaterial material = Util.randomElement(ArmorMaterial.values());
		if (material == ArmorMaterial.LEATHER)
			return Util.singleItem(Items.LEATHER_HELMET);
		if (material == ArmorMaterial.CHAIN)
			return Util.singleItem(Items.CHAINMAIL_HELMET);
		if (material == ArmorMaterial.IRON)
			return Util.singleItem(Items.IRON_HELMET);
		if (material == ArmorMaterial.GOLD)
			return Util.singleItem(Items.GOLDEN_HELMET);
		if (material == ArmorMaterial.DIAMOND)
			return Util.singleItem(Items.DIAMOND_HELMET);
		return ItemStack.EMPTY;
	}

	static ItemStack chestplate() {
		final ArmorMaterial material = Util.randomElement(ArmorMaterial.values());
		if (material == ArmorMaterial.LEATHER)
			return Util.singleItem(Items.LEATHER_CHESTPLATE);
		if (material == ArmorMaterial.CHAIN)
			return Util.singleItem(Items.CHAINMAIL_CHESTPLATE);
		if (material == ArmorMaterial.IRON)
			return Util.singleItem(Items.IRON_CHESTPLATE);
		if (material == ArmorMaterial.GOLD)
			return Util.singleItem(Items.GOLDEN_CHESTPLATE);
		if (material == ArmorMaterial.DIAMOND)
			return Util.singleItem(Items.DIAMOND_CHESTPLATE);
		return ItemStack.EMPTY;
	}
	
	static ItemStack leggings() {
		final ArmorMaterial material = Util.randomElement(ArmorMaterial.values());
		if (material == ArmorMaterial.LEATHER)
			return Util.singleItem(Items.LEATHER_LEGGINGS);
		if (material == ArmorMaterial.CHAIN)
			return Util.singleItem(Items.CHAINMAIL_LEGGINGS);
		if (material == ArmorMaterial.IRON)
			return Util.singleItem(Items.IRON_LEGGINGS);
		if (material == ArmorMaterial.GOLD)
			return Util.singleItem(Items.GOLDEN_LEGGINGS);
		if (material == ArmorMaterial.DIAMOND)
			return Util.singleItem(Items.DIAMOND_LEGGINGS);
		return ItemStack.EMPTY;
	}
	
	static ItemStack boots() {
		final ArmorMaterial material = Util.randomElement(ArmorMaterial.values());
		if (material == ArmorMaterial.LEATHER)
			return Util.singleItem(Items.LEATHER_BOOTS);
		if (material == ArmorMaterial.CHAIN)
			return Util.singleItem(Items.CHAINMAIL_BOOTS);
		if (material == ArmorMaterial.IRON)
			return Util.singleItem(Items.IRON_BOOTS);
		if (material == ArmorMaterial.GOLD)
			return Util.singleItem(Items.GOLDEN_BOOTS);
		if (material == ArmorMaterial.DIAMOND)
			return Util.singleItem(Items.DIAMOND_BOOTS);
		return ItemStack.EMPTY;
	}
}
