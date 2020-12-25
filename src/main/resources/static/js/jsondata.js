/*
 * Copyright (c) 2020 ZHANGDI. All Rights Reserved.
 * 作者：ZhangDi
 * 日期：2020-06-12 12:16
 * 项目：Simple-So
 * URL：https://github.com/zzd/Simple-So
 * 请勿删除版权。Do not delete copyright.
 */

const search_engine = {
    'baidu': ["https://www.baidu.com/s", "wd", "百度一下，你就知道"],
    'google': ['https://www.google.com/search', 'q', "Google 搜索"],
    'bing': ['https://cn.bing.com/search', 'q', "微软 Bing"],
    '360': ['https://www.so.com/s', 'q', "360搜索，SO靠谱"],
    'sougou': ['https://www.sogou.com/web', 'query', "上网从搜狗开始"],
    'dogedoge': ['https://www.dogedoge.com/results', 'q', "不追踪，不误导"],
    'scholar': ['https://scholar.google.com/scholar', 'q', "谷歌学术"]
};

const jsonData = [
    {
        "icon": "icon-sousuo1",
        "title": "常用/搜索",
        "node": [
            {
                "url": "https://www.baidu.com/",
                "icon": "icon-baidu",
                "text": "百度"
            },
            {
                "url": "https://www.google.com/",
                "icon": "icon-google",
                "text": "谷歌"
            },
            {
                "url": "https://github.com",
                "icon": "icon-gitHub",
                "text": "GitHub"
            },
            {
                "url": "https://wx.qq.com/",
                "icon": "icon-weixin",
                "text": "微信"
            },
            {
                "url": "https://weibo.com/",
                "icon": "icon-weibo",
                "text": "微博"
            },
            {
                "url": "https://tieba.baidu.com/",
                "icon": "icon-baidutieba",
                "text": "贴吧"
            },
            {
                "url": "https://mail.163.com/",
                "icon": "icon-wangyi",
                "text": "网易邮箱"
            },
            {
                "url": "https://mail.google.com/",
                "icon": "icon-Gmail",
                "text": "Gmail"
            },
            {
                "url": "https://outlook.live.com/mail/",
                "icon": "icon-outlook_x",
                "text": "Outlook"
            }
        ]
    },
    {
        "icon": "icon-shipin1",
        "title": "视频/直播",
        "node": [
            {
                "url": "https://www.youtube.com/",
                "icon": "icon-youtube",
                "text": "YouTube"
            },
            {
                "url": "https://www.bilibili.com/",
                "icon": "icon-bilibili",
                "text": "哔哩哔哩"
            },
            {
                "url": "https://www.youku.com/",
                "icon": "icon-youku",
                "text": "优酷"
            },
            {
                "url": "https://v.qq.com/",
                "icon": "icon-tengxunshipin",
                "text": "腾讯视频"
            },
            {
                "url": "https://www.iqiyi.com/",
                "icon": "icon-aiqiyi",
                "text": "爱奇艺"
            },
            {
                "url": "https://www.huya.com/",
                "icon": "icon-huyazhibo",
                "text": "虎牙直播"
            },
            {
                "url": "https://www.douyu.com/",
                "icon": "icon-douyuTV",
                "text": "斗鱼直播"
            },
            {
                "url": "https://egame.qq.com/",
                "icon": "icon-fangqiedianjing",
                "text": "企鹅电竞"
            },
            {
                "url": "http://www.zmz2019.com/",
                "icon": "icon-zimu",
                "text": "人人影视"
            }
        ]
    },
    {
        "icon": "icon-bangong",
        "title": "办公/设计",
        "node": [
            {
                "url": "https://www.kancloud.cn/",
                "icon": "icon-biji",
                "text": "看云"
            },
            {
                "url": "https://www.yuque.com/",
                "icon": "icon-yuquemianlogo",
                "text": "语雀"
            },
            {
                "url": "https://www.latexstudio.net/",
                "icon": "icon-tianjiagongshi",
                "text": "LaTeX"
            },
            {
                "url": "https://cn.overleaf.com/",
                "icon": "icon-xiezuo",
                "text": "Overleaf"
            },
            {
                "url": "https://www.iconfont.cn/",
                "icon": "icon-alixingqiu",
                "text": "阿里图标"
            },
            {
                "url": "https://huaban.com/",
                "icon": "icon-huabanwang",
                "text": "花瓣"
            }
        ]
    },
    {
        "icon": "icon-caozuojiemiantubiao---_gongju",
        "title": "存储/工具",
        "node": [
            {
                "url": "https://pan.baidu.com/",
                "icon": "icon-baiduwangpan",
                "text": "百度网盘"
            },
            {
                "url": "https://www.jianguoyun.com/",
                "icon": "icon-jianguo",
                "text": "坚果云"
            },
            {
                "url": "https://up.woozooo.com/u",
                "icon": "icon-yuncunchu",
                "text": "蓝奏云"
            },
            {
                "url": "https://cowtransfer.com/",
                "icon": "icon--nainiu",
                "text": "奶牛快传"
            },
            {
                "url": "https://send.firefox.com/",
                "icon": "icon-huohuliulanqifirefox",
                "text": "Ff Send"
            },
            {
                "url": "https://translate.google.cn/",
                "icon": "icon-google",
                "text": "谷歌翻译"
            },
            {
                "url": "https://lolicon.dev/",
                "icon": "icon-idrex",
                "text": "Toolbox"
            },
            {
                "url": "https://tools.miku.ac/",
                "icon": "icon-gongju",
                "text": "MikuTools"
            },
            {
                "url": "https://apkdl.in/",
                "icon": "icon-apk",
                "text": "APK下载"
            },
            {
                "url": "http://tool.chinaz.com/",
                "icon": "icon-ico_yunyingguanli_yuangongxinxichaxun",
                "text": "站长工具"
            },
            {
                "url": "https://tinify.cn/",
                "icon": "icon--xiongmao",
                "text": "TinyPNG"
            }
        ]
    },
    {
        "icon": "icon-_qianduankaifa",
        "title": "开发/云",
        "node": [
            {
                "url": "https://www.aliyun.com/",
                "icon": "icon-aliyun",
                "text": "阿里云"
            },
            {
                "url": "https://cloud.tencent.com/",
                "icon": "icon-tengxunyun",
                "text": "腾讯云"
            },
            {
                "url": "https://www.qiniu.com/",
                "icon": "icon-qiniuyun",
                "text": "七牛云"
            },
            {
                "url": "https://www.cloudflare.com/",
                "icon": "icon-cloudflare",
                "text": "Cloudflare"
            },
            {
                "url": "https://www.w3school.com.cn/",
                "icon": "icon-wc",
                "text": "W3school"
            },
            {
                "url": "https://msdn.itellyou.cn/",
                "icon": "icon-weiruan",
                "text": "MSDN"
            },
            {
                "url": "https://rrkee.com/",
                "icon": "icon-renren",
                "text": "人人客"
            },
            {
                "url": "https://code.visualstudio.com/",
                "icon": "icon-file_type_vscode",
                "text": "VSCode"
            },
            {
                "url": "https://www.jetbrains.com/",
                "icon": "icon-jetbrains",
                "text": "JetBrains"
            }
        ]
    },
    {
        "icon": "icon-_shequluntan",
        "title": "论坛/学习",
        "node": [
            {
                "url": "https://juejin.im/",
                "icon": "icon-juejin",
                "text": "掘金"
            },
            {
                "url": "https://segmentfault.com/",
                "icon": "icon-iconsf-copy",
                "text": "SF思否"
            },
            {
                "url": "https://www.52pojie.cn/",
                "icon": "icon-wuaipojie",
                "text": "吾爱破解"
            },
            {
                "url": "https://www.itsk.com/",
                "icon": "icon-SKY",
                "text": "IT天空"
            },
            {
                "url": "https://www.ituring.com.cn/",
                "icon": "icon-tulingyunlogo",
                "text": "图灵社区"
            },
            {
                "url": "https://leetcode-cn.com/",
                "icon": "icon-LeetCode",
                "text": "力扣"
            }
        ]
    }
];

const os_txt = [
    [`<span>2004 [20H1] 2020.07</span>
    <br>Windows 10 (consumer edition), Version 2004 (Updated July 2020) (x64) - DVD (Chinese-Simplified)
    <br>ed2k://|file|cn_windows_10_consumer_editions_version_2004_updated_july_2020_x64_dvd_c1f5f37f.iso|5318148096|D429926047D6059B947D67D3C2CD9C0B|/
    <br>SHA1：870B5AD89AAFE2BBCCEE750E7B9179D0591AEF38

    <br><span>2004 [20H1] 2020.06</span>
    <br>Windows 10 (consumer edition), Version 2004 (Updated June 2020) (x64) - DVD (Chinese-Simplified)
    <br>ed2k://|file|cn_windows_10_consumer_editions_version_2004_updated_june_2020_x64_dvd_cf236229.iso|5301362688|D9157E065A45C5D142AB89E90EA1E45E|/
    <br>SHA1：AE77E94D5709171252992CD31644A1A73032074C
    <br><span>2004 [20H1] 2020.05</span>
    <br>Windows 10 (consumer edition), Version 2004 (Updated May 2020) (x64) - DVD (Chinese-Simplified)
    <br>ed2k://|file|cn_windows_10_consumer_editions_version_2004_updated_may_2020_x64_dvd_5a83cf4e.iso|5260658688|7B09EFFC08DD0FBF1D8A5558DA8445F5|/
    <br>SHA1：F4C4C7F47B5A230AB07DC791AC3CA1315701877C
    <br><span>1909 [19H2] 2020.04</span>
    <br>Windows 10 (consumer edition), Version 1909 (Updated April 2020) (x64) - DVD (Chinese-Simplified)
    <br>ed2k://|file|cn_windows_10_consumer_editions_version_1909_updated_april_2020_x64_dvd_d4f1cee8.iso|5536696320|7186FF25DD5DC27C951F20945360A3C1|/
    <br>SHA1：6CEF4FCCD7556D8F9BB112F636C3ECDBD2F5278C
    <br><span>1909 [19H1] 2019.12</span>
    <br>Windows 10 (consumer edition), Version 1909 (Updated December 2019) (x64) - DVD (Chinese-Simplified)
    <br>ed2k://|file|cn_windows_10_consumer_editions_version_1903_updated_dec_2019_x64_dvd_702857cf.iso|5414295552|DDBB3335613D41428B79A80E6821CEE7|/
    <br>SHA1：5ED23F8F4D7CBA4AC7F09F7C5FA02D86E34C9926
    <br><span>LTSC 2019.03</span>
    <br>Windows 10 Enterprise LTSC 2019 (x64) - DVD (Chinese-Simplified)
    <br>ed2k://|file|cn_windows_10_enterprise_ltsc_2019_x64_dvd_9c09ff24.iso|4478906368|E7C526499308841A4A6D116C857DB669|/
    <br>SHA1：24B59706D5EDED392423936C82BA5A83596B50CC
    <br><span>LTSB 2016.08</span>
    <br>Windows 10 Enterprise LTSB 2016 (x64) - DVD (Chinese-Simplified)
    <br>ed2k://|file|cn_windows_10_enterprise_2016_ltsb_x64_dvd_9060409.iso|3821895680|FF17FF2D5919E3A560151BBC11C399D1|/
    <br>SHA1：9E405E950890D2A196565BCA35E152F9CFAD296D`
    ],
    [`<span>Win7旗舰版 2011.05</span>
    <br>Windows 7 Ultimate with Service Pack 1 (x64) - DVD (Chinese-Simplified)
    <br>ed2k://|file|cn_windows_7_ultimate_with_sp1_x64_dvd_u_677408.iso|3420557312|B58548681854236C7939003B583A8078|/
    <br>SHA1：2CE0B2DB34D76ED3F697CE148CB7594432405E23
    <br><span>Win7专业版 2009.11</span>
    <br>Windows 7 Professional, VL Build (x64) - DVD (Chinese-Simplified)
    <br>ed2k://|file|cn_windows_7_professional_vl_build_x64_dvd_x15-71029.iso|3203971072|23155387CBD0771CFBA528CB1E7B170F|/
    <br>SHA1：2270C4A0715B204282AF1E8E05CBDCFCC776EB46`
    ],
    [`暂未收录，敬请期待`],
    [`<span>Deepin 20 Beta</span> 
    <br>官方下载：http://cdimage.deepin.com/releases/20Beta/deepin-20Beta-desktop-amd64.iso 
    <br>清华镜像：https://mirrors.tuna.tsinghua.edu.cn/deepin-cd/20Beta/deepin-20Beta-desktop-amd64.iso 
    <br>中科大镜像：http://mirrors.ustc.edu.cn/deepin-cd/releases/20Beta/deepin-20Beta-desktop-amd64.iso 
    <br>MD5：d0f92b930f4b369b6cbb67b612353366 
    <br>SHA256：77ba059a49756eb1c95f1f4f9f3c45d161762269977c520b115d548799eb01d4 
    <br><span>Deepin 15.11</span> 
    <br>官方下载：http://cdimage.deepin.com/releases/15.11/deepin-15.11-amd64.iso 
    <br>清华镜像：https://mirrors.tuna.tsinghua.edu.cn/deepin-cd/15.11/deepin-15.11-amd64.iso 
    <br>中科大镜像：http://mirrors.ustc.edu.cn/deepin-cd/releases/15.11/deepin-15.11-amd64.iso
    <br>MD5：daaf33cb284797cba582b99e8cc59a0a
    <br>SHA256：3b61802d83ec40c5c32eb6719ea641de75b8fa72b5e8bced48429172bc53f0f7`
    ]
];
const nav_txt = [["暂未收录，敬请期待"], ["暂未收录，敬请期待"], ["暂未收录，敬请期待"], ["暂未收录，敬请期待"], ["暂未收录，敬请期待"],];
const software_txt = [["暂未收录，敬请期待"], ["暂未收录，敬请期待"], ["暂未收录，敬请期待"], ["暂未收录，敬请期待"], ["暂未收录，敬请期待"],];
const os_declare = "本页提供均为原版镜像，未做任何修改，请自行验证SHA或MD5。<br>";
const soft_declare = "本页资源来自网络，如有侵权请联系我及时删除。<br>";