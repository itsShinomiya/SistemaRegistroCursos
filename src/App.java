import java.util.Scanner;
import java.sql.*;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        boolean x = true;
        Scanner scanner = new Scanner(System.in);
        sqlConn conn = new sqlConn();
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
                    criaProfessor(scanner, conn);
                    break;
                case 2:
                    criaArea();
                    break;
                case 3:
                    alteraArea();
                    break;
                case 4:
                    criaCurso();
                    break;
                case 5:
                    x = false;
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        } while (x == true);
        scanner.close();
    }

    public static void criaProfessor(Scanner scanner, sqlConn sqlConn) {
        scanner.nextLine();

        System.out.println("Digite o nome do professor:");
        String nome = scanner.nextLine();
        System.out.println("Digite a data de nascimento do professor:");
        String dataNascimento = scanner.nextLine();
        LocalDate data = LocalDate.parse(dataNascimento);
        System.out.println("Digite o salário do professor:");
        double salario = scanner.nextDouble();
        System.out.println("Digite o número de cursos ministrados pelo professor:");
        int curso = scanner.nextInt();

        String sql = "INSERT INTO professores (nome, data, salario, cursosministrados) VALUES (?, ?, ?, ?)";

        try(Connection conn = sqlConn.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setObject(2, data);
            pstmt.setDouble(3, salario);
            pstmt.setInt(4, curso);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Professor cadastrado com sucesso!");
            } else {
                System.out.println("Erro ao cadastrar professor.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void criaArea() {
        
    }

    public static void alteraArea() {
        
    }

    public static void criaCurso() {
        
    }    
}
