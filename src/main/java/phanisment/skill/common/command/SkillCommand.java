package phanisment.skill.common.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.literal;

import phanisment.skill.util.SkillRegistery;
import phanisment.skill.lib.Skill;

public class SkillCommand {
	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(literal("castSkill")
			.then(CommandManager.argument("skillName", StringArgumentType.string())
			.executes(context -> {
				String skillName = StringArgumentType.getString(context, "skillName");
				Skill skill = SkillManager.getSkill(skillName);
				if (skill != null) {
					skill.cast();
					context.getSource().sendFeedback(Text.of("Casting " + skillName), false);
				} else {
					context.getSource().sendError(Text.of("Skill not found!"));
				}
				return 1;
			}))
		);
	}
}
