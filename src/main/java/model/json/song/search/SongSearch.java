package model.json.song.search;

import java.util.List;

/**
 * Created by ml on 2017/7/21.
 */
public class SongSearch {

    /**
     * result : {"songCount":1500,"songs":[{"id":32957315,"name":" 明天","artists":[{"id":1087604,"name":"李伦","picUrl":null}],"album":{"id":3175058,"name":"明天","artist":{"id":0,"name":"","picUrl":null},"picUrl":"http://p1.music.126.net/E4eE4EYBAzJEFQifJGwvRg==/7985752953418966.jpg"},"audio":"http://m2.music.126.net/CDFfi2rhXwaO0_ArmGUglg==/7979155883675126.mp3","djProgramId":0,"page":"http://music.163.com/m/song/32957315"},{"id":427016416,"name":"明天","artists":[{"id":12111121,"name":"$$ SQUAD","picUrl":null},{"id":12198387,"name":"A$en","picUrl":null},{"id":404508,"name":"MKN","picUrl":null},{"id":12110093,"name":"Lil K","picUrl":null},{"id":12459364,"name":"徐添寒","picUrl":null}],"album":{"id":34847218,"name":"明天","artist":{"id":0,"name":"","picUrl":null},"picUrl":"http://p1.music.126.net/o7hvCHLh72aez8ZK2bXilA==/18267286184305038.jpg"},"audio":"http://m2.music.126.net/HgXzAs0niL3_efOOS3jdsA==/1382086130848332.mp3","djProgramId":0,"page":"http://music.163.com/m/song/427016416"},{"id":481537328,"name":"明天","artists":[{"id":122455,"name":"群星","picUrl":null}],"album":{"id":35562356,"name":"明天","artist":{"id":0,"name":"","picUrl":null},"picUrl":"http://p1.music.126.net/mWWn7vyiCJtLbZKGfjUfhg==/18784056650841323.jpg"},"audio":"http://m2.music.126.net/B0GJueRTv7qsQOf35Oojpg==/18674105488659156.mp3","djProgramId":0,"page":"http://music.163.com/m/song/481537328"},{"id":457120619,"name":"明天","artists":[{"id":12277861,"name":"王兆年","picUrl":null}],"album":{"id":35153987,"name":"明天","artist":{"id":0,"name":"","picUrl":null},"picUrl":"http://p1.music.126.net/VrhHHDkUM0YQpkvmFEL23g==/109951162852912529.jpg"},"audio":"http://m2.music.126.net/V_io0HH3-Fer5ZUR1DjSDw==/18714787418141333.mp3","djProgramId":0,"page":"http://music.163.com/m/song/457120619"}]}
     * code : 200
     */

    private ResultBean result;
    private int code;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class ResultBean {
        /**
         * songCount : 1500
         * songs : [{"id":32957315,"name":" 明天","artists":[{"id":1087604,"name":"李伦","picUrl":null}],"album":{"id":3175058,"name":"明天","artist":{"id":0,"name":"","picUrl":null},"picUrl":"http://p1.music.126.net/E4eE4EYBAzJEFQifJGwvRg==/7985752953418966.jpg"},"audio":"http://m2.music.126.net/CDFfi2rhXwaO0_ArmGUglg==/7979155883675126.mp3","djProgramId":0,"page":"http://music.163.com/m/song/32957315"},{"id":427016416,"name":"明天","artists":[{"id":12111121,"name":"$$ SQUAD","picUrl":null},{"id":12198387,"name":"A$en","picUrl":null},{"id":404508,"name":"MKN","picUrl":null},{"id":12110093,"name":"Lil K","picUrl":null},{"id":12459364,"name":"徐添寒","picUrl":null}],"album":{"id":34847218,"name":"明天","artist":{"id":0,"name":"","picUrl":null},"picUrl":"http://p1.music.126.net/o7hvCHLh72aez8ZK2bXilA==/18267286184305038.jpg"},"audio":"http://m2.music.126.net/HgXzAs0niL3_efOOS3jdsA==/1382086130848332.mp3","djProgramId":0,"page":"http://music.163.com/m/song/427016416"},{"id":481537328,"name":"明天","artists":[{"id":122455,"name":"群星","picUrl":null}],"album":{"id":35562356,"name":"明天","artist":{"id":0,"name":"","picUrl":null},"picUrl":"http://p1.music.126.net/mWWn7vyiCJtLbZKGfjUfhg==/18784056650841323.jpg"},"audio":"http://m2.music.126.net/B0GJueRTv7qsQOf35Oojpg==/18674105488659156.mp3","djProgramId":0,"page":"http://music.163.com/m/song/481537328"},{"id":457120619,"name":"明天","artists":[{"id":12277861,"name":"王兆年","picUrl":null}],"album":{"id":35153987,"name":"明天","artist":{"id":0,"name":"","picUrl":null},"picUrl":"http://p1.music.126.net/VrhHHDkUM0YQpkvmFEL23g==/109951162852912529.jpg"},"audio":"http://m2.music.126.net/V_io0HH3-Fer5ZUR1DjSDw==/18714787418141333.mp3","djProgramId":0,"page":"http://music.163.com/m/song/457120619"}]
         */

        private int songCount;
        private List<SongsBean> songs;

        public int getSongCount() {
            return songCount;
        }

        public void setSongCount(int songCount) {
            this.songCount = songCount;
        }

        public List<SongsBean> getSongs() {
            return songs;
        }

        public void setSongs(List<SongsBean> songs) {
            this.songs = songs;
        }

        public static class SongsBean {
            /**
             * id : 32957315
             * name :  明天
             * artists : [{"id":1087604,"name":"李伦","picUrl":null}]
             * album : {"id":3175058,"name":"明天","artist":{"id":0,"name":"","picUrl":null},"picUrl":"http://p1.music.126.net/E4eE4EYBAzJEFQifJGwvRg==/7985752953418966.jpg"}
             * audio : http://m2.music.126.net/CDFfi2rhXwaO0_ArmGUglg==/7979155883675126.mp3
             * djProgramId : 0
             * page : http://music.163.com/m/song/32957315
             */

            private int id;
            private String name;
            private AlbumBean album;
            private String audio;
            private int djProgramId;
            private String page;
            private List<ArtistsBean> artists;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public AlbumBean getAlbum() {
                return album;
            }

            public void setAlbum(AlbumBean album) {
                this.album = album;
            }

            public String getAudio() {
                return audio;
            }

            public void setAudio(String audio) {
                this.audio = audio;
            }

            public int getDjProgramId() {
                return djProgramId;
            }

            public void setDjProgramId(int djProgramId) {
                this.djProgramId = djProgramId;
            }

            public String getPage() {
                return page;
            }

            public void setPage(String page) {
                this.page = page;
            }

            public List<ArtistsBean> getArtists() {
                return artists;
            }

            public void setArtists(List<ArtistsBean> artists) {
                this.artists = artists;
            }

            public static class AlbumBean {
                /**
                 * id : 3175058
                 * name : 明天
                 * artist : {"id":0,"name":"","picUrl":null}
                 * picUrl : http://p1.music.126.net/E4eE4EYBAzJEFQifJGwvRg==/7985752953418966.jpg
                 */

                private int id;
                private String name;
                private ArtistBean artist;
                private String picUrl;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public ArtistBean getArtist() {
                    return artist;
                }

                public void setArtist(ArtistBean artist) {
                    this.artist = artist;
                }

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public static class ArtistBean {
                    /**
                     * id : 0
                     * name :
                     * picUrl : null
                     */

                    private int id;
                    private String name;
                    private Object picUrl;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public Object getPicUrl() {
                        return picUrl;
                    }

                    public void setPicUrl(Object picUrl) {
                        this.picUrl = picUrl;
                    }
                }
            }

            public static class ArtistsBean {
                /**
                 * id : 1087604
                 * name : 李伦
                 * picUrl : null
                 */

                private int id;
                private String name;
                private Object picUrl;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public Object getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(Object picUrl) {
                    this.picUrl = picUrl;
                }
            }
        }
    }
}
