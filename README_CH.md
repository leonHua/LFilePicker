---

## LFilePicker

这是一个轻量级的文件选择器，可以检索手机目录选择文件。同时包含：

 - 多种界面风格
 - 支持文件多选或者单选
 - 支持文件类型过滤
 - 支持Fragment启动
 - 自定义标题文字和颜色
 - 国际化（中英文切换）
### 运行效果：
#### 动态操作（如果图片无法正常显示，可以查看screenshot文件夹中gif文件）
![](screenshot/操作.gif)
#### 页面效果：
![][5]
![][6]
![][7]
![][8]
![][9]
![][10]
![][11]
![][12]
![][13]

### 快速使用
#### 1. 添加引用

    compile 'com.leon:lfilepickerlibrary:1.2.0'
or

    [下载aar文件](http://o9w936rbz.bkt.clouddn.com/blog/img/201704/1/lfilepickerlibrary.aar?attname=)
    
#### 2. 添加文件读写权限

    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
    

#### 3. 开启Activity
    int REQUESTCODE_FROM_ACTIVITY = 1000;
    new LFilePicker()
                .withActivity(MainActivity.this)
                .withRequestCode(REQUESTCODE_FROM_ACTIVITY)
                .start();
                
#### 4. 接收返回结果

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUESTCODE_FROM_ACTIVITY) {
                 //List<String> list = data.getStringArrayListExtra(Constant.RESULT_INFO);//Constant.RESULT_INFO == "paths"
                              List<String> list = data.getStringArrayListExtra("paths");
                Toast.makeText(getApplicationContext(), "选中了" + list.size() + "个文件", Toast.LENGTH_SHORT).show();
            }
        }
    }
    
### 接口方法
#### 方法说明
| 方法        | 说明   |
| --------   | --------- |
| withActivity(Activity activity)   |绑定Activity|
| withFragment(Fragment fragment)   |绑定Fragment|
| withSupportFragment(Fragment supportFragment)|绑定V4包Fragment|
| withRequestCode(int requestCode)  |设置请求码|
| withTitle(String title)           |设置标题文字|
| withTitleColor(String color)      |设置标题文字颜色|
| withBackgroundColor(String color) |设置标题背景颜色|
| withIconStyle(int style)          |设置列表图标样式|
| withBackIcon(int backStyle)       |设置返回图标样式|
| withFileFilter(String[] arrs)     |设置文件类型过滤器|
| withMutilyMode(boolean isMutily)  |设置多选或单选模式|
| withAddText(String text)          |设置多选模式选中文字|
| withNotFoundBooks(String text)    |设置没有选中文件时的提示信息|
#### 提供样式

 **withIconStyle(int style)** 取值模式：
 
 - Constant.BACKICON_STYLEONE
 - Constant.BACKICON_STYLETWO
 - Constant.BACKICON_STYLETHREE
 
 **withBackIcon(int backStyle)** 取值模式：
 - Constant.ICON_STYLE_YELLOW
 - Constant.ICON_STYLE_BLUE
 - Constant.ICON_STYLE_GREEN
 
  **withFileFilter(String[] arrs)** 取值模式：

     withFileFilter(new String[]{".txt", ".png", ".docx"})

### 详细使用请参考文章：[简书：LFilePicker---文件选择利器，各种样式有它就够了](http://www.jianshu.com/p/eeb211e190be)

### 感谢
 - 使用了[AndroidUtilCode][2]中的文件工具类
 - 参考了[MaterialFilePicker][3]部分思路


----------
如果本库对你有用，欢迎star或者fork! 欢迎访问 [博客][4] 查看更多文章。


  [5]: http://o9w936rbz.bkt.clouddn.com/github/img/LFilePicker/Screenshot_20170330-132717.png?imageView2/0/w/500/h/1200/q/100
  [6]: http://o9w936rbz.bkt.clouddn.com/github/img/LFilePicker/Screenshot_20170330-133458.png?imageView2/0/w/500/h/1200/q/100
  [7]: http://o9w936rbz.bkt.clouddn.com/github/img/LFilePicker/Screenshot_20170330-133811.png?imageView2/0/w/500/h/1200/q/100
  [8]: http://o9w936rbz.bkt.clouddn.com/github/img/LFilePicker/Screenshot_20170330-133831.png?imageView2/0/w/500/h/1200/q/100
  [9]: http://o9w936rbz.bkt.clouddn.com/github/img/LFilePicker/Screenshot_20170330-133836.png?imageView2/0/w/500/h/1200/q/100
  [10]: http://o9w936rbz.bkt.clouddn.com/github/img/LFilePicker/Screenshot_20170330-133844.png?imageView2/0/w/500/h/1200/q/100
  [11]: http://o9w936rbz.bkt.clouddn.com/github/img/LFilePicker/Screenshot_20170330-134316.png?imageView2/0/w/500/h/1200/q/100
  [12]: http://o9w936rbz.bkt.clouddn.com/github/img/LFilePicker/Screenshot_20170330-134327.png?imageView2/0/w/500/h/1200/q/100
  [13]: http://o9w936rbz.bkt.clouddn.com/github/img/LFilePicker/Screenshot_20170330-134333.png?imageView2/0/w/500/h/1200/q/100
  [14]: http://o9w936rbz.bkt.clouddn.com/github/img/LFilePicker/%E7%AE%80%E5%8D%95%E6%93%8D%E4%BD%9C01.gif?imageView2/0/w/700/h/1400/q/100
  [15]: http://o9w936rbz.bkt.clouddn.com/github/img/LFilePicker/%E7%AE%80%E5%8D%95%E6%93%8D%E4%BD%9C02.gif?imageView2/0/w/700/h/1400/q/100
  [16]: http://o9w936rbz.bkt.clouddn.com/github/img/LFilePicker/%E7%AE%80%E5%8D%95%E6%93%8D%E4%BD%9C03.gif?imageView2/0/w/700/h/1400/q/100
  [17]: http://o9w936rbz.bkt.clouddn.com/github/img/LFilePicker/%E7%AE%80%E5%8D%95%E6%93%8D%E4%BD%9C04.gif?imageView2/0/w/700/h/1400/q/100
  [2]: https://github.com/Blankj/AndroidUtilCode
  [3]: https://github.com/nbsp-team/MaterialFilePicker
  [4]: https://leonhua.github.io/
