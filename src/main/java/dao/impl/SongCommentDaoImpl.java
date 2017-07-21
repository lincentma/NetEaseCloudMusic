package dao.impl;

import dao.BaseDao;
import dao.SongCommentDao;
import model.bean.SongComment;

import java.util.List;

/**
 * Created by ml on 2017/7/21.
 */
public class SongCommentDaoImpl extends BaseDao<SongComment> implements SongCommentDao {

    public List<SongComment> getAll() {
        return this.findAll();
    }

    public boolean insert(SongComment songComment) {
        return this.save(songComment);
    }
}
