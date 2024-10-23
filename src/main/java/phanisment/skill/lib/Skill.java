package phanisment.skill.lib;

import net.minecraft.entity.player.PlayerEntity;

public interface Skill {
	void cast(PlayerEntity player);
	default int getCooldown() {return 0;}
	default float getDamage() {return Float.NaN;}
}