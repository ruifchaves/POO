import javax.print.DocFlavor;
import java.lang.reflect.Array;
define MAX

public class Telemovel {

    //Variáveis de Instância
    private String marca;
    private String modelo;
    private int x;
    private int y;
    private String [] armazMsgs;
    private double armazTotal;
    private double armazFotos;
    private double armazApps;
    private double armazTotalOcupado;
    private int nFotos;
    private int nApps;
    private String [] appsNomes;

    //Construtores da classe (omissão, parametrizado e cópia)
    public Telemovel(){
        this.marca = "n/a";
        this.modelo = "n/a";
        this.x = 0;
        this.y = 0;
        this.armazMsgs = null;
        this.armazTotal = 0;
        this.armazFotos = 0;
        this.armazApps = 0;
        this.armazTotalOcupado = 0;
        this.nFotos = 0;
        this.nApps = 0;
        this.appsNomes = null;
    }
    public Telemovel(String marca, String modelo, int x, int y, String [] armazMsgs, Double armazTotal, Double armazFotos, Double armazApps, Double armazTotalOcupado, int nFotos, int nApps, String [] appsNomes){
        this.marca = marca;
        this.modelo = modelo;
        this.x = x;
        this.y = y;
        this.armazMsgs = armazMsgs;
        this.armazTotal = armazTotal;
        this.armazFotos = armazFotos;
        this.armazApps = armazApps;
        this.armazTotalOcupado = armazTotalOcupado;
        this.nFotos = nFotos;
        this.nApps = nApps;
        this.appsNomes = appsNomes;
    }
    public Telemovel(Telemovel tel){
        this.marca = tel.marca;
        this.modelo = tel.modelo;
        this.x = tel.x;
        this.y = tel.y;
        this.armazMsgs = tel.armazMsgs;
        this.armazTotal = tel.armazTotal;
        this.armazFotos = tel.armazFotos;
        this.armazApps = tel.armazApps;
        this.armazTotalOcupado = tel.armazTotalOcupado;
        this.nFotos = tel.nFotos;
        this.nApps = tel.nApps;
        this.appsNomes = tel.appsNomes;
    }

    //Métodos de Instância
    public String getMarca() {
        return this.marca;
    }
    public String getModelo(){
        return this.modelo;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public String[] getArmazMsgs(){
        return this.armazMsgs;
    }
    public double getArmazTotal() {
        return this.armazTotal;
    }
    public double getArmazFotos() {
        return this.armazFotos;
    }
    public double getArmazApps() {
        return this.armazApps;
    }
    public double getArmazTotalOcupado() {
        return this.armazTotalOcupado;
    }
    public int getNFotos(){
        return this.nFotos;
    }
    public int getNApps(){
        return this.nApps;
    }
    public String[] getAppsNomes(){
        return this.appsNomes;
    }

    public void setMarca(String newMarca){
        this.marca = marca;
    }
    public void setModelo(String newModelo){
        this.modelo = newModelo;
    }
    public void setX(int newX){
        this.x = newX;
    }
    public void setY(int newY){
        this.y = newY;
    }
    //basta this.armazSMS = newArmazSMS; ?
    public void setArmazMsgs(String [] newArmazMsgs){
        for(int i=0; i<newArmazMsgs.length; i++)
            this.armazMsgs[i] = newArmazMsgs[i];
    }
    public void setArmazTotal(Double newArmazTotal){
        this.armazTotal = newArmazTotal;
    }
    public void setArmazFotos(Double newArmazFotos){
        this.armazFotos = newArmazFotos;
    }
    public void setArmazApps(Double newArmazApps){
        this.armazApps = newArmazApps;
    }
    public void setArmazTotalOcupado(Double newArmazTotalOcupado){
        this.armazTotalOcupado = newArmazTotalOcupado;
    }
    public void setNFotos(int newNFotos){
        this.nFotos = newNFotos;
    }
    public void setNApps(int newNApps){
        this.nApps = newNApps;
    }
    public void setAppsNome(String[] newAppsNome){ //testar se é assim ou com um ciclo for
        this.appsNomes = newAppsNome;
    }

    //métodos complementares (equals(), toString() e clone())
    public boolean equals(Object tel){
        boolean flag1 = true, flag2 = true;
        if(this == tel) return true;
        if((tel == null) || (this.getClass() != tel.getClass())) return false;
        Telemovel o = (Telemovel) tel;
        for (int i = 0; i < armazMsgs.length; i++) {
            if (armazMsgs[i]!=(o.getArmazMsgs()[i])) //ou !armazMsgs[i].equals(o.getArmazMsgs()[i])
                flag1 = false;
        }
        for (int i = 0; i < appsNomes.length; i++) {
            if (appsNomes[i]!=(o.getAppsNomes()[i])) //ou !appsNomes[i].equals(o.getAppsNomes()[i])
                flag2 = false;
        }
        return marca.equals(o.getMarca())
                && modelo.equals(o.getModelo())
                && x == o.getX()
                && y == o.getY()
                // && armazMsgs.equals(o.getArmazMsgs()); Não usar isto, cause https://stackoverflow.com/questions/8777257/equals-vs-arrays-equals-in-java/8777279
                // daí se ter feito as flags
                && flag1
                && armazTotal == o.getArmazTotal()
                && armazFotos == o.getArmazFotos()
                && armazApps == o.getArmazApps()
                && armazTotalOcupado == o.getArmazTotalOcupado()
                && nFotos == o.getNFotos()
                && nApps == o.getNApps()
                && flag2;
    }
    //StringBuilder vs String concatenation: https://stackoverflow.com/questions/1532461/stringbuilder-vs-string-concatenation-in-tostring-in-java
    private static final int MAX = 100;
    public String toString(){
        StringBuilder sb = new StringBuilder(MAX);
        return sb.append("TELEMÓVEL")
                .append("\nMarca: ").append(marca)
                .append("\nModelo: ").append(modelo)
                .append("\nResolução: ").append(x).append("x").append(y)
                .append("\nArmazenamento Total: ").append(armazTotal)
                .append("\nArmazenamento Fotos: ").append(armazFotos)
                .append("\nArmazenamento Aplicações: ").append(armazApps)
                .append("\nEspaço Total Ocupado: ").append(armazTotalOcupado)
                .append("\nNúmero de Fotos: ").append(nFotos)
                .append("\nNúmero de Apps: ").append(nApps)
                .append("\nSMS: ").append(armazMsgs)                    //Isto imprime bem?
                .append("\nAPPS: ").append(appsNomes)                   //Isto imprime bem?
                .toString();
        //        return "Marca:" + marca + "    Modelo:" + modelo + "    Dimensão:" + x + "x" + y + "    Armazenamento Total:" + armazTotal + "  Armazenamento Fotos:" + armazFotos + "  Armazenamento Apps:" + armazApps + "    Espaço Total ocupado:" + espacoTotalocu + " Numero de fotos:" + nfotos + "Número de apps: " + napp + " SMS " +  armazSMS + "APPS" + apps;
    }
    public Telemovel clone(){
        return new Telemovel(this);
    }

    //métodos propostos
    public boolean existeEspaco(int numeroBytes){
        return ((armazTotal-armazTotalOcupado)>numeroBytes);
    }

    public void instalaApp(String nome, int tamanho){
        if(existeEspaco(tamanho)) {
            armazTotalOcupado += tamanho;
            if(nApps == 0){
                nApps++;
                String[] nova = new String[nApps];
                nova[0] = nome;
                setAppsNome(nova);
            }
            else{
                if(nApps<appsNomes.length){
                    appsNomes[nApps] = nome;
                    nApps++;
                }
                else{
                    String[] copy = new String[nApps*2];
                    System.arraycopy(appsNomes, 0, copy, 0, appsNomes.length);
                    copy[nApps] = nome;
                    nApps++;
                    setAppsNome(copy);
                }
            }
        }
    }

    public void recebeMsg(String msg){
            if(armazMsgs.length == 0){
                String[] nova = new String[10];
                nova[0] = msg;
                setAppsNome(nova);
            }
            else{
                if ((this.armazMsgs)[armazMsgs.length-1] == null){
                    for(int i=0; i < armazMsgs.length; i++){
                        if (this.armazMsgs[i] == null) this.armazMsgs[i] = msg;
                    }
                }
                else{
                    String [] addedMsg = new String[armazMsgs.length*2];
                    System.arraycopy(armazMsgs,0,addedMsg,0, armazMsgs.length);
                    addedMsg[armazMsgs.length] = msg;
                    setArmazMsgs(addedMsg);
                }
            }
        }
    }

    public double tamMedioApps() {
        return armazApps / nApps;
    }

    public String maiorMsg(){
        int maior = 0;
        String store = "";
        for(String msg : armazMsgs)
            if(msg.length()>maior){
                maior = msg.length();
                store = msg;
            }
        return store;
    }

    public void removeApp(String nome, int tamanho) {
        for (int i = 0; i < appsNomes.length; i++) {
            if (appsNomes[i] == nome) {
                appsNomes[i] = null;
                for (; i < appsNomes.length - 1; i++)
                    appsNomes[i] = appsNomes[i + 1];
                armazTotalOcupado -= tamanho;
            }
        }
    }
}


