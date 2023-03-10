import javax.swing.*;
import java.util.ArrayList;

public class Produto {

    static ArrayList<Produto> produtos = new ArrayList<>();

    String nome;
    double preco;
    int quantidadeEstoque;
    int codigo;

    public Produto(String nome, double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public static void alterarPreco(double preco, int codigo){

        for (Produto i:
                Produto.produtos) {

            if (i.codigo == codigo){

                i.preco = preco;

            }

        }

    }

    public void diminuirEstoque(int quantidade){

        quantidadeEstoque -= quantidade;

    }

    public void aumentarEstoque(int quantidade){

        quantidadeEstoque = quantidade;

    }

    public static void procurarProduto(int codigo){

        for (Produto i:
             Produto.produtos) {

            if (codigo == i.codigo){

                JOptionPane.showMessageDialog(null,i.toString());

            }

        }

    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidadeEstoque=" + quantidadeEstoque +
                ", codigo=" + codigo +
                '}';
    }
}
