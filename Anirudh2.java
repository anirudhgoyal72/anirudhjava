import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Project{
    private String prjId;
    private String prjName;
    private Integer prjCost;

    public Project(String prjId, String prjName, Integer prjCost) {
        this.prjId = prjId;
        this.prjName = prjName;
        this.prjCost = prjCost;
    }

    public String getPrjId() {
        return prjId;
    }

    public void setPrjId(String prjId) {
        this.prjId = prjId;
    }

    public String getPrjName() {
        return prjName;
    }

    public void setPrjName(String prjName) {
        this.prjName = prjName;
    }

    public Integer getPrjCost() {
        return prjCost;
    }

    public void setPrjCost(Integer prjCost) {
        this.prjCost = prjCost;
    }
}
class User{
    private Integer id;
    private String name;
    private Integer salary;

    public User(Integer id, String name, Integer salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
class ProjectData{
    private List<User> users;
    private Integer credit;
    private Integer available;

    public ProjectData(ArrayList<User> users, Integer credit, Integer available) {
        this.users = users;
        this.credit = credit;
        this.available = available;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void pushUser(User u){
        this.users.add(u);
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "ProjectData{" +
                "users=" + users +
                ", credit=" + credit +
                ", available=" + available +
                '}';
    }
}
public class GrpByProjects {
    private Integer userId;
    private String userName;
    private Integer userSalary;
    private Project project;

    public GrpByProjects(Integer userId, String userName, Integer userSalary, Project project) {
        this.userId = userId;
        this.userName = userName;
        this.userSalary = userSalary;
        this.project = project;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserSalary() {
        return userSalary;
    }

    public void setUserSalary(Integer userSalary) {
        this.userSalary = userSalary;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public static void main(String[] args) {
        GrpByProjects grp = new GrpByProjects(1,"User1",100,
                new Project("Prj1","ATT",1000));
        GrpByProjects grp2 = new GrpByProjects(2,"User2",150,
                new Project("Prj2","Google",320));
        GrpByProjects grp3 = new GrpByProjects(3,"User3",500,
                new Project("Prj1","ATT",1000));

        List<GrpByProjects> grpList = new ArrayList<GrpByProjects>();
        grpList.add(grp);
        grpList.add(grp2);
        grpList.add(grp3);

        Map<String,ProjectData> m= new HashMap<String,ProjectData>();
        for(GrpByProjects g:grpList){
            String p = g.getProject().getPrjName();
            User u = new User(g.getUserId(),g.getUserName(),g.getUserSalary());
            if(m.containsKey(p)){
                m.get(p).pushUser(u);
                m.get(p).setCredit(m.get(p).getCredit()+u.getSalary());
                m.get(p).setAvailable(m.get(p).getAvailable()-u.getSalary());
            }
            else{
                ArrayList<User> users = new ArrayList<>();
                users.add(u);
                ProjectData pd = new ProjectData(users,u.getSalary(),g.getProject().getPrjCost()-u.getSalary());
                m.put(p,pd);
            }
        }
        for(String p:m.keySet()){
            System.out.println(p);
            System.out.println(m.get(p));

        }

    }
}
