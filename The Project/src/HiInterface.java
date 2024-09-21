import javax.swing.* ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HiInterface extends  AssGUI {


    private JTextField username ,password ,confirmpassword  ;
    private JLabel lblUsername ,lblPassword ,lblConfirmpassword ;
private JButton Type ;
    public HiInterface() {
        setTitle("UserInterface");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 500);
        setLocationRelativeTo(null);
        setLayout(null);


        username =new JTextField();
        password =new JPasswordField();
        confirmpassword =new JPasswordField();
        Type =new JButton();

        lblUsername =new JLabel("username");
        lblPassword =new JLabel("password");
        lblConfirmpassword =new JLabel("confirmpassword");


        lblUsername.setBounds(20 ,120 ,260 ,20);
        username.setBounds(20 ,150 ,260 ,20);
        lblPassword.setBounds(20 ,180,260 ,20);
        password.setBounds(20 ,210 ,260 ,20);
        lblConfirmpassword .setBounds(20 ,240 ,260 ,20);
        confirmpassword .setBounds(20 ,270 ,260 ,20);
        Type.setBounds(20 , 320 , 260 , 20);


        add(username);
        add(password);
        add(lblUsername);
        add(lblPassword);
        add(confirmpassword);
        add(lblConfirmpassword);
        add(Type);








        setVisible(true);

    }

    public static void main(String[] args) {
        HiInterface hiInterface =new HiInterface();
    }


    }
