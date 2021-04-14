package mc322.lab03;

public class AquarioLombriga {
	
	int tamAquario, tamLombriga, posLombriga, posCauda;
	
	// Vari�vel de controle que, quando verdadeira, indica que a lombriga est� virada para a direita
	boolean direita; 
	
	AquarioLombriga(int tamAquario, int tamLombriga, int posLombriga){
		this.tamAquario = tamAquario;
		this.tamLombriga = tamLombriga;
		
		// Condi��o de contorno: lombriga maior do que o aqu�rio
		if(this.tamAquario < this.tamLombriga) {
			this.tamAquario = this.tamLombriga;
		}
		
		this.posLombriga = posLombriga;
		posCauda = posLombriga - (tamLombriga - 1);
		
		// Condi��o de contorno: posi��o inicial da lombriga n�o a comporta no aqu�rio
		if(posCauda < 1) {
			this.posLombriga = this.tamLombriga;
			posCauda = 1;
		}
		
		direita = true;
	}
	
	void crescer(){
		// Se h� espa�o para a lombriga crescer e ela est� virada para a direita
		if((direita) && (posCauda > 1)) {
			tamLombriga++;
			posCauda--;
			return;
		}
		
		// Se h� espa�o para a lombriga crescer e ela est� virada para a esquerda
		if(!(direita) && (posCauda < tamAquario)) {
			tamLombriga++;
			posCauda++;
			return;
		}
		
	}
	
	void mover() {
		// Se a lombriga est� virada para a direita
		if(direita) {
			
			// Se estamos no limite do aqu�rio
			if(posLombriga == tamAquario) {
				virar();
				return;
			}
			
			posLombriga++;
			posCauda++;
		}
		
		// Se a lombriga est� virada para a esquerda
		else {
			
			// Se estamos no limite do aqu�rio
			if(posLombriga == 1) {
				virar();
				return;
			}
			
			posLombriga--;
			posCauda--;
		}
	}
	
	void virar() {
		// Salvamos temporariamente as posi��es originais da cabe�a e da cauda
		int cabecaOrig = posLombriga;
		int caudaOrig = posCauda;
		
		// Invertemos as posi��es da cabe�a e da cauda e aplicamos o toggle na vari�vel de posi��o
		posLombriga = caudaOrig;
		posCauda = cabecaOrig;
		
		direita = !direita;
	}
	
	String criaLombriga() {
		// M�todo auxiliar usado para criar a representa��o em string da lombriga
		
		String lombriga = "";
		char pedaco = '@';
		
		// Se a lombriga est� virada para a direita
		if(direita) {
			for(int i = 0; i < (tamLombriga - 1); i++) {
				lombriga += pedaco;
			}
			lombriga += 'O';
		}
		
		// Se a lombriga est� virada para a esquerda
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
		
		// Criamos a representa��o da lombriga
		String lombriga = criaLombriga();
		
		for(int i = 1; i < tamAquario; i++) {
			// Quando encontramos a posi��o para inserir a lombriga
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
