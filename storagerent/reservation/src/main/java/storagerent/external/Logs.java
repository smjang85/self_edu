package storagerent.external;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Logs {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String keyId;
    private String sEventName;
    private String sEventStream;
    private Boolean bCancelled;
 
  

    public String getsEventName() {
        return sEventName;
    }

    public void setsEventName(String sEventName) {
        this.sEventName = sEventName;
    }

    
    public String getsEventStream() {
        return sEventStream;
    }

    public void setsEventStream(String sEventStream) {
        this.sEventStream = sEventStream;
    }

    public Boolean getbCancelled() {
        return bCancelled;
    }

    public void setbCancelled(Boolean bCancelled) {
        this.bCancelled = bCancelled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }


}
