package com.nextu.entities;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sport")
public class Produit {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "code_produit")
   private Long code;
   @Column(name = "intitule")
   private String libelle;
   @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sport")
   private Set<Produit> produits;

   public Long getCode() {
      return code;
   }

   public void setCode(Long code) {
      this.code = code;
   }

   public String getLibelle() {
      return libelle;
   }

   public void setLibelle(String libelle) {
      this.libelle = libelle;
   }

   public void addDiscipline(Produit produit) {
      if (this.produits == null) {
         this.produits = new HashSet<>();
      }
      this.produits.add(produit);
   }

   public void removeDiscipline(Produit produit) {
      if (this.produits != null)
         produits.remove(produit);
   }

   public Set<Produit> getDisciplines() {
      return produits;
   }


}