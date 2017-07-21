package dao;

import model.bean.Song;

import java.util.List;

/**
 * Created by ml on 2017/7/19.
 */
public interface SongDao {
    //查询所有
    public List<Song> getAll();

    //保存操作
    public boolean insert(Song song);
}
