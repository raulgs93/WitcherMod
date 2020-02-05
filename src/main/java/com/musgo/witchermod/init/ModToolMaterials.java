package com.musgo.witchermod.init;


import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum ModToolMaterials implements IItemTier {

    silver(ItemTier.DIAMOND.getAttackDamage(), ItemTier.IRON.getEfficiency(), ItemTier.IRON.getMaxUses(), ItemTier.IRON.getHarvestLevel(), ItemTier.GOLD.getEnchantability(), ModItems.SILVER_INGOT);

    private float attackDamage;
    private float efficiency;
    private int durability;
    private int harvestLevel;
    private int enchantability;
    private Item repairMaterial;

    ModToolMaterials(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Item repairMaterial) {

        this.attackDamage = attackDamage;
        this.efficiency = efficiency;
        this.durability = durability;
        this.harvestLevel = harvestLevel;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getMaxUses() {
        return this.durability;
    }

    @Override
    public float getEfficiency() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(this.repairMaterial);
    }
}
