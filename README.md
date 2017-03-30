---

## LFilePicker

这是一个轻量级的文件选择器，可以检索手机目录选择文件。同时包含：

 - 多种界面风格
 - 支持文件多选或者单选
 - 支持文件类型过滤
 - 支持Fragment启动

### 运行效果：
![][1]


### 快速使用
#### 1. 添加引用

    compile 'com.leon:lfilepickerlibrary:1.0'
    
#### 2. 开启Activity

    new LFilePicker()
                .withActivity(MainActivity.this)
                .withRequestCode(Consant.REQUESTCODE_FROM_ACTIVITY)
                .start();
                
#### 3. 接收返回结果

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == Consant.REQUESTCODE_FROM_ACTIVITY) {
                List<String> list = data.getStringArrayListExtra(Constant.RESULT_INFO);
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

#### 提供样式

 **withIconStyle(int style)** 取值样式：
 
 - Constant.BACKICON_STYLEONE
 - Constant.BACKICON_STYLETWO
 - Constant.BACKICON_STYLETHREE
 
 **withBackIcon(int backStyle)** 取值样式：
 - Constant.ICON_STYLE_YELLOW
 - Constant.ICON_STYLE_BLUE
 - Constant.ICON_STYLE_GREEN
 
### 感谢
 - 使用了[AndroidUtilCode][2]中的文件工具类
 - 参考了[MaterialFilePicker][3]部分思路


----------
如果本库对你有用，欢迎star或者fork! 欢迎访问 [博客][4] 查看更多文章。


  [1]: http://github.com/leonHua/LFilePicker/raw/master/screenshot/Screenshot_20170330-132717.png
  [2]: https://github.com/Blankj/AndroidUtilCode
  [3]: https://github.com/nbsp-team/MaterialFilePicker
  [4]: https://leonhua.github.io/
