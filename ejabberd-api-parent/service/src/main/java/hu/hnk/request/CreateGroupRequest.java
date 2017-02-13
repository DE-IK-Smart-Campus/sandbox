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
public class CreateGroupRequest extends AbstractXMPPRequest implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String group;
    private String name;
    private String description;
    private String display;

    @Builder
    public CreateGroupRequest(String host, String group, String name, String description,
            String display) {
        super();
        this.host = host;
        this.group = group;
        this.name = name;
        this.description = description;
        this.display = display;
    }



}
