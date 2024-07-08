package powersaj.skybuttons;

import powersaj.skybuttons.skybuttons.KeyBindingManager;
import powersaj.skybuttons.skybuttons.ListingScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.ActionResult;


public class ExampleModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        try{
            // Register all keybindings
            KeyBindingManager.registerAll();

            // Check KeyBinding in ClientTick Event
            ClientTickEvents.END_CLIENT_TICK.register(client -> {
                while (KeyBindingManager.openScreenKeyBinding.wasPressed()) {
                    MinecraftClient.getInstance().setScreen(new ListingScreen()); // Change to MyFirstScreen eventually
                }
            });

            AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
                //System.out.println("Player " + player.getName().toString() + " is trying to break block at " + pos.toString());
                return ActionResult.PASS;
            });
        } catch (Exception e) {
	        throw new RuntimeException(e);
        }

    }
}