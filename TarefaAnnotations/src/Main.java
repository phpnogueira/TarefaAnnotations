import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Tabela {
    String nome();
}


@Tabela(nome = "usuarios")
class Usuario {
    private int id;
    private String nome;
    private String email;

    public Usuario(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

public class Main {
    public static void main(String[] args) {
        Tabela tabelaAnnotation = Usuario.class.getAnnotation(Tabela.class);

        if (tabelaAnnotation != null) {
            String nomeDaTabela = tabelaAnnotation.nome();
            System.out.println("Nome da tabela associada à classe Usuario: " + nomeDaTabela);
        } else {
            System.out.println("A classe Usuario não está associada a uma tabela.");
        }
    }
}