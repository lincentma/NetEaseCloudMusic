package service.impl.impl;

import dao.impl.SongCommentDaoImpl;
import dao.impl.SongDaoImpl;
import model.bean.Song;
import model.bean.SongComment;
import model.json.song.comment.SongCommentResult;
import model.json.song.search.SongSearchResult;
import service.impl.DataBaseService;
import utils.Constants;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by ml on 2017/7/21.
 */
public class DataBaseServiceImpl implements DataBaseService {
    public boolean saveSong(SongSearchResult songSearchResult) {
        Song song = new Song();
        SongDaoImpl songDaoImpl = new SongDaoImpl();
        //转换对象
        song.setId(songSearchResult.getId());
        song.setSong_name(songSearchResult.getSong_name());
        song.setSinger_name(songSearchResult.getArtist_name());
        return songDaoImpl.save(song);
    }

    public boolean saveComment(SongCommentResult songCommentResult) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        SongComment songComment = new SongComment();
        SongCommentDaoImpl songCommentDaoImpl = new SongCommentDaoImpl();
        //转换对象
        songComment.setId(songCommentResult.getId());
        songComment.setTotal(songCommentResult.getTotal());
        //反射调用方法
        for (int i = 0; i < Constants.HOT_NUM; i++) {
            String hotComment = "";
            Class clazz = songComment.getClass();
            String funcName = Constants.FUNC_HOT + String.valueOf(i + 1);
            Method setHot = clazz.getDeclaredMethod(funcName, String.class);
            if (i < songCommentResult.getHotComments().size()) {
                hotComment = songCommentResult.getHotComments().get(i);
            } else {
                hotComment = "";
            }
            setHot.invoke(songComment, hotComment);
        }
        for (int j = 0; j < Constants.NEW_NUM; j++) {
            String newComment = "";
            Class clazz = songComment.getClass();
            String funcName = Constants.FUNC_NEW + String.valueOf(j + 1);
            Method setHot = clazz.getDeclaredMethod(funcName, String.class);
            if (j < songCommentResult.getNewComments().size()) {
                newComment = songCommentResult.getNewComments().get(j);
            } else {
                newComment = "";
            }
            setHot.invoke(songComment, newComment);
        }
        return songCommentDaoImpl.save(songComment);
    }
}
