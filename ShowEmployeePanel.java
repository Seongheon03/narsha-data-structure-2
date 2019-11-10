import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class ShowEmployeePanel extends BaseFrame {

    public ShowEmployeePanel(LinkedList <Employee> list, int i) {
        setLayout(new FlowLayout());

        PrintEmployeeInformation print = new PrintEmployeeInformation();
        JButton endBtn = new JButton("확인");

        add(new JLabel("해당 사원의 정보", 0));
        add(print.PrintEmployeeInformation(list, i));

        add(endBtn);

        endBtn.addActionListener(e->{
            dispose();
        });

        return;
    }
    
}
