package phanisment.skill.common.command;

import net.minecraft.entity.player.PlayerEntity;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.literal;

import phanisment.skill.util.SkillRegistery;
import phanisment.skill.lib.Skill;

public class SkillCommand {
	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(literal("castSkill")
			.then(CommandManager.argument("skill", StringArgumentType.string())
			.then(CommandManager.argument("target", EntityArgumentType.entity())
			.executes(context -> {
				String skillName = StringArgumentType.getString(context, "skillName");
				Skill skill = SkillManager.getSkill(skillName);
				PlayerEntity player = context.getSource().getPlayer();
				if (skill != null) {
					if (player != null) {
						skill.cast();
						context.getSource().sendFeedback(Text.of("Casting " + skillName), false);
					} else {
						context.getSource().sendError(Text.of("Target not found!"));
					}
				} else {
					context.getSource().sendError(Text.of("Skill not found!"));
				}
				return 1;
			})))
		);
	}
}
