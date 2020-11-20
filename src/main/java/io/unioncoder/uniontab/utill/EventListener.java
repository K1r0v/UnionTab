package io.unioncoder.uniontab.utill;

import io.unioncoder.uniontab.UTab;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.ServerConnectedEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class EventListener implements Listener {
    String server;

    @EventHandler
    public void onJoin(ServerConnectedEvent e) {
        if (UTab.getInstance().getConfig().getBoolean("TabList.Used"))
            if (UTab.getInstance().getConfig().getString("TabList." + e.getServer().getInfo().getName() + ".Header") != null)
                e.getPlayer().setTabHeader((BaseComponent)new TextComponent(UTab.getInstance().getConfig().getString("TabList." + e.getServer().getInfo().getName() + ".Header")
                    .replace("&","§")
                    .replace("{player}", e.getPlayer().getName())
                    .replace("{server}", e.getServer().getInfo().getName())
                    .replace("{ping}", String.valueOf(e.getPlayer().getPing()))
                    .replace("{newline}", "\n")), (BaseComponent)new TextComponent(

                    UTab.getInstance().getConfig().getString("TabList." + e.getServer().getInfo().getName() + ".Footer")
                            .replace("&","§")
                                    .replace("{player}", e.getPlayer().getName())
                                    .replace("{server}", e.getServer().getInfo().getName())
                                    .replace("{ping}", String.valueOf(e.getPlayer().getPing()))
                                    .replace("{newline}", "\n")));
    }
}
