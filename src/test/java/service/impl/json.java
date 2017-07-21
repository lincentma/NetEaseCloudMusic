package service.impl;

import model.json.song.comment.SongCommentResult;
import model.json.song.search.SongSearchResult;
import org.junit.Test;
import service.impl.impl.HtmlParserServiceImpl;

import java.util.Queue;

/**
 * Created by ml on 2017/7/21.
 */
public class json {
    @Test
    public void parseJosn() {
        HtmlParserServiceImpl parse = new HtmlParserServiceImpl();
        String search = "真的假的";
        Queue<SongSearchResult> result = parse.parseSearchInfo(search);

        System.out.println(result.size());
        System.out.println(result.peek().getArtist_name());
        System.out.println(result.peek().getId());
        System.out.println(result.peek().getSong_name());

    }

    @Test
    public void parseJosn2() {
        HtmlParserServiceImpl parse = new HtmlParserServiceImpl();
        int id = 488733382;
        SongCommentResult result = parse.parseSongInfo(id);
        System.out.println(result.getNewComments().get(1));
    }

}
