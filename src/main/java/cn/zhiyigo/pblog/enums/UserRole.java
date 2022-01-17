package cn.zhiyigo.pblog.enums;

public enum UserRole {

    ADMIN(0,"admin"),
    USER(1,"user");

    private Integer roleNum;

    private String roleName;

    UserRole(Integer roleNum, String roleName) {
        this.roleNum = roleNum;
        this.roleName = roleName;
    }

    public Integer getRoleNum() {
        return roleNum;
    }

    public void setRoleNum(Integer roleNum) {
        this.roleNum = roleNum;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
