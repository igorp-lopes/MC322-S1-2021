package mc322.lab03;

public class AquarioLombriga {
	
	int tamAquario, tamLombriga, posLombriga, posCauda;
	
	// Variável de controle que, quando verdadeira, indica que a lombriga está virada para a direita
	boolean direita; 
	
	AquarioLombriga(int tamAquario, int tamLombriga, int posLombriga){
		this.tamAquario = tamAquario;
		this.tamLombriga = tamLombriga;
		
		// Condição de contorno: lombriga maior do que o aquário
		if(this.tamAquario < this.tamLombriga) {
			this.tamAquario = this.tamLombriga;
		}
		
		this.posLombriga = posLombriga;
		posCauda = posLombriga - (tamLombriga - 1);
		
		// Condição de contorno: posição inicial da lombriga não a comporta no aquário
		if(posCauda < 1) {
			this.posLombriga = this.tamLombriga;
			posCauda = 1;
		}
		
		direita = true;
	}
	
	void crescer(){
		// Se há espaço para a lombriga crescer e ela está virada para a direita
		if((direita) && (posCauda > 1)) {
			tamLombriga++;
			posCauda--;
			return;
		}
		
		// Se há espaço para a lombriga crescer e ela está virada para a esquerda
		if(!(direita) && (posCauda < tamAquario)) {
			tamLombriga++;
			posCauda++;
			return;
		}
		
	}
	
	void mover() {
		// Se a lombriga está virada para a direita
		if(direita) {
			
			// Se estamos no limite do aquário
			if(posLombriga == tamAquario) {
				virar();
				return;
			}
			
			posLombriga++;
			posCauda++;
		}
		
		// Se a lombriga está virada para a esquerda
		else {
			
			// Se estamos no limite do aquário
			if(posLombriga == 1) {
				virar();
				return;
			}
			
			posLombriga--;
			posCauda--;
		}
	}
	
	void virar() {
		// Salvamos temporariamente as posições originais da cabeça e da cauda
		int cabecaOrig = posLombriga;
		int caudaOrig = posCauda;
		
		// Invertemos as posições da cabeça e da cauda e aplicamos o toggle na variável de posição
		posLombriga = caudaOrig;
		posCauda = cabecaOrig;
		
		direita = !direita;
	}
	
	String criaLombriga() {
		// Método auxiliar usado para criar a representação em string da lombriga
		
		String lombriga = "";
		char pedaco = '@';
		
		// Se a lombriga está virada para a direita
		if(direita) {
			for(int i = 0; i < (tamLombriga - 1); i++) {
				lombriga += pedaco;
			}
			lombriga += 'O';
		}
		
		// Se a lombriga está virada para a esquerda
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
		
		// Criamos a representação da lombriga
		String lombriga = criaLombriga();
		
		for(int i = 1; i < tamAquario; i++) {
			// Quando encontramos a posição para inserir a lombriga
			if((i == posCauda) || (i == posLombriga)) {
				aquario += lombriga;
				i += tamLombriga;
				continue;
			}
			
			aquario += vazio;
		}
		
		return aquario;
	}
	

}
