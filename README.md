# free-google-translate
Free Google Translator API 免费的Google翻译，其中的破解思路主要来源于将 https://translate.google.cn 的web访问方式模拟成全部代码的形式来控制api的访问

# 注意事项
- 1.大量的相同IP请求会导致Google翻译接口返回 429 Too many requests 
   -  建议处理方案：每一个app客户端自己去请求此接口，就可以避免只有一个IP的服务器去请求
- 2.大量的请求也会使此接口的服务不可用
-
<br/>
<br/>

# 其他编程语言的使用方法请去原作者处查看
[# [VictorZhang2014](https://github.com/VictorZhang2014)/**[free-google-translate](https://github.com/VictorZhang2014/free-google-translate)**](https://github.com/VictorZhang2014/free-google-translate)<br/>
<br/>

自用 留档

# Android使用

导入


    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

>

	dependencies {
			...
	        implementation 'com.github.GuoFangPeng:free-google-translate:an_0.0.1'
	}


权限

    <uses-permission android:name="android.permission.INTERNET"/>
    
代码

```java
GoogleTranslateUtil.defaulanguage="zh-CN";  //设置默认翻译的目标语言
GoogleTranslateUtil g=new GoogleTranslateUtil(this, (code, response) -> {
//code错误码  0表示正确  |response 返回翻译文本/错误信息
 //一定要post回到主进程  方式随意  但一定要回到主进程  
    textview.post(() -> {    
      textview.setText(response);  //对翻译文本操作
    });  
});  

button.setOnClickListener(view -> {  
    g.query(edittext.getText().toString());  //请求翻译
});
```
<br/>

## 在填写目标语言缩写时不知道该语言的缩写是什么怎么办？

[谷歌翻译](https://translate.google.cn/)
打开谷歌翻译的网页，找到你想要知道缩写的语言，看地址栏，上面sl=后面那个就是缩写
<br/>

## 所使用到的库

[okhttp](https://github.com/square/okhttp)
