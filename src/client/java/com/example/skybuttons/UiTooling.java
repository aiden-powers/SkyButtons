package com.example.skybuttons;

import com.example.powersaj.StringPair;
import io.wispforest.owo.ui.component.Components;
import io.wispforest.owo.ui.container.Containers;
import io.wispforest.owo.ui.core.Component;
import io.wispforest.owo.ui.core.Insets;
import io.wispforest.owo.ui.core.Sizing;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import java.util.List;

public class UiTooling {

    /**
     * @param buttonName Player-facing button text
     * @param commandExecute Command to execute, "/" not needed.
     * @return Returns button component. Button style: List format.
     */
    static Component makeButtonListEntry(String buttonName, String commandExecute){
        return Components.button(Text.literal(buttonName), button -> {
            assert MinecraftClient.getInstance().player != null;
            MinecraftClient.getInstance().player.networkHandler.sendCommand(commandExecute);
        }).margins(Insets.of(0,3,0,9));
    }

    /**
     * @param buttonName Player-facing button text
     * @param commandExecute Command to execute, "/" not needed.
     * @return Returns button component. Standard button.
     */
    static Component makeButtonEntry(String buttonName, String commandExecute){
        return Components.button(Text.literal(buttonName), button -> {
            assert MinecraftClient.getInstance().player != null;
            MinecraftClient.getInstance().player.networkHandler.sendCommand(commandExecute);
        }).margins(Insets.of(2));
    }

    /**
     * @param listName Name of the list
     * @param buttonNamesListWithCommands List of button names and commands
     * @param openOnStartup If the list should be open on startup
     * @return Returns a list of buttons in a collapsible container.
     * @see #makeButtonList(String, List)
     */
    static Component makeButtonList(String listName, List<StringPair> buttonNamesListWithCommands, boolean openOnStartup){
        return Containers.collapsible(Sizing.content(),Sizing.content(),Text.literal(listName), openOnStartup)
                .child(Containers.verticalFlow(Sizing.content(),Sizing.content())
                        .children(buttonNamesListWithCommands.stream()
                                .map(pair -> makeButtonListEntry(pair.getFirst(), pair.getSecond()))
                                .toList()
                        )
                );
    }

    /**
     * @param listName Name of the list
     * @param buttonNamesListWithCommands List of button names and commands
     * @return Returns a list of buttons in a collapsible container.
     * @see #makeButtonList(String, List, boolean)
     */
    static Component makeButtonList(String listName, List<StringPair> buttonNamesListWithCommands){
        return makeButtonList(listName, buttonNamesListWithCommands, true);
}}
