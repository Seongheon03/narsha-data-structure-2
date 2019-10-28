import java.util.LinkedList;
import java.util.Scanner;

public class EmployeeManager {
    LinkedList<Employee> list = new LinkedList<Employee>();
    Scanner sc = new Scanner(System.in);

    public void uploadEmployee(){
        Employee e = new Employee();
        Boolean check = true;

        list.addLast(e);
        System.out.print("사원 코드 : ");
        e.setCode(sc.nextLine());
        System.out.print("사원 이름 : ");
        e.setName(sc.nextLine());
        System.out.print("전화번호 : ");
        e.setPhone(sc.nextLine());
        System.out.print("사원 부서 ( 인사팀 / 개발팀 / 디자인팀 ) : ");
        while(check){
            String department = sc.nextLine();
            switch(department){
                case "인사팀":
                    e.setDepartment(Department.HUMAN_RESOURCE);
                    check = false;
                    break;
                case "개발팀":
                    e.setDepartment(Department.DEVELOPMENT);
                    check = false;
                    break;
                case "디자인팀":
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

    }

    void printEmployeeByCode(){
        int code;

        code = sc.nextInt();
    }

    void removeEmployee(){
        Employee e = new Employee();
        String input;
        String check = "1";

        System.out.print("삭제할 사원의 코드 : ");
        input = sc.nextLine();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getCode() == input){
                System.out.println("삭제할 사원의 정보 : ");
                list.get(i).getName();
                list.get(i).getPhone();
                list.get(i).getDepartment();
                list.get(i).getAddress();
                list.get(i).getSignUpDate();
                while(check != "Y" || check != "N") {
                    System.out.println("삭제하시겠습니까? ( Y / N ) : ");
                    check = sc.nextLine();
                    if (check == "Y") {
                        list.remove(i);
                        System.out.println("삭제되었습니다.");
                    }
                    else if(check == "N")
                        System.out.println("취소되었습니다.");
                    else
                        System.out.println("Y 또는 N만 입력해 주세요.");
                }
                break;
            }
        }
    }

    void moveDepartment(int code){
        System.out.print("부서를 옮길 사원의 번호를 입력하세요 : ");
        String input = sc.nextLine();
    }
}
