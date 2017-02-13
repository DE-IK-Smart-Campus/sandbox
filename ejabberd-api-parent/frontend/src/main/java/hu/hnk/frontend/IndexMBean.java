package hu.hnk.frontend;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DualListModel;

import hu.hnk.service.SharedRosterService;

@ViewScoped
@ManagedBean(name = "indexBean")
public class IndexMBean {

    @EJB
    private SharedRosterService service;

    private String welcome = "Hello";

    private List<String> groupList;

    private String groupName;

    private String group;

    private String description;

    private List<String> displayedGroups;

    private DualListModel<String> groups;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getDisplayedGroups() {
        return displayedGroups;
    }

    public void setDisplayedGroups(List<String> displayedGroups) {
        this.displayedGroups = displayedGroups;
    }

    @PostConstruct
    public void init() {
        groupList = service.getGroupList();
        List<String> target = new ArrayList<>();
        groups = new DualListModel<>(groupList, target);
    }

    public String getWelcome() {
        return welcome;
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }

    public List<String> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<String> groupList) {
        this.groupList = groupList;
    }

    public void createGroup() {
        System.out.println("Creating group");
        System.out.println("Targets:" + groups.getTarget());
        service.createNewGroup(group, groupName, description, groups.getTarget());
    }

    public DualListModel<String> getGroups() {
        return groups;
    }

    public void setGroups(DualListModel<String> groups) {
        this.groups = groups;
    }


}
