package org.example;

import org.apache.catalina.startup.Tomcat;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.io.File;

public class Webapplication {

    private static final Logger log = LoggerFactory.getLogger(Webapplication.class);


    public static void main(String[] args) throws Exception{
        String webappDirLocation = "webapps/";//webapps라는 디렉토리를 바라보게 하겠다라는 뜻이다.
        //즉 경로를 입력했을때 (아래의 "/"처럼) , webbapps를 루트경로로 인식한다
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
        log.info("configuraing app with basedir: {}",new File("./"+webappDirLocation).getAbsolutePath());


        tomcat.start();
        tomcat.getServer().await();

    }
}