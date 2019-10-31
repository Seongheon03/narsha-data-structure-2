import java.util.LinkedList;
import java.util.Scanner;

public class EmployeeManager {
    LinkedList<Employee> list = new LinkedList<Employee>();
    Scanner sc = new Scanner(System.in);

    public void uploadEmployee(){
        Employee e = new Employee();
        int department = 0;
        Boolean check = true;

        list.addLast(e);
        System.out.print("사원 코드 : ");
        e.setCode(sc.nextInt());
        System.out.print("사원 이름 : ");
        e.setName(sc.nextLine());
        System.out.print("전화번호 : ");
        e.setPhone(sc.nextLine());
        System.out.print("사원 부서 (1. 인사팀 / 2. 개발팀 / 3. 디자인팀) :");
        sc.nextInt(department);
        while(check){
            switch(department){
                case 1:
                    e.setDepartment(Department.HUMAN_RESOURCE);
                    check = false;
                    break;
                case 2:
                    e.setDepartment(Department.DEVELOPMENT);
                    check = false;
                    break;
                case 3:
                    e.setDepartment(Department.DESIGN);
                    check = false;
                    break;
                default:
                    System.out.println("다시 입력해주세요");
            }
        }
        System.out.print("사원 주소 : ");
        e.setAddress(sc.nextLine());
        System.out.print("가입 일자 : ");
        e.setSignUpDate(sc.nextLine());
        System.out.println("등록이 완료되었습니다.");
    }

    void printEmployeeAll(){
        if(list.size() == 0){
            System.out.println("등록된 사원이 없습니다.");
            return;
        }
        for(int i = 0; i < list.size(); i++){
            printEmployeeInformation(i);
            System.out.println();
        }
    }

    void printEmployeeByCode(){
        String input = sc.nextLine();

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getCode().equals(input)){
                printEmployeeInformation(i);
                return;
            }
        }
        System.out.println("사원을 찾을 수 없습니다.");
    }

    void removeEmployee(){
        Employee e = new Employee();
        int code;
        int i = 0;

        code = sc.nextInt();
        list.get(i);
        while(i <= list.size()){
            if(list.get(i))
        }
    }

    void moveDepartment(int code){

    }
}
