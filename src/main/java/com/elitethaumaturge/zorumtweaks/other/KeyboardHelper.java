package com.elitethaumaturge.zorumtweaks.other;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;

public class KeyboardHelper {

    private static final long WINDOW = Minecraft.getInstance().getMainWindow().getHandle();

    //Pressing Shift
    @OnlyIn(Dist.CLIENT)
    public static boolean isHoldingShift() {
        return InputMappings.isKeyDown(WINDOW, GLFW.GLFW_KEY_LEFT_SHIFT) || InputMappings.isKeyDown(WINDOW, GLFW.GLFW_KEY_RIGHT_SHIFT);
    }

    //Pressing A
    @OnlyIn(Dist.CLIENT)
    public static boolean isHoldingA() {
        return InputMappings.isKeyDown(WINDOW, GLFW.GLFW_KEY_A) || InputMappings.isKeyDown(WINDOW, GLFW.GLFW_KEY_A);
    }
}
