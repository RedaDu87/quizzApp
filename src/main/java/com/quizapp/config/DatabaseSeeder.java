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

        // 1. Quand et où vous êtes-vous rencontrés ?
        questionRepository.save(new Question(
                null,
                "Quand et où vous êtes-vous rencontrés ? / ¿Cuándo y dónde se conocieron?",
                "En ligne sur une application de rencontre / En línea en una aplicación de citas",
                "À Genève via Tinder / En Ginebra por Tinder",
                "À Lausanne en sortant d’une bibliothèque / En Lausana al salir de una biblioteca",
                "À un mariage d’amis communs / En una boda de amigos comunes",
                0
        ));

// 2. Quand avez-vous décidé de vous marier ?
        questionRepository.save(new Question(
                null,
                "Quand avez-vous décidé de vous marier ? / ¿Cuándo decidieron casarse?",
                "Après la première rencontre / Después del primer encuentro",
                "Après plusieurs mois de relation / Después de varios meses de relación",
                "Lors d’un voyage ensemble / Durante un viaje juntos",
                "Après discussion avec les familles / Tras hablar con las familias",
                0
        ));

// 3. Quand avez-vous commencé votre relation ?
        questionRepository.save(new Question(
                null,
                "Quand avez-vous commencé votre relation ? / ¿Cuándo empezaron su relación?",
                "Dès les premiers messages / Desde los primeros mensajes",
                "Après la première sortie ensemble / Después de la primera cita juntos",
                "Après plusieurs semaines d’échanges / Tras varias semanas hablando",
                "Dès la rencontre en personne / Desde que se vieron en persona",
                0
        ));

// 4. Avez-vous des passions en commun ?
        questionRepository.save(new Question(
                null,
                "Avez-vous des passions en commun ? / ¿Tienen pasiones en común?",
                "Lire, marcher, cuisiner, découvrir / Leer, caminar, cocinar, descubrir",
                "Lire et voyager / Leer y viajar",
                "Cinéma et jeux vidéo / Cine y videojuegos",
                "Musique et danse / Música y baile",
                0
        ));

// 5. Quel est le dernier film que vous avez vu ensemble ?
        questionRepository.save(new Question(
                null,
                "Quel est le dernier film que vous avez vu ensemble ? / ¿Cuál es la última película que han visto juntos?",
                "Aucun encore / Todavía ninguno",
                "Un film d’horreur / Una película de terror",
                "Une comédie romantique / Una comedia romántica",
                "Un documentaire / Un documental",
                0
        ));

// 6. Quel est le dernier voyage que vous avez fait ensemble ?
        questionRepository.save(new Question(
                null,
                "Quel est le dernier voyage que vous avez fait ensemble ? / ¿Cuál es el último viaje que han hecho juntos?",
                "Nous n’avons pas encore voyagé ensemble / Aún no hemos viajado juntos",
                "Un week-end en Espagne / Un fin de semana en España",
                "Une visite en France / Una visita a Francia",
                "Un séjour en Italie / Una estancia en Italia",
                0
        ));

// 7. Avez-vous des enfants ensemble ?
        questionRepository.save(new Question(
                null,
                "Avez-vous des enfants ensemble ? / ¿Tienen hijos juntos?",
                "Non / No",
                "Oui, un / Sí, uno",
                "Oui, deux / Sí, dos",
                "Nous prévoyons bientôt / Planeamos tener pronto",
                0
        ));

// 8. Version Réda — Nationalité
        questionRepository.save(new Question(
                null,
                "Quelle est la nationalité de Réda ? / ¿Cuál es la nacionalidad de Réda?",
                "Française / Francesa",
                "Marocaine / Marroquí",
                "Espagnole / Española",
                "Suisse / Suiza",
                0
        ));

// 9. Version Romaisa — Nationalité
        questionRepository.save(new Question(
                null,
                "Quelle est la nationalité de Romaisa ? / ¿Cuál es la nacionalidad de Romaisa?",
                "Espagnole / Española",
                "Marocaine / Marroquí",
                "Française / Francesa",
                "Algérienne / Argelina",
                0
        ));

// 10. Version Réda — Passions
        questionRepository.save(new Question(
                null,
                "Quelles sont les passions de Réda ? / ¿Cuáles son las pasiones de Réda?",
                "Sport, programmation, lecture, cuisine / Deporte, programación, lectura, cocina",
                "Football, danse, pâtisserie / Fútbol, baile, repostería",
                "Photo, couture, peinture / Foto, costura, pintura",
                "Jeux vidéo, musique, voyage / Videojuegos, música, viajes",
                0
        ));
// 11. Version Romaisa — Passions
        questionRepository.save(new Question(
                null,
                "Quelles sont les passions de Romaisa ? / ¿Cuáles son las pasiones de Romaisa?",
                "Marche, nature, lecture, cuisine / Caminar, naturaleza, leer, cocinar",
                "Jeux vidéo / Videojuegos",
                "Chant, théâtre / Canto, teatro",
                "Natation, danse / Natación, baile",
                0
        ));

// 12. Version Réda — Diplômes
        questionRepository.save(new Question(
                null,
                "Quels sont les diplômes de Réda ? / ¿Qué títulos tiene Réda?",
                "Doctorat en sciences des matériaux / Doctorado en ciencias de materiales",
                "Master en informatique / Máster en informática",
                "Licence en gestion / Licenciatura en gestión",
                "Aucun diplôme supérieur / Ningún título superior",
                0
        ));

// 13. Version Romaisa — Diplômes
        questionRepository.save(new Question(
                null,
                "Quels sont les diplômes de Romaisa ? / ¿Qué títulos tiene Romaisa?",
                "Diplôme d’État de dentiste / Título estatal de odontóloga",
                "Doctorat en chimie / Doctorado en química",
                "Licence en biologie / Licenciatura en biología",
                "Aucun diplôme universitaire / Ninguno",
                0
        ));

// 14. Version Réda — Heure de lever
        questionRepository.save(new Question(
                null,
                "À quelle heure Réda se lève-t-il généralement ? / ¿A qué hora suele levantarse Réda?",
                "Très tôt / Muy temprano",
                "Vers midi / Al mediodía",
                "Tard dans la matinée / Tarde por la mañana",
                "Cela dépend / Depende",
                0
        ));

// 15. Version Romaisa — Heure de lever
        questionRepository.save(new Question(
                null,
                "À quelle heure Romaisa se lève-t-elle généralement ? / ¿A qué hora suele levantarse Romaisa?",
                "Très tôt / Muy temprano",
                "Tard / Tarde",
                "Vers 9–10h / 9–10 de la mañana",
                "Cela dépend / Depende",
                0
        ));

// 16. Version Réda — Qui prépare les repas ?
        questionRepository.save(new Question(
                null,
                "Qui prépare les repas selon Réda ? / ¿Quién prepara la comida según Réda?",
                "Chacun chez soi pour l’instant / Cada uno en su casa por ahora",
                "Lui-même / Él mismo",
                "Romaisa / Romaisa",
                "Ils commandent souvent / Piden comida a menudo",
                0
        ));

// 17. Version Romaisa — Qui prépare les repas ?
        questionRepository.save(new Question(
                null,
                "Qui prépare les repas selon Romaisa ? / ¿Quién cocina según Romaisa?",
                "Chacun chez soi / Cada uno en su casa",
                "Elle-même / Ella misma",
                "Réda / Réda",
                "Ils commandent souvent / Piden a menudo",
                0
        ));

// 18. Réda a-t-il visité Romaisa ?
        questionRepository.save(new Question(
                null,
                "Réda a-t-il rendu visite à Romaisa ? / ¿Ha visitado Réda a Romaisa en su país?",
                "Pas encore / Todavía no",
                "Oui, une fois / Sí, una vez",
                "Oui, plusieurs fois / Sí, varias veces",
                "Il y vit / Vive allí",
                0
        ));

// 19. Romaisa a-t-elle rendu visite à Réda ?
        questionRepository.save(new Question(
                null,
                "Romaisa a-t-elle rendu visite à Réda ? / ¿Ha visitado Romaisa a Réda en su país?",
                "Pas encore / Todavía no",
                "Oui, une fois / Sí, una vez",
                "Oui, plusieurs fois / Sí, varias veces",
                "Elle y a vécu / Vivió allí",
                0
        ));

// 20. Les parents de Réda sont-ils mariés ?
        questionRepository.save(new Question(
                null,
                "Les parents de Réda sont-ils mariés ? / ¿Los padres de Réda están casados?",
                "Oui / Sí",
                "Non / No",
                "Divorcés / Divorciados",
                "L’un décédé / Uno fallecido",
                0
        ));
// 21. Les parents de Romaisa sont-ils mariés ?
        questionRepository.save(new Question(
                null,
                "Les parents de Romaisa sont-ils mariés ? / ¿Los padres de Romaisa están casados?",
                "Oui / Sí",
                "Non / No",
                "Divorcés / Divorciados",
                "Veufs / Viudos",
                0
        ));

// 22. Profession de Réda
        questionRepository.save(new Question(
                null,
                "Quelle est la profession de Réda ? / ¿Cuál era la profesión de Réda?",
                "Ingénieur logiciel / Ingeniero de software",
                "Professeur / Profesor",
                "Médecin / Médico",
                "Chef cuisinier / Chef cocinero",
                0
        ));

// 23. Profession de Romaisa
        questionRepository.save(new Question(
                null,
                "Quelle est la profession de Romaisa ? / ¿Cuál era la profesión de Romaisa?",
                "Dentiste / Odontóloga",
                "Infirmière / Enfermera",
                "Enseignante / Maestra",
                "Pharmacienne / Farmacéutica",
                0
        ));

// 24. Plat détesté de Réda
        questionRepository.save(new Question(
                null,
                "Quel plat Réda n’aime-t-il pas ? / ¿Qué plato no le gusta a Réda?",
                "Couscous aux raisins secs / Cuscús con pasas",
                "Pizza / Pizza",
                "Poisson / Pescado",
                "Burger / Hamburguesa",
                0
        ));

// 25. Plat détesté de Romaisa
        questionRepository.save(new Question(
                null,
                "Quel plat Romaisa n’aime-t-elle pas ? / ¿Qué comida no le gusta a Romaisa?",
                "Soupes / Sopas",
                "Kercha / Kercha",
                "Choux de Bruxelles / Coles de Bruselas",
                "Elle aime tout / Le gusta todo",
                0
        ));

// 26. Où Réda veut voyager en premier ?
        questionRepository.save(new Question(
                null,
                "Quel endroit Réda veut-il visiter en premier ? / ¿Qué lugar quiere visitar primero Réda?",
                "Italie / Italia",
                "Japon / Japón",
                "Grèce / Grecia",
                "Turquie / Turquía",
                0
        ));

// 27. Où Romaisa veut voyager en premier ?
        questionRepository.save(new Question(
                null,
                "Quel endroit Romaisa veut-elle visiter en premier ? / ¿Qué lugar quiere visitar primero Romaisa?",
                "Médine / Medina",
                "Italie / Italia",
                "Grèce / Grecia",
                "Turquie / Turquía",
                0
        ));

// 28. Anniversaire de Réda
        questionRepository.save(new Question(
                null,
                "Quelle est la date de naissance de Réda ? / ¿Fecha de nacimiento de Réda?",
                "14/12/1990",
                "12/07/1991",
                "22/03/1992",
                "14/02/1989",
                0
        ));

// 29. Anniversaire de Romaisa
        questionRepository.save(new Question(
                null,
                "Quelle est la date de naissance de Romaisa ? / ¿Fecha de nacimiento de Romaisa?",
                "08/02/1998",
                "12/06/1997",
                "20/03/1999",
                "05/05/1996",
                0
        ));

// 30. Frères et sœurs de Réda
        questionRepository.save(new Question(
                null,
                "Qui sont les frères et sœurs de Réda ? / ¿Quiénes son los hermanos de Réda?",
                "Anas, Sara, Imane / Anas, Sara, Imane",
                "Un frère unique / Un solo hermano",
                "Deux sœurs / Dos hermanas",
                "Aucun / Ninguno",
                0
        ));
// 31. Frères et sœurs de Romaisa
        questionRepository.save(new Question(
                null,
                "Qui sont les frères et sœurs de Romaisa ? / ¿Quiénes son los hermanos de Romaisa?",
                "Aimane, Chaima, Brahim, Fatema",
                "Un seul frère / Un solo hermano",
                "Deux sœurs / Dos hermanas",
                "Aucun / Ninguno",
                0
        ));

// 32. Plat préféré du couple
        questionRepository.save(new Question(
                null,
                "Quel est votre plat préféré ? Et celui de votre partenaire ? / ¿Cuál es su plato favorito y el de su pareja?",
                "Viande aux pruneaux / Rfissa — Carne con ciruelas / Rfissa",
                "Couscous / Paella",
                "Tajine / Pizza",
                "Harira / Tortilla",
                0
        ));

// 33. Lieu du mariage
        questionRepository.save(new Question(
                null,
                "Où aura lieu le mariage ? / ¿Dónde tendrá lugar la boda?",
                "À Cieza / En Cieza",
                "À Madrid / En Madrid",
                "À Casablanca / En Casablanca",
                "À Paris / En París",
                0
        ));

// 34. Première rencontre — version détaillée
        questionRepository.save(new Question(
                null,
                "Quand et où vous êtes-vous rencontrés pour la première fois ? / ¿Cuándo y dónde se conocieron por primera vez?",
                "Le 7 octobre 2025 via une application / El 7 de octubre 2025 por una app",
                "À l’université / En la universidad",
                "Dans un café / En una cafetería",
                "À un mariage / En una boda",
                0
        ));

// 35. Qui a fait le premier pas ?
        questionRepository.save(new Question(
                null,
                "Qui a fait le premier pas ? / ¿Quién dio el primer paso?",
                "Les deux naturellement / Los dos naturalmente",
                "Réda",
                "Romaisa",
                "Aucun, cela s’est fait tout seul / Ninguno, surgió solo",
                0
        ));

// 36. Date de décision du mariage
        questionRepository.save(new Question(
                null,
                "À quelle date avez-vous décidé de vous marier ? / ¿En qué fecha decidieron casarse?",
                "Dès le premier jour / Desde el primer día",
                "Après quelques semaines / Tras unas semanas",
                "Après plusieurs mois / Tras varios meses",
                "Après l’accord des familles / Tras el acuerdo familiar",
                0
        ));

// 37. Qui a proposé le mariage ?
        questionRepository.save(new Question(
                null,
                "Qui a proposé le mariage ? / ¿Quién propuso el matrimonio?",
                "Les deux / Los dos",
                "Réda",
                "Romaisa",
                "La famille / La familia",
                0
        ));

// 38. Activité lors de la dernière soirée ensemble
        questionRepository.save(new Question(
                null,
                "Quelle activité avez-vous faite la dernière fois ensemble ? / ¿Qué actividad hicieron la última vez juntos?",
                "Dîner ensemble / Cenar juntos",
                "Regarder un film / Ver una película",
                "Marcher dans un parc / Pasear",
                "Jouer à un jeu / Jugar",
                0
        ));

// 39. Où habite Réda ?
        questionRepository.save(new Question(
                null,
                "Où habite Réda actuellement ? / ¿Dónde vive Réda actualmente?",
                "Prilly depuis février 2025 / Prilly desde febrero 2025",
                "Lausanne depuis 2024",
                "Genève depuis 2023",
                "Zurich depuis 2022",
                0
        ));

// 40. Où habite Romaisa ?
        questionRepository.save(new Question(
                null,
                "Où habite Romaisa actuellement ? / ¿Dónde vive Romaisa actualmente?",
                "Fortuna depuis ses 26 ans / Fortuna desde los 26 años",
                "Madrid depuis 2020",
                "Murcie depuis 2022",
                "Barcelone depuis 2023",
                0
        ));
// 41. Nombre de pièces — Réda
        questionRepository.save(new Question(
                null,
                "Combien de pièces y a-t-il chez Réda ? / ¿Cuántas habitaciones tiene la vivienda de Réda?",
                "2 pièces / 2 habitaciones",
                "3 pièces / 3 habitaciones",
                "Studio / Estudio",
                "4 pièces / 4 habitaciones",
                0
        ));

// 42. Nombre de pièces — Romaisa
        questionRepository.save(new Question(
                null,
                "Combien de pièces y a-t-il chez Romaisa ? / ¿Cuántas habitaciones tiene la vivienda de Romaisa?",
                "T6 / 6 habitaciones",
                "T4 / 4 habitaciones",
                "T5 / 5 habitaciones",
                "T3 / 3 habitaciones",
                0
        ));

// 43. Qui paie le loyer ?
        questionRepository.save(new Question(
                null,
                "Qui paie le loyer ou crédit ? / ¿Quién paga el alquiler o la hipoteca?",
                "Réda",
                "Romaisa",
                "Les deux / Los dos",
                "Partagé selon les revenus / Repartido según ingresos",
                0
        ));

// 44. Comment partagez-vous les dépenses ?
        questionRepository.save(new Question(
                null,
                "Comment partagez-vous les dépenses ? / ¿Cómo dividen los gastos del hogar?",
                "Réda paie / Paga Réda",
                "Romaisa paie / Paga Romaisa",
                "50/50",
                "Selon la situation / Según la situación",
                0
        ));

// 45. Qui fait le ménage ?
        questionRepository.save(new Question(
                null,
                "Qui fait le ménage ? / ¿Quién hace la limpieza?",
                "Les deux / Los dos",
                "Réda",
                "Romaisa",
                "Une aide extérieure / Una ayuda externa",
                0
        ));

// 46. Qui cuisine ?
        questionRepository.save(new Question(
                null,
                "Qui fait la cuisine ? / ¿Quién cocina en casa?",
                "Les deux / Los dos",
                "Réda",
                "Romaisa",
                "On commande souvent / Pedimos a menudo",
                0
        ));

// 47. Plat préféré de Réda
        questionRepository.save(new Question(
                null,
                "Quel est le plat préféré de Réda ? / ¿Cuál es el plato favorito de Réda?",
                "Rfissa",
                "Couscous",
                "Harira",
                "Pastilla",
                0
        ));

// 48. Plat préféré de Romaisa
        questionRepository.save(new Question(
                null,
                "Quel est le plat préféré de Romaisa ? / ¿Cuál es el plato favorito de Romaisa?",
                "Carne con ciruelas",
                "Paella",
                "Tajine",
                "Sopa",
                0
        ));

// 49. Boisson préférée de Réda
        questionRepository.save(new Question(
                null,
                "Quelle est la boisson préférée de Réda ? / ¿Cuál es su bebida favorita?",
                "Café",
                "Cappuccino",
                "Thé noir / Té negro",
                "Chocolat chaud / Chocolate caliente",
                0
        ));

// 50. Boisson préférée de Romaisa
        questionRepository.save(new Question(
                null,
                "Quelle est la boisson préférée de Romaisa ? / ¿Cuál es su bebida favorita?",
                "Café",
                "Thé / Té",
                "Jus de fruits / Zumo",
                "Eau / Agua",
                0
        ));
// 51. Heure de réveil du partenaire
        questionRepository.save(new Question(
                null,
                "À quelle heure votre partenaire se lève-t-il/elle généralement ? / ¿A qué hora suele levantarse su pareja?",
                "6h30",
                "7h00",
                "8h00",
                "9h00",
                0
        ));

// 52. Routine du matin — Réda
        questionRepository.save(new Question(
                null,
                "Quelle est la routine du matin de Réda ? / ¿Cuál es la rutina matutina de Réda?",
                "Douche → Prière → Café",
                "Café → Douche → Travail",
                "Sport → Douche → Prière",
                "Petit-déjeuner → Douche → Prière",
                0
        ));

// 53. Routine du matin — Romaisa
        questionRepository.save(new Question(
                null,
                "Quelle est la routine du matin de Romaisa ? / ¿Cuál es la rutina matutina de Romaisa?",
                "Prière → Café → Douche",
                "Douche → Café → Prière",
                "Petit-déjeuner → Douche → Travail",
                "Prière → Douche → Thé",
                0
        ));

// 54. Profession de Réda
        questionRepository.save(new Question(
                null,
                "Quel est le métier de Réda ? / ¿Cuál es el trabajo de Réda?",
                "Ingénieur logiciel / Ingeniero de software",
                "Professeur / Profesor",
                "Comptable / Contable",
                "Médecin / Médico",
                0
        ));

// 55. Profession de Romaisa
        questionRepository.save(new Question(
                null,
                "Quel est le métier de Romaisa ? / ¿Cuál es el trabajo de Romaisa?",
                "Dentiste / Odontóloga",
                "Enfermera / Infirmière",
                "Pharmacienne / Farmacéutica",
                "Secrétaire / Secretaria",
                0
        ));

// 56. Où travaille Réda ?
        questionRepository.save(new Question(
                null,
                "Où travaille Réda ? / ¿Dónde trabaja Réda?",
                "Sword Group",
                "EPFL",
                "État de Vaud",
                "Freelance",
                0
        ));

// 57. Où travaille Romaisa ?
        questionRepository.save(new Question(
                null,
                "Où travaille Romaisa ? / ¿Dónde trabaja Romaisa?",
                "Ne travaille pas actuellement / No trabaja actualmente",
                "Clinique dentaire",
                "Hôpital / Hospital",
                "Centre médical / Centro médico",
                0
        ));

// 58. Horaire de travail du partenaire
        questionRepository.save(new Question(
                null,
                "Quel est son horaire de travail ? / ¿Cuál es su horario de trabajo?",
                "9h-12h / 14h-17h",
                "8h-16h",
                "10h-18h",
                "Horaires variables",
                0
        ));

// 59. Connaissez-vous le nom de son employeur ?
        questionRepository.save(new Question(
                null,
                "Connaissez-vous le nom de son employeur ? / ¿Conoce el nombre de su empleador?",
                "Sword Group",
                "EPFL",
                "Université / Universidad",
                "Aucune idée / Ninguna idea",
                0
        ));

// 60. Moyen de transport utilisé
        questionRepository.save(new Question(
                null,
                "Quel moyen de transport utilise-t-il/elle pour aller au travail ? / ¿Qué medio de transporte usa para ir a trabajar?",
                "À pied / A pie",
                "Vélo / Bicicleta",
                "Bus / Autobús",
                "Voiture / Coche",
                0
        ));
// 61. Date de naissance — Réda
        questionRepository.save(new Question(
                null,
                "Quelle est la date de naissance de Réda ? / ¿Cuál es la fecha de nacimiento de Réda?",
                "14/12/1990",
                "02/11/1991",
                "20/03/1990",
                "18/12/1992",
                0
        ));

// 62. Date de naissance — Romaisa
        questionRepository.save(new Question(
                null,
                "Quelle est la date de naissance de Romaisa ? / ¿Cuál es la fecha de nacimiento de Romaisa?",
                "08/02/1998",
                "10/04/1999",
                "15/05/1997",
                "12/01/1996",
                0
        ));

// 63. Lieu de naissance — Réda
        questionRepository.save(new Question(
                null,
                "Où est né Réda ? / ¿Dónde nació Réda?",
                "Libourne",
                "Casablanca",
                "Paris",
                "Rabat",
                0
        ));

// 64. Lieu de naissance — Romaisa
        questionRepository.save(new Question(
                null,
                "Où est née Romaisa ? / ¿Dónde nació Romaisa?",
                "Huelva",
                "Madrid",
                "Valencia",
                "Granada",
                0
        ));

// 65. Prénoms des parents — Réda
        questionRepository.save(new Question(
                null,
                "Quels sont les prénoms des parents de Réda ? / ¿Cuáles son los nombres de los padres de Réda?",
                "Driss & Rahma",
                "Anouar & Samira",
                "Ahmed & Khadija",
                "Mohamed & Aicha",
                0
        ));

// 66. Prénoms des parents — Romaisa
        questionRepository.save(new Question(
                null,
                "Quels sont les prénoms des parents de Romaisa ? / ¿Cuáles son los nombres de los padres de Romaisa?",
                "Mohamed & Rachida",
                "Antonio & Maria",
                "Ahmed & Fatima",
                "Youssef & Halima",
                0
        ));

// 67. Frères et sœurs — Réda
        questionRepository.save(new Question(
                null,
                "Réda a-t-il des frères et sœurs ? / ¿Tiene Réda hermanos?",
                "3 frères/sœurs",
                "2",
                "1",
                "Aucun",
                0
        ));

// 68. Frères et sœurs — Romaisa
        questionRepository.save(new Question(
                null,
                "Romaisa a-t-elle des frères et sœurs ? / ¿Tiene Romaisa hermanos?",
                "4 frères/sœurs",
                "2",
                "1",
                "Aucun",
                0
        ));

// 69. Avez-vous rencontré sa famille ?
        questionRepository.save(new Question(
                null,
                "Avez-vous déjà rencontré sa famille ? / ¿Ya conocieron a su familia?",
                "Oui / Sí",
                "Non / No",
                "Seulement une partie / Solo una parte",
                "Pas encore mais bientôt / Todavía no pero pronto",
                0
        ));

// 70. Réaction des familles au mariage
        questionRepository.save(new Question(
                null,
                "Comment votre famille a réagi au mariage ? / ¿Cómo reaccionó su familia al matrimonio?",
                "Très bien, toutes heureuses / Muy bien, ambas felices",
                "Quelques inquiétudes / Algunas preocupaciones",
                "Indifférents / Indiferentes",
                "Partagés / Divididos",
                0
        ));
// 71. Dernier cadeau offert
        questionRepository.save(new Question(
                null,
                "Quel est le dernier cadeau que vous lui avez offert ? / ¿Cuál fue el último regalo que le dieron?",
                "Collier / Collar",
                "Parfum / Perfume",
                "Livre / Libro",
                "Fleurs / Flores",
                0
        ));

// 72. Dernier film vu ensemble
        questionRepository.save(new Question(
                null,
                "Quel est le dernier film que vous avez regardé ensemble ? / ¿Cuál fue la última película que vieron juntos?",
                "Aucun / Ninguna",
                "Une comédie / Una comedia",
                "Un film d’horreur / Una de terror",
                "Un documentaire / Un documental",
                0
        ));

// 73. Hobby de Réda
        questionRepository.save(new Question(
                null,
                "Quel est le hobby préféré de Réda ? / ¿Cuál es el pasatiempo favorito de Réda?",
                "Programmation / Programación",
                "Sport / Deporte",
                "Lecture / Lectura",
                "Cuisine / Cocina",
                0
        ));

// 74. Hobby de Romaisa
        questionRepository.save(new Question(
                null,
                "Quel est le hobby préféré de Romaisa ? / ¿Cuál es el pasatiempo favorito de Romaisa?",
                "Lire / Leer",
                "Peinture / Pintura",
                "Jardinage / Jardinería",
                "Marche / Caminar",
                0
        ));

// 75. Type de musique préféré
        questionRepository.save(new Question(
                null,
                "Quel type de musique aime-t-il/elle ? / ¿Qué tipo de música le gusta?",
                "Musique spirituelle / Música espiritual",
                "Pop",
                "Classique / Clásica",
                "Rap",
                0
        ));

// 76. Artiste préféré
        questionRepository.save(new Question(
                null,
                "Quel est son artiste préféré ? / ¿Cuál es su artista favorito?",
                "Artiste marocain / Artista marroquí",
                "Artiste espagnol / Artista español",
                "Artiste international / Artista internacional",
                "Aucun / Ninguno",
                0
        ));

// 77. Taille — Réda
        questionRepository.save(new Question(
                null,
                "Quelle est la taille de Réda ? / ¿Cuál es la estatura de Réda?",
                "1m80",
                "1m75",
                "1m70",
                "1m85",
                0
        ));

// 78. Taille — Romaisa
        questionRepository.save(new Question(
                null,
                "Quelle est la taille de Romaisa ? / ¿Cuál es la estatura de Romaisa?",
                "1m65",
                "1m70",
                "1m60",
                "1m75",
                0
        ));

// 79. Couleur des yeux — Réda
        questionRepository.save(new Question(
                null,
                "De quelle couleur sont les yeux de Réda ? / ¿De qué color son los ojos de Réda?",
                "Marron",
                "Marron foncé",
                "Noisette",
                "Noir",
                0
        ));

// 80. Couleur des yeux — Romaisa
        questionRepository.save(new Question(
                null,
                "De quelle couleur sont les yeux de Romaisa ? / ¿De qué color son los ojos de Romaisa?",
                "Marron foncé",
                "Marron clair",
                "Noisette",
                "Vert",
                0
        ));
// 81. Heure du dîner — Réda
        questionRepository.save(new Question(
                null,
                "À quelle heure dîne Réda ? / ¿A qué hora cena Réda?",
                "20h00",
                "21h00",
                "19h30",
                "Variable",
                0
        ));

// 82. Heure du dîner — Romaisa
        questionRepository.save(new Question(
                null,
                "À quelle heure dîne Romaisa ? / ¿A qué hora cena Romaisa?",
                "21h00",
                "22h00",
                "20h00",
                "Variable",
                0
        ));

// 83. Compte bancaire commun
        questionRepository.save(new Question(
                null,
                "Avez-vous un compte bancaire commun ? / ¿Tienen una cuenta bancaria conjunta?",
                "Non",
                "Oui",
                "En projet / En proyecto",
                "Plus tard / Más adelante",
                0
        ));

// 84. Voyages ensemble
        questionRepository.save(new Question(
                null,
                "Avez-vous déjà voyagé ensemble ? / ¿Han viajado juntos?",
                "Pas encore / Aún no",
                "Une fois",
                "Plusieurs fois",
                "En projet",
                0
        ));

// 85. Projet d’enfants
        questionRepository.save(new Question(
                null,
                "Avez-vous des projets d’enfants ? / ¿Tienen planes de tener hijos?",
                "Oui in shaa Allah",
                "Plus tard",
                "Non",
                "Nous ne savons pas encore",
                0
        ));

// 86. Dernier week-end ensemble
        questionRepository.save(new Question(
                null,
                "Où avez-vous passé votre dernier week-end ensemble ? / ¿Dónde pasaron su último fin de semana juntos?",
                "Chez l’un de vous / En casa de uno de ustedes",
                "À la mer / En la playa",
                "À la montagne / En la montaña",
                "Pas encore d’occasion / Aún no",
                0
        ));

// 87. Marque de téléphone — Réda
        questionRepository.save(new Question(
                null,
                "Quelle marque de téléphone utilise Réda ? / ¿Qué marca de teléfono usa Réda?",
                "Samsung",
                "iPhone",
                "Huawei",
                "Xiaomi",
                0
        ));

// 88. Marque de téléphone — Romaisa
        questionRepository.save(new Question(
                null,
                "Quelle marque de téléphone utilise Romaisa ? / ¿Qué marca de teléfono usa Romaisa?",
                "Samsung",
                "iPhone",
                "Oppo",
                "Xiaomi",
                0
        ));

// 89. Série en cours
        questionRepository.save(new Question(
                null,
                "Quelle série regarde-t-il/elle en ce moment ? / ¿Qué serie está viendo?",
                "Série turque",
                "Série espagnole",
                "Série américaine",
                "Ne regarde pas de séries",
                0
        ));

// 90. Qui fait les courses ?
        questionRepository.save(new Question(
                null,
                "Qui fait les courses ? / ¿Quién hace las compras?",
                "Les deux / Los dos",
                "Réda",
                "Romaisa",
                "Livraison / Servicio a domicilio",
                0
        ));
// 91. Qui choisit les restaurants ?
        questionRepository.save(new Question(
                null,
                "Qui choisit les restaurants quand vous sortez ? / ¿Quién elige los restaurantes cuando salen?",
                "Les deux / Los dos",
                "Réda",
                "Romaisa",
                "Selon l’envie / Según el gusto",
                0
        ));

// 92. Dormez-vous du même côté du lit ?
        questionRepository.save(new Question(
                null,
                "Dormez-vous du même côté du lit ? / ¿Duermen del mismo lado de la cama?",
                "Oui / Sí",
                "Non / No",
                "Pas encore",
                "On change souvent / Cambiamos",
                0
        ));

// 93. Marque de dentifrice — Réda
        questionRepository.save(new Question(
                null,
                "Quelle marque de dentifrice utilise Réda ? / ¿Qué pasta dental usa Réda?",
                "Signal",
                "Colgate",
                "Sensodyne",
                "Aquafresh",
                0
        ));

// 94. Marque de dentifrice — Romaisa
        questionRepository.save(new Question(
                null,
                "Quelle marque de dentifrice utilise Romaisa ? / ¿Qué pasta dental usa Romaisa?",
                "Colgate",
                "Signal",
                "Oral B",
                "Sensodyne",
                0
        ));

// 95. Allergies du partenaire
        questionRepository.save(new Question(
                null,
                "Votre partenaire a-t-il une allergie ? / ¿Su pareja tiene alergias?",
                "Aucune / Ninguna",
                "Pollen",
                "Poussière / Polvo",
                "Animaux",
                0
        ));

// 96. Date du mariage civil
        questionRepository.save(new Question(
                null,
                "Quelle est la date prévue du mariage civil ? / ¿Cuál es la fecha prevista para la boda civil?",
                "Mars / Marzo",
                "Avril / Abril",
                "Mai / Mayo",
                "Date à confirmer / Fecha por confirmar",
                0
        ));

// 97. Témoins du mariage
        questionRepository.save(new Question(
                null,
                "Qui seront vos témoins ? / ¿Quiénes serán sus testigos?",
                "Père de Romaisa",
                "Mère de Réda",
                "Amis proches",
                "Pas encore décidé",
                0
        ));

// 98. Pourquoi vous marier ?
        questionRepository.save(new Question(
                null,
                "Pourquoi souhaitez-vous vous marier ? / ¿Por qué desean casarse?",
                "Toutes les réponses / Todas",
                "Construire une famille / Formar una familia",
                "L’amour / El amor",
                "Avancer dans la vie / Avanzar",
                0
        ));

// 99. Fréquence avec la famille du partenaire
        questionRepository.save(new Question(
                null,
                "À quelle fréquence voyez-vous la famille de votre partenaire ? / ¿Con qué frecuencia ven a la familia de su pareja?",
                "Régulièrement",
                "Une fois par mois",
                "Rarement",
                "Cela dépend / Depende",
                0
        ));

// 100. Dernière fête célébrée ensemble
        questionRepository.save(new Question(
                null,
                "Quelle est la dernière fête que vous avez célébrée ensemble ? / ¿Cuál fue la última celebración juntos?",
                "Demande en mariage / Pedida de mano",
                "Anniversaire",
                "Aid",
                "Nouvel an / Año nuevo",
                0
        ));


        System.out.println(">>> 30 REAL questions inserted successfully !");
    }
}
