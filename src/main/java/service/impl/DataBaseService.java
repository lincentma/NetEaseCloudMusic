package service.impl;

import model.json.song.comment.SongCommentResult;
import model.json.song.search.SongSearchResult;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by ml on 2017/7/21.
 */
public interface DataBaseService {
    //保存歌曲信息
    public boolean saveSong(SongSearchResult songSearchResult);

    //保存歌曲评论信息
    public boolean saveComment(SongCommentResult songCommentResult) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}
