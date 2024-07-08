package powersaj.skybuttons.skybuttons;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;


public class KeyBindingManager {
    // Step 1: Declare the KeyBinding
    public static KeyBinding openScreenKeyBinding;

    public static void registerAll() {
        // Step 2: Register the KeyBinding
	    KeyBindingManager.openScreenKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "Open Warp Menu",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_UP,
                "Skybuttons"
        ));
    }
}