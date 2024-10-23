package phanisment.skill.util;

import java.util.HashMap;
import java.util.Map;

import phanisment.skill.lib.Skill;

public class SkillRegistery {
	private static final Map<String, Skill> skillRegistry = new HashMap<>();

	public static void register(String name, Skill skill) {
		skillRegistry.put(name, skill);
	}

	public static Skill getSkill(String name) {
		return skillRegistry.get(name);
	}
}