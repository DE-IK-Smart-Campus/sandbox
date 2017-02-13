package hu.hnk.service;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

/**
 * Service for managing shared roster service by Java side.
 *
 */
@Local
public interface SharedRosterService {

    /**
     * Get the groups' list from the domain.
     *
     * @return groups list.
     */
    List<String> getGroupList();

    /**
     * Creating new Shared Roster Group.
     *
     * @param group group id.
     * @param groupName group name.
     * @param description description of the group.
     * @param displayedGroups displayed groups.
     */
    void createNewGroup(String group, String groupName, String description,
            List<String> displayedGroups);

    /**
     * Asking for group information.
     *
     * @param group group id.
     * @return Map which contains the group's details.
     */
    Map<String, String> getGroupInformation(String group);

    /**
     * Add user to given group.
     *
     * @param user user's account name withouth domain.
     * @param group group to add user.
     */
    void addUserToGroup(String user, String group);

    /**
     * Delete user from given group.
     *
     * @param user user's account name withouth domain.
     * @param group group to remove user.
     */
    void deleteUserFromGroup(String user, String group);
}
