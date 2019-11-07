import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class PrintEmployeeInformation extends BaseFrame {

        public JPanel PrintEmployeeInformation(LinkedList<Employee> list, int i) {
        JPanel showPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        showPanel.setPreferredSize(new Dimension(500, 280));

        showPanel.add(new JLabel("사원 번호 : " + list.get(i).getCode(), 0));
        showPanel.add(new JLabel("사원 이름 : " + list.get(i).getName(),0 ));
        showPanel.add(new JLabel("전화번호 : " + list.get(i).getPhone(), 0));
        showPanel.add(new JLabel("사원 부서 : " + list.get(i).getDepartment(),0 ));
        showPanel.add(new JLabel("사원 주소 : " + list.get(i).getAddress(), 0));
        showPanel.add(new JLabel("가입 일자 : " + list.get(i).getSignUpDate(), 0));

        return showPanel;
    }

        public static void main(String[] args) {
                LinkedList<Employee> list = new LinkedList<>();
                Employee employee1 = new Employee();

                employee1.setCode("1234");
                employee1.setName("김");
                employee1.setPhone("1234");
                employee1.setDepartment("인사팀");
                employee1.setAddress("대구");
                employee1.setSignUpDate("19.12.12");
                list.add(employee1);

                //new PrintEmployeeInformation(list, 0).setVisible(true);
        }
}
