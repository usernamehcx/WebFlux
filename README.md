# WebFlux
##前提条件
需要修改StockService代码中
```java
System.setProperty("selenuim_config", "/Users/njuics/workspace/Spring-WebFlux/spring-webflux-streaming/config.ini");
```
中config.ini的地址，改为在你的电脑上的地址

还需要下载 ChromeDriver，并且在StockService代码中
```java
.setDownloader(new SeleniumDownloader("/Users/njuics/Downloads/chromedriver")).thread(1).start();
```
将ChromeDiver的地址改为实际地址

## 执行命令
mvn spring-boot:run
