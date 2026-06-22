package dev.imguitest;

import foundry.imguimc.event.ImGuiSetupEvent;
import foundry.imguimc.event.RenderImGuiEvent;
import imgui.ImGui;
import net.fabricmc.api.ClientModInitializer;

public class ImGuiTestMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        RenderImGuiEvent.START.register(() -> {
            ImGui.begin("ImGuiTest");
            ImGui.text("Hello from ImGuiTest on 26.2!");
            if (ImGui.button("Click Me")) {
                System.out.println("[ImGuiTest] Button clicked!");
            }
            ImGui.end();
        });
    }
}
