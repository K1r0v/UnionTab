package io.unioncoder.uniontab;

import io.unioncoder.uniontab.utill.CFGManager;
import io.unioncoder.uniontab.utill.EventListener;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;

public class UTab extends Plugin {
    private static UTab instance;

    public void onEnable() {
        CFGManager.saveDefaultConfig();
        getProxy().getPluginManager().registerListener(this, (Listener) new EventListener());
    }

    public UTab() {
        instance = this;
    }
    public static UTab getInstance() {
        return instance;
    }
    public Configuration getConfig() {
        return CFGManager.getConfig();
    }
}
