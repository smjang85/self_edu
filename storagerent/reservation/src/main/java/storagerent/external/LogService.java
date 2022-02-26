
package storagerent.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import storagerent.config.HttpConfiguration;
import storagerent.fallback.LogServiceFallBackFactory;


@FeignClient(name="log", url="${prop.log.url}",
        configuration = HttpConfiguration.class,
        fallbackFactory = LogServiceFallBackFactory.class)
public interface LogService {

    @GetMapping("/logs/checkLogService")
    String checkLogService();
}