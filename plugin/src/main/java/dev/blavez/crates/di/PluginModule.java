package dev.blavez.crates.di;

import com.google.inject.AbstractModule;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginModule extends AbstractModule {

    private final JavaPlugin plugin;

    public PluginModule(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void configure() {
        bind(JavaPlugin.class).toInstance(plugin);

    }

}
