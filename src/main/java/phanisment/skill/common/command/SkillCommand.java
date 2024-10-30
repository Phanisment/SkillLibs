package phanisment.skill.common.command;

import net.minecraft.entity.player.PlayerEntity;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestions.SuggestionsBuilder;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import static net.minecraft.server.command.CommandManager.literal;

import phanisment.skill.util.SkillRegistery;
import phanisment.skill.lib.Skill;

import java.util.concurrent.CompletableFuture;

public class SkillCommand {
	private static final SuggestionProvider<ServerCommandSource> SKILL_SUGGESTIONS = (context, builder) -> {
		for (String skillName : SkillRegistery.getSkill().keySet()) {
			builder.suggest(skillName);
		}
		return builder.buildFuture();
	};

	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(CommandManager.literal("castSkill")
			.then(CommandManager.argument("Skill", StringArgumentType.word()).suggests(SKILL_SUGGESTIONS)
			.executes(context -> {
				String skillName = StringArgumentType.getString(context, "Skill");
				Skill skill = SkillRegistery.getSkill(skillName);
				PlayerEntity target = context.getSource().getPlayer();
				if (skill != null) {
					skill.cast(target);
					context.getSource().sendMessage(Text.literal("Casting [" + skillName + "]");
				} else {
					context.getSource().sendMessage(Text.literal("Skill not found!").formatted(Formatting.RED));
				}
				return 1;
			}))
		);
	}
}