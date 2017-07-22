# NetEaseCloudMusic
> 自己在准备面试通过做一个网易云音乐评论抓取的demo来复习Java的各种知识。
> 市面上Python的最多，Java的很少，自己动手，丰衣足食

## 功能

输入搜索内容，调用网易云音乐的API接口获取歌曲搜索信息，并对所有歌曲评论信息进行抓取存储到数据库中。

## 如何使用

1. database.sql 创建数据库
2. 修改数据库配置c3p0-config.xml
3. 运行Run，输入搜索内容


## 代码结构
> 熟悉学习了Java的各种层的结构以及他们之间的关系，不得不说，Java的代码结构虽然复杂，复杂的一看就懂~哈哈

    - controller
        - run
    - service
        - serviceimpl
            - DataBaseService
            - HtmlParserService
            - MusicQueueService
        - service
    - model
        - bean
        - json
    - dao
        - annotation
        - daoimpl
            - SongDao
            - CommentDao
        - BaseDao
    - utils
        - Constants
        - EncrypUtil
        - HttpUtil
        - JdbcUtil
    - resouce
        - c3p0-config.xml
        - jdbc.properties
        - log4j.properties
    - test

## 版本迭代

    - 1.0 beta 斯是陋室唯吾德馨

## 相关技术
    - Java
    - MySQL
    - Maven
    - Gson
    - c3p0
    - crypto


## 踩过的坑

- 查询API之前的版本居然返回的结果数和请求的结果数不一样，Get还是没有Post好，还有，请求的偏移值大于你查询的结果总数，API还是会返回给你另外的结果满足数量的要求。
- 评论中emoji表情存储的坑，千万别忘了JDBC的配置[点我](http://blog.csdn.net/applebomb/article/details/52755666)
- 利用注解实现BaseDao，获取表名的时候，是直接获取类还是获取注解呢[点我](http://www.cnblogs.com/fnz0/p/6108047.html)
- 利用反射去循环调用对象的方法
- 更改数据库表字段的编码格式是一件非常痛苦的事情，还不如删了重新建


## TODO

- [ ] 爬虫框架[Webmagic](http://webmagic.io/)
- [ ] 抓取代理设置，反爬策略学习
- [ ] 歌曲、评论数据可视化分析
- [ ] 缓存处理
- [ ] 加密学习

## License

[Apache License](./LICENSE)

## Author

[lincentma](//github.com/lingma1993)
