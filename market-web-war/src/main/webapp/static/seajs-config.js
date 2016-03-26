seajs.config({
    // 基础路径
    base: "/static/",
    // 别名配置
    alias: {
        "$": "bower_components/jquery/dist/jquery.js",
        "bts": "bower_components/bootstrap/dist/js/bootstrap.min.js",
        "utils": "app/js/utils.js",
        "echarts": "bower_components/echarts/echarts-all.js",
        "jqueryUi": "bower_components/jquery-ui/jquery-ui.js",
        "paginator": "app/js/bootstrap-paginator.js"

    },
    preload: ['$'],
    //map,批量更新时间戳
    map: [[/^(.*\.(?:css|js))(.*)$/i, '$1?v=' + new Date().getTime() ]],
    // 文件编码
    charset: 'utf-8'
});
