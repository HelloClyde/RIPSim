package Router.b;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ShowWindow extends JFrame{

	private JPanel contentPane;
	private SimScreen simScreen;
	private JButton Next3Min;
	private JButton DivideNet;
	
	ArrayList<SimRouter> RouterArr;
	SimRouter R_A;
	SimRouter R_B;
	SimRouter R_C;
	SimRouter R_D;
	SimRouter R_E;
	SimRouter R_F;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowWindow frame = new ShowWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public ShowWindow() {
		String[] N_A = {"1","2","3"};
		String[] S_A = {"E","D","B"};
		R_A = new SimRouter("A",N_A,S_A);
		String[] N_B = {"3","4"};
		String[] S_B = {"A","C"};
		R_B = new SimRouter("B",N_B,S_B);
		String[] N_C = {"4","6"};
		String[] S_C = {"B","F"};
		R_C = new SimRouter("C",N_C,S_C);
		String[] N_D = {"2","5"};
		String[] S_D = {"A","E","F"};
		R_D = new SimRouter("D",N_D,S_D);
		String[] N_E = {"1","5"};
		String[] S_E = {"A","D","F"};
		R_E = new SimRouter("E",N_E,S_E);
		String[] N_F = {"5","6"};
		String[] S_F = {"E","D","C"};
		R_F = new SimRouter("F",N_F,S_F);
		RouterArr = new ArrayList<SimRouter>();
		RouterArr.add(R_A);
		RouterArr.add(R_B);
		RouterArr.add(R_C);
		RouterArr.add(R_D);
		RouterArr.add(R_E);
		RouterArr.add(R_F);
		
		setResizable(false);
		setTitle("Router Sim");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		simScreen = new SimScreen(RouterArr);
		simScreen.setBounds(0, 0, 1000, 600);
		contentPane.add(simScreen);
		
		Next3Min = new JButton("下一周期");
		Next3Min.setBounds(20, 620, 100, 50);
		contentPane.add(Next3Min);
		Next3Min.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0;i < RouterArr.size();i ++){
					SimRouter TempR = RouterArr.get(i);
					//SimRouter TempR = GetRByName("B");
					for (int j = 0;j < TempR.SurrRouter.length;j ++){
						String RName = TempR.SurrRouter[j];
						SimRouter DesR = GetRByName(RName);
						if (DesR == null){
							continue;
						}
						TempR.Accept(DesR.mRouterTables, RName);
					}
				}
				simScreen.repaint();
			}
			
		});
		
		DivideNet = new JButton("切断路由F和网络6");
		DivideNet.setBounds(140, 620, 200, 50);
		contentPane.add(DivideNet);
		DivideNet.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//R_B.GetRouterInfoItemByNetAddr("4").setDistance(16);
				for (int i = 0;i < R_F.mRouterTables.size();i ++){
					if (R_F.mRouterTables.get(i).getNextRouterAddr().equals("C")){
						R_F.mRouterTables.get(i).setDistance(16);
					}
					else if (R_F.mRouterTables.get(i).getDesNetWorkAddr().equals("6") && R_F.mRouterTables.get(i).getNextRouterAddr().equals("-")){
						R_F.mRouterTables.get(i).setDistance(16);
					}
				}
				for (int i = 0;i < R_F.SurrRouter.length;i ++){
					if (R_F.SurrRouter[i].equals("C")){
						R_F.SurrRouter[i] = "";
					}
				}
				simScreen.IsDivide = true;
				simScreen.repaint();
			}
			
		});
		
		setContentPane(contentPane);
	}
	
	SimRouter GetRByName(String name){
		for (int i = 0;i < RouterArr.size();i ++){
			if (RouterArr.get(i).getName().equals(name)){
				return RouterArr.get(i);
			}
		}
		return null;
	}
}
