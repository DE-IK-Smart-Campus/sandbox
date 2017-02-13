package hu.hnk.request;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
public class GroupRequest extends AbstractXMPPRequest implements Serializable {
    /**
    *
    */
    private static final long serialVersionUID = 1L;


    public GroupRequest(String host) {
        super();
        this.host = host;
    }

}
