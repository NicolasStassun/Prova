import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        addPadrao();
        do {
        login();
        }while(logado!=true);
    }

    static Funcionario FuncionarioLogado = new Funcionario(null,0,0);
    static boolean logado = false;

    public static void login(){



            int Matricula = Integer.parseInt(JOptionPane.showInputDialog("Login \n\n"+
                    "Matrícula"));
            int senha = Integer.parseInt(JOptionPane.showInputDialog("Senha \n" +
                    "*A senha não pode conter nenhum caracter especial."));
            for (Funcionario i :
                    Funcionario.funcionario) {

                if (Matricula == i.matricula && senha == i.cpf) {

                    logado = true;

                    FuncionarioLogado = i;

                    menu();

                    return;

                }

            }
            JOptionPane.showMessageDialog(null, "Erro");

    }
    public static void menu(){

        int opcao = Integer.parseInt(JOptionPane.showInputDialog("Bem Vindo "+FuncionarioLogado.Nome+"\n"+
                """
                1 - Registrar Venda
                2 - Alterar Preço
                3 - Repor Estoque
                4 - Informações do Usuário
                5 - Informações do Produto
                6 - Sair
                
                """));

        if(opcao==1){

            registrarVenda();
            menu();

        }
        else if(opcao==2){

            alterarPreco();
            menu();

        }
        else if(opcao==3){

            reporEstoque();
            menu();

        }
        else if(opcao==4){

            mostrarFuncionario();
            menu();

        }
        else if(opcao==5){

            mostrarProduto();
            menu();

        }
        else if(opcao==6){

            sair();

        }
        else{

            JOptionPane.showMessageDialog(null,"Erro");

        }

    }
    public static void registrarVenda(){

        FuncionarioLogado.registrarVenda(FuncionarioLogado.matricula);
        return;

    }
    public static void alterarPreco(){

        FuncionarioLogado.alterarPreco();
        return;

    }
    public static void reporEstoque(){

        FuncionarioLogado.reporEstoque();
        return;

    }
    public static void mostrarFuncionario(){

        FuncionarioLogado.buscarFuncionario(FuncionarioLogado.matricula);

    }
    public static void mostrarProduto(){

        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do produto que deseja Procurar"));

        Produto.procurarProduto(codigo);

    }
    public static void sair(){

        for (Funcionario i:
             Funcionario.funcionario) {

            if (i.matricula == FuncionarioLogado.matricula){

                i = FuncionarioLogado;

            }

        }

        logado = false;

    }
    public static void addPadrao(){

        Funcionario Funcionario1 = new Funcionario("Fulano",123,2000.0);
        Funcionario Funcionario2 = new Funcionario("Mathues",1,2000.0);
        Funcionario Funcionario3 = new Funcionario("Miguel",2,2000.0);
        Funcionario Funcionario4 = new Funcionario("Gustavo",3,2000.0);
        Funcionario Funcionario5 = new Funcionario("Henrique",4,2000.0);

        Funcionario.funcionario.add(Funcionario1);
        Funcionario.funcionario.add(Funcionario2);
        Funcionario.funcionario.add(Funcionario3);
        Funcionario.funcionario.add(Funcionario4);
        Funcionario.funcionario.add(Funcionario5);

        for (Funcionario i:
             Funcionario.funcionario) {

            i.matricula = Funcionario.funcionario.indexOf(i)+1;

        }

        Produto Produto1 = new Produto("Regata Milwaukee Bucks",450.0,100);
        Produto Produto2 = new Produto("Regata Brooklyn Nets",450.0,100);
        Produto Produto3 = new Produto("Regata Los Angeles Lakers",450.0,50);
        Produto Produto4= new Produto("Regata Los Angeles Clippers",450.0,100);
        Produto Produto5 = new Produto("Regata Phoenix Suns",450.0,100);
        Produto Produto6 = new Produto("Regata Dallas Mavericks",450.0,100);
        Produto Produto7= new Produto("Regata Boston Celtics",450.0,100);
        Produto Produto8 = new Produto("Regata Sacramento Kings",450.0,100);
        Produto Produto9 = new Produto("Regata Cleveland Cavaliers",450.0,100);
        Produto Produto10 = new Produto("Regata Minessota Timberwolves",450.0,100);
        Produto Produto11 = new Produto("Regata OKC Thunders",450.0,100);
        Produto Produto12 = new Produto("Regata Golden State Warriors",450.0,100);
        Produto Produto13 = new Produto("Tênis Lebron XX",1200.0,20);
        Produto Produto14 = new Produto("Tênis Kyrie Infinity",635.0,100);
        Produto Produto15 = new Produto("Tênis D.O.N Issue 4",790.0,100);
        Produto Produto16 = new Produto("Tênis Harden Vol 6",1000.0,100);
        Produto Produto17 = new Produto("Tênis Ja 1",650.0,100);
        Produto Produto18 = new Produto("Tênis Kobe 4",990.99,100);
        Produto Produto19 = new Produto("Bola de Basquete Spalding",250.0,100);
        Produto Produto20 = new Produto("Bola de Basquete Wilson",354.90,100);

        Produto.produtos.add(Produto1);
        Produto.produtos.add(Produto2);
        Produto.produtos.add(Produto3);
        Produto.produtos.add(Produto4);
        Produto.produtos.add(Produto5);
        Produto.produtos.add(Produto6);
        Produto.produtos.add(Produto7);
        Produto.produtos.add(Produto8);
        Produto.produtos.add(Produto9);
        Produto.produtos.add(Produto10);
        Produto.produtos.add(Produto11);
        Produto.produtos.add(Produto12);
        Produto.produtos.add(Produto13);
        Produto.produtos.add(Produto14);
        Produto.produtos.add(Produto15);
        Produto.produtos.add(Produto16);
        Produto.produtos.add(Produto17);
        Produto.produtos.add(Produto18);
        Produto.produtos.add(Produto19);
        Produto.produtos.add(Produto20);

        for (Produto i:
                Produto.produtos) {

            i.codigo = Produto.produtos.indexOf(i)+1;

        }
    }




}
