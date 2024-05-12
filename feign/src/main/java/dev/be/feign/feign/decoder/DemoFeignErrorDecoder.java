package dev.be.feign.feign.decoder;


import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

public class DemoFeignErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        HttpStatus httpStatus = HttpStatus.resolve(response.status()); // resolve는 HttpStatus에 정의된 상태 코드를 반환한다.

        if(httpStatus == HttpStatus.NOT_FOUND) {
            System.out.println("httpStatus = " + httpStatus);
            throw new RuntimeException(String.format("Runtime Exception : %s", httpStatus));
        }

        return errorDecoder.decode(methodKey,response);
    }
}
