package phanisment.skill.util;

import com.electronwill.nightconfig.core.Config;
import com.electronwill.nightconfig.core.file.FileConfig;
import java.nio.file.Path;

public class SkillConfig {
	private static FileConfig config;

	public static void loadConfig(Path configPath) {
		config = FileConfig.of(configPath);
		config.load();
	}

	public static double getDamage(String skillName, int defaultValue) {
		return config.getOrElse("skills." + skillName + ".damage", defaultValue);
	}

	public static int getCooldown(String skillName, int defaultValue) {
		return config.getOrElse("skills." + skillName + ".cooldown", defaultValue);
	}

	public static void save() {
		config.save();
	}

	public static void close() {
		config.close();
	}
}