package com.example.examplemod;

import java.util.function.Supplier;

import net.minecraft.init.Items;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;

enum RandomWeapon {
    SWORD(() -> {
        final ToolMaterial material = Util.randomElement(ToolMaterial.values());
        if (material == ToolMaterial.WOOD)
            return Util.singleItem(Items.WOODEN_SWORD);
        if (material == ToolMaterial.STONE)
            return Util.singleItem(Items.STONE_SWORD);
        if (material == ToolMaterial.IRON)
            return Util.singleItem(Items.IRON_SWORD);
        if (material == ToolMaterial.DIAMOND)
            return Util.singleItem(Items.DIAMOND_SWORD);
        if (material == ToolMaterial.GOLD)
            return Util.singleItem(Items.GOLDEN_SWORD);
        return ItemStack.EMPTY;
    }),

    AXE(() -> {
        final ToolMaterial material = Util.randomElement(ToolMaterial.values());
        if (material == ToolMaterial.WOOD)
            return Util.singleItem(Items.WOODEN_AXE);
        if (material == ToolMaterial.STONE)
            return Util.singleItem(Items.STONE_AXE);
        if (material == ToolMaterial.IRON)
            return Util.singleItem(Items.IRON_AXE);
        if (material == ToolMaterial.DIAMOND)
            return Util.singleItem(Items.DIAMOND_AXE);
        if (material == ToolMaterial.GOLD)
            return Util.singleItem(Items.GOLDEN_AXE);
        return ItemStack.EMPTY;
    }),
	
	BOW(() -> Util.singleItem(Items.BOW));

	private final Supplier<ItemStack> weaponSupplier;

	private RandomWeapon(final Supplier<ItemStack> weaponSupplier) {
		this.weaponSupplier = weaponSupplier;
	}

	ItemStack get() {
		return weaponSupplier.get();
	}
}