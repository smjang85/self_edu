package storagerent;

import storagerent.config.kafka.KafkaProcessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PolicyHandler {

    
    @Autowired
    LogRepository logRepository;

    
    
    private AtomicLong value = new AtomicLong(1);

    public String getNext() {
        return Long.toString(value.getAndIncrement());
    }
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverStorageReserved_RecvLogs(@Payload StorageRegistered storageRegistered) {

        System.out.println("\n\n##### wheneverStorageReserved_RecvLogs() Called : " + storageRegistered);
        System.out.println("\n\n##### listener RecvLogs : " + storageRegistered.toJson() + "\n\n");

        if (!storageRegistered.validate()) {
            return;
        }


        Logs logs = new Logs();
        logs.setKeyId(getNext() );
        logs.setsEventName(storageRegistered.getClass().getName());
        logs.setsEventStream(storageRegistered.toString());

        System.out.println("\n\n##### created logs : " + logs + "\n\n");
        logRepository.save(logs);
    }



    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){

        System.out.println("\n\n##### eventString : " + eventString);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
        try {
            Map<String, Object> map = mapper.readValue(eventString, Map.class);
            String eventType = String.valueOf(map.get("eventType"));
            if("StorageRegistered".equals(eventType) || "LogRegistered".equals(eventType)){
                return;
            }

            
            Logs logs = new Logs();
            logs.setKeyId(getNext() );
            logs.setsEventName(eventType);
            logs.setsEventStream(eventString);

            System.out.println("\n\n##### created logs : " + logs + "\n\n");
            logRepository.save(logs);

        } catch (IOException e) { 
            e.printStackTrace(); 
        }

    }


}
