package dao;

import model.bean.SongComment;

import java.util.List;

/**
 * Created by ml on 2017/7/21.
 */
public interface SongCommentDao {
    //查询所有
    public List<SongComment> getAll();

    //保存操作
    public boolean insert(SongComment songComment);
}
