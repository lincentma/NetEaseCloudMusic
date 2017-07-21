package dao.impl;

import dao.BaseDao;
import dao.SongDao;
import model.bean.Song;

import java.util.List;

/**
 * Created by ml on 2017/7/19.
 */
public class SongDaoImpl extends BaseDao<Song> implements SongDao {
    public List<Song> getAll() {
        return this.findAll();
    }

    public boolean insert(Song song) {
        return this.save(song);
    }
}
