package dev.be.feign.feign.interceptor;

import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;


@RequiredArgsConstructor(staticName = "of")// of는 static 메소드로 객체를 생성한다.
public class DemoFeignInterCeptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        // GET 일경우
        if(template.method() == Request.HttpMethod.GET.name()){
            System.out.println("[GET] [DemoFeignInterCeptor] : queries :  " + template.queries()); // 해당 요청에 사용하는 쿼리들 가져옴
            return;
        }
        // POST 일경우
        if(template.method() == Request.HttpMethod.POST.name()){
            String encodedRequestBody = StringUtils.toEncodedString(template.body(), StandardCharsets.UTF_8);
            System.out.println("[POST] [DemoFeignInterCeptor] : body :  " + encodedRequestBody); // 해당 요청에 사용하는 바디 가져옴

            String converReuqestBody = encodedRequestBody;
            // 추가적으로 본인이 필요한 로직을 추가
            template.body(converReuqestBody);
            // ObjectMapper로 나중에 Json으로 변환할 수 있음
            return;
        }
        template.header("CustomHeaderName", "CustomHeaderValue");
    }
}
