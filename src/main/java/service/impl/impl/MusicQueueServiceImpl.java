package service.impl.impl;

import model.json.song.search.SongSearchResult;
import service.impl.MusicQueueService;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by ml on 2017/7/20.
 */
public class MusicQueueServiceImpl implements MusicQueueService {

    private static Queue<SongSearchResult> uncrawledMusics = new ConcurrentLinkedQueue<SongSearchResult>();
    private static Queue<String> crawledMusics = new ConcurrentLinkedQueue<String>();

    public static void addUncrawledMusic(SongSearchResult e) {
        uncrawledMusics.offer(e);
    }

    public static SongSearchResult getMusic() {
        if (!uncrawledMusics.isEmpty()) {
            return uncrawledMusics.poll();
        }
        return null;
    }

    public static void addCrawledMusic(String e) {
        crawledMusics.offer(e);
    }

    public static boolean isMusicCrawled(String id) {
        return crawledMusics.contains(id);
    }

    public static boolean isUncrawledMusicQueueEmpty() {
        return uncrawledMusics.isEmpty();
    }

    public static int getCrawledMusicSize() {
        return crawledMusics.size();
    }

    //队列中处理

    //保存到数据库


}
