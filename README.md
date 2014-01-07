# JSP 교육 샘플 소스

2014년 JSP/Servlet 관련 샘플 소스입니다.


## 초기 설정

git clone 을 이용해 원격 저장소에 있는 소스를 내려 받습니다.

``` git clone https://github.com/yoyojyv/2014-01-JSP-Training.git ```

Maven 명령어를 이용하여 Eclipse WTP 프로젝트 형태로 만들어줍니다.

``` mvn eclipse:eclipse -Dwtpversion=2.0 ```

Eclipse 프로젝트로 import 합니다.
import 후 톰캣 서버를 띄워 정상적으로 뜨는지 확인합니다.


## 시작...


### 01. Hello World! (JSP 는 너무 간단하니 생략)

기본 서블릿을 만들어 봅니다.

- Servlet 만들기
HttpServlet 을 상속받는 HelloWorldServlet 클래스를 생성합니다.


```
package com.humuson.training.hello;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      PrintWriter out = resp.getWriter();

      out.println("Hello, World!");
      out.close();
  }
}
```


다음으로 web.xml 파일에 서블릿 정보를 넣어줍니다.


```
    <servlet>
        <servlet-name>HelloWorldServlet</servlet-name>
        <servlet-class>com.humuson.training.hello.HelloWorldServlet</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>HelloWorldServlet</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>

```

브라우저에서 /hello 로 접근하여 페이지를 확인해 봅니다.

- Servlet 만들기 (@annotation 을 이용해서 만들기, Servlet 3.0 이상)

HelloWorldAnnotationServlet 클래스 파일을 만듭니다.

```
@WebServlet(urlPatterns = "/helloAnnotation")
public class HelloWorldAnnotationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream os = resp.getOutputStream();

        for (int i=0;i<1000;i++) {
            os.print(i);
            os.write(", Hello, World2!!".getBytes("UTF-8"));

            if (i % 100 == 0) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                os.println();
                os.flush();
            }
        }
        os.println("***** end");
        os.close();
    }
}
```

브라우저에서 /helloAnnotation 로 접근하여 페이지를 확인해 봅니다.


