package com.corsosiam.entities;

public class Articolo
    {
    String _id;
    String id_prodotto;
    int qta;
    Profumo prodotto;
    
    public Articolo()
    {
    }
    public Articolo(String _id, String id_prodotto, int qta)
    {
        this._id = _id;
        this.id_prodotto = id_prodotto;
        this.qta = qta;
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String getId_prodotto() {
        return id_prodotto;
    }
    public void setId_prodotto(String id_prodotto) {
        this.id_prodotto = id_prodotto;
    }
    public int getQta() {
        return qta;
    }
    public void setQta(int qta) {
        this.qta = qta;
    }

    public Profumo getProfumo() {
        return prodotto;
    }

    public void setProfumo(Profumo prodotto) {
        this.prodotto = prodotto;
    }
    
}
