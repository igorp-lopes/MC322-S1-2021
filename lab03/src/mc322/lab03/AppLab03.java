package mc322.lab03;

public class AppLab03 {

	public static void main(String[] args) {
		
		AquarioLombriga lombriga1 = new AquarioLombriga(8, 4, 3);
		
		for (int i = 1; i < 10; i++) {
			System.out.println(lombriga1.apresenta());
			if (i % 2 == 0) {
				lombriga1.crescer();
			}
			lombriga1.mover();
			System.out.println();
		}
	}

}
