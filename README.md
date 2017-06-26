----------
### [中文文档](README_CH.md)
This is a lightweight file selector, it can select files by retrieve phone directory. At the same time contains：

 - A variety of interface style
 - Support file multiple-choice or radio
 - Support the file type filter
 - Support the fragments
 - custom title text and color
 - Internationalization (switch in both Chinese and English)

### Running effect：
#### dynamic effect（If the picture can't display properly, you can view the screenshot GIF files in the folder）
![](screenshot/操作.gif)
#### the page：
![][5]
![][6]
![][7]
![][8]
![][9]
![][10]
![][11]
![][12]
![][13]

### Quick to use
#### 1. add reference
    compile 'com.leon:lfilepickerlibrary:1.2.0'
or

    [下载aar文件](http://o9w936rbz.bkt.clouddn.com/blog/img/201704/1/lfilepickerlibrary.aar?attname=)
    
#### 2. add permission

    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
   
    
#### 3. open Activity
    int REQUESTCODE_FROM_ACTIVITY = 1000;
    new LFilePicker()
                .withActivity(MainActivity.this)
                .withRequestCode(REQUESTCODE_FROM_ACTIVITY)
                .start();
                
#### 4. accept the results of the return

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
    
### Interface methods
#### method statement
| method        | statement   |
| --------   | --------- |
| withActivity(Activity activity)   |bind Activity|
| withFragment(Fragment fragment)   |bind Fragment|
| withSupportFragment(Fragment supportFragment)|bind V4 Fragment|
| withRequestCode(int requestCode)  |set the request code|
| withTitle(String title)           |Set the title|
| withTitleColor(String color)      |Set the title color|
| withBackgroundColor(String color) |Set the title background color|
| withIconStyle(int style)          |set the list icon style|
| withBackIcon(int backStyle)       |set back icon style|
| withFileFilter(String[] arrs)     |set the file type filter|
| withMutilyMode(boolean isMutily)  |setting a multiple-choice or radio mode|
| withAddText(String text)          |set the multiselect mode selected text|
| withNotFoundBooks(String text)    |Set the prompt information when no file selected|
#### Provide style

 **withIconStyle(int style)** Value model：
 
 - Constant.BACKICON_STYLEONE
 - Constant.BACKICON_STYLETWO
 - Constant.BACKICON_STYLETHREE
 
 **withBackIcon(int backStyle)** Value model：
 - Constant.ICON_STYLE_YELLOW
 - Constant.ICON_STYLE_BLUE
 - Constant.ICON_STYLE_GREEN
 
  **withFileFilter(String[] arrs)** Value model：

     withFileFilter(new String[]{".txt", ".png", ".docx"})
     
### More detailed usage：[简书：LFilePicker---文件选择利器，各种样式有它就够了](http://www.jianshu.com/p/eeb211e190be)
 
### Thanks
 - [AndroidUtilCode][2]
 - [MaterialFilePicker][3]


----------
If the library is useful to you, welcome to star or fork!
Welcome to visit [blog] [4] for more articles.


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
