package io.unioncoder.uniontab.utill;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import io.unioncoder.uniontab.UTab;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class CFGManager {

    private static Configuration config;

    public static void saveDefaultConfig() {
        try {
            if (!UTab.getInstance().getDataFolder().exists())
                UTab.getInstance().getDataFolder().mkdir();
            File file = new File(UTab.getInstance().getDataFolder(), "config.yml");
            if (!file.exists())
                Files.copy(UTab.getInstance().getResourceAsStream("config.yml"), file.toPath(), new java.nio.file.CopyOption[0]);
            loadConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reloadConfig() {
        loadConfig();
    }

    public static void loadConfig() {
        try {
            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(UTab.getInstance().getDataFolder(), "config.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Configuration getConfig() {
        return config;
    }
}
