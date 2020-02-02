package com.musgo.examplemod;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Main.MODID)
public class Main {

    public static final String MODID = "examplemod";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public Main() {
        LOGGER.info("Hello from the Constructor");
    }

}
