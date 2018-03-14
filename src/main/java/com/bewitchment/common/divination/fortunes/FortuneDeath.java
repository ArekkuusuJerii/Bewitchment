package com.bewitchment.common.divination.fortunes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.MinecraftForge;

import javax.annotation.Nonnull;

import com.bewitchment.common.divination.Fortune;

/**
 * Created by Joseph on 1/16/2018.
 */

public class FortuneDeath extends Fortune {

	public FortuneDeath(int weight, String name, String modid) {
		super(weight, name, modid);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public boolean canBeUsedFor(@Nonnull EntityPlayer player) {
		return true;
	}

	@Override
	public boolean canShouldBeAppliedNow(@Nonnull EntityPlayer player) {
		return player.getRNG().nextDouble() < 0.0005d;
	}

	@Override
	public boolean apply(@Nonnull EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(MobEffects.WITHER, 200, 1 + player.world.getDifficulty().ordinal(), false, false));
		return true;
	}

	@Override
	public boolean isNegative() {
		return true;
	}
}
