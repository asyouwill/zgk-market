var gulp = require('gulp');
var watch = require('gulp-watch');
var gulpSequence = require('gulp-sequence');
var sass = require('gulp-sass');
var concat = require('gulp-concat');
var cssmin = require('gulp-cssmin');
var uglify = require('gulp-uglify');

var fs = require('fs');
var scssDependenceJson = JSON.parse(fs.readFileSync('scss-concat-config.json'));
var taskArr = [];
var watchTaskArr;
function gulpTask(name, sourceArr){
    gulp.task(name, function(){
        gulp.src(sourceArr)
            .pipe(concat("style.scss"))
            .pipe(sass())
            //.pipe(cssmin())
            .pipe(gulp.dest('dist/css/'+name+'/'));
    })
}
for (var key in scssDependenceJson) {
    taskArr.push(key);
}
watchTaskArr = taskArr.slice();
var taskArrLen = taskArr.length;
for(var i=0; i<taskArrLen; i++){
    gulpTask(taskArr[i], scssDependenceJson[taskArr[i]]);
}

gulp.task('scss', gulpSequence(taskArr))


gulp.task('minifyjs', function() {
    return gulp.src('src/*.js')
        .pipe(concat('main.js'))    //合并所有js到main.js
        .pipe(gulp.dest('minified/js'))    //输出main.js到文件夹
        .pipe(rename({suffix: '.min'}))   //rename压缩后的文件名
        .pipe(uglify())    //压缩
        .pipe(gulp.dest('minified/js'));  //输出
});




gulp.task('watch', function(){
    gulp.watch(['assets/**/*.scss'], watchTaskArr)
});

gulp.task('default', gulpSequence(['scss', 'watch']));



