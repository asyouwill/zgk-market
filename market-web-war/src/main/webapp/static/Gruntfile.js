"use strict";

module.exports = function (grunt) {
    // 时间任务花多长时间,可以帮助优化构建
    require('time-grunt')(grunt);
    // 自动加载任务
    require('load-grunt-tasks')(grunt);
    // 配置路径
    var config = {
        app: 'app',
        dist: 'dist',
        bower_components: 'bower_components'
    };
    // 定义所有任务配置
    grunt.initConfig({
        // 项目设置
        config: config,
        // 监听文件的变化和运行
        watch: {
            gruntfile: {
                files: ['Gruntfile.js']
            },
            sass: {
                files: ['<%= config.app %>/css/{,*/}*.{scss,sass}'],
                tasks: ['sass', 'autoprefixer']
            },
            js: {
                files: ['<%= config.app %>/js/{,*/}*.js'],
                tasks: ['uglify']
            },
            imagemin: {
                files: ['<%= config.app %>/images/{,*/}*.{jpg,png,gif}'],
                tasks: ['imagemin']
            },
            livereload: {
                files: [  //下面文件的改变就会实时刷新网页
                    '<%= config.app %>/css/{,*/}*.css',
                    '<%= config.app %>/js/{,*/}*.js',
                    '<%= config.app %>/images/{,*/}*.{png,jpg,gif}'
                ]
            }
        },
        // 清空文件夹重新开始
        clean: {
            dist: {
                src: ['<%= config.dist %>/**/*'],
                filter: 'isFile' // 保留文件夹
            }
        },
        // 编译sass css生成文件
        sass: {
            dist: {
                options: {
                    style: 'compressed'
                },
                files: [{
                    expand: true,
                    cwd: '<%= config.app %>/css',
                    src: ['*.scss'],
                    dest: '<%= config.dist %>/css',
                    ext: '.min.css'
                }]
            }
        },
        // 添加供应商前缀的样式
        autoprefixer: {
            options: {
                browsers: ['> 1%', 'last 2 versions', 'Firefox ESR', 'Opera 12.1']
            },
            dist: {
                files: [{
                    expand: true,
                    cwd: '<%= config.dist %>/css/',
                    src: '{,*/}*.css',
                    dest: '<%= config.dist %>/css/'
                }]
            }

        },
        // 压缩*-min 文件
        imagemin: {
            /* 压缩图片大小 */
            dist: {
                files: [{
                    expand: true,
                    cwd: "<%= config.app %>/images/",
                    src: ["**/*.{jpg,png,gif}"],
                    dest: "<%= config.dist %>/images/"
                }]
            }
        },
        // 压缩
        uglify: {
            javascript: {//任务三：按原文件结构压缩js文件夹内所有JS文件
                options: {
                    report: "min",//输出压缩率，可选的值有 false(不输出信息)，gzip
                    // 不混淆变量名
                    mangle: false
                },
                files: [{
                    expand: true,
                    cwd: ['<%= config.app %>/js'],
                    src: '*.js',
                    dest: '<%= config.dist %>/js',
                    ext: '.js'
                }]
            }
        },
        // 复制文件
        copy: {
            dist: {
                files: [{
                    expand: true,
                    cwd: '<%= config.app %>', // src 相对src 询问路径
                    src: '**/*.*',
                    dest: '<%= config.dist %>'
                    //ext: '.js'//是否修改文件的后缀名
                }]
            }
        },
        jshint: {
            files: [/*'Gruntfile.js',*/ '<%= config.app %>/js/*.js'/*, 'dist/js*//*.js'*/],
            options: {
                globals: {
                    exports: true
                }
            }
        },
        concat: {
            options: {
                //定义一个字符串插入没个文件之间用于连接输出
                separator: ';'
            },
            dist: {
                src: ['<%= config.app %>/**/*.js'],
                dest: '<%= config.dist %>/js/main.concat.js'
            }
        },
        rev: {
            options: {
                encoding: 'utf8',
                algorithm: 'md5',
                length: 8
            },
            assets: {
                files: [{
                    src: [
                        '<%= config.dist %>/images/**/*.{jpg,jpeg,gif,png}',
                        '<%= config.dist %>/**/*.css',
                        '<%= config.dist %>/**/**/*.js'
                    ]
                }]
            }
        }
    });
    grunt.registerTask('default',
        ['clean:dist', 'copy:dist', 'sass', 'autoprefixer', 'imagemin', 'uglify']
    );

    grunt.registerTask('live', ['watch']);

};