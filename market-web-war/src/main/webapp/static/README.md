technical spike:
由于手机上对web的性能要求较高
看了两个framwork app.js和angular mobile
使用它们确实可以快速构建web app，但由于它是基于单页应用，如果页面很多逻辑逐渐增大的情况下，会使得第一次加载的时候有点慢。
比如js css 图片等需要在第一次访问时候加载完，好处就是浏览其它页面就会快一些。
根据需求我的选择如下：
1.使用gulp构建工具打包css、js等
2.使用sass，可以使每个页面仅仅加载对应的css和所需的图片（import），而且有层级开发起来速度快。
3.使用template7 javascript模版引擎，好处是不用频繁得处理dom的拼接，更注重数据。
4.布局使用flex，保证适配
5.有些地方使用类似bootstrap写法，使之后的开发能快速融入进来

run:
1.npm install
2.gulp
3.





页面view url


register :  login