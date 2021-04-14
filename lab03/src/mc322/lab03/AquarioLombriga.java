package mc322.lab03;

public class AquarioLombriga {
	
	int tamAquario, tamLombriga, posCabeca, posCauda;
	
	// Variavel de controle que, quando verdadeira, indica que a lombriga esta
	// virada para a direita
	boolean direita; 
	
	AquarioLombriga(int tamAquario, int tamLombriga, int posCauda) {
		this.tamAquario = tamAquario;
		this.tamLombriga = tamLombriga;
		
		// Condicao de contorno: lombriga maior do que o aquario
		if(this.tamAquario < this.tamLombriga) {
			this.tamAquario = this.tamLombriga;
		}
		
		this.posCauda = posCauda;

		// Condicao de contorno: posicao inicial da lombriga nao a comporta no aquario
		if ((posCauda < 1) || (posCauda > tamAquario)) {
			posCauda = 1;
		}

		posCabeca = posCauda + (tamLombriga - 1);
		direita = true;
	}
	
	void crescer(){
		// Se ha espaco para a lombriga crescer e ela esta virada para a direita
		if((direita) && (posCauda > 1)) {
			tamLombriga++;
			posCauda--;
			return;
		}
		
		// Se ha espaco para a lombriga crescer e ela esta virada para a esquerda
		if(!(direita) && (posCauda < tamAquario)) {
			tamLombriga++;
			posCauda++;
			return;
		}
		
	}
	
	void mover() {
		// Se a lombriga esta virada para a direita
		if(direita) {
			
			// Se estamos no limite do aquario
			if (posCabeca == tamAquario) {
				virar();
				return;
			}
			
			posCabeca++;
			posCauda++;
		}
		
		// Se a lombriga esta virada para a esquerda
		else {
			
			// Se estamos no limite do aquario
			if (posCabeca == 1) {
				virar();
				return;
			}
			
			posCabeca--;
			posCauda--;
		}
	}
	
	void virar() {
		// Salvamos temporariamente as posicoes originais da cabeca e da cauda
		int cabecaOrig = posCabeca;
		int caudaOrig = posCauda;
		
		// Invertemos as posicoes da cabeca e da cauda e aplicamos o toggle na variavel
		// de posicao
		posCabeca = caudaOrig;
		posCauda = cabecaOrig;
		
		direita = !direita;
	}
	
	String criaLombriga() {
		// Metodo auxiliar usado para criar a representacao em string da lombriga
		
		String lombriga = "";
		char pedaco = '@';
		
		// Se a lombriga esta virada para a direita
		if(direita) {
			for(int i = 0; i < (tamLombriga - 1); i++) {
				lombriga += pedaco;
			}
			lombriga += 'O';
		}
		
		// Se a lombriga esta virada para a esquerda
		else {
			lombriga += 'O';
			for(int i = 1; i < tamLombriga; i++) {
				lombriga += pedaco;
			}
		}
		
		return lombriga;
	}
	
	String apresenta() {
		
		String aquario = "";
		char vazio = '#';
		
		// Criamos a representacao da lombriga
		String lombriga = criaLombriga();
		
		for (int i = 1; i <= tamAquario; i++) {
			// Quando encontramos a posicao para inserir a lombriga
			if ((i == posCauda) || (i == posCabeca)) {
				aquario += lombriga;
				i += tamLombriga - 1;
				continue;
			}
			
			aquario += vazio;
		}
		
		return aquario;
	}
	

}
