import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class EmployeeManager extends BassFrame {

    JTextField[] jtf = new JTextField[6];
    JLabel[] jlb = new JLabel[6];
    String[] labelText = "사원 코드, 사원 이름, 전화번호, 사원 부서 ( 인사팀 / 개발팀 / 디자인팀 ), 사원 주소, 가입 일자".split(", ");
    int listIndex = 0;

    JButton left = new JButton("◀");
    JButton right = new JButton("▶");

    public EmployeeManager(int input, LinkedList<Employee> list) {

        switch(input){
            case 1:
                addEmployeePanel(list);
                break;
            case 2:
                PrintEmployeeAll(list);
                break;
            case 3:
                PrintEmployeeByCode(list);
                break;
            case 4:
                RemoveEmployee(list);
                break;
            case 5:
                MoveDepartment(list);
        }

    }

    public void addEmployeePanel(LinkedList<Employee> list) {
        setLayout(new GridLayout(0, 1, 5, 5));

        for (int i = 0; i < jtf.length; i++) {
            JPanel jp = new JPanel();
            jp.add(jlb[i] = new JLabel(labelText[i]));
            jp.add(jtf[i] = new JTextField(20));
            add(jp);
        }

        JButton addBtn = new JButton("추가");
        JButton endBtn = new JButton("완료");
        add(addBtn);
        add(endBtn);
        addBtn.addActionListener(e -> uploadEmployee(list));
        endBtn.addActionListener(e -> dispose());
    }

    //TODO : 함수명 바꾸기
    private void uploadEmployee(LinkedList<Employee> list) {
        Employee e = new Employee();
        Boolean codeCheck = false;
        Boolean departmentCheck = false;

        for (int i = 0; i < jtf.length; i++) {
            if (jtf[i].getText().equals("")) {
                wmsg("공백이 있습니다.");
                return;
            }
        }

        departmentCheck = e.setDepartment(jtf[3].getText().toString());
        if (departmentCheck == false) {
            wmsg("부서를 다시 입력해주세요.");
            return;
        }

        while (!codeCheck) {
            e.setCode(jtf[0].getText().toString());
            codeCheck = true;
            if (list.size() == 0)
                break;
            System.out.println(e.getCode());
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getCode().equals(e.getCode())) {
                    wmsg("중복된 사원코드입니다. 다시 입력해 주세요.");
                    codeCheck = false;
                    return;
                }
            }
        }

        e.setName(jtf[1].getText().toString());
        e.setPhone(jtf[2].getText().toString());
        e.setAddress(jtf[4].getText().toString());
        e.setSignUpDate(jtf[5].getText().toString());
        list.addLast(e);
    }

    public void PrintEmployeeAll(LinkedList<Employee> list){
        setLayout(new BorderLayout());
        JLabel jlb = new JLabel();

        add(left, BorderLayout.WEST);
        add(right, BorderLayout.EAST);
        add(printEmployeeInformation(list, listIndex));

        left.setEnabled(listIndex != 0);
        right.setEnabled(listIndex < (list.size() -1));

        left.addActionListener(e -> {
            leftButtonAction(list);
        });

        right.addActionListener(e -> {
            rightButtonAction(list);
        });

        if(list.size() == 0){
            add(jlb = new JLabel("등록된 사원이 없습니다."));
            return;
        }
    }

    public void PrintEmployeeByCode(LinkedList<Employee> list){
        setLayout(new GridLayout(6,0,5,5));

        JLabel jlb = new JLabel("사원 코드");
        JTextField jtf = new JTextField(20);
        JButton check = new JButton("검색");

        add(jlb);
        add(check);

        for(int i = 0; i<list.size(); i++){
            if(list.get(i).getCode.equals(jtf.getText().toString())){
                printEmployeeInformation(list, i);
                break;
            }
        }
    }

    private JPanel printEmployeeInformation(LinkedList<Employee> list, int i){
        JPanel showPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        showPanel.removeAll();

        showPanel.add(new JLabel(labelText[0] + " : " + list.get(i).getCode()));
        showPanel.add(new JLabel(labelText[1] + " : " + list.get(i).getName()));
        showPanel.add(new JLabel(labelText[2] + " : " + list.get(i).getPhone()));
        showPanel.add(new JLabel(labelText[3] + " : " + list.get(i).getDepartment()));
        showPanel.add(new JLabel(labelText[4] + " : " + list.get(i).getAddress()));
        showPanel.add(new JLabel(labelText[5] + " : " + list.get(i).getSignUpDate()));

        System.out.println(labelText[0] + " : " + list.get(i).getCode());
        showPanel.repaint();
        showPanel.revalidate();
        return showPanel;
    }

    public void RemoveEmployee(LinkedList<Employee> list){

    }

    public void MoveDepartment(LinkedList<Employee> list){

    }

    private void leftButtonAction(LinkedList<Employee> list) {
        add(printEmployeeInformation(list, --listIndex));
        left.setEnabled(listIndex != 0);
        right.setEnabled(listIndex < (list.size() -1));
    }

    private void rightButtonAction(LinkedList<Employee> list) {
        add(printEmployeeInformation(list, ++listIndex));
        left.setEnabled(listIndex != 0);
        right.setEnabled(listIndex < (list.size() -1));
    }

}