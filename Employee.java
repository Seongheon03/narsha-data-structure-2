import javax.swing.*;
import java.awt.*;

enum Department {
    HUMAN_RESOURCE,
    DEVELOPMENT,
    DESIGN;
}

public class Employee extends BaseFrame {
    private String code;
    private String name;
    private String phone;
    private Department department;
    private String address;
    private String signUpDate;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        switch(this.department){
            case HUMAN_RESOURCE:
                return "인사팀";
            case DEVELOPMENT:
                return "개발팀";
            case DESIGN:
                return "디자인팀";
        }
        return null;
    }

    public Boolean setDepartment(String department) {
        switch(department){
            case "인사팀":
                this.department = Department.HUMAN_RESOURCE;
                return true;
            case "개발팀":
                this.department = Department.DEVELOPMENT;
                return true;
            case "디자인팀":
                this.department = Department.DESIGN;
                return true;
            default:
                return false;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSignUpDate() {
        return signUpDate;
    }

    public void setSignUpDate(String signUpDate) {
        this.signUpDate = signUpDate;
    }
}