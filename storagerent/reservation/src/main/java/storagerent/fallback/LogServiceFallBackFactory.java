package storagerent.fallback;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;
import storagerent.external.LogService;




@Component
public class LogServiceFallBackFactory  implements FallbackFactory<LogService> {
    @Override
    public LogService create(Throwable cause) {
       System.out.println(" fall back process start");

        return new LogService() {
            
            @Override
            public String checkLogService() {
                System.out.println(" fall back return ");
                return "fallback";
            }

          
        };
    }
}
