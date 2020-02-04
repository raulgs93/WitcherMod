package com.musgo.examplemod.items;

import com.musgo.examplemod.Main;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.NBTTextComponent;

import java.awt.*;

public class WitcherSword extends SwordItem {

    public WitcherSword(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        Main.LOGGER.info(target.getName().getString() +  " HIT!!!");

        int extraDamage = 0;

        if (target instanceof MonsterEntity){
            extraDamage = 10;
            target.attackEntityFrom(DamageSource.GENERIC, extraDamage);
            Main.LOGGER.debug("Monster hit! extra damage: " +  extraDamage );
        }
        else{
            Main.LOGGER.info("this not a monster! extra damage: " + extraDamage );
        }

        return super.hitEntity(stack, target, attacker);
    }
}

// new SwordItem(ModToolMaterials.silver, 0, 6.0f, new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)).setRegistryName(location(ModItemIDs.WITCHER_SWORD))
