package dev.imguitest;

import foundry.imgui.fabric.api.event.RenderImGuiEventsFabric;
import imgui.ImGui;
import net.fabricmc.api.ClientModInitializer;

public class ImGuiTestMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        RenderImGuiEventsFabric.PRE.register(() -> {
            ImGui.begin("ImGuiTest");
            ImGui.text("Hello from ImGuiTest on 26.2!");
            if (ImGui.button("Click Me")) {
                System.out.println("[ImGuiTest] Button clicked!");
            }
            ImGui.end();
        });
    }
}
