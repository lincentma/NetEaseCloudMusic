package controller;

import model.json.song.comment.SongCommentResult;
import model.json.song.search.SongSearchResult;
import service.impl.impl.DataBaseServiceImpl;
import service.impl.impl.HtmlParserServiceImpl;
import service.impl.impl.MusicQueueServiceImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ml on 2017/7/19.
 */
public class Run {

    //音乐信息队列
    public static MusicQueueServiceImpl musicQueue;

    public static void main(String[] args) {
        //获取输入搜索信息
        Scanner sc = new Scanner(System.in);
        String str = null;
        str = sc.nextLine();

        //处理搜索结果
        HtmlParserServiceImpl htmlParserService = new HtmlParserServiceImpl();
        List<SongSearchResult> song = htmlParserService.parseSearchInfo(str);


        //线程
        ExecutorService musicService = Executors.newFixedThreadPool(5);


        ProducerThread producer = new ProducerThread(song);
        ConsumerThread consumer = new ConsumerThread();

        musicService.submit(producer);
        musicService.submit(consumer);
        musicService.submit(consumer);
        musicService.submit(consumer);
        musicService.shutdown();

    }

    static class ProducerThread implements Runnable {
        private List<SongSearchResult> song = new LinkedList<SongSearchResult>();

        public ProducerThread(List<SongSearchResult> song) {
            this.song = song;
        }

        public void run() {
            //1、结果插入队列
            //2、结果插入数据库
            DataBaseServiceImpl dataBaseService = new DataBaseServiceImpl();
            for (int i = 0; i < song.size(); i++) {
                try {
                    musicQueue.addUncrawledMusic(song.get(i));
                    dataBaseService.saveSong(song.get(i));
                    Thread.sleep(200); //模拟慢速的生产，产生阻塞的效果
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                System.out.println("OK");
            }

        }
    }

    static class ConsumerThread implements Runnable {
        DataBaseServiceImpl dataBaseService = new DataBaseServiceImpl();
        HtmlParserServiceImpl htmlParserService = new HtmlParserServiceImpl();

        public void run() {
            //1、取队列结果
            //2、插入数据库


            while (!musicQueue.isUncrawledMusicQueueEmpty()) {
                try {
                    SongSearchResult song = musicQueue.getMusic();
                    //判读是否处理过
                    if (!musicQueue.isMusicCrawled(String.valueOf(song.getId()))) {
                        SongCommentResult comment = htmlParserService.parseSongInfo(song.getId());
                        dataBaseService.saveComment(comment);
                        musicQueue.addCrawledMusic(song);
                    }
                    Thread.sleep(100);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Done");

            }

        }
    }

}


//1、输入搜索内容

//2、查找搜索歌曲信息，生成队列

//3、多线程去队列中解析评论

//线程池多线程去操作队列
