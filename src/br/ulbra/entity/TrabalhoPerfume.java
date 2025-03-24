package br.ulbra.entity;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TrabalhoPerfume {

    public ArrayList<String> Original;
    public ArrayList<String> Alfabetica;

    public TrabalhoPerfume() {
        Original = new ArrayList<>();
        Alfabetica = new ArrayList<>();
    }

    // Método de salvar 
    public void salvar(String produto) {
        Original.add(produto);  // Adquirir à lista original
        Alfabetica.add(produto);   // Adquirir à lista alfabetica
        JOptionPane.showMessageDialog(null, produto + " Salvo com êxito ");
    }

    // Método para listar os produtos
    public String listar() {
        String resultado = "Lista de Produtos\n";
        
        if (!Alfabetica.isEmpty()) {
            for (int i = 0; i < Alfabetica.size(); i++) {
                resultado += Alfabetica.get(i) + "\n";
            }
        } else {
            resultado = "Não tem nada na lista!!";
        }

        return resultado;
    }

    // Método de deleter um produto
    public void excluir(int cod) {
        if (!Alfabetica.isEmpty()) {
            cod = cod - 1;  // Configura o código para o índice da lista
            if (cod >= 0 && cod < Alfabetica.size()) {
                if (JOptionPane.showConfirmDialog(null, "Você tem certeza que pretende excluir o"
                        + Alfabetica.get(cod), "Deletado", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    Original.remove(cod);
                    Alfabetica.remove(cod); // Remove da lista ordenada também
                    JOptionPane.showMessageDialog(null, "Deletado com sucesso");
                } else {
                    JOptionPane.showMessageDialog(null, "Projeto cancelado");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Código inválido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não é possível excluir");
        }
    }

    // Método de coloar a quantidade na lista
    public int quantidade() {
        return Original.size();
    }

    // Método para limpar listas
    public void limparLista() {
        Original.clear();
        Alfabetica.clear();
    }

    // Método de alterar o nome 
    public void alterar(int cod, String novoNome) {
        if (!Alfabetica.isEmpty()) {
            cod = cod - 1;  // Configura o código para o índice da lista
            if (cod >= 0 && cod < Alfabetica.size()) {
                if (JOptionPane.showConfirmDialog(null, "Você que mesmo alterar o "
                        + Alfabetica.get(cod), "Alteração", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    Original.set(cod, novoNome);  // Alterar lista original
                    Alfabetica.set(cod, novoNome);  // Alterar lista ordenada
                    JOptionPane.showMessageDialog(null, "Alterado com sucesso");
                } else {
                    JOptionPane.showMessageDialog(null, "Operação cancelada");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Código errado");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Impossível alterar uma lista vazia");
        }
    }

    // Método para ordenar em ordem alfabética
    public void ordenarAlfabeticamente() {
        Alfabetica.sort(String::compareTo); // Ordena em alfabética
    }

    // Método para restabelecer a ordem original
    public void resetarLista() {
        Alfabetica.clear(); // Limpa a lista ordenada
        Alfabetica.addAll(Original); // Restabelece a lista ordenada para o estado original
    }

    // Método para limpar a lista
    public void limpar() {
        Original.clear();
        Alfabetica.clear();
    }
}
