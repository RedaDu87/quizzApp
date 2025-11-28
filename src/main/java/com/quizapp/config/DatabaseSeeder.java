package com.quizapp.config;

import com.quizapp.model.Question;
import com.quizapp.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {

    private final QuestionRepository questionRepository;

    @Override
    public void run(String... args) {

        // Ne pas repopuler si la base contient déjà des questions
        if (questionRepository.count() > 0) {
            System.out.println(">>> Database already populated. Skipping seeding.");
            return;
        }

        System.out.println(">>> Populating MongoDB with initial quiz data...");

        questionRepository.save(new Question(null, "REDA",
                "Quelle est votre nationalité ? / ¿Cuál es su nacionalidad?",
                "Espagnole / Española", "Française / Francesa", "Marocaine / Marroquí", "Italienne / Italiana",
                0));

        questionRepository.save(new Question(null, "ROMAISA",
                "Quelle est la nationalité de votre partenaire ? / ¿Cuál es la nacionalidad de su pareja?",
                "Française / Francesa", "Espagnole / Española", "Belge / Belga", "Portugaise / Portuguesa",
                1));

        questionRepository.save(new Question(null, "REDA",
                "Quelles sont vos passions principales ? / ¿Cuáles son sus aficiones principales?",
                "Le sport et la programmation / El deporte y la programación",
                "La musique et le cinéma / La música y el cine",
                "Les voyages et la mode / Los viajes y la moda",
                "Le dessin et la danse / El dibujo y la danza",
                0));

        questionRepository.save(new Question(null, "ROMAISA",
                "Quelles sont les passions de votre partenaire ? / ¿Cuáles son las aficiones de su pareja?",
                "Marcher et lire / Caminar y leer",
                "Danser et chanter / Bailar y cantar",
                "Couture et maquillage / Costura y maquillaje",
                "Football et moto / Fútbol y motos",
                0));

        questionRepository.save(new Question(null, "REDA",
                "Comment vous êtes-vous rencontrés ? / ¿Cómo se conocieron?",
                "Sur une application MuzzMatch / En la aplicación MuzzMatch",
                "Au travail / En el trabajo",
                "À l'université / En la universidad",
                "Dans la rue / En la calle",
                0));

        questionRepository.save(new Question(null, "ROMAISA",
                "Où vous êtes-vous rencontrés ? / ¿Dónde se conocieron?",
                "MuzzMatch / MuzzMatch",
                "Facebook / Facebook",
                "Instagram / Instagram",
                "Un café / Una cafetería",
                0));

        questionRepository.save(new Question(null, "REDA",
                "Quand vous êtes-vous rencontrés ? / ¿Cuándo se conocieron?",
                "Le 07/10/2025 / El 07/10/2025",
                "En 2023 / En 2023",
                "En 2022 / En 2022",
                "En 2024 / En 2024",
                0));

        questionRepository.save(new Question(null, "ROMAISA",
                "Quand avez-vous décidé de vous marier ? / ¿Cuándo decidieron casarse?",
                "Dès la première rencontre / Desde el primer encuentro",
                "Après un an / Después de un año",
                "Après quelques mois / Después de unos meses",
                "Après un voyage / Después de un viaje",
                0));

        questionRepository.save(new Question(null, "REDA",
                "Quand votre relation a-t-elle commencé ? / ¿Cuándo empezó su relación?",
                "Quand vous avez commencé à parler / Cuando empezaron a hablar",
                "Quand vous vous êtes vus / Cuando se vieron",
                "Après un rendez-vous / Después de una cita",
                "Après un mois / Después de un mes",
                0));

        questionRepository.save(new Question(null, "ROMAISA",
                "Avez-vous des passions en commun ? / ¿Tienen aficiones en común?",
                "Lire et marcher / Leer y caminar",
                "Dormir et manger / Dormir y comer",
                "Danser et chanter / Bailar y cantar",
                "Jouer au foot / Jugar fútbol",
                0));


// ====== 10 DONE — 40 LEFT ======

        questionRepository.save(new Question(null, "REDA",
                "Quels sont les diplômes de votre partenaire ? / ¿Qué estudios tiene su pareja?",
                "Doctorat et diplôme de dentiste / Doctorado y diploma de dentista",
                "Licence en biologie / Licenciatura en biología",
                "Master en finance / Máster en finanzas",
                "BTS informatique / Técnico en informática",
                0));

        questionRepository.save(new Question(null, "ROMAISA",
                "Qui se lève le plus tôt ? / ¿Quién se levanta más temprano?",
                "Réda / Réda",
                "Romaisa / Romaisa",
                "Les deux pareil / Ambos igual",
                "Aucun / Ninguno",
                0));

        questionRepository.save(new Question(null, "REDA",
                "Qui prépare les repas ? / ¿Quién prepara las comidas?",
                "Chacun chez soi pour l'instant / Cada uno en su casa por ahora",
                "Seulement Romaisa / Solo Romaisa",
                "Seulement Réda / Solo Réda",
                "Personne / Nadie",
                0));

        questionRepository.save(new Question(null, "ROMAISA",
                "Avez-vous déjà visité le pays de votre partenaire ? / ¿Ha visitado el país de su pareja?",
                "Pas encore / Aún no",
                "Oui, plusieurs fois / Sí, varias veces",
                "Une seule fois / Solo una vez",
                "Non, jamais / No, nunca",
                0));

        questionRepository.save(new Question(null, "REDA",
                "Les parents de votre partenaire sont-ils mariés ? / ¿Los padres de su pareja están casados?",
                "Oui / Sí",
                "Non / No",
                "Divorcés / Divorciados",
                "Je ne sais pas / No lo sé",
                0));

        questionRepository.save(new Question(null, "ROMAISA",
                "Quelle était la profession de votre partenaire dans son pays ? / ¿A qué se dedicaba su pareja en su país?",
                "Ingénieur logiciel / Ingeniero de software",
                "Dentiste / Dentista",
                "Professeur / Profesor",
                "Architecte / Arquitecto",
                0));

        questionRepository.save(new Question(null, "REDA",
                "Quel plat votre partenaire n’aime-t-il pas ? / ¿Qué plato no le gusta a su pareja?",
                "Le couscous avec raisins secs / Cuscús con pasas",
                "La paella / La paella",
                "Les pâtes / La pasta",
                "Le poulet / El pollo",
                0));

        questionRepository.save(new Question(null, "ROMAISA",
                "Quel film avez-vous vu ensemble ? / ¿Qué película vieron juntos?",
                "Aucun encore / Ninguna todavía",
                "Une comédie / Una comedia",
                "Un film d'horreur / Una de terror",
                "Une romance / Una romántica",
                0));

        questionRepository.save(new Question(null, "REDA",
                "Avez-vous voyagé ensemble ? / ¿Han viajado juntos?",
                "Pas encore / Aún no",
                "Oui une fois / Sí una vez",
                "Oui plusieurs fois / Sí varias veces",
                "Non jamais / Nunca",
                0));

        questionRepository.save(new Question(null, "ROMAISA",
                "Où aimeriez-vous voyager ensemble ? / ¿Dónde les gustaría viajar juntos?",
                "Italie ou Grèce / Italia o Grecia",
                "Canada / Canadá",
                "Japon / Japón",
                "Allemagne / Alemania",
                0));


// ====== 20 DONE — 30 LEFT ======

        questionRepository.save(new Question(null, "REDA",
                "Quelle est la date d’anniversaire de votre partenaire ? / ¿Cuál es la fecha de nacimiento de su pareja?",
                "14/12/1990", "10/10/1992", "01/01/1990", "03/03/1993",
                0));

        questionRepository.save(new Question(null, "ROMAISA",
                "Et votre date d’anniversaire à vous ? / ¿Y su propia fecha de nacimiento?",
                "08/02/1998", "05/05/1997", "10/10/1998", "01/01/1999",
                0));

        questionRepository.save(new Question(null, "REDA",
                "Avez-vous des enfants ensemble ? / ¿Tienen hijos en común?",
                "Non / No", "Oui 1 / Sí 1", "Oui 2 / Sí 2", "Oui 3 / Sí 3",
                0));

        questionRepository.save(new Question(null, "ROMAISA",
                "Nom d’un frère de votre partenaire ? / Nombre de un hermano de su pareja?",
                "Anas", "Mario", "Hassan", "David",
                0));

        questionRepository.save(new Question(null, "REDA",
                "Nom d'une sœur de votre partenaire ? / Nombre de una hermana de su pareja?",
                "Sara", "Lucia", "Noor", "Amina",
                0));

        questionRepository.save(new Question(null, "ROMAISA",
                "Quel est votre plat préféré ? / ¿Cuál es su comida favorita?",
                "Viande aux pruneaux / Carne con ciruelas", "Pizza", "Tacos", "Pâtes",
                0));

        questionRepository.save(new Question(null, "REDA",
                "Quel est son plat préféré ? / ¿Cuál es la comida favorita de su pareja?",
                "Rfissa", "Couscous", "Pastilla", "Tajine",
                0));

        questionRepository.save(new Question(null, "ROMAISA",
                "Où aura lieu votre mariage ? / ¿Dónde será la boda?",
                "Cieza", "Madrid", "Paris", "Tanger",
                0));

        questionRepository.save(new Question(null, "REDA",
                "Où s’est passée votre première rencontre ? / ¿Dónde fue su primer encuentro?",
                "Sur MuzzMatch", "Dans un café", "Au parc", "Au travail",
                0));

        questionRepository.save(new Question(null, "ROMAISA",
                "Que n’aime pas manger votre partenaire ? / ¿Qué no le gusta comer a su pareja?",
                "Kercha et choux de Bruxelles", "Pizza", "Oeufs", "Poisson",
                0));


// ====== 30 DONE — 20 LEFT ======

        questionRepository.save(new Question(null, "REDA",
                "Quel sport pratiquez-vous ? / ¿Qué deporte practica usted?",
                "Karaté", "Foot", "Natation", "Tennis",
                0));

        questionRepository.save(new Question(null, "ROMAISA",
                "Quel sport votre partenaire n’aime pas ? / ¿Qué deporte no le gusta a su pareja?",
                "Le football", "Basket", "Karaté", "Running",
                0));

        questionRepository.save(new Question(null, "REDA",
                "Qu’aimez-vous faire ensemble ? / ¿Qué les gusta hacer juntos?",
                "Lire et marcher", "Jouer au foot", "Dormir", "Regarder la TV",
                0));

        questionRepository.save(new Question(null, "ROMAISA",
                "Qu’aime votre partenaire ? / ¿Qué le gusta a su pareja?",
                "La programmation", "Le football", "La couture", "La danse",
                0));

        questionRepository.save(new Question(null, "REDA",
                "Que voulez-vous cuisiner ensemble ? / ¿Qué quieren cocinar juntos?",
                "Des plats maison", "Pizza", "Hamburgers", "Sushi",
                0));

        questionRepository.save(new Question(null, "ROMAISA",
                "Où aimeriez-vous vivre ensemble ? / ¿Dónde les gustaría vivir juntos?",
                "Suisse", "Espagne", "France", "Maroc",
                0));

        questionRepository.save(new Question(null, "REDA",
                "Quelle activité aimez-vous en nature ? / ¿Qué actividad le gusta en la naturaleza?",
                "Marcher", "Courir", "Camper", "Pêcher",
                0));

        questionRepository.save(new Question(null, "ROMAISA",
                "Que préfère votre partenaire dans la vie ? / ¿Qué prefiere su pareja en la vida?",
                "Le calme", "La fête", "Voyager", "Le luxe",
                0));

        questionRepository.save(new Question(null, "REDA",
                "Où voulez-vous aller après le mariage ? / ¿A dónde quieren ir después de la boda?",
                "Médine", "Tokyo", "New York", "Rome",
                0));

        questionRepository.save(new Question(null, "ROMAISA",
                "Quel moment préférez-vous passer ensemble ? / ¿Cuál es su momento favorito juntos?",
                "Marcher ensemble", "Regarder des films", "Aller au restaurant", "Dormir",
                0));


// ====== 40 DONE — 10 LEFT ======

        questionRepository.save(new Question(null, "REDA",
                "Quel type de films allez-vous regarder ensemble ? / ¿Qué tipo de películas verán juntos?",
                "Horreur ou comédie", "Romance", "Action", "Documentaire",
                0));

        questionRepository.save(new Question(null, "ROMAISA",
                "Où aimeriez-vous faire votre premier voyage ? / ¿Dónde les gustaría hacer su primer viaje?",
                "Italie", "USA", "Brésil", "Chine",
                0));

        questionRepository.save(new Question(null, "REDA",
                "Que préfère cuisiner votre partenaire ? / ¿Qué le gusta cocinar a su pareja?",
                "Des plats maison", "Fast food", "Salades", "Desserts",
                0));

        questionRepository.save(new Question(null, "ROMAISA",
                "Quelle qualité votre partenaire aime chez vous ? / ¿Qué cualidad le gusta a su pareja?",
                "La gentillesse", "La force", "L'humour", "La patience",
                0));

        questionRepository.save(new Question(null, "REDA",
                "Quelle est la ville de votre mariage ? / ¿Cuál es la ciudad de su boda?",
                "Cieza", "Madrid", "Barcelone", "Paris",
                0));

        questionRepository.save(new Question(null, "ROMAISA",
                "Comment commence votre journée idéale ensemble ? / ¿Cómo empieza su día ideal juntos?",
                "Un café et une promenade", "Dormir tard", "Regarder Netflix", "Faire du sport",
                0));

        questionRepository.save(new Question(null, "REDA",
                "Que veut construire votre partenaire avec vous ? / ¿Qué quiere construir su pareja?",
                "Une famille", "Un business", "Une maison", "Un voyage",
                0));

        questionRepository.save(new Question(null, "ROMAISA",
                "Que vous a dit votre partenaire dès le début ? / ¿Qué le dijo su pareja desde el principio?",
                "Qu’il voulait vous épouser", "Qu’il voulait voyager", "Qu’il voulait cuisiner", "Qu’il voulait danser",
                0));

        questionRepository.save(new Question(null, "REDA",
                "Quel pays votre partenaire veut visiter ? / ¿Qué país quiere visitar su pareja?",
                "Turquie", "Canada", "Mexique", "Thaïlande",
                0));

        questionRepository.save(new Question(null, "ROMAISA",
                "Quel endroit sacré souhaitez-vous visiter ensemble ? / ¿Qué lugar sagrado quieren visitar juntos?",
                "Médine", "La Mecque", "Jérusalem", "Fès",
                0));


        System.out.println(">>> 50 questions inserted successfully !");
    }

    private Question createQuestion(String owner, String q, String op1, String op2, String op3, String op4, int correct) {
        Question question = new Question();
        question.setOwner(owner);
        question.setQuestion(q);
        question.setOption1(op1);
        question.setOption2(op2);
        question.setOption3(op3);
        question.setOption4(op4);
        question.setCorrectIndex(correct);
        return question;
    }
}
