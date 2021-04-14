package mc322.lab03;

public class AppLab03 {

	public static void main(String[] args) {

		Animacao anim1 = new Animacao("080403MCMVM");
		String output;

		for (int i = 0; i < 6; i++) {
			output = anim1.apresenta();
			System.out.println(output);
			anim1.passo();
		}
	}

}
