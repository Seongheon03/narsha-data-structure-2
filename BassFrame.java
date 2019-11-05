import javax.swing.*;

public class BassFrame extends JFrame {

    public static void main(String args[] ){
        new BassFrame();
    }

    public BassFrame(){
        setTitle("HRM");
        setSize(500, 400);
        setDefaultCloseOperation(2);
    }

    public void wmsg(String text) {
        JOptionPane.showMessageDialog(null, text, "ERROR", JOptionPane.WARNING_MESSAGE);
    }
}
