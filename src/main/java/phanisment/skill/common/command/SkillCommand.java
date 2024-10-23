package phanisment.skill.common.command;
/*
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.CommandSource;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.Collection;

public class SkillCommand {
	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(
			CommandManager.literal("castskill")
				.then(CommandManager.argument("skill", StringArgumentType.string())
					.suggests((context, builder) -> {
						return CommandSource.suggestMatching(SkillManager.getAllSkillNames(), builder);
					})
					.then(CommandManager.argument("target", EntityArgumentType.players())
						.executes(SkillCommand::castSkill))
				)
		);
	}

	private static int castSkill(CommandContext<ServerCommandSource> context) {
		String skillName = StringArgumentType.getString(context, "skill");
		Collection<PlayerEntity> targets = EntityArgumentType.getPlayers(context, "target");
		Skill skill = SkillManager.getSkill(skillName);
		if (skill == null) {
			context.getSource().sendError(Text.literal("Skill not found").formatted(Formatting.RED));
			return 0;
		}
		for (PlayerEntity target : targets) {
			target.sendMessage(Text.literal("Casting " + skillName + " on " + target.getName().getString()).formatted(Formatting.GREEN), false);
			skill.cast();
		}
		return 1;
	}
}
*/