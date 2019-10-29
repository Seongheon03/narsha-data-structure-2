import java.util.LinkedList;
import java.util.Scanner;

public class EmployeeManager {
    LinkedList<Employee> list = new LinkedList<Employee>();
    Scanner sc = new Scanner(System.in);

    public void uploadEmployee(){
        Employee e = new Employee();
        Boolean check = false;

        System.out.print("사원 코드 : ");
        while(!check){
            e.setCode(sc.nextLine());
            check = true;
            if(list.size() == 0)
                break;
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).getCode().equals(e.getCode())){
                    System.out.println("중복된 사원코드입니다. 다시 입력해 주세요.");
                    check = false;
                }
            }
        }
        System.out.print("사원 이름 : ");
        e.setName(sc.nextLine());
        System.out.print("전화번호 : ");
        e.setPhone(sc.nextLine());
        System.out.print("사원 부서 ( 인사팀 / 개발팀 / 디자인팀 ) : ");
        check = false;
        while(!check){
            String department = sc.nextLine();
            check = e.setDepartment(department, e);
        }
        System.out.print("사원 주소 : ");
        e.setAddress(sc.nextLine());
        System.out.print("가입 일자 : ");
        e.setSignUpDate(sc.nextLine());
        System.out.println("등록이 완료되었습니다.");
        list.addLast(e);
    }

    void printEmployeeAll(){

    }

    void printEmployeeByCode(){

    }

    void removeEmployee(){
        Employee e = new Employee();
        String input;
        String check = "1";

        System.out.print("삭제할 사원의 코드 : ");
        input = sc.nextLine();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getCode().equals(input)){
                System.out.println("삭제할 사원의 정보");
                printEmployeeInformation(i);
                System.out.println();
                while(!check.equals("Y") && !check.equals("N")) {
                    System.out.println("삭제하시겠습니까? ( Y / N ) : ");
                    check = sc.nextLine();
                    if (check.equals("Y")) {
                        list.remove(i);
                        System.out.println("삭제되었습니다.");
                    }
                    else if(check.equals("N"))
                        System.out.println("취소되었습니다.");
                    else
                        System.out.println("Y 또는 N만 입력해 주세요.");
                }
                return;
            }
        }
        System.out.println("사원을 찾을 수 없습니다.");
    }

    void moveDepartment(){
        System.out.print("부서를 옮길 사원의 번호를 입력하세요 : ");
        String input = sc.nextLine();
        Boolean check = false;

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getCode().equals(input)){
                System.out.println("현재 사원의 부서 : " + list.get(i).getDepartment());
                System.out.print("옮길 부서 ( 인사팀 / 개발팀 / 디자인팀 ) : ");
                while(!check) {
                    String department = sc.nextLine();
                    check = list.get(i).setDepartment(department, list.get(i));
                }
                System.out.println(list.get(i).getDepartment() + "으로 옮겨졌습니다.");
                return;
            }
        }
        System.out.println("사원을 찾을 수 없습니다.");
    }

    private void printEmployeeInformation(int i){
        System.out.println("사원 번호 : " + list.get(i).getCode());
        System.out.println("사원 이름 : " + list.get(i).getName());
        System.out.println("전화번호 : " + list.get(i).getPhone());
        System.out.println("사원 부서 : " + list.get(i).getDepartment());
        System.out.println("사원 주소 : " + list.get(i).getAddress());
        System.out.println("가입 일자 : " + list.get(i).getSignUpDate());
    }
}
