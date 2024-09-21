import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface extends AssGUI implements ActionListener  {

    //declration

    private  JButton btnlogin ;
    private JButton btnregister ;

    public UserInterface(){
        setTitle("UserInterface");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300 ,500);
        setLocationRelativeTo(null);
        setLayout(null);




        btnlogin =new JButton("Login");
        btnregister =new JButton("register");




        btnlogin.setBounds(20 ,400 ,100 ,20);
        btnregister.setBounds(140 ,400 ,    100 ,20);



        add(btnlogin);
        add(btnregister);

        setVisible(true);


        btnlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


//                if (Username.compareToIgnoreCase(User.login(Username,Password))==0) {
//                    if (Password.compareTo("admin") == 0) {
//                    } else {
//                        showmess();
//                    }
//                } else {
//                    showmess();
//                }

            }
        });

    }
    public void showmess(){
        JOptionPane.showMessageDialog(this ,"false" );
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();



    }
}

