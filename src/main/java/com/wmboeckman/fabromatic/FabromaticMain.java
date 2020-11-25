package com.wmboeckman.fabromatic;

import com.wmboeckman.fabromatic.init.BlockInit;
import com.wmboeckman.fabromatic.init.EntityInit;
import com.wmboeckman.fabromatic.init.ItemInit;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FabromaticMain implements ModInitializer {

    public static final String MODID = "fabromatic";
    private static final Logger LOGGER = LogManager.getLogger(MODID);

    public static ModConfig config;


    @Override
    public void onInitialize() {
        LOGGER.info("Starting Fabromatic Init...");

        AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

        BlockInit.register();
        ItemInit.register();
        EntityInit.register();

        LOGGER.info("Finished registering Fabromatic content!");
    }
}
