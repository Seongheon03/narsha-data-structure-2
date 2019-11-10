import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class MainPanel extends BaseFrame {

    static LinkedList<Employee> list = new LinkedList<Employee>();
    String[] buttonTitle = "사원등록, 사원 전체 조회, 사원 조회, 사원 해고, 사원 부서 이동, 프로그램 종료".split(", ");
    JButton[] jbt = new JButton[6];

    public MainPanel(){
        setLayout(new GridLayout(3, 2, 5, 5));

        for(int i = 0; i < jbt.length ; i++){
            jbt[i] = new JButton(buttonTitle[i]);
            add(jbt[i]);
        }

        jbt[0].addActionListener(e->{
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
