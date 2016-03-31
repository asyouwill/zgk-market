var CommonsChunkPlugin = require("webpack/lib/optimize/CommonsChunkPlugin");
var path = require('path');
var webpack = require('webpack');
module.exports = {
    entry: {
        vipBuy: "./src/assets/js/vip-buy/vip-buy",
        regLogin: "./src/assets/js/reglogin/reglogin",
        modifyUserDetail: './src/assets/js/modify-user-detail/modify-user-detail'
    },
    output: {
        path: path.join(__dirname, "./dist/js"),
        filename: "[name].js"
    },
    resolve: {
        alias: {
            pgwmodal: path.join(__dirname, "./src/lib/PgwModa/pgwmodal.min"),
            commonjs: path.join(__dirname, "./src/assets/js/common/common"),
            urlConfig: path.join(__dirname, "./src/assets/js/common/url-config"),
            cookie: path.join(__dirname, "./src/assets/js/common/cookie"),
            md5: path.join(__dirname, "./src/lib/md5/jQuery.md5"),
            timeFormat: path.join(__dirname, "./src/assets/js/common/timeFormat"),
            util: path.join(__dirname, "./src/lib/baseComponents/common"),
            interfaceUrl: path.join(__dirname, "./src/lib/baseComponents/url-config")
        }
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



