/*

INTEGRANTES

Marcel Assunção da Silva  / RA: 1136750
Joaquim Lorenzoni Amarante / RA: 1136252
Gabriel Henrique Ramos Cannini / RA 1135604
*/

// Aqui importamos o Objeto/Variável Sacnner externamente para nosso código.
import java.util.Scanner;

public class combustivel {
    
    public static void main(String[] args) {
        
        Scanner lerTeclado = new Scanner(System.in);
        
        // Aqui definimos nossos vetores para armazenar nossos carros criados e valores de combustível, sendo ambos definidos para armazenar no máximo 5 elementos cada.
        String[] nomesCarros = new String[5];
        double[] valoresCombustivel = new double[5];

        // Decidimos deixá-la como "String" em vez de int, pois nas conferências do código abaixo, nos ajuda em casos em que o usuário tente digitar alguma letra e não números, o que não tem sentido para o menu.
        String opcao;
        int cadastrados = 0;

        // Decidimos utilizar um "Do While" para garantir a execução do nosso programa ao menos 1 vez ao usuário.
        do { 
            System.out.println(" MENU");
            System.out.println(" 1. CADASTRAR CARRO");
            System.out.println(" 2. EXIBIR TODOS OS CARROS E GASTOS");
            System.out.println(" 3. MOSTRAR CARRO QUE MAIS GASTOU");
            System.out.println(" 4. MOSTRAR TOTAL GASTO EM COMBUSTÍVEL");
            System.out.println(" 5. MOSTRAR A MÉDIA DE GASTO DOS CARROS");
            System.out.println(" 0. SAIR DO PROGRAMA");

            // Aqui nossa variável "opcao", criada anteriormente, assumirá o valor digitado pelo nosso usuário no Terminal
            opcao = lerTeclado.nextLine();

            // Iniciamos um "Switch" para estabelecermos as ações tomados pelo nosso programa a partir de cada valor da variável "opcao".
            switch (opcao) {
                case "1":
                    
                // Inicialmente fazemos a conferência do número de carros que já temos registrados, pois se já houver 5 carros, não será possível cadastrar mais 1. Caso não, será solicitado o nome deste novo carro
                // e o mesmo será alocado como um novo elemento no vetor de "nomesCarros".
                    if (cadastrados < 5) {
                        System.out.print("Digite o nome do carro: ");
                        nomesCarros[cadastrados] = lerTeclado.nextLine();

                        double gasto;

                        //Aqui inciamos mais um loop, que se não se encerrará enquanto o usuário não digitar um valor válido de combustível.
                        do {
                            System.out.print("Digite o gasto com combustível: ");
                            gasto = lerTeclado.nextDouble();
                            lerTeclado.nextLine();

                            // É feita a conferência se o valor digitado é igual ou menor a 0, pois se for, é considerado um valor inválido. 
                            if (gasto <= 0) {
                                System.out.println("\nValor inválido. O gasto deve ser positivo.\n"); // Como um todo, aplicamos o "\n" para termos um espaçamento entre o resultado e o menu mais agradável visualmente.
                            }
                        } while (gasto <= 0);

                        // O valor digitado pelo usurário é alocado como um novo elemento do vetor "valoresCombustivel" e é somado 1 ao número de cadastros de elementos deste vetor. 
                        valoresCombustivel[cadastrados] = gasto;
                        cadastrados++;

                        System.out.println("\n Carro cadastrado com sucesso! \n");
                    } else {
                        System.out.println("\nLimite de 5 carros atingido.\n");
                    }
                    break;

                case "2":
                
                    // Das funcionalidades do menu, de 2 à 5, sempre iniciamos cada case fazendo a conferência se há ou não, ao menos 1 carro cadastrado, pois se não houver, 
                    // não tem sentido solicitar tais funcionalidades. 
                    if (cadastrados == 0) {
                        System.out.println("\nNenhum carro cadastrado!\n");
                    } else {
                        System.out.println("\nCarros cadastrados e seus respectivos gastos:\n");
                        
                        // Iniciamos um laço for para fazer a conferência de todos os nossos elementos dos vetores, assim listando um por um.
                        for (int i = 0; i < cadastrados; i++) {
                            System.out.println(nomesCarros[i] + " - R$ " + valoresCombustivel[i] + "\n");
                        }
                    }
                    break;
                
                case "3":

                    if (cadastrados > 0) {

                        // Iniciamos a variável "maiorGasto", a qual atribuimos o valor do gasto de combustivel do primeiro carro cadastrado em nosso vetor "valoresCombustivel"
                        double maiorGasto = valoresCombustivel[0];
                        int indiceMaior = 0;


                        // Neste laço, fazemos uma conferência do valor de cada combustível cadastrado, verificando se há algum valor maior do que o atribuído à posição "valoresCombustivel[0]"
                        for (int i = 0; i < cadastrados; i++) {
                            if (valoresCombustivel[i] > maiorGasto) {
                                maiorGasto = valoresCombustivel[i];

                                // Em nossa variável indiceMaior, criada anteriormente neste case, atribuímos á ela o valor de "indice" do elemento a qual possua o gasto de combustível maior,
                                // para assim em seguida podermos utilizar o mesmo em nosso "println".
                                indiceMaior = i;
                            }
                        }

                        System.out.println("\nCarro que mais gastou: " + nomesCarros[indiceMaior] + " - R$ " + maiorGasto + "\n");
                    } else {
                        System.out.println("\nNenhum carro cadastrado.\n");
                    }
                    break;

                case "4":

                    // Aqui fazemos um laço para somar todos os valores de combustível cadastrados em nosso vetor, e então vínculamos este resultado á variável "gastoTotal"
                    if (cadastrados > 0){
                        double gastoTotal = 0;
                        for (int i = 0; i < cadastrados; i++) {
                            gastoTotal += valoresCombustivel[i];
                        }
                        System.out.println("\n Total gasto com combustível: R$ " + gastoTotal + "\n");
                    }
                    else {
                        System.out.println("\nNenhum carro cadastrado.\n");
                    }
                    break;

                // Aqui definimos uma variável double "mediaGastos" com valor inicial zerado e armazenamos nela a soma de todos os gastos fornecidos pelo usuário a 
                // partir de um laço "for" que percorre todos os carros cadastrados e, após isso, divide o valor de "mediaGastos" pelo número de carros cadastrados.
                case "5":

                    if (cadastrados > 0) {
                        double mediaGasto = 0;
                        for (int i = 0; i < cadastrados; i++) {
                            mediaGasto += valoresCombustivel[i];
                        }
                        mediaGasto /= cadastrados;
                        System.out.println("\n Média de gasto dos carros: R$ " + String.format("%.2f", mediaGasto) + "\n");
                    } else {
                        System.out.println("\nNenhum carro cadastrado.\n");
                    }
                    break;

                // Caso o usuário digite "0", o programa se encerrará e uma mensagem de encerramento será exibida.
                case "0":

                    System.out.println("Encerrando o programa...");
                    break;
                    
                // Caso o usuário digite um valor diferente de 0, 1, 2, 3, 4 ou 5, uma mensagem de erro será exibida e o menu será apresentado novamente ao usuário.
                default:
                    System.out.println("\n Digite uma opção válida\n");
            }

        // Estabelecemos que o programa rodará até que o usuário digite a opção de Encerrar o Programa
        } while (!opcao.equals("0"));
        
        lerTeclado.close();
    }
}