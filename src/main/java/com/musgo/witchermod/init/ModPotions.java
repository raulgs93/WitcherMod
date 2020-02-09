package com.musgo.witchermod.init;

import com.google.common.base.Preconditions;
import com.musgo.witchermod.Main;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import javax.annotation.Nullable;

/**
 * Registers this mod's {@link Potion}s.
 *
 * @author Choonster
 */

@SuppressWarnings("WeakerAccess")
@ObjectHolder(Main.MODID)
public class ModPotions {

    public static final Potion TEST = null;

    public static final Potion LONG_TEST = null;

    public static final Potion STRONG_TEST = null;

    @Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistrationHandler {
        /**
         * Register this mod's {@link Potion}s.
         *
         * @param event The event
         */
        @SubscribeEvent
        public static void registerPotionTypes(final RegistryEvent.Register<Potion> event) {
            final String LONG_PREFIX = "long_";
            final String STRONG_PREFIX = "strong_";

            final int HELPFUL_DURATION_STANDARD = 3600;
            final int HELPFUL_DURATION_LONG = 9600;
            final int HELPFUL_DURATION_STRONG = 1800;

            final int HARMFUL_DURATION_STANDARD = 1800;
            final int HARMFUL_DURATION_LONG = 4800;
            final int HARMFUL_DURATION_STRONG = 900;

            final Potion[] potions = new Potion[]{
                    createPotion(new EffectInstance(Effects.INVISIBILITY, HELPFUL_DURATION_STANDARD)),
                    createPotion(new EffectInstance(Effects.INVISIBILITY, HELPFUL_DURATION_LONG), LONG_PREFIX),
                    createPotion(new EffectInstance(Effects.INVISIBILITY, HELPFUL_DURATION_STRONG, 1), STRONG_PREFIX),
            };

            event.getRegistry().registerAll(potions);
        }

        /**
         * Create a {@link Potion} from the specified {@link EffectInstance}.
         * <p>
         * Uses the {@link Effect}'s registry name as the {@link Potion}'s registry name and base name.
         *
         * @param effectInstance The effect instance
         * @return The potion
         */
        private static Potion createPotion(final EffectInstance effectInstance) {
            return createPotion(effectInstance, null);
        }

        /**
         * Create a {@link Potion} from the specified {@link EffectInstance}
         * <p>
         * Uses the {@link Effect}'s registry name as the {@link Potion}'s registry name (with an optional prefix) and base name (with no prefix).
         *
         * @param effectInstance The effect instance
         * @param namePrefix     The name prefix, if any
         * @return The PotionType
         */
        private static Potion createPotion(final EffectInstance effectInstance, @Nullable final String namePrefix) {
            final ResourceLocation effectName = Preconditions.checkNotNull(effectInstance.getPotion().getRegistryName());

            final ResourceLocation potionName;
            if (namePrefix != null) {
                potionName = new ResourceLocation(effectName.getNamespace(), namePrefix + effectName.getPath());
            } else {
                potionName = effectName;
            }

            // Based on net.minecraft.util.Util.makeTranslationKey. This ensures that the base name is valid in ResourceLocation paths.
            final String potionBaseName = effectName.getNamespace() + "." + effectName.getPath().replace('/', '.');

            return new Potion(potionBaseName, effectInstance).setRegistryName(potionName);
        }
    }
}
