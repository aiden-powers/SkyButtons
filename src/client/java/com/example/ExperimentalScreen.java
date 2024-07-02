package com.example;

import io.wispforest.owo.ui.base.BaseOwoScreen;
import io.wispforest.owo.ui.container.Containers;
import io.wispforest.owo.ui.container.FlowLayout;
import io.wispforest.owo.ui.core.*;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;


import java.util.List;

import static com.example.UiTooling.makeButtonList;

public class ExperimentalScreen extends BaseOwoScreen<FlowLayout> {

    boolean ifOpenAllOnStartup = true;

    @Override
    protected @NotNull OwoUIAdapter<FlowLayout> createAdapter() {
        return OwoUIAdapter.create(this, Containers::verticalFlow);
    }

    @Override
    protected void build(FlowLayout rootComponent) {

        rootComponent
                .surface(Surface.BLANK)
                .horizontalAlignment(HorizontalAlignment.LEFT)
                .verticalAlignment(VerticalAlignment.CENTER);

        rootComponent
                .child(Containers.verticalScroll(Sizing.fill(35),Sizing.fill(), Containers.verticalFlow(Sizing.content(),Sizing.content())

                        .child(makeButtonList("Common", List.of(
                                new Pair<>("Island", "warp island"),
                                new Pair<>("Garden", "warp garden"),
                                new Pair<>("Dungeon Hub", "warp dungeon_hub"),
                                new Pair<>("Jerry's Workshop", "warp jerry")
                        )))

                        .child(makeButtonList("The Hub", List.of(
                                new Pair<>("Spawn (Default)", "warp hub"),
                                new Pair<>("Museum", "warp museum"),
                                new Pair<>("Sirius Shack", "warp da"),
                                new Pair<>("Hub Crypts", "warp crypts")
                        )))

                        .child(makeButtonList("The Farming Islands", List.of(
                                new Pair<>("Spawn (Default)", "warp barn"),
                                new Pair<>("Mushroom Desert", "warp desert"),
                                new Pair<>("Trapper's Den", "warp trapper")
                        )))

                        .child(makeButtonList("The Park", List.of(
                                new Pair<>("Spawn (Default)", "warp park"),
                                new Pair<>("Howling Cave", "warp howl"),
                                new Pair<>("Jungle Island", "warp jungle")
                        )))

                        .child(makeButtonList("Singular Mines", List.of(
                                new Pair<>("Gold Mine", "warp gold"),
                                new Pair<>("Deep Caverns", "warp deep")
                        )))

                        .child(makeButtonList("Dwarven Mines", List.of(
                                new Pair<>("Spawn (Default)", "warp dwarves"),
                                new Pair<>("The Forge", "warp forge"),
                                new Pair<>("Dwarven Base Camp", "warp basecamp")
                        )))

                        .child(makeButtonList("Crystal Hollows", List.of(
                                new Pair<>("Spawn (Default)", "warp crystals"),
                                new Pair<>("Crystal Nucleus", "warp nucleus")
                        )))

                        .child(makeButtonList("Spider's Den", List.of(
                                new Pair<>("Spawn (Default)", "warp spider"),
                                new Pair<>("Top Of Nest", "warp top"),
                                new Pair<>("Arachne's Sanctuary", "warp arachne")
                        )))

                        .child(makeButtonList("The End", List.of(
                                new Pair<>("Spawn (Default)", "warp end"),
                                new Pair<>("Dragon's Nest", "warp drag"),
                                new Pair<>("Void Sepulture", "warp void")
                        )))

                        .child(makeButtonList("Crimson Isle", List.of(
                                new Pair<>("Spawn (Default)", "warp isle"),
                                new Pair<>("Forgotten Skull", "warp skull"),
                                new Pair<>("Smoldering Tomb", "warp tomb"),
                                new Pair<>("The Wasteland", "warp wasteland"),
                                new Pair<>("Dragontail", "warp dragontail"),
                                new Pair<>("Scarleton", "warp scarleton")
                        )))

        ).margins(Insets.of(0,0,0,0)).alignment(HorizontalAlignment.LEFT,VerticalAlignment.CENTER).surface(Surface.VANILLA_TRANSLUCENT));
}}


