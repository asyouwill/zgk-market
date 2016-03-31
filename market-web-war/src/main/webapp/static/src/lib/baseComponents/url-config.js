/*
 * url配置文件
 * */
//var BASE_URL = 'http://s1.service.zhigaokao.cn'; //正式
//var BASE_URL = 'http://10.136.21.171:8080';  //正式环境
var BASE_URL = 'http://10.136.13.233:8080';  //测试环境
//var BASE_URL2 = 'http://10.254.130.33:8080';  //测试环境(智能填报)
//var BASE_URL = 'http://10.136.56.195:8080';  //开发环境
//var BASE_URL = 'http://172.16.180.150:8086';  //yyp
//var BASE_URL = 'http://127.0.0.1:8080';



var interfaceUrl = {
    /*
     * 高考咨询
     * */
    getGkTopList: BASE_URL + '/gkhot/getGkHotList.do', //头条1
    getGkHotList: BASE_URL + '/gkhot/getGkHotList.do?type=0',//热点0
    getGkHotInfo: BASE_URL + '/gkhot/getGkHotInfo.do',      //咨询详情



    /*
     * 高考日程
     * */
    getScheduleList: BASE_URL + '/schedule/getScheduleList.do', //  高考日程列表
    getScheduleInfo: BASE_URL + '/schedule/getScheduleInfo.do', //  高考日程详情


    /*
     * 政策解读|招办电话
     * */
    getPolicyList: BASE_URL + '/policy/getPolicyList.do',//获取政策解读摘要列表
    getPolicyInfo: BASE_URL + '/policy/getPolicyInfo.do',//根据主键获取政策解读详情
    getGkTelList: BASE_URL + '/phone/getGkPhoneList.do',//获取招办电话列表

    /*
     * 院校信息
     * */
    getProvinceList: BASE_URL + '/university/getRemoteProvinceList.do',   // 省份
    getCollegeList: BASE_URL + '/university/getRemoteDataDictList.do',   // 院校分类type=PROPERTY（院校分类）|type=EDULEVEL（学历层次）|type=FEATURE（院校特征）| type=BATCHTYPE(院校批次)
    getSearchList: BASE_URL + '/university/getRemoteUniversityList.do',  // 院校信息(筛选)查询
    getSchoolDetail: BASE_URL + '/university/getRemoteUniversityById.do', //院校信息详情?universityId=51
    getOpenProfessional: BASE_URL + '/university/getRemoteUniversityMajorListByUniversityId.do',//开设专业
    getRemoteDataDictList: BASE_URL + '/university/getRemoteDataDictList.do?type=UNIVERSITY_MAJOR_TYPE',
    getUniversityMajorEnrollingPlanList: BASE_URL + '/university/getUniversityMajorEnrollingPlanList.do',//院校招生计划列表
    getQueryUniversityPlanChart: BASE_URL + '/university/queryUniversityPlanChart.do',//院校招生计划图标展示(暂时只有2015年数据)
    queryUniversityEnrollingChartList: BASE_URL + '/university/queryUniversityEnrollingChart.do',//录取情况 (院校录取详情)
    getUniversityMajorEnrollingSituationList: BASE_URL + '/university/getUniversityMajorEnrollingSituationList.do',//录取情况 (院校专业录取详情)


    /*
     * 收藏
     * */
    getUserCollectList: BASE_URL + '/userCollection/getUserCollectList.do',   // 收藏列表
    saveUserCollect: BASE_URL + '/userCollection/saveUserCollect.do',//添加收藏
    deleteUserCollect: BASE_URL + '/userCollection/deleteUserCollect.do',//取消收藏
    getIsUniversityCollect: BASE_URL + '/userCollection/isUniversityCollect.do',//判断是否已收藏 1已收藏,0未收藏


    /*
     * 院校招生信息
     * */
    getAdmissionline: BASE_URL + '/admissionline/getYears.do', //院校招生年份
    getLineList: BASE_URL + '/admissionline/getGkAdmissionLineList.do',//招生分数线

    /*
     * 登录|注册
     * */
    postLogin: BASE_URL + '/login/login.do',   // 登录
    postRegisterLogin: BASE_URL + '/register/account.do',   // 注册
    postConfirmAccountCode: BASE_URL + '/register/confirmAccount.do',  // 确认是否注册
    postVerificationCode: BASE_URL + '/captcha/captcha.do',   // 获取手机验证码
    postRetrievePassword: BASE_URL + '/register/retrievePassword.do',   // 获取手机验证码


    /**
     * 提交个人设置中心
     */
    postUpdateUserInfo: BASE_URL + '/info/updateUserInfo.do',   // 获取手机验证码

    /*
     * 在线互动
     * */
    getOnlineInteractive: BASE_URL + '/question/newQuestion.do',//在线互动?startSize=0&endSize=10
    getOnlineHot: BASE_URL + '/question/hotQuestion.do',//热门解答?startSize=0&endSize=10
    getQuestionDetail: BASE_URL + '/question/questionDetail.do',//问题详情?id=3356

    /*
     * 评测
     * */
    postQueryApeskUrl: BASE_URL + '/apesk/queryApeskUrl.do', //专家测评


    /*
     * 高考学堂
     * */
    getTeacherLectureList: BASE_URL + '/video/getGkVideoList.do',//获取高考学堂列表?isIgnore=&page=&rows=&type=
    getMentalityList: BASE_URL + '/video/getGkVideoList.do',//获取心理讲堂列表?isIgnore=&page=&rows=&type=
    getVolunteerForumList: BASE_URL + '/video/getGkVideoList.do',//获取志愿讲堂列表?isIgnore=&page=&rows=&type=
    getRecommendList: BASE_URL + '/video/getGkVideoList.do',//获取推荐学习列表?isIgnore=&page=&rows=&type=


    /*
     * 用户信息
     *
     * */
    getAllRegion: BASE_URL + '/region/getAllRegion.do', //省市区
    getUserInfo: BASE_URL + '/info/getUserInfo.do', //获取用户信息


    /*
     * 高考学堂
     * */
    getVideoDetail: BASE_URL + '/video/getGkVideoInfo.do',//根据id获取视屏详情
    postHitInCount: BASE_URL + '/video/hitInc.do', //视屏访问量?id=
    postUserVideoCollect: BASE_URL + '/userCollection/saveUserCollect.do?type=2', //视屏收藏添加 id

    /*
     * 高考词条
     * */
    getGkEntryList: BASE_URL + '/entry/getGkEntryList.do',//获取高考词条列表page：页rows:条
    getGkEntryInfo: BASE_URL + '/entry/getGkEntryInfo.do',//根据主键获取高考词条详情  id

    //getMapData:'../../mock/zgk-data.json'//智高考首页map地图数据


    /**
     * 职业信息
     */
    getProfessionalList: BASE_URL + '/professional/getProfessionalList.do',//获取职业列表
    getProfessionalInfo: BASE_URL + '/professional/getProfessionalInfo.do',//获取职业详情
    getProfessionCategory: BASE_URL + '/professional/getProfessionCategory.do',//获取职业分类


    /**
     * 志愿填报
     */
    getPredictProbability: BASE_URL + '/predict/predictProbability.do',// 录取难易预测
    getPredictSchoolList: BASE_URL + '/predict/predictSchoolList.do',// 录取难易预测
    getTallyPredictProbability: BASE_URL + '/predict/tallyPredictProbability.do',// 目标定位
    getPredictResults: BASE_URL + '/predict/predictResults.do',// 获取定位结果页


    /**
     * VIP
     */
    getFindProduct: BASE_URL + '/product/findProduct.do',// 获取商品信息
    getCreateOrders: BASE_URL + '/orders/createOrders.do',// 创建订单
    getAccount: BASE_URL + '/vip/getAccount.do',// 获取VIP账户
    upgradeVipByCard: BASE_URL + '/vip/upgradeVipByCard.do', // 升级VIP


    /**
     * 专业信息
     */
    getMajoredCategory: BASE_URL + '/majored/getMajoredCategory.do',// 专业门类查询
    getMajoredCategoryById: BASE_URL + '/majored/getCategoryMajoredList.do',// 单个门类查询
    getMajoredInfoById: BASE_URL + '/majored/getMajoredInfoById.do',// 专业详情
    getMajorOpenUniversityList: BASE_URL + '/majored/getMajorOpenUniversityList.do',// 开设院校
    getMajoredByName: BASE_URL + '/majored/getMajoredByName.do',// 搜索


    /**
     * 用户定位
     */
    postAddFrecast: BASE_URL + '/forecast/addFrecast.do',// 保存定位
    getPerformanceDetail: BASE_URL + '/forecast/getPerformanceDetail.do',// 获取当前用户的成绩明细
    getLastoFrecast: BASE_URL + '/forecast/getLastoFrecast.do',// /forecast/getLastoFrecast.do//获取最后一次目标定位结果
    getFormerYearsAdmission: BASE_URL + '/forecast/getFormerYearsAdmission.do',// /forecast/getLastoFrecast.do

    /**
     * 地区批次线
     */
    getGkAreaBatchInfo: BASE_URL + '/areabatch/getGkAreaBatchInfo.do',// 地区批次线


    postModifyPassword: BASE_URL + '/info/modifyPassword.do',// 修改密码


    /**
     * 智能填报
     */
    getVolunteerReport: BASE_URL +'/report/get/batch.do', // 智能填报
    getVolunteerSchool: BASE_URL +'/report/main.do', // 院校清单
    getSpecialty: BASE_URL +'/report/get/specialty.do', // 获取专业信息
    volunteerSave: BASE_URL +'/report/save.do', // 保存志愿填报
    getVolunteerFinalInfo: BASE_URL +'/report/get/info.do' // 志愿报告结果页


};


module.exports = interfaceUrl;
