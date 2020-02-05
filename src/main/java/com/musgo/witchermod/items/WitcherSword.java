package com.musgo.witchermod.items;

import com.musgo.witchermod.Main;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.AbstractRaiderEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.DamageSource;

public class WitcherSword extends SwordItem {

    public WitcherSword(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        Main.LOGGER.info(target.getName().getString() +  " HIT!!!");

        int extraDamage = 0;

        if (target instanceof MonsterEntity && !(target instanceof AbstractRaiderEntity)){
            extraDamage = 10;
            target.attackEntityFrom(DamageSource.GENERIC, extraDamage);
            Main.LOGGER.debug("Monster hit! extra damage: " +  extraDamage );
        }
        else if (target instanceof AbstractRaiderEntity){
            Main.LOGGER.debug("Hostile human hit! extra damage: " +  extraDamage );
        }
        else{
            Main.LOGGER.debug("this not a monster! extra damage: " + extraDamage );
        }

        return super.hitEntity(stack, target, attacker);
    }
}


