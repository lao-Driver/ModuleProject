#system相关  分包是设置的不混淆   配置multiDexKeep.txt文件，指定类即可，这个是保留在MainDex里的类
#com.xxx.xx.xxxxxxx.class
-keepclassmembers class fqcn.of.javascript.interface.for.webview {
   public *;
}