import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("Informe seu nome completo:");
        String nome = read.nextLine();

        String tipoConta;

        do{
            System.out.println("Escolha o tipo de conta: 1) para corrente, 2) para poupança):");
            int type = read.nextInt();

            if(type == 1){
                tipoConta = "Corrente";
            } else if(type == 2){
                tipoConta = "Poupança";
            } else {
                tipoConta = "Invalido";
            }
        } while (tipoConta == "Invalido");

        Double montante;

        if(tipoConta == "Corrente"){
            System.out.println("Digite o saldo da sua conta corrente: ");
            montante = read.nextDouble();
        } else {
            do {
                System.out.println("Digite o saldo da sua conta poupança: ");
                montante = read.nextDouble();
                if (montante <= 0) {
                    System.out.println("Sua conta é poupança e não pode ser negativa");
                }

            } while (montante <= 0);
        }

        System.out.println("Nome: " + nome);
        System.out.println("Tipo de conta: " + tipoConta);
        System.out.println("Saldo inicial: R$" + montante);

        int option;

        do {
            System.out.println("""
                    OPERAÇÕES:
                    
                    1- Consultar saldos
                    2- Receber valor
                    3- Transferir valor
                    4- Sair
                """);
            option = read.nextInt();
            if(option == 1){
                System.out.println("Seu saldo é: " + montante);
            } else if(option == 2){
                System.out.println("Digite o valor a ser depositado: ");
                double sum = read.nextDouble();
                montante += sum;
                System.out.println("Seu novo valor é: R$" + montante);
            } else if(option == 3){
                System.out.println("Digite o valor a ser transferido: ");
                double min = read.nextDouble();
                montante -= min;
                System.out.println("Seu novo valor é: R$" + montante);
            } else if(option == 4){
                return;
            }
        }while (option != 4);

        read.close();
    }

}