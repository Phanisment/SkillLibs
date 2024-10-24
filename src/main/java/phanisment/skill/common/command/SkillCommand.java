package phanisment.skill.common.command;

import net.minecraft.entity.player.PlayerEntity;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.command.argument.TextArgumentType;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.literal;

import phanisment.skill.util.SkillRegistery;
import phanisment.skill.lib.Skill;

public class SkillCommand {
	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(literal("castSkill")
			.then(CommandManager.argument("skill", TextArgumentType.text())
			.executes(context -> {
				String skillName = TextArgumentType.getTextArgument(context, "skill");
				Skill skill = SkillRegistery.getSkill(skillName);
				PlayerEntity player = context.getSource().getPlayer();
				if (skill != null) {
					skill.cast(player);
					context.getSource().sendFeedback(Text.of("Casting " + skillName), false);
				} else {
					context.getSource().sendError(Text.of("Skill not found!"));
				}
				return 1;
			}))
		);
	}
}
