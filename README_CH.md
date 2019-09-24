---

## LFilePicker


> 说明：如果发现应用名称被修改，可以参考issues#26 查看解决方案，或者可以自己下载代码依赖改动，目前木有精力改动，如果你改了欢迎提pull，如果不能接受此缺陷，请慎用~

这是一个轻量级的文件选择器，可以检索手机目录选择文件。同时包含：

 - 多种界面风格
 - 支持文件多选或者单选
 - 支持文件类型过滤
 - 支持Fragment启动
 - 自定义标题文字和颜色
 - 国际化（中英文切换）
 - 最大数量限制
 - 全选或者全部取消
 - 文件夹路径选择
 - 文件大小过滤
 - 默认路径指定


### 版本更新：
 #### V1.8.0
  - 修改了资源名称，统一添加前缀 
  - 增加了标题字体的大小设置
  - 增加了通过主题直接修改 标题颜色和后退图标，更多菜单颜色
 #### V1.7.0
  - 增加接口指定初始显示路径
  - 增加接口可以过滤文件大小，大于指定大小或者小于指定大小
 #### V1.6.0
  - 增加文件夹路径选择
 #### V1.5.0
  - 全选校验，避免数据重复添加
  - 单选模式下不在显示全选操作
 #### V1.4.0
  - 最大数量限制 (withMaxNum)
  - 全选或者全部取消
  
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

    compile 'com.leon:lfilepickerlibrary:1.8.0'

#### 2. 添加文件读写权限

    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
    

#### 3. 开启Activity
    int REQUESTCODE_FROM_ACTIVITY = 1000;
    new LFilePicker()
                .withActivity(MainActivity.this)
                .withRequestCode(REQUESTCODE_FROM_ACTIVITY)
                .withStartPath("/storage/emulated/0/Download")//指定初始显示路径
                .withIsGreater(false)//过滤文件大小 小于指定大小的文件
                .withFileSize(500 * 1024)//指定文件大小为500K
                .start();
                
#### 4. 接收返回结果

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUESTCODE_FROM_ACTIVITY) {
                //如果是文件选择模式，需要获取选择的所有文件的路径集合
                 //List<String> list = data.getStringArrayListExtra(Constant.RESULT_INFO);//Constant.RESULT_INFO == "paths"
                  List<String> list = data.getStringArrayListExtra("paths");
                  Toast.makeText(getApplicationContext(), "选中了" + list.size() + "个文件", Toast.LENGTH_SHORT).show();
                  //如果是文件夹选择模式，需要获取选择的文件夹路径
                   String path = data.getStringExtra("path");
                   Toast.makeText(getApplicationContext(), "选中的路径为" + path, Toast.LENGTH_SHORT).show();
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
| withMaxNum(int num)          |设置最大可选文件数量|
| withChooseMode(boolean chooseMode)|设置文件夹选择模式,true(默认)为选择文件，false为选择文件夹|
| withStartPath(String path)        |设置初始显示路径|
| withIsGreater(boolean isGreater)  |设置过滤方式,true(默认)为大于指定大小，false小于指定大小|
| withFileSize(long size)           |设置指定过滤文件大小，如果是500K则输入500*1024|
#### 提供样式

 **withIconStyle(int style)** 取值模式：
 - Constant.ICON_STYLE_YELLOW
 - Constant.ICON_STYLE_BLUE
 - Constant.ICON_STYLE_GREEN
 
 **withBackIcon(int backStyle)** 取值模式：
 - Constant.BACKICON_STYLEONE
 - Constant.BACKICON_STYLETWO
 - Constant.BACKICON_STYLETHREE
 
  **withFileFilter(String[] arrs)** 取值模式：

     withFileFilter(new String[]{".txt", ".png", ".docx"})

### 详细使用请参考文章：[简书：LFilePicker---文件选择利器，各种样式有它就够了](http://www.jianshu.com/p/eeb211e190be)

### 感谢
 - 使用了[AndroidUtilCode][2]中的文件工具类
 - 参考了[MaterialFilePicker][3]部分思路


----------
如果本库对你有用，欢迎star或者fork! 欢迎访问 [博客][4] 查看更多文章。

## License

Copyright (C) 2017 leonHua

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.


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
