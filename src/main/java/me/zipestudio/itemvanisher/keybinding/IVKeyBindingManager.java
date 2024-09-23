package me.zipestudio.itemvanisher.keybinding;

import me.zipestudio.itemvanisher.client.IVClient;
import me.zipestudio.itemvanisher.config.IVConfig;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.lwjgl.glfw.GLFW;

public class IVKeyBindingManager {


    public static final KeyBinding IV_TOGGLE_KEYBINDING = new KeyBinding(
            "itemvanisher.key.toggle",
            InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_I,
            "Item Vanisher"
    );

    public static void register() {
        registerDefaultKeys();

        ClientTickEvents.START_CLIENT_TICK.register((client -> {

            if (IV_TOGGLE_KEYBINDING.wasPressed()) {
                if (client.player == null) {
                    return;
                }

                IVConfig clientConfig = IVClient.getClientConfig();
                boolean toggle = !clientConfig.isToggle();
                clientConfig.setToggle(toggle);

                client.player.sendMessage(Text.translatable("itemvanisher.text.actionbar." + toggle), true);
            }

        }));
    }

    private static void registerDefaultKeys() {
        registerKeyBinding(IV_TOGGLE_KEYBINDING);
    }

    public static void registerKeyBinding(KeyBinding keyBinding) {
        KeyBindingHelper.registerKeyBinding(keyBinding);
    }
}
