package com.corsosiam.entities;

public class Profumo
    {
    private String _id;
    private String brand;
    private String nome;
    private float prezzo;
    private String formato;
    private String descrizione;

    // Costruttore vuoto
    public Profumo()
    {
    }

    // Costruttore completo con tutti gli attributi
    public Profumo(String _id, String brand, String nome, float prezzo, String formato, String descrizione)
    {
        this._id = _id;
        this.brand = brand;
        this.nome = nome;
        this.prezzo = prezzo;
        this.formato = formato;
        this.descrizione = descrizione;
    }

    // Getter e Setter
    public String getId()
    {
        return _id;
    }

    public void setId(String _id)
    {
        this._id = _id;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public float getPrezzo()
    {
        return prezzo;
    }

    public void setPrezzo(float prezzo)
    {
        this.prezzo = prezzo;
    }

    public String getFormato()
    {
        return formato;
    }

    public void setFormato(String formato)
    {
        this.formato = formato;
    }

    public String getDescrizione()
    {
        return descrizione;
    }

    public void setDescrizione(String descrizione)
    {
        this.descrizione = descrizione;
    }

    // Metodo toString per stampare l'oggetto
    @Override
    public String toString()
    {
        return "Profumo{" +
                "id='" + _id + '\'' +
                ", brand='" + brand + '\'' +
                ", nome='" + nome + '\'' +
                ", prezzo=" + prezzo +
                ", formato='" + formato + '\'' +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}
