package View;

import java.util.Locale;
import java.util.Scanner;

public class MenuPrincipal {

    public void menu() {
        Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

        int op = 0;
        char control = 's';

        do {
            do {
                System.out.println("------------------------------------");
                System.out.println("|        0 - Sair                  |");
                System.out.println("|        1 - Livros                |");
                System.out.println("|        2 - Bibliotecas           |");
                System.out.println("|        3 - Generos               |");
                System.out.println("------------------------------------");
                System.out.println("|     Digite aqui a sua opção:     |");
                System.out.println("------------------------------------");
                op = leitor.nextInt();
            } while (op == 5);

            switch (op) {

                case 0:
                    break;

                case 1:
                    LivroView livroView = new LivroView();
                    livroView.menuLivros();

                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 2:
                    BibliotecaView bibliotecaView = new BibliotecaView();
                    bibliotecaView.menuBiblioteca();

                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 3:
                    GeneroView generoView = new GeneroView();
                    generoView.menuGenero();

                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                default:
                    System.out.println("Opção inválida");
                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;
            }

        } while (op != 0);

    }

}
