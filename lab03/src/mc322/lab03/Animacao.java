package mc322.lab03;

public class Animacao {

    // Entrada de dados e sequencia de comandos
    String input, sequencia;

    // Parametros da lombriga
    int tamAquario, tamLombriga, posCauda;
    AquarioLombriga lombriga;

    // Controle de posicao na string de comando
    int atual = 0;

    Animacao(String input) {

        // Extraimos do input os parametros da lombriga
        tamAquario = Integer.parseInt(input.substring(0, 2));
        tamLombriga = Integer.parseInt(input.substring(2, 4));
        posCauda = Integer.parseInt(input.substring(4, 6));

        // Extraimos os comandos numa string separada
        sequencia = input.substring(6);

        // Criamos a lombriga
        lombriga = new AquarioLombriga(tamAquario, tamLombriga, posCauda);
    }

    String apresenta() {

        String aquario;

        aquario = lombriga.apresenta();

        return aquario;
    }

    void passo() {

        // Se já executamos toda a sequencia de comandos
        if (atual >= sequencia.length()) {
            return;
        }

        char comando = sequencia.charAt(atual);

        switch (comando) {
        case 'C':
            lombriga.crescer();
            break;

        case 'M':
            lombriga.mover();
            break;

        case 'V':
            lombriga.virar();
            break;
        }

        atual++;

        return;
    }

}
