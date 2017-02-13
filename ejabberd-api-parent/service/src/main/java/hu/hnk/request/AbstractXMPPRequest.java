package hu.hnk.request;

/**
 *
 *
 */
public abstract class AbstractXMPPRequest {

    protected String host;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
