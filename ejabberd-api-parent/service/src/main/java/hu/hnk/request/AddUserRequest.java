package hu.hnk.request;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AddUserRequest extends AbstractXMPPRequest implements Serializable {

    /**
    *
    */
    private static final long serialVersionUID = 1L;


    private String group;
    private String user;
    private String grouphost;

    @Builder
    public AddUserRequest(String host, String group, String user) {
        super();
        this.host = host;
        this.group = group;
        this.user = user;
        this.grouphost = host;
    }



}
