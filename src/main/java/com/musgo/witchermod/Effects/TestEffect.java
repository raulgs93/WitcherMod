package com.musgo.witchermod.Effects;


import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;

import java.awt.*;



public class TestEffect extends Effect {

    protected TestEffect(final EffectType effectType, final int liquidColor) {
        super(effectType, liquidColor);
    }

    public TestEffect(final EffectType effectType, final int liquidR, final int liquidG, final int liquidB) {
        this(effectType, new Color(liquidR, liquidG, liquidB).getRGB());
    }

    

}
