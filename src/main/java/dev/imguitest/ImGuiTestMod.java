package dev.imguitest;

import imgui.ImGui;
import imgui.ImGuiIO;
import imgui.app.Application;
import imgui.app.Configuration;
import imgui.flag.ImGuiConfigFlags;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class ImGuiTestMod implements ClientModInitializer {

    private static boolean imguiInitialized = false;

    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register((drawContext, tickDeltaManager) -> {
            if (!imguiInitialized) {
                ImGui.createContext();
                ImGuiIO io = ImGui.getIO();
                io.addConfigFlags(ImGuiConfigFlags.NavEnableKeyboard);
                imguiInitialized = true;
            }
            ImGui.newFrame();
            ImGui.begin("ImGuiTest");
            ImGui.text("Hello from ImGuiTest mod on 26.2!");
            if (ImGui.button("Click Me")) {
                System.out.println("[ImGuiTest] Button clicked!");
            }
            ImGui.end();
            ImGui.render();
        });
    }
}
