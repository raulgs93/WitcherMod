package com.musgo.witchermod.Effects;


import com.musgo.witchermod.Main;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;

import javax.annotation.Nullable;
import java.awt.*;



public class TestEffect extends Effect {

    protected TestEffect(final EffectType effectType, final int liquidColor) {
        super(effectType, liquidColor);
    }

    public TestEffect(final EffectType effectType, final int liquidR, final int liquidG, final int liquidB) {
        this(effectType, new Color(liquidR, liquidG, liquidB).getRGB());
    }


    @Override
    public boolean isInstant() {
        return  false;
    }

    @Override
    public boolean isReady(int duration, int amplifier) {

        if (duration >= 0){
            Main.LOGGER.debug("Duration is " + duration);
            return true;
        }
        return false;
    }

    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
        Main.LOGGER.info("Setting " + entityLivingBaseIn.getName().getFormattedText() + " on fire");
        entityLivingBaseIn.setFire(1);
    }




}
