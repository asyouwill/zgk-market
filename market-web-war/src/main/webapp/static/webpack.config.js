var CommonsChunkPlugin = require("webpack/lib/optimize/CommonsChunkPlugin");
module.exports = {
    entry: {
        vipBuy: "./src/assets/js/vip-buy/vip-buy"
    },
    output: {
        publicPath: "./dist/js/",
        filename: "[name].js"
    },
    plugins: [
        //new CommonsChunkPlugin("admin-commons.js", ["ap1", "ap2"]),
        //new CommonsChunkPlugin("commons.js", ["p1", "p2", "admin-commons.js"])
    ]
};
// 在不同页面用<script>标签引入如下js:
// page1.html: commons.js, p1.js
// page2.html: commons.js, p2.js
// page3.html: p3.js
// admin-page1.html: commons.js, admin-commons.js, ap1.js
// admin-page2.html: commons.js, admin-commons.js, ap2.js



