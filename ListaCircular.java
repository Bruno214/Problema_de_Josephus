package AD2;

import java.util.ArrayList;
import java.util.List;

public class ListaCircular {
    private No cabeca;  //fim da lista
    private No cauda; // inicio
    private int tamanhoLista;

    //construtor
    public ListaCircular() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanhoLista = 0;
    }

    public int pegaPosicao(int passo) {
        // aqui eu pego quem esta na primeira posição da lista
        No noAux = this.cauda; // aqui eu pego o NO na primeira posição
        int posNo = -1;
        int cont = 0;
        int cont3 = 0;

        List<No> meusNos = new ArrayList<>();
        // preencher a lista com os nós criando um backup das posições
        // originais que os nós foram inseridos
        for (int i = 0; i < this.tamanhoLista; i++) {
            meusNos.add(noAux);
            noAux = noAux.getProximoNo();
        }

        while (true) {
            cont3 = 0; //  o cont3 é uma variavel de controle para não
            // deixar incrementar quando houver remoção

            if (cont == passo) {
                //passar o no para remoção
                remove(noAux);
                cont3++;
//
                cont = 0; // zera para continuar as remoções
                if (this.tamanhoLista == 1) {
                    break;
                }
            }
            noAux = noAux.getProximoNo(); // pega o proximo NO

            if (cont3++ == 0) { // se ele é diferente de zero significa que houve remoção, entao nao incrementa o cont
                cont++;  // logo incremento esse cont
            }

            if (this.tamanhoLista == 1) { // condição de parada
                break;
            }
        } // final do while
        // como so restou uma pessoa na roda atualizo a cauda e a cabeça recebe a cauda
        this.cauda = noAux.getProximoNo();
        this.cabeca = cauda;

        // aqui minha variavel vai na lista de backup e pega a posição
        //original do inicio de quem se manteve vivo
        posNo = meusNos.indexOf(this.cabeca);

        return posNo + 1; // retornando a posição

    }

    // inserindo pela calda os NOs
    public void add(String conteudo) {
        No novoNo = new No(conteudo);
        if (isEmpty()) { // verifica se a lista ta vazia
            this.cabeca = novoNo;
            this.cauda = this.cabeca;
        } else {
            novoNo.setProximoNo(this.cauda);
            this.cabeca.setProximoNo(novoNo);
            this.cabeca = novoNo;

        }
        this.tamanhoLista++;
    }


    // Remove por No
    public void remove(No no) { //pedro
        No noAux = this.cauda;
        No noAnterior = this.cauda;// se nao for -1 é pq exite o no procurado

       for (int i = 0; i < this.tamanhoLista; i++) {
           // se for a cauda e primeiro loop
           if (i == 0 && noAux.getConteudo().equals(no.getConteudo())) {
                this.cauda = this.cauda.getProximoNo();
                cabeca.setProximoNo(this.cauda);
                break;
           }

           if(i == 1){
                noAux = noAux.getProximoNo();
                if (noAux.getConteudo().equals(no.getConteudo())){
                    this.cauda.setProximoNo(this.cauda.getProximoNo().getProximoNo());
                }
           }else {
               for (int j = 0; j < this.tamanhoLista; j++) {
                   if (noAux.getConteudo().equals(no.getConteudo())){

                        noAnterior.setProximoNo(noAnterior.getProximoNo().getProximoNo());
                       if (this.cabeca.getConteudo().equals(noAux.getConteudo())){
                           this.cabeca = noAnterior;
                       }
                       break;
                   }
                   noAnterior = noAux;
                   noAux = noAux.getProximoNo();
               }

           }
       }
       this.tamanhoLista--;
    }

    public boolean isEmpty(){
        return this.tamanhoLista == 0 ? true: false;
    }


    public int size(){
        return this.tamanhoLista; // pega o tamanho da lista
    }

    @Override
    public String toString(){
        String strRetorno = "";

        No noAuxiliar = this.cauda;

        for(int i = 0; i < size(); i++) {
            strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() + "}]--->";
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        strRetorno += !(this.isEmpty())  ? "(Retorna ao início)" : "[]";
        return strRetorno;
    }

}
