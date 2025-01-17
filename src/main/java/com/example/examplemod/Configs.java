package com.example.examplemod;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.RangeDouble;
import net.minecraftforge.common.config.Config.SlidingOption;

@Config(modid = ExampleMod.MODID)
public class Configs
{
	@RangeDouble(min = 0, max = 1)
	@SlidingOption
	public static double helmetChance = .1;

	@RangeDouble(min = 0, max = 1)
	@SlidingOption
	public static double chestplateChance = .1;

	@RangeDouble(min = 0, max = 1)
	@SlidingOption
	public static double leggingsChance = .1;

	@RangeDouble(min = 0, max = 1)
	@SlidingOption
	public static double bootsChance = .1;

	@RangeDouble(min = 0, max = 1)
	@SlidingOption
	public static double weaponChance = .1;

	@RangeDouble(min = 0, max = 1)
	@SlidingOption
	public static double shieldChance = .1;
}
