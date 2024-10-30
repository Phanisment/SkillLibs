package phanisment.skill;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import phanisment.skill.example.ExampleSkill;

public class Skills implements ModInitializer {
	public static final String MOD_ID = "skill_libs";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ExampleSkill.register();
	}
}