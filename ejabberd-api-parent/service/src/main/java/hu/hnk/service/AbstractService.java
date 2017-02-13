package hu.hnk.service;

/**
 *
 *
 */
public abstract class AbstractService {
    protected static final String HOST = "http://holi.net:5280/api";

    protected static final String SHARED_ROSTER_GROUP_LIST_COMMAND = "/srg_list";

    protected static final String SHARED_ROSTER_GROUP_CREATE_COMMAND = "/srg_create";

    protected static final String SHARED_ROSTER_GROUP_INFO_COMMAND = "/srg_get_info";

    protected static final String SHARED_ROSTER_GROUP_CREATE_USER_COMMAND = "/srg_user_add";

    protected static final String SHARED_ROSTER_GROUP_DELETE_USER_COMMAND = "/srg_user_del";

    protected static final String DOMAIN = "holi.net";

}
