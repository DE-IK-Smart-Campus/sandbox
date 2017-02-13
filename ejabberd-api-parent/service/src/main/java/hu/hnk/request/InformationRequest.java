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
@NoArgsConstructor
public class InformationRequest extends AbstractXMPPRequest implements Serializable {

    /**
    *
    */
    private static final long serialVersionUID = 1L;


    private String group;

    @Builder
    public InformationRequest(String host, String group) {
        super();
        this.host = host;
        this.group = group;
    }

}
