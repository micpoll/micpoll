package com.example.DB;

import jakarta.persistence.*;

@Entity
@Table(name = "Zamowienia")
public class Zamowienie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String date;
    private String zrealizowane;
    private Integer cena;



    @Column(name = "email", nullable = false)
    private String email;

    private String telefon;

    @Transient
    private boolean nowy;

    public Zamowienie(String date, String zrealizowane, Integer cena, String email, String telefon, boolean nowy) {
        this.date = date;
        this.zrealizowane = zrealizowane;
        this.cena = cena;
        this.email = email;
        this.telefon = telefon;
        this.nowy = nowy;
    }

    public Zamowienie() {
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getZrealizowane() {return zrealizowane;}
    public void setZrealizowane(String zrealizowane) {this.zrealizowane = zrealizowane;}

    public Integer getCena() {return cena;}
    public void setCena(Integer cena) {this.cena = cena;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getTelefon() {return telefon;}
    public void setTelefon(String telefon) {this.telefon = telefon;}
}



