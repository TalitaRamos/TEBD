package script_preenchimento.hibernate;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="revisao")
public class Revisao {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "revisao_id")
    int revisao_id ;

    @Column(name = "revisao_nota")
    Float revisao_nota;

    @Column(name = "revisao_data_envio")
    Date revisao_data_envio;

    @Column(name = "revisao_comentario")
    String revisao_comentario;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="artigo_id",insertable=true, updatable=true)
    @Fetch(FetchMode.SELECT)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Artigo artigo;


    public Revisao() {
    }

    public Revisao(Float revisao_nota, Date revisao_data_envio, String revisao_comentario) {
        super();
        this.revisao_nota = revisao_nota;
        this.revisao_data_envio = revisao_data_envio;
        this.revisao_comentario = revisao_comentario;
    }

    public int getRevisao_id() {
        return revisao_id;
    }

    public void setRevisao_id(int revisao_id) {
        this.revisao_id = revisao_id;
    }

    public Float getRevisao_nota() {
        return revisao_nota;
    }

    public void setRevisao_nota(Float revisao_nota) {
        this.revisao_nota = revisao_nota;
    }

    public Date getRevisao_data_envio() {
        return revisao_data_envio;
    }

    public void setRevisao_data_envio(Date revisao_data_envio) {
        this.revisao_data_envio = revisao_data_envio;
    }

    public String getRevisao_comentario() {
        return revisao_comentario;
    }

    public void setRevisao_comentario(String revisao_comentario) {
        this.revisao_comentario = revisao_comentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Artigo getArtigo() {
        return artigo;
    }

    public void setArtigo(Artigo artigo) {
        this.artigo = artigo;
    }
}
