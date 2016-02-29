# recommend
基于网络爬虫及用户的协同过滤推荐算法的电影推荐系统

本系统分为4个模块：

1. 登陆/注册模块     
2. 知乎电影相关热门推荐（十万个为什么）
3. 豆瓣电影相关热门推荐（下载专区）
4. 收藏夹功能（我的收藏）
5. 个性化推荐（个性化推荐）

总体效果图：

![login](https://github.com/OamMot/recommend/blob/master/MovieRec/git_all.png)

模块1简介：

登陆界面为几个人观看电影屏幕为背景进行设计, 用户信息存储在本地

![login](https://raw.githubusercontent.com/OamMot/recommend/master/MovieRec/git_login.png)

模块2简介：

本模块为爬取知乎当天的电影相关的一些热门问题，包括：电影 推荐/台词/评论/审查/频道/作品。

![login](https://raw.githubusercontent.com/OamMot/recommend/master/MovieRec/git_zhihu.png)

![login](https://raw.githubusercontent.com/OamMot/recommend/master/MovieRec/git_zhihu_detail.png)

模块3简介：

本模块为爬取豆瓣电影当天比较热的电影信息，并根据这个电影的信息，去电影天堂搜索该电影的下载链接并下载下来。

![login](https://raw.githubusercontent.com/OamMot/recommend/master/MovieRec/git_movie.png)

![login](https://raw.githubusercontent.com/OamMot/recommend/master/MovieRec/git_movie_detail.png)

模块4简介：

我的收藏功能是在每个信息后面有一颗小星星， 未收藏状态下是灰色，在收藏之后便是黄色。收藏之后可在我的收藏专区查看。

![login](https://github.com/OamMot/recommend/blob/master/MovieRec/git_mylove_movie.png)

![login](https://raw.githubusercontent.com/OamMot/recommend/master/MovieRec/git_mylove_zhihu.png)

模块5简介：

个性化推荐是基于用户的协同过滤推荐算法的，根据用户之间收藏信息的不同进行相关推荐。

![login](https://raw.githubusercontent.com/OamMot/recommend/master/MovieRec/rec.png)



