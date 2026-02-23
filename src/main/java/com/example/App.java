package com.example;

<<<<<<< HEAD
import com.example.model.Equipement;
import com.example.model.Reservation;
import com.example.model.Salle;
import com.example.model.Utilisateur;
=======
import com.example.model.Produit;
>>>>>>> 74f70ff38d710340c8a7b318b06fb6b04dc04f25

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
<<<<<<< HEAD
import java.time.LocalDateTime;
=======
import java.math.BigDecimal;
>>>>>>> 74f70ff38d710340c8a7b318b06fb6b04dc04f25
import java.util.List;

public class App {
    public static void main(String[] args) {
<<<<<<< HEAD
        // Create the EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion-reservations");

        try {
            // Run test scenarios in order
            // Test cascade relationships and operations
            System.out.println("\n Testing cascade relationships ");
            testRelationsEtCascade(emf);

            // Test orphan removal
            System.out.println("\n Testing orphan removal ");
            testSuppressionOrpheline(emf);

            // Test many-to-many relationship with equipment
            System.out.println("\n Testing many-to-many with equipment ");
            testRelationManyToMany(emf);

        } finally {
            // Close the EntityManagerFactory
            emf.close();
        }
    }

    private static void testRelationsEtCascade(EntityManagerFactory emf) {
=======
        // Création de l'EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-demo");

        // Insertion de produits
        insererProduits(emf);

        // Lecture des produits
        lireProduits(emf);

        // Fermeture de l'EntityManagerFactory
        emf.close();
    }

    private static void insererProduits(EntityManagerFactory emf) {
>>>>>>> 74f70ff38d710340c8a7b318b06fb6b04dc04f25
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

<<<<<<< HEAD
            // Create entities
            System.out.println("Creating entities...");

            // Test data with Arabic names (Latin letters)
            // Create a user
            Utilisateur utilisateur = new Utilisateur("Alshammari", "Ahmad", "ahmad.alshammari@example.com");

            // Create a room
            Salle salle = new Salle("Room Aisha", 30);
            salle.setDescription("Team meeting room with a projector");

            // Create a reservation
            Reservation reservation = new Reservation(
                    LocalDateTime.now().plusDays(1),
                    LocalDateTime.now().plusDays(1).plusHours(2),
                    "Team meeting"
            );

            // Establish relationships
            utilisateur.addReservation(reservation);
            salle.addReservation(reservation);

            // Persist the user with cascade on reservation
            em.persist(utilisateur);
            em.persist(salle);

            em.getTransaction().commit();
            System.out.println("Entities created and linked successfully!");

            // Verify persisted entities
            em.clear(); // Clear the persistence context

            System.out.println("\nVerifying persisted entities:");
            Utilisateur utilisateurPersiste = em.find(Utilisateur.class, utilisateur.getId());
            System.out.println("User: " + utilisateurPersiste);
            System.out.println("Reservation count: " + utilisateurPersiste.getReservations().size());

            Salle sallePersistee = em.find(Salle.class, salle.getId());
            System.out.println("Room: " + sallePersistee);
            System.out.println("Reservation count: " + sallePersistee.getReservations().size());

=======
            // Création de quelques produits
            Produit p1 = new Produit("Laptop", new BigDecimal("999.99"));
            Produit p2 = new Produit("Smartphone", new BigDecimal("499.99"));
            Produit p3 = new Produit("Tablette", new BigDecimal("299.99"));

            // Persistance des produits
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);

            em.getTransaction().commit();
            System.out.println("Produits insérés avec succès !");
>>>>>>> 74f70ff38d710340c8a7b318b06fb6b04dc04f25
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

<<<<<<< HEAD
    private static void testSuppressionOrpheline(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        try {
            // Create a user with reservations
            em.getTransaction().begin();

            Utilisateur utilisateur = new Utilisateur("Alhashemi", "Layla", "layla.alhashemi@example.com");

            Salle salle1 = new Salle("Room Omar", 20);
            em.persist(salle1);

            Salle salle2 = new Salle("Room Zainab", 15);
            em.persist(salle2);

            // Create two reservations
            Reservation reservation1 = new Reservation(
                    LocalDateTime.now().plusDays(2),
                    LocalDateTime.now().plusDays(2).plusHours(1),
                    "Interview"
            );

            Reservation reservation2 = new Reservation(
                    LocalDateTime.now().plusDays(3),
                    LocalDateTime.now().plusDays(3).plusHours(2),
                    "Training session"
            );

            // Establish relationships
            utilisateur.addReservation(reservation1);
            utilisateur.addReservation(reservation2);
            salle1.addReservation(reservation1);
            salle2.addReservation(reservation2);

            em.persist(utilisateur);

            em.getTransaction().commit();
            System.out.println("User with two reservations created!");

            // Delete a reservation (orphan removal test)
            em.getTransaction().begin();

            Utilisateur utilisateurAModifier = em.find(Utilisateur.class, utilisateur.getId());
            System.out.println("Reservation count before deletion: " + utilisateurAModifier.getReservations().size());

            // Delete the first reservation (removed via orphanRemoval=true)
            Reservation reservationASupprimer = utilisateurAModifier.getReservations().get(0);
            utilisateurAModifier.removeReservation(reservationASupprimer);

            em.getTransaction().commit();

            // Verify deletion
            em.clear();
            Utilisateur utilisateurApresModification = em.find(Utilisateur.class, utilisateur.getId());
            System.out.println("Reservation count after deletion: " + utilisateurApresModification.getReservations().size());

            // Verify the reservation was deleted from the database
            Long reservationId = reservationASupprimer.getId();
            Reservation reservationSupprimee = em.find(Reservation.class, reservationId);
            System.out.println("Reservation still exists? " + (reservationSupprimee != null));

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
=======
    private static void lireProduits(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        try {
            // Requête JPQL pour récupérer tous les produits
            List<Produit> produits = em.createQuery("SELECT p FROM Produit p", Produit.class)
                    .getResultList();

            System.out.println("\nListe des produits :");
            for (Produit produit : produits) {
                System.out.println(produit);
            }

            // Recherche d'un produit par ID
            System.out.println("\nRecherche du produit avec ID=2 :");
            Produit produit = em.find(Produit.class, 2L);
            if (produit != null) {
                System.out.println(produit);
            } else {
                System.out.println("Produit non trouvé");
            }
>>>>>>> 74f70ff38d710340c8a7b318b06fb6b04dc04f25
        } finally {
            em.close();
        }
    }
<<<<<<< HEAD

    private static void testRelationManyToMany(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            // Create equipment
            Equipement projecteur = new Equipement("Projector", "HD projector");
            Equipement ecran = new Equipement("Interactive Screen", "65-inch touch screen");
            Equipement visioconference = new Equipement("Video Conference System", "Full system with HD camera");

            // Create rooms
            Salle salleReunion = new Salle("Room Hassan", 25);
            Salle salleFormation = new Salle("Room Mariam", 40);

            // Add equipment to rooms
            salleReunion.addEquipement(projecteur);
            salleReunion.addEquipement(visioconference);

            salleFormation.addEquipement(projecteur);
            salleFormation.addEquipement(ecran);

            // Persist rooms (equipment is cascaded)
            em.persist(salleReunion);
            em.persist(salleFormation);

            em.getTransaction().commit();
            System.out.println("Rooms and equipment created successfully!");

            // Verify relationships
            em.clear();

            System.out.println("\nVerifying many-to-many relationships:");

            // Fetch rooms
            Salle salleReunionPersistee = em.find(Salle.class, salleReunion.getId());
            System.out.println("Room: " + salleReunionPersistee.getNom());
            System.out.println("Equipment:");
            for (Equipement equipement : salleReunionPersistee.getEquipements()) {
                System.out.println("- " + equipement.getNom());
            }

            Salle salleFormationPersistee = em.find(Salle.class, salleFormation.getId());
            System.out.println("\nRoom: " + salleFormationPersistee.getNom());
            System.out.println("Equipment:");
            for (Equipement equipement : salleFormationPersistee.getEquipements()) {
                System.out.println("- " + equipement.getNom());
            }

            // Fetch an equipment and list associated rooms
            Equipement projecteurPersiste = em.createQuery(
                            "SELECT e FROM Equipement e WHERE e.nom = :nom", Equipement.class)
                    .setParameter("nom", "Projector")
                    .getSingleResult();

            System.out.println("\nEquipment: " + projecteurPersiste.getNom());
            System.out.println("Rooms with this equipment:");
            for (Salle salle : projecteurPersiste.getSalles()) {
                System.out.println("- " + salle.getNom());
            }

            // Test removing equipment from a room
            em.getTransaction().begin();

            salleReunionPersistee.removeEquipement(projecteurPersiste);

            em.getTransaction().commit();

            // Verify after removal
            em.clear();

            Salle salleApresModification = em.find(Salle.class, salleReunion.getId());
            System.out.println("\nRoom after removing equipment: " + salleApresModification.getNom());
            System.out.println("Remaining equipment:");
            for (Equipement equipement : salleApresModification.getEquipements()) {
                System.out.println("- " + equipement.getNom());
            }

            // Verify the equipment still exists
            Equipement projecteurApresModification = em.find(Equipement.class, projecteurPersiste.getId());
            System.out.println("\nEquipment still exists? " + (projecteurApresModification != null));

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
=======
}
>>>>>>> 74f70ff38d710340c8a7b318b06fb6b04dc04f25
