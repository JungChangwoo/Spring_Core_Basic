package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) // 가짜 proxy 객체를 생성하고, 실제 기능 요청이 오면 그때 내부에서 진짜 빈을 요청하는 위임 로직이 들어있다.
public class MyLogger {
    private String uuid;
    private String requestURL;
    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }
    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] " +
                message);
    }
    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create:" + this);
    }
    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close:" + this);
    }
}