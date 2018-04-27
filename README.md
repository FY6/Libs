# Libs
本人常用开发libs

本常用库，其中包含改装，rxjava和常用的控件，后期将继续维护，写文档；


注意配置文件：


    ext {
    android = [
            compileSdkVersion: 26,
            buildToolsVersion: "26.1.0",
            applicationId    : "com.water.reminder.drinkwater",
            minSdkVersion    : 19,
            targetSdkVersion : 26,
            versionCode      : 2,
            versionName      : "1.0.1"
     ]

    dependencies = [
            "support-v7"            : "com.android.support:appcompat-v7:26.1.0",
            "support-v4"            : "com.android.support:support-v4:26.1.0",
            "design"                : "com.android.support:design:26.1.0",
            "gif"                   : "pl.droidsonroids.gif:android-gif-drawable:+",
            "easyrecyclerview"      : "com.jude:easyrecyclerview:latest.integration",
            "recyclerview"          : "com.android.support:recyclerview-v7:26.1.0",
            "glide"                 : "com.github.bumptech.glide:glide:3.7.0",
            /*动画*/
            "NineOldAndroids"       : "com.nineoldandroids:library:latest.integration",
            /* 视频播放*/
            "squareup"              : "com.squareup:otto:latest.integration",
            "fastjson"              : "com.alibaba:fastjson:latest.integration",
            /*友盟统计*/
            "collectionsUser"       : "com.umeng.analytics:analytics:latest.integration",
            /*模糊渐变清晰的imageview*/
            "blurimageview"         : "com.wingjay:blurimageviewlib:latest.integration",
            /*模式玻璃效果*/
            "blurview"              : "com.eightbitlab:blurview:1.1.2",
            /*圆形图片*/
            "roundedimageview"      : "com.makeramen:roundedimageview:2.2.1",
            /*banner*/
            "convenientbanner"      : "com.bigkoo:convenientbanner:latest.integration",
            /*rx-android-java内存管理*/
            "rxjava"                : 'io.reactivex:rxjava:latest.integration',
            "rxlifecycle"           : 'com.trello:rxlifecycle:latest.integration',
            "rxlifecycle_components": 'com.trello:rxlifecycle-components:latest.integration',
            "Jackson"               : 'com.squareup.retrofit2:converter-gson:2.0.2',
            /*butterknife*/
            "butterknife"           : 'com.jakewharton:butterknife:8.5.1',
            "butterknife-compiler"  : 'com.jakewharton:butterknife-compiler:8.5.1',
            /*alertview*/
            "alertview"             : 'com.bigkoo:alertview:1.0.3',
            /*下拉刷新*/
            "Ultra-Pull-To-Refresh" : 'com.github.wzgiceman:PtrLibrary:v1.0.2',
            /*浮动按钮*/
            "floatingactionbutton"  : 'com.melnykov:floatingactionbutton:1.3.0',
            /*retrofit*/
            "rxjava_adpater"        : 'com.squareup.retrofit2:adapter-rxjava:2.1.0',
            "retrofit"              : 'com.squareup.retrofit2:retrofit:2.1.0',
            "converter-scalars"     : 'com.squareup.retrofit2:converter-scalars:2.0.0',
            /*http输出Log*/
            "logging-interceptor"   : 'com.squareup.okhttp3:logging-interceptor:3.1.2',
            /*数据库*/
            "greenDao"              : 'org.greenrobot:greendao:3.2.0',
            /*图片选择*/
            "takephoto"             : 'com.jph.takephoto:takephoto_library:4.0.3',
            "imagepicker"           : 'com.lzy.widget:imagepicker:0.6.1',
            /*高德地图*/
            "location"              : 'com.amap.api:location:latest.integration',
            /*分包*/
            "multidex"              : 'com.android.support:multidex:1.0.1',
            /*微信支付-分享*/
            "wxpay"                 : 'com.tencent.mm.opensdk:wechat-sdk-android-without-mta:1.3.4',
            /*环信及时通信*/
            "hyphenate"             : 'com.hyphenate:hyphenate-sdk:3.3.1',
            /*ali推送*/
            "aliyun"                : 'com.aliyun.ams:alicloud-android-push:3.1.0',
            /*ali推送辅助*/
            "aliyun_more"           : 'com.aliyun.ams:alicloud-android-third-push:3.0.5@aar',
            /*解密拼音*/
            "pinyin4j"              : 'com.belerweb:pinyin4j:2.5.1',
            /*进度圆圈*/
            "sectorprogressview"    : 'com.timqi.sectorprogressview:library:2.0.0',
            /*photoview查看图片详情*/
            "photoview"             : 'com.github.chrisbanes.photoview:library:1.2.4',
            /*扁平化布局*/
            "flatui"                : 'com.github.eluleci:flatui:3.0.0',
            /*视频播放器-简单*/
            "scalablevideoview"     : 'com.yqritc:android-scalablevideoview:1.0.4',
            /*截图*/
            "android-crop"          : 'com.soundcloud.android:android-crop:1.0.1@aar',
            "gson"                  : 'com.google.code.gson:gson:2.8.2',
            "facebook-ads"          : 'com.facebook.android:audience-network-sdk:4.+',
            "facebook-ays"          : 'com.facebook.android:facebook-android-sdk:4.31.0',
            "multidex"              : 'com.android.support:multidex:+',
          ]

            }
