package Router.b;

public class SimMain {
	static public void main(String[] args){
		String[] N_A = {"1","2","3"};
		String[] S_A = {"E","D","B"};
		SimRouter R_A = new SimRouter("A",N_A,S_A);
		String[] N_B = {"3","4"};
		String[] S_B = {"A","C"};
		SimRouter R_B = new SimRouter("B",N_B,S_B);
		String[] N_C = {"4","6"};
		String[] S_C = {"B","F"};
		SimRouter R_C = new SimRouter("C",N_C,S_C);
		String[] N_D = {"2","5"};
		String[] S_D = {"A","E","F"};
		SimRouter R_D = new SimRouter("D",N_D,S_D);
		String[] N_E = {"1","5"};
		String[] S_E = {"A","D","F"};
		SimRouter R_E = new SimRouter("E",N_E,S_E);
		String[] N_F = {"5","6"};
		String[] S_F = {"E","D","C"};
		SimRouter R_F = new SimRouter("F",N_F,S_F);
		
		
	}
}
