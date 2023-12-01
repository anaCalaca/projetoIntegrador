package com.empresa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.empresa.controller.ClienteController;
import com.empresa.controller.ProdutoController;
import com.empresa.model.Cliente;
import com.empresa.model.Produto;
import com.empresa.repositorio.ClienteRepositorio;
import com.empresa.repositorio.ProdutoRepositorio;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SpringComposicaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringComposicaoApplication.class, args);
	}
	
	@Autowired
	private ClienteController clienteControler;

	@Autowired
	private ProdutoController produtoControler;
	
	@Bean
	public CommandLineRunner demo(ClienteRepositorio clienteRepositorio, ProdutoRepositorio produtoRepositorio) {
		return args -> {
			Scanner scanner = new Scanner(System.in);
			int choice;

			do {
				System.out.println("\n------ Menu ------");
				System.out.println("1. Cadastrar cliente");
				System.out.println("2. Visualizar cliente");
				System.out.println("3. Cadastrar produto");
				System.out.println("4. Visualizar produto");
				System.out.println("5. Estoque");
				System.out.println("6. Orçamento");
				System.out.println("7. Agenda");
				System.out.println("8. Check-in");
				System.out.println("9. Check-out");
				System.out.println("10. Sair");
				System.out.println("--------------------");
				System.out.println("");
				System.out.print("Escolha uma opção: ");

				choice = scanner.nextInt();
				scanner.nextLine(); // Consumir a quebra de linha

				switch (choice) {
				case 1:
					createLiente(clienteRepositorio, scanner);
					break;
				case 2:
					viewCliente(clienteRepositorio);
					break;
				case 3:
					createProduto(produtoRepositorio, scanner);
					break;
				case 4:
					viewpProduto(produtoRepositorio);
					break;
//              case 5:
//                  break;
//              case 6:
//                  break;
//				case 7:
////                break;
////            case 8:
////                break;
//				case 9:
////                break;	
				case 10:
					System.out.println("Saindo do Sistema.");
					break;
				default:
					System.out.println("Opção Inválida. Tente novamente.");
				}
			} while (choice != 7);
		};
	}

// CRIAR CLIENTE
	private void createLiente(ClienteRepositorio clienteRepositorio, Scanner scanner) {
		System.out.print("Nome do cliente: ");
		String name = scanner.nextLine();

		   System.out.print("CPF do cliente: ");
		    String cpf = scanner.nextLine();
		    
		    System.out.print("Telefone do cliente: ");
		    String telefone = scanner.nextLine();
		    
		    System.out.print("Email do cliente: ");
		    String email = scanner.nextLine();
		    
		    System.out.print("Endereço do cliente: ");
		    String endereco = scanner.nextLine();

		
		    
		    clienteControler.salvarCliente(name, cpf, telefone, email, endereco);
		    
		    
		System.out.println("Cliente cadastrado com Sucesso.");
	}

//VER CLIENTE CADASTRADO
	private void viewCliente(ClienteRepositorio clienteRepositorio) {
		List<Cliente> cliente = clienteRepositorio.findAll();

		System.out.println("\n------ Cliente ------");
		for (Cliente clientes : cliente) {
			System.out.println("ID: " + clientes.getId() + ", Nome: " + clientes.getName());
		}
	}

//CRIAR PRODUTO
	private void createProduto(ProdutoRepositorio produtoRepositorio, Scanner scanner) {
		System.out.print("Cadastrar produto: ");
		String name = scanner.nextLine();

		System.out.print("Valor do produto: ");
		double valor = scanner.nextDouble();		
		
		System.out.print("Desconto do produto: ");
		double desconto = scanner.nextDouble();

		
		Produto produto = new Produto(name, valor, desconto);
		produtoRepositorio.save(produto);

		produtoControler.salvarProduto(name, valor, desconto);
		
		System.out.println("Produto cadastrado com Sucesso.");
	}

	private void viewpProduto(ProdutoRepositorio produtoRepositorio) {
		List<Produto> produtos = produtoRepositorio.findAll();

		System.out.println("\n------ Cursos ------");
		for (Produto produto : produtos) {
			System.out.println("ID: " + produto.getId() + ", Nome: " + produto.getName());
		}
	}
}
//    private void enrollStudentInCourse(StudentRepository studentRepository, CourseRepository courseRepository,
//                                       EnrollmentRepository enrollmentRepository, Scanner scanner) {
//        System.out.print("Enter com ID do Estudante: ");
//        int studentId = scanner.nextInt();
//        scanner.nextLine();  // Consumir a quebra de linha
//
//        System.out.print("Enter com ID do Curso: ");
//        int courseId = scanner.nextInt();
//        scanner.nextLine();  // Consumir a quebra de linha
//
//        Student student = studentRepository.findById((long) studentId).orElse(null);
//        Course course = courseRepository.findById((long) courseId).orElse(null);
//
//        if (student != null && course != null) {
//            Enrollment enrollment = new Enrollment(student, course);
//            enrollmentRepository.save(enrollment);
//
//            System.out.println("Estudante matriculado no curso com sucesso.");
//        } else {
//            System.out.println("Estudante ou Curso não encontrado.");
//        }
//    }
//
//    private void viewEnrollments(EnrollmentRepository enrollmentRepository) {
//        List<Enrollment> enrollments = enrollmentRepository.findAll();
//
//        System.out.println("\n------ Matrícula ------");
//        for (Enrollment enrollment : enrollments) {
//            System.out.println("ID: " + enrollment.getId() +
//                    ", Estudante: " + enrollment.getStudent().getName() +
//                    ", Curso: " + enrollment.getCourse().getName() +
//                    ", Data da Matrícula: " + enrollment.getEnrollmentDate());
//        }
//}
