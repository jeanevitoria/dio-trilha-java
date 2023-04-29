import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {

            Scanner sc = new Scanner (System.in);
            System.out.println("Digite o seu nome: ");
            String nomeCliente = sc.next();
            System.out.println("Digite o número da conta: ");
            int numero = sc.nextInt();
            System.out.println("Digite o saldo da conta: ");
            double saldo = sc.nextDouble();
            System.out.println("Digite o número da Agência: ");
            String agencia = sc.next();
            sc.close();
            System.out.println("Olá "+ nomeCliente + ", obrigado por criar uma conta em nosso banco, sua Agência é " + agencia + ", Conta " + numero + " e seu saldo " + saldo + " já está disponível para saque.");
    }
}
