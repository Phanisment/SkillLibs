package phanisment.skill.example;

import net.minecraft.text.Text;
import net.minecraft.entity.player.PlayerEntity;

import phanisment.skill.util.SkillConfig;
import phanisment.skill.util.SkillRegistery;
import phanisment.skill.lib.Skill;

public class ExampleSkill implements Skill {
	private int cooldown;
	private double damage;

	public ExampleSkill(double damage, int cooldown) {
		this.cooldown = cooldown;
		this.damage = damage;
	}

	@Override
	public void cast(PlayerEntity player) {
		player.sendMessage(Text.literal("Cast Skill"));
	}

	@Override
	public int getCooldown() {
		return 5;
	}

	@Override
	public float getDamage() {
		return 10.0f;
	}

	public static void register() {
		SkillRegistery.register("example", new ExampleSkill(
			SkillConfig.getDamage("example", 1),
			SkillConfig.getCooldown("example", 10)
		));
	}
}