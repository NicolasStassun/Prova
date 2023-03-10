import javax.swing.*;
import java.util.ArrayList;

public class Funcionario {

    static ArrayList<Funcionario> funcionario = new ArrayList<>();

    String Nome;
    int cpf;
    int matricula;
    double salario;
    double comissaoAcumulada;

    public Funcionario(String nome, int cpf, double salario) {
        Nome = nome;
        matricula++;
        this.cpf = cpf;
        this.salario = salario;

    }

    public static void registrarVenda(int matricula) {

        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do produto vendido"));
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade vendida"));

        for (Produto i :
                Produto.produtos) {

            if (i.codigo == codigo) {

                if (i.quantidadeEstoque > quantidade) {

                    adicionarComissao(quantidade, codigo, matricula);

                    i.diminuirEstoque(quantidade);

                    JOptionPane.showMessageDialog(null, "Venda efetuada com sucesso");
                    return;

                }
                    JOptionPane.showMessageDialog(null, "Estoque insuficiente");
                    return;
            }

        }
        JOptionPane.showMessageDialog(null, "Produto não encontrado");
    }

    public static void adicionarComissao(int quantidade, int codigo, int matricula) {

        for (Produto i :
                Produto.produtos) {

            if (i.codigo == codigo) {

                double precoComissao = i.preco * 0.05;

                double valorComissao = precoComissao * quantidade;

                for (Funcionario j:
                     Funcionario.funcionario) {

                    if (j.matricula==matricula){

                        j.comissaoAcumulada += valorComissao;

                    }

                }
            }

        }

    }

    public static void alterarPreco() {

        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do produto que deseja alterar"));
        double preco = Double.parseDouble(JOptionPane.showInputDialog("Informe o Preço que deseja"));

        for (Produto i :
                Produto.produtos) {

            if (i.codigo == codigo) {

                Produto.alterarPreco(preco, codigo);

                JOptionPane.showMessageDialog(null, "Troca efetuada com sucesso");
                return;
            }

        }
        JOptionPane.showMessageDialog(null, "Produto não encontrado");


    }

    public static void reporEstoque() {

        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do produto"));
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade da reposição"));

        for (Produto i :
                Produto.produtos) {

            if (i.codigo == codigo) {


                i.aumentarEstoque(quantidade);

                JOptionPane.showMessageDialog(null, "Aumento efetuado com sucesso");
                return;

            }

        }
        JOptionPane.showMessageDialog(null,"Produto não encontrado");
    }

    public static void buscarFuncionario(int matricula){

        for (Funcionario i:
                Funcionario.funcionario) {

            if (matricula == i.matricula){

                JOptionPane.showMessageDialog(null,i.toString());

            }

        }

    }





    @Override
    public String toString() {
        return "Funcionario{" +
                "Nome='" + Nome + '\'' +
                ", cpf=" + cpf +
                ", matricula=" + matricula +
                ", salario=" + salario +
                ", comissaoAcumulada=" + comissaoAcumulada +
                '}';
    }
}
