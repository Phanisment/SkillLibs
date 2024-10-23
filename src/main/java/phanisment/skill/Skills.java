package phanisment.skill;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import phanisment.skill.util.SkillConfig;

import java.nio.file.Path;

public class Skills implements ModInitializer {
	public static final String MOD_ID = "skill_libs";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		SkillConfig.loadConfig(Paths.get("config/skill_modifiers.toml"));
		SkillConfig.close();
	}
}