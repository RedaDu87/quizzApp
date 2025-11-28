package com.quizapp.config;

import com.quizapp.model.Question;
import com.quizapp.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {

    private final QuestionRepository questionRepository;

    @Override
    public void run(String... args) {

        if (questionRepository.count() > 0) {
            System.out.println(">>> Database already populated. Skipping seeding.");
            return;
        }

        System.out.println(">>> Populating MongoDB with REAL romantic quiz data... 💗");

        questionRepository.save(new Question(null,
                "Quelle est votre nationalité ? / ¿Cuál es su nacionalidad?",
                "Espagnole / Española", "Française / Francesa", "Marocaine / Marroquí", "Italienne / Italiana",
                0));

        questionRepository.save(new Question(null,
                "Quelle est la nationalité de votre partenaire ? / ¿Cuál es la nacionalidad de su pareja?",
                "Française / Francesa", "Espagnole / Española", "Marocaine / Marroquí", "Italienne / Italiana",
                1));

        questionRepository.save(new Question(null,
                "Quelles sont vos passions principales ? / ¿Cuáles son sus aficiones principales?",
                "Sport, programmation, lecture, cuisine",
                "Danse et maquillage",
                "Voyages et cinéma",
                "Peinture et photographie",
                0));

        questionRepository.save(new Question(null,
                "Quelles sont les passions de votre partenaire ? / ¿Cuáles son las aficiones de su pareja?",
                "Marcher dans la nature, lire, cuisiner",
                "Jouer au foot",
                "Faire du shopping",
                "Regarder Netflix",
                0));

        questionRepository.save(new Question(null,
                "Comment vous êtes-vous rencontrés ? / ¿Cómo se conocieron?",
                "Sur MuzzMatch (application de rencontre)",
                "Au travail",
                "À l'université",
                "Dans la rue",
                0));

        questionRepository.save(new Question(null,
                "Quand vous êtes-vous rencontrés ? / ¿Cuándo se conocieron?",
                "Le 07/10/2025", "En 2023", "En 2022", "En 2024",
                0));

        questionRepository.save(new Question(null,
                "Quand avez-vous décidé de vous marier ? / ¿Cuándo decidieron casarse?",
                "Dès la première rencontre",
                "Après un mois",
                "Après un an",
                "Après un voyage",
                0));

        questionRepository.save(new Question(null,
                "Quand avez-vous commencé votre relation ? / ¿Cuándo empezó su relación?",
                "Depuis que vous avez commencé à parler",
                "Après un rendez-vous",
                "Après un mois",
                "Après un voyage",
                0));

        questionRepository.save(new Question(null,
                "Avez-vous des passions en commun ? / ¿Tienen aficiones en común?",
                "Lire, marcher, découvrir de nouveaux endroits, cuisiner",
                "Regarder des films",
                "Faire du shopping",
                "Faire du sport",
                0));

        questionRepository.save(new Question(null,
                "Quels sont les diplômes de votre partenaire ? / ¿Qué estudios tiene su pareja?",
                "Doctorat en sciences des matériaux + Diplôme d’État de dentiste",
                "Licence en biologie",
                "Master en finance",
                "BTS informatique",
                0));

        questionRepository.save(new Question(null,
                "Qui se lève le plus tôt ? / ¿Quién se levanta antes?",
                "Les deux se lèvent tôt",
                "Réda",
                "Romaisa",
                "Aucun",
                0));

        questionRepository.save(new Question(null,
                "Qui prépare les repas actuellement ? / ¿Quién prepara las comidas actualmente?",
                "Chacun chez soi pour l’instant",
                "Seulement Romaisa",
                "Seulement Réda",
                "Personne",
                0));

        questionRepository.save(new Question(null,
                "Avez-vous visité le pays de votre partenaire ? / ¿Ha visitado el país de su pareja?",
                "Pas encore",
                "Oui une fois",
                "Oui plusieurs fois",
                "Non jamais",
                0));

        questionRepository.save(new Question(null,
                "Les parents de votre partenaire sont-ils mariés ? / ¿Los padres de su pareja están casados?",
                "Oui / Sí", "Non / No", "Divorcés / Divorciados", "Je ne sais pas / No lo sé",
                0));

        questionRepository.save(new Question(null,
                "Quelle était la profession de votre partenaire dans son pays ? / ¿A qué se dedicaba su pareja en su país?",
                "Ingénieur logiciel / Ingeniero de software",
                "Dentiste",
                "Professeur",
                "Architecte",
                0));

        questionRepository.save(new Question(null,
                "Quel plat votre partenaire n’aime-t-il pas ? / ¿Qué plato no le gusta a su pareja?",
                "Couscous avec raisins secs",
                "Pizza",
                "Poisson",
                "Tajine",
                0));

        questionRepository.save(new Question(null,
                "Quel plat vous n’aimez pas ? / ¿Qué plato no le gusta a usted?",
                "Kercha & choux de Bruxelles & soupes",
                "Pizza",
                "Poulet",
                "Pâtes",
                0));

        questionRepository.save(new Question(null,
                "Quel film avez-vous vu ensemble ? / ¿Qué película vieron juntos?",
                "Aucun encore",
                "Une comédie",
                "Un film d’horreur",
                "Une romance",
                0));

        questionRepository.save(new Question(null,
                "Quel sera le premier voyage que vous ferez ensemble ? / ¿Cuál será su primer viaje juntos?",
                "Médine", "Italie", "Grèce", "Turquie",
                0));

        questionRepository.save(new Question(null,
                "Quelle est la date d’anniversaire de votre partenaire ? / ¿Cuándo es el cumpleaños de su pareja?",
                "14/12/1990", "10/10/1992", "01/01/1990", "03/03/1993",
                0));

        questionRepository.save(new Question(null,
                "Quelle est votre date d’anniversaire ? / ¿Cuándo es su cumpleaños?",
                "08/02/1998", "10/10/1998", "05/05/1997", "01/01/1999",
                0));

        questionRepository.save(new Question(null,
                "Avez-vous des enfants ensemble ? / ¿Tienen hijos en común?",
                "Non", "Oui (1)", "Oui (2)", "Oui (3)",
                0));

        questionRepository.save(new Question(null,
                "Noms des frères et sœurs de votre partenaire ? / Nombre de los hermanos de su pareja?",
                "Anas, Sara, Imane", "Aimane, Chaima", "David et Lucia", "Aucun",
                0));

        questionRepository.save(new Question(null,
                "Noms de vos frères et sœurs ? / Nombre de sus propios hermanos?",
                "Aimane, Chaima, Brahim, Fatema",
                "Anas, Sara, Imane",
                "Aucun",
                "3 frères uniquement",
                0));

        questionRepository.save(new Question(null,
                "Quel est votre plat préféré ? / ¿Cuál es su comida favorita?",
                "Viande aux pruneaux", "Pizza", "Tacos", "Pâtes",
                0));

        questionRepository.save(new Question(null,
                "Quel est le plat préféré de votre partenaire ? / ¿Cuál es la comida favorita de su pareja?",
                "RFISSA 😍", "Couscous", "Pastilla", "Tajine",
                0));

        questionRepository.save(new Question(null,
                "Où aura lieu votre mariage ? / ¿Dónde será la boda?",
                "Cieza", "Madrid", "Paris", "Tanger",
                0));

        System.out.println(">>> 30 REAL questions inserted successfully !");
    }
}
