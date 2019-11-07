import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class RemoveEmployeePanel extends BaseFrame {
    public RemoveEmployeePanel(LinkedList<Employee> list, int i){
        PrintEmployeeInformation print = new PrintEmployeeInformation();
        setLayout(new FlowLayout());

        JButton del = new JButton("해고");
        JButton cancel = new JButton("취소");

        add(new JLabel("해당 사원의 정보", 0));

        add(print.PrintEmployeeInformation(list, i));

        add(del);
        add(cancel);

        del.addActionListener(e->{
            list.remove(i);
            showMsg("사원이 해고되었습니다.");
            dispose();
        });

        cancel.addActionListener(e->{
            showMsg("취소되었습니다.");
            dispose();
        });
    }
}
