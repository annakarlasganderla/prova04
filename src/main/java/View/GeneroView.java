package View;

import Controller.GeneroController;
import Model.Genero;

import java.util.Locale;
import java.util.Scanner;

public class GeneroView {

    Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
    GeneroController generoController = new GeneroController();

    public void cadastrarGenero () {
        Genero genero = new Genero();

        System.out.println("Digite o nome do genero: ");
        genero.setNomeGenero(leitor.next());

        generoController.criaTabelaGeneros();
        generoController.cadastraGeneros(genero);
    }

    public void mostrarGeneros() {
        System.out.println(generoController.listarGeneros());
    }

    public Genero getGeneroById() {
        this.mostrarGeneros();

        System.out.println("Selecione o genero: ");
        int gen = leitor.nextInt();

        Genero genero = generoController.getGeneroById(gen);

        System.out.println("O genero selecionado foi: " + genero.getNomeGenero());

        return genero;
    }

    public void editaGenero(Genero genero) {
        int op = 0;

        do {
            System.out.println("Escolha o que você quer editar: ");
            System.out.println("| 1 - Nome       |");

            int selecionaAtributo = leitor.nextInt();

            switch (selecionaAtributo) {
                case 1:
                    System.out.println("Digite o novo nome: ");
                    genero.setNomeGenero(leitor.next());
                    break;

                default:
                    System.out.println("Opção invalida");
            }
            System.out.println("Deseja continuar? 1 - Sim | 0 - Não");
            op = leitor.nextInt();

        } while (op != 0);

        System.out.println("Genero editado com sucesso!");
        generoController.editaGenero(genero);
    }

    public void menuGenero() {
        int op = 0;
        char control = 's';

        do {
            do {
                System.out.println("-------------------------------------");
                System.out.println("|        0 - Sair                   |");
                System.out.println("|        1 - Cadastrar              |");
                System.out.println("|        2 - Visualizar             |");
                System.out.println("|        3 - Editar                 |");
                System.out.println("-------------------------------------");
                System.out.println("|     Digite aqui a sua opção:      |");
                System.out.println("-------------------------------------");
                op = leitor.nextInt();
            } while (op == 5);

            switch (op) {

                case 0:
                    break;

                case 1:
                    do {
                        this.cadastrarGenero();

                        System.out.println("Deseja continuar cadastrando? digite s ou S para sim");
                        control = leitor.next().charAt(0);

                    } while (control == 's' || control == 'S');

                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 2:
                    this.mostrarGeneros();
                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 3:
                    this.editaGenero(getGeneroById());
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
