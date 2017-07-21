package service.impl;

import model.json.song.comment.SongCommentResult;
import model.json.song.search.SongSearchResult;
import org.junit.Test;
import service.impl.impl.DataBaseServiceImpl;
import service.impl.impl.HtmlParserServiceImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by ml on 2017/7/21.
 */
public class database {
    @Test
    public void insert1() {
        HtmlParserServiceImpl parse = new HtmlParserServiceImpl();
        String search = "真的假的";
        List<SongSearchResult> result = parse.parseSearchInfo(search);

        DataBaseServiceImpl dataBaseServiceImpl = new DataBaseServiceImpl();

        for (SongSearchResult song : result) {
            System.out.println(dataBaseServiceImpl.saveSong(song));
        }


    }

    @Test
    public void insert2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        HtmlParserServiceImpl parse = new HtmlParserServiceImpl();
        int id = 488733382;
        SongCommentResult result = parse.parseSongInfo(id);
        DataBaseServiceImpl dataBaseServiceImpl = new DataBaseServiceImpl();
        System.out.println(dataBaseServiceImpl.saveComment(result));

    }

}
