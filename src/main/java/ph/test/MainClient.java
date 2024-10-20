package ph.test;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.client.network.ClientPlayerEntity;

public class MainClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (client.world != null && !client.isPaused()) {
				handleLeftClick(client);
			}
		});
	}

	private void handleLeftClick(MinecraftClient client) {
		if (client.mouse.wasLeftButtonClicked()) {
			ClientPlayerEntity player = client.player;
			if (player != null) {
				player.sendMessage(Text.literal("Klik kiri terdeteksi!"), true);
			}
		}
	}
}