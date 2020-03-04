
/*
Utilizando a linha de comando
        Compilação: $javac OlaMundo.java
        • javac é o compilador de Java para bytecode
        • Se correu bem (ie. sem erros) foi gerado o cheiro OláMundo.class
Execução: $java OláMundo
        • java é a máquina virtual Java
        • não se deve indicar a extensão do cheiro (.class), apenas o nome da classe

INTELLIJ: Open the class in the editor and do one of the following:
    -In the gutter, clickRun icon, and choose the desired command.
    -Choose Run <method name > from the context menu
    -Press Ctrl+Shift+F10
*/
public class OlaMundo {
    public static void main(String[] args) {
        System.out.println("Olá Mundo!");
    }
}