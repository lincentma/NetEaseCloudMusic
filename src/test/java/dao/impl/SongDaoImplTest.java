package dao.impl;

import model.bean.Song;
import org.junit.Test;

import java.util.List;

/**
 * Created by ml on 2017/7/19.
 */
public class SongDaoImplTest {

    SongDaoImpl songtest = new SongDaoImpl();

    @Test
    public void testSongDaoImpl() {
        Song song = new Song();
        song.setId(490602754);
        song.setSong_name("越过山丘1");
        song.setSinger_name("杨宗纬1");
        songtest.insert(song);
        List<Song> song2 = songtest.getAll();
        for (int i = 0; i < song2.size(); i++) {
            System.out.println(song2.get(i).toString());
        }
    }
}
