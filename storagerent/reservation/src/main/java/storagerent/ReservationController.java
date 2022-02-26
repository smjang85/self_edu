package storagerent;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import storagerent.external.LogService;

 @RestController
 public class ReservationController {
      @Value("${PHONENO}")
      String phoneNo;

      @GetMapping("/reservations/phone_no")
      public String getPhoneNo(){
          return phoneNo;
      }
     private LogService logService;
     
     public ReservationController(LogService logService){
        this.logService = logService;
    }

     @GetMapping("/reservations/checkLogService")
     public String getLogServiceStat() {
         System.out.println("call checkLogService");
         String logStat = logService.checkLogService();
         System.out.println("logStat :" + logStat);
         return logStat;
     }


 }
