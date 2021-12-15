package View;

import Controller.BibliotecaController;
import Model.Biblioteca;
import Model.Genero;

import java.util.Locale;
import java.util.Scanner;

public class BibliotecaView {
    Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
    BibliotecaController bibliotecaController = new BibliotecaController();

    public void cadastraBiblioteca() {
        Biblioteca biblioteca = new Biblioteca();

        System.out.println("Digite o nome da biblioteca: ");
        biblioteca.setNomeBiblioteca(leitor.next());

        bibliotecaController.criaTabelaBiblioteca();
        bibliotecaController.cadastraBibliotecas(biblioteca);
    }

    public void mostrarBibliotecas() {
        System.out.println(bibliotecaController.listarBibliotecas());
    }

    public Biblioteca getBibliotecaById() {
        this.mostrarBibliotecas();

        System.out.println("Selecione a biblioteca: ");
        int bib = leitor.nextInt();

        Biblioteca biblioteca = bibliotecaController.getBibliotecasById(bib);

        System.out.println("A biblioteca selecionada foi: " + biblioteca.getNomeBiblioteca());

        return biblioteca;
    }

    public void menuBiblioteca() {
        int op = 0;
        char control = 's';

        do {
            do {
                System.out.println("-------------------------------------");
                System.out.println("|        0 - Sair                   |");
                System.out.println("|        1 - Cadastrar              |");
                System.out.println("|        2 - Visualizar             |");
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
                        this.cadastraBiblioteca();

                        System.out.println("Deseja continuar cadastrando? digite s ou S para sim");
                        control = leitor.next().charAt(0);

                    } while (control == 's' || control == 'S');

                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 2:
                    this.mostrarBibliotecas();
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
