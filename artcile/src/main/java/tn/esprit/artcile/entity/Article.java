package tn.esprit.artcile.entity;

import javax.persistence.*;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String libelle;
    private float stock;
    private String image;
    private long idCat;



    public Article() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Article(Long id, String code, String libelle, float pa, int tva, int fodec, int dc, float pv, float stk_init,
                   float stock, String image, long idCat) {
        this.id = id;
        this.code = code;
        this.libelle = libelle;
        this.stock = stock;
        this.image = image;
        this.idCat = idCat;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getLibelle() {
        return libelle;
    }

    public float getStock() {
        return stock;
    }

    public String getImage() {
        return image;
    }

    public long getIdCat() {
        return idCat;
    }


    public void setId(Long id) {
        this.id = id;
    }
}