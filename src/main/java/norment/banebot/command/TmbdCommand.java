package norment.banebot.command;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import norment.banebot.module.tmdb.*;
import norment.banebot.module.tmdb.data.Movie;
import norment.banebot.module.tmdb.data.Result;

public class TmbdCommand extends Command {
    @Override
    public String getCommand() {
        return "tmdb";
    }

    @Override
    public String getDescription() {
        return "Search tMDB for media/people";
    }

    @Override
    public String[] getUsage() {
        return new String[] {
                "tmdb `<query>`::Search tMDB for `query`",
                "tmdb movie `<movie>`::Search tMDB for a movie titled `movie`",
                "tmdb person `<person>::Search tMDB for a person named `person`"
        };
    }

    @Override
    public void run(GuildMessageReceivedEvent event) {
        Result it = TmdbUtil.search(SearchType.MOVIE, "14 cameras");
        assert it != null;
        System.out.println(it.data);
        System.out.println(it.data.page);
    }
}
