package ph.test;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;

public class MainClient extends ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (client.world != null && !client.isPaused()) {
				action(client);
			}
		});
	}
	
	private void action(MinecraftClient client) {
		if (InputUtil.isMouseButtonPressed(client.getWindow().getHandle(), GLFW.GLFW_MOUSE_BUTTON_LEFT)) {
			ClientPlayerEntity player = client.player;
			if (player != null) {
				if (!client.world.isClient) {
					player.sendMessage(Text.literal("Klik kiri terdeteksi!"), true);
				}
			}
		}
	}
}