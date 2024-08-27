package me.zipestudio.itemvanisher.client;

import lombok.Getter;
import me.zipestudio.itemvanisher.config.IVConfig;
import me.zipestudio.itemvanisher.keybinding.IVKeyBindingManager;
import net.fabricmc.api.ClientModInitializer;

public class IVClient implements ClientModInitializer {

    @Getter
    private static IVConfig clientConfig;

    @Override
    public void onInitializeClient() {
        IVKeyBindingManager.register();

        clientConfig = IVConfig.getInstance();
    }

}
