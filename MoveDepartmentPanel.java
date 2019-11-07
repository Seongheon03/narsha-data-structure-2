import javax.swing.*;
import java.awt.*;

public class MoveDepartmentPanel extends BaseFrame {
    public MoveDepartmentPanel(Employee employee){
        super(250, 230);
        setLayout(new GridLayout(0,1,5,5));

        JLabel department = new JLabel("사원의 현재 부서 : " + employee.getDepartment(),0);
        JTextField inputDepartment = new JTextField(20);
        JButton check = new JButton("확인");
        JButton endBtn = new JButton("완료");

        add(department);
        add(inputDepartment);
        add(check);
        add(endBtn);

        check.addActionListener(e->{
            Boolean departmentCheck = employee.setDepartment(inputDepartment.getText());
            if(departmentCheck == false){
                warringMsg("부서를 다시 입력해주세요.");
                return;
            }
            showMsg(employee.getDepartment() + "으로 옮겨졌습니다.");
            dispose();
        });
        endBtn.addActionListener(e->dispose());

    }

}
