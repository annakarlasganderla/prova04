package View;

import Controller.LivroController;
import Model.Biblioteca;
import Model.Genero;
import Model.Livro;

import java.util.Locale;
import java.util.Scanner;

public class LivroView {

    Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
    LivroController livroController = new LivroController();

    public void cadastrarLivros () {
        GeneroView generoView = new GeneroView();
        BibliotecaView bibliotecaView = new BibliotecaView();

        Livro livro = new Livro();

        System.out.println("Informe o nome do livro: ");
        livro.setNomeLivro(leitor.next());

        System.out.println("Informe o genero do livro: ");
        Genero genero = generoView.getGeneroById();
        livro.setIdGeneroLivro(genero);

        System.out.println("Informe a biblioteca onde você quer cadastrar o livro: ");
        Biblioteca biblioteca = bibliotecaView.getBibliotecaById();
        livro.setBiblioteca(biblioteca);

        livroController.criaTabelaLivros();
        livroController.cadastraLivros(livro);
    }

    public void mostrarLivros() {
        System.out.println(livroController.listarLivros());
    }

    public void listarLivrosByIdGenero() {
        GeneroView generoView = new GeneroView();
        Genero genero = generoView.getGeneroById();

        System.out.println(livroController.getLivrosByIdGenero(genero));
    }

    public void listarLivrosByIdBiblioteca() {
        BibliotecaView bibliotecaView = new BibliotecaView();
        Biblioteca biblioteca = bibliotecaView.getBibliotecaById();

        System.out.println(livroController.getLivrosByIdBiblioteca(biblioteca));
    }

    public void menuLivros() {
        int op = 0;
        char control = 's';

        do {
            do {
                System.out.println("--------------------------------------------------------");
                System.out.println("|        0 - Sair                                      |");
                System.out.println("|        1 - Cadastrar                                 |");
                System.out.println("|        2 - Visualizar Todos                          |");
                System.out.println("|        3 - Visualizar por Genero                     |");
                System.out.println("|        4 - Visualizar por Biblioteca                 |");
                System.out.println("--------------------------------------------------------");
                System.out.println("|           Digite aqui a sua opção:                   |");
                System.out.println("--------------------------------------------------------");
                op = leitor.nextInt();
            } while (op == 5);

            switch (op) {

                case 0:
                    break;

                case 1:
                    do {
                        this.cadastrarLivros();

                        System.out.println("Deseja continuar cadastrando? digite s ou S para sim");
                        control = leitor.next().charAt(0);

                    } while (control == 's' || control == 'S');

                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 2:
                    this.mostrarLivros();
                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 3:
                    this.listarLivrosByIdGenero();
                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 4:
                    this.listarLivrosByIdBiblioteca();
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
