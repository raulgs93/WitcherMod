package com.musgo.witchermod.init;

import com.musgo.witchermod.Effects.TestEffect;
import com.musgo.witchermod.Main;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;



@ObjectHolder(Main.MODID)
public class ModEffects {



    public static final TestEffect TEST = null;

    @Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistrationHandler {
        /**
         * Register this mod's {@link Effect}s.
         *
         * @param event The event
         */


        @SubscribeEvent
        public static void registerPotions(final RegistryEvent.Register<Effect> event) {
            final Effect[] potions = {
                    new TestEffect(EffectType.BENEFICIAL, 2, 2, 2).setRegistryName("test"),
            };

            event.getRegistry().registerAll(potions);
        }
    }
}

