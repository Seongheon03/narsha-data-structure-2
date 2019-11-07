import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class EmployeeManager extends BaseFrame {

    PrintEmployeeInformation print = new PrintEmployeeInformation();
    JTextField[] inputEmployeeInformation = new JTextField[6];
    JLabel[] showInformation = new JLabel[6];
    String[] InformationList = "사원 코드, 사원 이름, 전화번호, 사원 부서 ( 인사팀 / 개발팀 / 디자인팀 ), 사원 주소, 가입 일자".split(", ");
    int listIndex = 0;

    JButton endBtn = new JButton("완료");
    Boolean departmentCheck;
    JButton left = new JButton("◀");
    JButton right = new JButton("▶");

    public EmployeeManager(int input, LinkedList<Employee> list) {

        switch(input){
            case 1:
                addEmployeePanel(list);
                break;
            case 2:
                printEmployeeAll(list);
                break;
            case 3:
                printEmployeeByCode(list);
                break;
            case 4:
                removeEmployee(list);
                break;
            case 5:
                moveDepartment(list);
        }

    }

    public void addEmployeePanel(LinkedList<Employee> list) {
        setLayout(new GridLayout(0, 1, 5, 5));

        JButton addBtn;

        for (int i = 0; i < inputEmployeeInformation.length; i++) {
            JPanel jp = new JPanel();
            jp.add(showInformation[i] = new JLabel(InformationList[i]));
            jp.add(inputEmployeeInformation[i] = new JTextField(20));
            add(jp);
        }

        add(addBtn = new JButton("추가"));
        add(endBtn);

        addBtn.addActionListener(e -> {
            uploadEmployee(list);
            showMsg("사원이 등록되었습니다.");
            dispose();
        });
        endBtn.addActionListener(e -> dispose());
    }

    public void printEmployeeAll(LinkedList<Employee> list){
        setLayout(new BorderLayout());

        add(endBtn, BorderLayout.SOUTH);
        endBtn.setPreferredSize(new Dimension(200, 100));
        endBtn.addActionListener(e->dispose());

        if(list.size() == 0){
            add(new JLabel("등록된 사원이 없습니다.", 0), BorderLayout.CENTER);
            return;
        }

        add(left, BorderLayout.WEST);
        add(right, BorderLayout.EAST);
        add(print.PrintEmployeeInformation(list, listIndex));

        setLeftRightEnabled(list);

        left.addActionListener(e -> {
            add(print.PrintEmployeeInformation(list, --listIndex));
            setLeftRightEnabled(list);
        });

        right.addActionListener(e -> {
            add(print.PrintEmployeeInformation(list, ++listIndex));
            setLeftRightEnabled(list);
        });

        endBtn.addActionListener(e->dispose());
    }

    public void printEmployeeByCode(LinkedList<Employee> list){
        setLayout(new GridLayout(0,1,5,5));

        JTextField inputCode = new JTextField(20);
        JButton check;

        add(new JLabel("사원 번호", 0));
        add(inputCode);
        add(check = new JButton("검색"));
        add(endBtn);

        check.addActionListener(e->{
            for(int i = 0; i<list.size(); i++){
                if(list.get(i).getCode().equals(inputCode.getText().toString())){
                    new ShowEmployeePanel(list, i).setVisible(true);
                    revalidate();
                    return;
                }
            }
            warringMsg("해당 사원이 없습니다.");
        });

        endBtn.addActionListener(e->dispose());
    }

    public void removeEmployee(LinkedList<Employee> list){
        setLayout(new GridLayout(0,1,5,5));

        JButton check;
        final JButton Y = new JButton("Y");
        final JButton N = new JButton("N");
        JTextField inputCode;

        add(new JLabel("사원 번호", 0));
        add(inputCode = new JTextField(20));
        add(check = new JButton("확인"));
        add(endBtn);

        check.addActionListener(e->{
            for(int i = 0; i<list.size(); i++){
                if(list.get(i).getCode().equals(inputCode.getText())){
                    new RemoveEmployeePanel(list, i).setVisible(true);
                    return;
                }
            }
            warringMsg("해당 사원이 없습니다.");
        });

        endBtn.addActionListener(e->dispose());
    }

    public void moveDepartment(LinkedList<Employee> list){
        setLayout(new GridLayout(0,1,5,5));

        JTextField inputCode = new JTextField(20);
        JTextField changeDepartment = new JTextField(20);
        JButton check = new JButton("검색");

        Employee employee = new Employee();

        add(new JLabel("사원 번호",0));
        add(inputCode);
        add(check);
        add(endBtn);

        check.addActionListener(e->{
            for(int i = 0; i<list.size(); i++){
                if(list.get(i).getCode().equals(inputCode.getText().toString())) {
                    new MoveDepartmentPanel(list.get(i)).setVisible(true);
                    return;
                }
            }
            warringMsg("사원을 찾을 수 없습니다.");
        });

        endBtn.addActionListener(e->dispose());
    }

    private void uploadEmployee(LinkedList<Employee> list) {
        Employee e = new Employee();
        Boolean codeCheck = false;

        for (int i = 0; i < inputEmployeeInformation.length; i++) {
            if (inputEmployeeInformation[i].getText().equals("")) {
                warringMsg("공백이 있습니다.");
                return;
            }
        }

        departmentCheck = e.setDepartment(inputEmployeeInformation[3].getText().toString());
        if (departmentCheck == false) {
            warringMsg("부서를 다시 입력해주세요.");
            return;
        }

        while (!codeCheck) {
            e.setCode(inputEmployeeInformation[0].getText().toString());
            codeCheck = true;
            if (list.size() == 0)
                break;
            System.out.println(e.getCode());
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getCode().equals(e.getCode())) {
                    warringMsg("중복된 사원코드입니다. 다시 입력해 주세요.");
                    codeCheck = false;
                    return;
                }
            }
        }

        e.setName(inputEmployeeInformation[1].getText().toString());
        e.setPhone(inputEmployeeInformation[2].getText().toString());
        e.setAddress(inputEmployeeInformation[4].getText().toString());
        e.setSignUpDate(inputEmployeeInformation[5].getText().toString());
        list.addLast(e);
    }

    private void setLeftRightEnabled(LinkedList<Employee> list) {
        left.setEnabled(listIndex != 0);
        right.setEnabled(listIndex < (list.size() -1));
        revalidate();
    }
}