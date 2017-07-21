package service.impl;

import model.json.song.comment.SongCommentResult;
import model.json.song.search.SongSearchResult;

import java.util.Queue;

/**
 * Created by ml on 2017/7/20.
 */
public interface HtmlParserService {

    //歌曲查询信息
    public Queue<SongSearchResult> parseSearchInfo(String search);

    //歌曲评论信息
    public SongCommentResult parseSongInfo(int id);

}
