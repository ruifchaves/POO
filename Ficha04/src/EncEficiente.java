import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class EncEficiente {
    private String nomeCli;
    private int nif;
    private String morada;
    private int numEnc;
    private LocalDate data;
    private ArrayList<LinhaEncomenda> linhas;

    /**
     * i. métodos usuais de acesso e alteração das variáveis de instância
     */
    public EncEficiente(){
        this.nomeCli = "n/a";
        this.nif = 0;
        this.morada = "n/a";
        this.numEnc = 0;
        this.data = LocalDate.now();
        this.linhas = new ArrayList<>();
    }

    public EncEficiente(String nomeCli, int nif, String morada, int numEnc,LocalDate data, List<LinhaEncomenda> linhasEnc) {
        this.nomeCli = nomeCli;
        this.nif = nif;
        this.morada = morada;
        this.numEnc = numEnc;
        this.data = data;
        setEnc(linhasEnc);
    }

    public EncEficiente(EncEficiente c){
        this.nomeCli = c.getNomeCli();
        this.nif = c.getNif();
        this.morada = c.getMorada();
        this.numEnc = c.getNumEnc();
        this.data = c.getData();
        this.linhas = c.getLinhas();
    }

    public String getNomeCli() {
        return this.nomeCli;
    }
    public int getNif() {
        return this.nif;
    }
    public String getMorada() {
        return this.morada;
    }
    public int getNumEnc() {
        return this.numEnc;
    }
    public LocalDate getData() {
        return this.data;
    }
    public ArrayList<LinhaEncomenda> getLinhas() {
        return this.linhas;
    }

    public void setNomeCli(String nomeCli) {
        this.nomeCli = nomeCli;
    }
    public void setNif(int nif) {
        this.nif = nif;
    }
    public void setMorada(String morada) {
        this.morada = morada;
    }
    public void setNumEnc(int noEnc) {
        this.numEnc = numEnc;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public void setEnc(List<LinhaEncomenda> linhasEnc){
        this.linhas = new ArrayList<LinhaEncomenda>();
        for(LinhaEncomenda le : linhasEnc)
            this.linhas.add(le.clone());
    }

    public EncEficiente clone(){
        return new EncEficiente(this);
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if((o == null) || o.getClass() != this.getClass()) return false;
        EncEficiente p = (EncEficiente) o;
        return (nomeCli==p.getNomeCli() &&
                nif==p.getNif() &&
                morada==p.getMorada() &&
                numEnc==p.getNumEnc() &&
                data==p.getData() &&
                linhas==p.getLinhas());
        // return nomeCli.equals(p.getNomeCli()) && nif == p.getNif() &&
        //         morada.equals(p.getMorada()) && numEnc == p.getNumEnc() &&
        //         data.equals(p.getData()) && linhas.equals(p.getLinhas());
    }

    public String toString() {
        return "ENCOMENDA: \n   -Nome de Cliente= "+ nomeCli +
                "; \n   -Nif= " + nif +
                "; \n   -Morada= " + morada +
                "; \n   -Número da Encomenda= " + numEnc +
                "; \n   -Data= " + data +
                "; \n   -Linhas= " + linhas.toString() + ';';
    }

    /**
     * ii. método que determina o valor total da encomenda.
     */
    public double calculaValorTotal(){
        double tot = 0;
        for(LinhaEncomenda le : this.linhas)
            tot += le.calculaValorLinhaEnc();
        return tot;
        //return this.linhas.stream().mapToDouble(LinhaEncomenda::calculaValorLinhaEnc).sum();
    }

    /**
     * iii. método que determina o valor total dos descontos obtidos nos diversos produtos encomendados.
     */
    public double calculaValorDesconto() {
        double des = 0;
        for(LinhaEncomenda le : this.linhas) {
            des += le.calculaValorDesconto();
        }
        return des;
        //return this.linhas.stream().mapToDouble(LinhaEncomenda::calculaValorDesconto).sum();
    }

    /**
     * iv. método que determina o número total de produtos a receber.
     */
    public int numeroTotalProdutos() {
        int qt = 0;
        for(LinhaEncomenda le : this.linhas) {
            qt += le.getQuantidade();
        }
        return qt;
        //return this.linhas.stream().mapToInt(LinhaEncomenda::getQuantidade).sum();
    }

    /**
     * v. método que determina se um produto vai ser encomendado.
     */
    public boolean existeProdutoEncomenda(String refProduto){
        boolean e = false;
        for(int i=0; !e && i<linhas.size(); i++)
            if(linhas.get(i).getReferencia().equals(refProduto)) e = true;
        return e;
    }

    /**
     * vi. método que adiciona uma nova linha de encomenda
     */
    public void adicionaLinha(LinhaEncomenda linha){
        this.linhas.add(linha.clone());
    }

    /**
     * vi. método que adiciona uma nova linha de encomenda
     */
    public void removeProduto(String codProd) {
        for (Iterator<LinhaEncomenda> it = this.linhas.iterator(); it.hasNext(); ) {
            LinhaEncomenda le = it.next();
            if (le.getReferencia().equals(codProd)) {
                it.remove();
            }
        }
    }
}