package com.example;

import com.example.skybuttons.KeyBindingManager;
import com.example.skybuttons.ListingScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.ActionResult;


public class ExampleModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
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
    }
}