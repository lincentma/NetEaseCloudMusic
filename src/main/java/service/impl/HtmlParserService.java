package service.impl;

import model.json.song.comment.SongCommentResult;
import model.json.song.search.SongSearchResult;

import java.util.List;

/**
 * Created by ml on 2017/7/20.
 */
public interface HtmlParserService {

    //歌曲查询信息
    public List<SongSearchResult> parseSearchInfo(String search);

    //歌曲评论信息
    public SongCommentResult parseSongInfo(int id);

}
