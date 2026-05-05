package dev.blavez.crates;

import com.google.inject.Guice;
import com.google.inject.Injector;
import dev.blavez.crates.di.PluginModule;
import org.bukkit.plugin.java.JavaPlugin;

public class Crates extends JavaPlugin {

    private Injector injector;

    @Override
    public void onEnable() {
        injector = Guice.createInjector(new PluginModule(this));

    }

    @Override
    public void onDisable() {

    }
}
