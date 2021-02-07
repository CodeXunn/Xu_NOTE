### SpringBoot系列—banner.txt



##### 前言

​       使用spring boot 开发时，当程序启动的时候控制台会输出由字符组成的Spring符号。这个是SpringBoot为自己设计的Banner:

```txt
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.4.2)
```

springboot 提供可以修改字符图案的方法

1. 在 src/main/resource 下新建 banner.txt

2. 网站生成自己想要的字符（我输入的是“abel“），将网站生成的字符复制到banner.txt 中。

3. 网站有：

   *  http://patorjk.com/software/taag
   * http://www.network-science.de/ascii/
   * http://www.degraeve.com/img2txt.php
   * https://www.bootschool.net/ascii 

   

   banner.txt配置

   `　　${AnsiColor.BRIGHT_RED}`：设置控制台中输出内容的颜色

   `　　${application.version}`：用来获取`MANIFEST.MF`文件中的版本号

   `　　${application.formatted-version}`：格式化后的`${application.version}`版本信息

   `　　${spring-boot.version}`：Spring Boot的版本号

　　`${spring-boot.formatted-version}`：格式化后的`${spring-boot.version}`版本信息



spring对banner的配置，来自springboot参考手册，Common application properties：https://docs.spring.io/spring-boot/docs/2.1.0.RELEASE/reference/htmlsingle/#common-application-properties

```yaml
# BANNER
spring.banner.charset=UTF-8 # Banner file encoding.
spring.banner.location=classpath:banner.txt # Banner text resource location.
spring.banner.image.location=classpath:banner.gif # Banner image file location (jpg or png can also be used).
spring.banner.image.width=76 # Width of the banner image in chars.
spring.banner.image.height= # Height of the banner image in chars (default based on image height).
spring.banner.image.margin=2 # Left hand image margin in chars.
spring.banner.image.invert=false # Whether images should be inverted for dark terminal themes.
```

##### banner默认开启，如果不想让它打印怎么办？

* 方法1，在main的run方法设置

```java
/**
 * 启动主类，springboot的入口
 * springboot 默认扫描的类是在启动类的当前包和下级包
 */
@SpringBootApplication
public class SpringbootWebsocketSpringdataJpaApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringbootWebsocketSpringdataJpaApplication.class);
        //Banner.Mode.OFF 关闭
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }
}
```

* 方法2，Edit Configurations --> 勾选Hide banner





参考：

https://www.cnblogs.com/huanzi-qch/

https://blog.csdn.net/u012373815/article/details/54948673