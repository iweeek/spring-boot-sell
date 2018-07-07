如果maven出错，重新刷新无反应，可以在项目根目录中执行mvn clean，然后再导入。

``` xml
<mirrors>
   <mirror>
      <id>alimaven</id>
      <name>aliyun maven</name>
      <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
      <mirrorOf>central</mirrorOf>        
   </mirror>
</mirrors>
```
