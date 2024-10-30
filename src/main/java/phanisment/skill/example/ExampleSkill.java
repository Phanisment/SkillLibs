package phanisment.skill.example;

import net.minecraft.text.Text;
import net.minecraft.entity.player.PlayerEntity;

import phanisment.skill.util.SkillRegistery;
import phanisment.skill.lib.Skill;

public class ExampleSkill implements Skill {
	
	@Override
	public void cast(PlayerEntity player) {
		player.sendMessage(Text.literal("Cast Skill"));
	}

	public static void register() {
		SkillRegistery.register("example", new ExampleSkill());
	}
}