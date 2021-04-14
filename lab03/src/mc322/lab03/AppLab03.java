package mc322.lab03;

public class AppLab03 {

	public static void main(String[] args) {

		String comandos = "MCMVM";
		String paramLombriga = "080403";

		// Criamos a string de sequencia para a animacao
		String sequencia = paramLombriga + comandos;

		Animacao anim1 = new Animacao(sequencia);
		String output;

		for (int i = 0; i <= comandos.length(); i++) {
			output = anim1.apresenta();
			System.out.println(output);
			anim1.passo();
		}
	}

}
