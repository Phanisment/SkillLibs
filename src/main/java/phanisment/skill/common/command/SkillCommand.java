package phanisment.skill.common.command;

import net.minecraft.entity.player.PlayerEntity;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.literal;

import phanisment.skill.util.SkillRegistery;
import phanisment.skill.lib.Skill;

public class SkillCommand {
	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(literal("castSkill")
			.then(CommandManager.argument("skill", StringArgumentType.string())
			.executes(context -> {
				String skillName = StringArgumentType.getString(context, "skill");
				Skill skill = SkillRegistery.getSkill(skillName);
				PlayerEntity player = context.getSource().getPlayer();
				if (skill != null) {
					skill.cast(player);
					context.getSource().sendFeedback(Text.literal("Casting " + skillName), false);
				} else {
					context.getSource().sendError(Text.literal("Skill not found!"));
				}
				return 1;
			}))
		);
	}
}
