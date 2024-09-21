import javax .swing.*;


public class Ressiter extends JButton  {

    private JTextField username ,password ,confirmpassword ,type  ;
    private JLabel lblUsername ,lblPassword ,lblConfirmpassword ,lblType;
    public Ressiter(){


        setSize(300 ,500);

        setLayout(null);

        username =new JTextField();
        password =new JPasswordField();
        confirmpassword =new JPasswordField();
        type =new JTextField();

        lblUsername =new JLabel("username");
        lblPassword =new JLabel("password");
        lblConfirmpassword =new JLabel("confirmpassword");
        lblType =new JLabel("type");

    }}
