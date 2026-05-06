package dev.blavez.crates.di;

import com.google.inject.AbstractModule;
import dev.blavez.crates.config.GeneralConfig;
import dev.blavez.crates.config.MessagesConfig;
import eu.okaeri.configs.ConfigManager;
import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.serdes.OkaeriSerdes;
import eu.okaeri.configs.yaml.bukkit.YamlBukkitConfigurer;
import eu.okaeri.configs.yaml.bukkit.serdes.SerdesBukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class ConfigModule extends AbstractModule {
    private final JavaPlugin plugin;

    public ConfigModule(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void configure() {
        bind(GeneralConfig.class).toProvider(this::createGeneralConfig).asEagerSingleton();
        bind(MessagesConfig.class).toProvider(this::createMessagesConfig).asEagerSingleton();
    }

    private <T extends OkaeriConfig> T createConfig(Class<T> clazz, String fileName, OkaeriSerdes... serdes) {
        return ConfigManager.create(clazz, config -> {
            config.configure(opt -> {
                opt.configurer(new YamlBukkitConfigurer(), serdes);
                opt.bindFile(new File(plugin.getDataFolder(), fileName));
                opt.removeOrphans(true);
            });
            config.saveDefaults();
            config.load(true);
        });
    }

    public GeneralConfig createGeneralConfig() {
        return createConfig(GeneralConfig.class, "general.yml", new SerdesBukkit());
    }

    public MessagesConfig createMessagesConfig() {
        return createConfig(MessagesConfig.class, "messages.yml");
    }
}
