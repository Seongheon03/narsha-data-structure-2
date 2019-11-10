import javax.swing.*;

public class BaseFrame extends JFrame {

    public BaseFrame(){
        setTitle("HRM");
        setSize(500, 400);
        setDefaultCloseOperation(2);
    }

    public BaseFrame(int width, int height){
        setTitle("HRM");
        setSize(width, height);
        setDefaultCloseOperation(2);
    }

    public void warringMsg(String text) {
        JOptionPane.showMessageDialog(null, text, "ERROR", JOptionPane.WARNING_MESSAGE);
    }

    public void showMsg(String text){
        JOptionPane.showMessageDialog(null, text, "", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
