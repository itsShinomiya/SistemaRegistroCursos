import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        boolean x = true;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("MENU \n" +
                               "1. Cadastrar professores \n" +
                               "2. Cadastrar área técnica \n" +
                               "3. Alterar área técnica \n" +
                               "4. Cadastrar curso \n" +
                               "5. Sair");
            int escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    
                    break;
            
                default:
                    break;
            }
        } while (x == true);
        scanner.close();
        sqlConn conn = new sqlConn();
    }
}
