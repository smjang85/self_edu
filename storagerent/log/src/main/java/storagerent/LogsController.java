package storagerent;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;
import java.util.Random;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogsController {

    @Autowired
    LogRepository logRepository;

    @RequestMapping(value = "/logs/checkLogService",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String checkStorage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        SimpleDateFormat format1 = new SimpleDateFormat( "yyyy년 MM월dd일 HH시mm분ss초");
                

        String format_time1 = format1.format (System.currentTimeMillis());
       


        System.out.println("checkLogService called :" + format_time1);
        
    
        return "logService status good. It is real";
    }

    @RequestMapping(value = "/isolation", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String isolation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Random rng = new Random();
        long loopCnt = 0;

        while (loopCnt < 100) {
            double r = rng.nextFloat();
            double v = Math.sin(Math.cos(Math.sin(Math.cos(r))));
            System.out.println(String.format("r: %f, v %f", r, v));
            loopCnt++;
        }
        
        return "real";
    }

    @GetMapping("/hpa")
    public String getHPA() {
        Random rng = new Random();
        long loopCnt = 0;

        while (loopCnt < 100) {
            double r = rng.nextFloat();
            double v = Math.sin(Math.cos(Math.sin(Math.cos(r))));
            System.out.println(String.format("r: %f, v %f", r, v));
            loopCnt++;
        }

        return "hpa";
    }

    @GetMapping("/serviceAddress")
    public String getServiceAddress () {
        String serviceAddress = null;
        if (serviceAddress == null) {
            serviceAddress = findMyHostname() + "/" + findMyIpAddress();
        }
        return serviceAddress;
    }

    private String findMyHostname() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return "unknown host name";
        }
    }

    private String findMyIpAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return "unknown IP address";
        }
    }
}
