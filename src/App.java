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
                    criaArea(conn, scanner);
                    break;
                case 3:
                    alteraArea(scanner, conn);
                    break;
                case 4:
                    criaCurso(scanner, conn);
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

    public static void criaArea(sqlConn sqlConn, Scanner scanner) {
        scanner.nextLine();

        System.out.println("Digite a descrição da área:");
        String desc = scanner.nextLine();
        System.out.println("Digite o número de cursos pelo qual a área é responsável:");
        int curso = scanner.nextInt();

        String sql = "INSERT INTO areas (descricao, cursos) VALUES (?, ?)";

        try(Connection conn = sqlConn.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, desc);
            pstmt.setInt(2, curso);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Área cadastrada com sucesso!");
            } else {
                System.out.println("Erro ao cadastrar área.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void alteraArea(Scanner scanner, sqlConn sqlConn) {
        scanner.nextLine();

        System.out.println("Digite o código da área que deseja alterar:");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite a nova descrição da área:");
        String desc = scanner.nextLine();
        System.out.println("Digite o novo número de cursos pelo qual a área é responsável:");
        int curso = scanner.nextInt();

        String sql = "UPDATE areas SET descricao = ?, cursos = ? WHERE codigo = ?";

        try(Connection conn = sqlConn.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, desc);
            pstmt.setInt(2, curso);
            pstmt.setInt(3, codigo);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Área alterada com sucesso!");
            } else {
                System.out.println("Erro ao alterar área.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    public static void criaCurso(Scanner scanner, sqlConn sqlConn) {
        scanner.nextLine();

        System.out.println("Digite o nome do curso:");
        String nome = scanner.nextLine();
        LocalDate dataI, dataF;
        do{
            System.out.println("Digite a data de início do curso (YYYY-MM-DD):");
            String dataInicio = scanner.nextLine();
            dataI = LocalDate.parse(dataInicio);
        }while(!dataI.isAfter(LocalDate.now()));
        do{
            System.out.println("Digite a data de fim do curso (YYYY-MM-DD):");
            String dataFim = scanner.nextLine();
            dataF = LocalDate.parse(dataFim);
        }while(!dataF.isBefore(LocalDate.now()) && !dataF.isAfter(dataI));
        System.out.println("Digite o código do professor responsável:");
        int prof = scanner.nextInt();
        System.out.println("Digite o código da área responsável:");
        int area = scanner.nextInt();

        String sql = "INSERT INTO cursos (nome, inicio, fim, professor, area) VALUES (?, ?, ?, ?, ?)";

        try(Connection conn = sqlConn.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setObject(2, dataI);
            pstmt.setObject(3, dataF);
            pstmt.setInt(4, prof);
            pstmt.setInt(5, area);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Curso cadastrado com sucesso!");
            } else {
                System.out.println("Erro ao cadastrar curso.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    
}
