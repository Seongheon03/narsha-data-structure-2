import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class MainPanel extends BassFrame{

    static LinkedList<Employee> list = new LinkedList<Employee>();
    JPanel mainPanel;
    String[] buttonTitle = "사원등록, 사원 전체 조회, 사원 조회, 사원 해고, 사원 부서 이동, 프로그램 종료".split(", ");
    JButton[] jbt = new JButton[6];

    public MainPanel(){

        setLayout(new GridLayout(3, 2, 5, 5));

        for(int i = 0; i < jbt.length ; i++){
            jbt[i] = new JButton(buttonTitle[i]);
            add(jbt[i]);
        }
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();

        employee1.setCode("1234");
        employee1.setName("김");
        employee1.setPhone("1234");
        employee1.setDepartment("인사팀");
        employee1.setAddress("대구");
        employee1.setSignUpDate("19.12.12");

        employee2.setCode("1235");
        employee2.setName("성");
        employee2.setPhone("1235");
        employee2.setDepartment("개발팀");
        employee2.setAddress("동구");
        employee2.setSignUpDate("19.12.13");

        list.addLast(employee1);
        list.addLast(employee2);

        jbt[0].addActionListener(e->{
            //control.UploadEmployee();
            new EmployeeManager(1, list).setVisible(true);
        });

        jbt[1].addActionListener(e->{
            new EmployeeManager(2, list).setVisible(true);
        });

        jbt[2].addActionListener(e->{
            new EmployeeManager(3, list).setVisible(true);
        });

        jbt[3].addActionListener(e->{
            new EmployeeManager(4, list).setVisible(true);
        });

        jbt[4].addActionListener(e->{
            new EmployeeManager(5, list).setVisible(true);
        });

        jbt[5].addActionListener(e->{
            dispose();
        });
    }

    public static void main(String[] args) {
        new MainPanel().setVisible(true);
    }
}
