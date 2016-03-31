var gulp = require('gulp');
var watch = require('gulp-watch');
var minifycss = require('gulp-minify-css');
var uglify = require('gulp-uglify');
var rename = require('gulp-rename');
var clean = require('gulp-clean');
var imagemin = require('gulp-imagemin');
var pngquant = require('imagemin-pngquant');
var gutil = require('gulp-util');
var webpack = require('webpack');
var webpackConfig = require('./webpack.config.js');




var paths = {
    srcCss: './src/assets/css/**/*.css',
    srcImg: './src/assets/img/**/*.png',
    srcJs: './src/assets/js/**/*.js',
    distCss: './dist/css',
    distImg: './dist/img',
    distJs: './dist/js'
};

//压缩css
gulp.task('minifycss', function() {
    return gulp.src(paths.srcCss)      //压缩的文件
        .pipe(gulp.dest(paths.distCss))   //输出文件夹
        .pipe(minifycss());   //执行压缩
});

gulp.task('minifyimg', function(){
    return gulp.src(paths.srcImg)
        .pipe(imagemin({
            progressive: true,
            svgoPlugins: [
                {removeViewBox: false},
                {cleanupIDs: false}
            ],
            use: [pngquant()]
        }))
        .pipe(gulp.dest(paths.distImg));
});



//压缩js
gulp.task('minifyjs', function() {
    return gulp.src(paths.srcJs)
        //.pipe(concat('main.js'))    //合并所有js到main.js
        .pipe(rename({suffix: '.min'}))   //rename压缩后的文件名
        .pipe(uglify())    //压缩
        .pipe(gulp.dest(paths.distJs));  //输出
});


// 清空图片、样式、js
gulp.task('clean', function() {
    gulp.src(['./dist'],
        {read: false})
        .pipe(clean());
});



var myDevConfig = Object.create(webpackConfig);
var devCompiler = webpack(myDevConfig);
gulp.task("build-js", function(callback) {
    devCompiler.run(function(err, stats) {
        if(err) throw new gutil.PluginError("webpack:build-js", err);
        gutil.log("[webpack:build-js]", stats.toString({
            colors: true
        }));
        callback();
    });
});

gulp.task('watch',['build-js'],function() {
    gulp.watch(paths.srcCss, ['minifycss']);
    gulp.watch(paths.srcImg, ['minifyimg']);
    //gulp.watch(paths.srcJs, ['minifyjs']);
});


// 默认命令
gulp.task('default',function() {
    //gulp.start('minifycss', 'minifyimg','minifyjs');
    gulp.start('minifycss', 'minifyimg','build-js');
});

