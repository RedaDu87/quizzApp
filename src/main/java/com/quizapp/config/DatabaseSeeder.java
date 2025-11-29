package com.quizapp.config;

import com.quizapp.model.Question;
import com.quizapp.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        saveMixed(
                "Quand et où vous êtes-vous rencontrés ? / ¿Cuándo y dónde se conocieron?",
                "En ligne sur une application de rencontre / En línea en una aplicación de citas",
                "À Genève via Tinder / En Ginebra por Tinder",
                "À Lausanne en sortant d’une bibliothèque / En Lausana al salir de una biblioteca",
                "À un mariage d’amis communs / En una boda de amigos comunes"
        );

        saveMixed(
                "Quand avez-vous décidé de vous marier ? / ¿Cuándo decidieron casarse?",
                "Après la première rencontre / Después del primer encuentro",
                "Après plusieurs mois de relation / Después de varios meses de relación",
                "Lors d’un voyage ensemble / Durante un viaje juntos",
                "Après discussion avec les familles / Tras hablar con las familias"
        );

        saveMixed(
                "Quand avez-vous commencé votre relation ? / ¿Cuándo empezaron su relación?",
                "Dès les premiers messages / Desde los primeros mensajes",
                "Après la première sortie ensemble / Después de la primera cita juntos",
                "Après plusieurs semaines d’échanges / Tras varias semanas hablando",
                "Dès la rencontre en personne / Desde que se vieron en persona"
        );

        saveMixed(
                "Avez-vous des passions en commun ? / ¿Tienen pasiones en común?",
                "Lire, marcher, cuisiner, découvrir / Leer, caminar, cocinar, descubrir",
                "Lire et voyager / Leer y viajar",
                "Cinéma et jeux vidéo / Cine y videojuegos",
                "Musique et danse / Música y baile"
        );

        saveMixed(
                "Quel est le dernier film que vous avez vu ensemble ? / ¿Cuál es la última película que han visto juntos?",
                "Aucun encore / Todavía ninguno",
                "Un film d’horreur / Una película de terror",
                "Une comédie romantique / Una comedia romántica",
                "Un documentaire / Un documental"
        );

        saveMixed(
                "Quel est le dernier voyage que vous avez fait ensemble ? / ¿Cuál es el último viaje que han hecho juntos?",
                "Nous n’avons pas encore voyagé ensemble / Aún no hemos viajado juntos",
                "Un week-end en Espagne / Un fin de semana en España",
                "Une visite en France / Una visita a Francia",
                "Un séjour en Italie / Una estancia en Italia"
        );

        saveMixed(
                "Avez-vous des enfants ensemble ? / ¿Tienen hijos juntos?",
                "Non / No",
                "Oui, un / Sí, uno",
                "Oui, deux / Sí, dos",
                "Nous prévoyons bientôt / Planeamos tener pronto"
        );

        saveMixed(
                "Quelle est la nationalité de Réda ? / ¿Cuál es la nacionalidad de Réda?",
                "Française / Francesa",
                "Marocaine / Marroquí",
                "Espagnole / Española",
                "Suisse / Suiza"
        );

        saveMixed(
                "Quelle est la nationalité de Romaisa ? / ¿Cuál es la nacionalidad de Romaisa?",
                "Espagnole / Española",
                "Marocaine / Marroquí",
                "Française / Francesa",
                "Algérienne / Argelina"
        );

        saveMixed(
                "Quelles sont les passions de Réda ? / ¿Cuáles son las pasiones de Réda?",
                "Sport, programmation, lecture, cuisine / Deporte, programación, lectura, cocina",
                "Football, danse, pâtisserie / Fútbol, baile, repostería",
                "Photo, couture, peinture / Foto, costura, pintura",
                "Jeux vidéo, musique, voyage / Videojuegos, música, viajes"
        );

        saveMixed(
                "Quelles sont les passions de Romaisa ? / ¿Cuáles son las pasiones de Romaisa?",
                "Marche, nature, lecture, cuisine",
                "Jeux vidéo",
                "Chant, théâtre",
                "Natation, danse"
        );

        saveMixed(
                "Quels sont les diplômes de Réda ? / ¿Qué títulos tiene Réda?",
                "Doctorat en sciences des matériaux",
                "Master en informatique",
                "Licence en gestion",
                "Aucun diplôme supérieur"
        );

        saveMixed(
                "Quels sont les diplômes de Romaisa ? / ¿Qué títulos tiene Romaisa?",
                "Diplôme d’État de dentiste",
                "Doctorat en chimie",
                "Licence en biologie",
                "Aucun diplôme universitaire"
        );

        saveMixed(
                "À quelle heure Réda se lève-t-il généralement ? / ¿A qué hora suele levantarse Réda?",
                "Très tôt",
                "Vers midi",
                "Tard dans la matinée",
                "Cela dépend"
        );

        saveMixed(
                "À quelle heure Romaisa se lève-t-elle généralement ? / ¿A qué hora suele levantarse Romaisa?",
                "Très tôt",
                "Tard",
                "Vers 9–10h",
                "Cela dépend"
        );

        saveMixed(
                "Qui prépare les repas selon Réda ? / ¿Quién prepara la comida según Réda?",
                "Chacun chez soi pour l’instant",
                "Lui-même",
                "Romaisa",
                "Ils commandent souvent"
        );

        saveMixed(
                "Qui prépare les repas selon Romaisa ? / ¿Quién cocina según Romaisa?",
                "Chacun chez soi",
                "Elle-même",
                "Réda",
                "Ils commandent souvent"
        );

        saveMixed(
                "Réda a-t-il rendu visite à Romaisa ? / ¿Ha visitado Réda a Romaisa?",
                "Pas encore",
                "Oui, une fois",
                "Oui, plusieurs fois",
                "Il y vit"
        );

        saveMixed(
                "Romaisa a-t-elle rendu visite à Réda ? / ¿Ha visitado Romaisa a Réda?",
                "Pas encore",
                "Oui, une fois",
                "Oui, plusieurs fois",
                "Elle y a vécu"
        );

        saveMixed(
                "Les parents de Réda sont-ils mariés ? / ¿Los padres de Réda están casados?",
                "Oui",
                "Non",
                "Divorcés",
                "L’un décédé"
        );

        saveMixed(
                "Les parents de Romaisa sont-ils mariés ? / ¿Los padres de Romaisa están casados?",
                "Oui",
                "Non",
                "Divorcés",
                "Veufs"
        );

        saveMixed(
                "Quelle était la profession de Réda ? / ¿Cuál era la profesión de Réda?",
                "Ingénieur logiciel",
                "Professeur",
                "Médecin",
                "Chef cuisinier"
        );

        saveMixed(
                "Quelle était la profession de Romaisa ? / ¿Cuál era la profesión de Romaisa?",
                "Dentiste",
                "Infirmière",
                "Enseignante",
                "Pharmacienne"
        );

        saveMixed(
                "Quel plat Réda n’aime-t-il pas ? / ¿Qué plato no le gusta a Réda?",
                "Couscous aux raisins secs",
                "Pizza",
                "Poisson",
                "Burger"
        );

        saveMixed(
                "Quel plat Romaisa n’aime-t-elle pas ? / ¿Qué comida no le gusta a Romaisa?",
                "Soupes",
                "Kercha",
                "Choux de Bruxelles",
                "Elle aime tout"
        );

        saveMixed(
                "Quel endroit Réda veut-il visiter en premier ? / ¿Qué lugar quiere visitar primero Réda?",
                "Italie",
                "Japon",
                "Grèce",
                "Turquie"
        );

        saveMixed(
                "Quel endroit Romaisa veut-elle visiter en premier ? / ¿Qué lugar quiere visitar primero Romaisa?",
                "Médine",
                "Italie",
                "Grèce",
                "Turquie"
        );

        saveMixed(
                "Quelle est la date de naissance de Réda ? / ¿Fecha de nacimiento de Réda?",
                "14/12/1990",
                "12/07/1991",
                "22/03/1992",
                "14/02/1989"
        );

        saveMixed(
                "Quelle est la date de naissance de Romaisa ? / ¿Fecha de nacimiento de Romaisa?",
                "08/02/1998",
                "12/06/1997",
                "20/03/1999",
                "05/05/1996"
        );

        saveMixed(
                "Qui sont les frères et sœurs de Réda ? / ¿Quiénes son los hermanos de Réda?",
                "Anas, Sara, Imane",
                "Un frère unique",
                "Deux sœurs",
                "Aucun"
        );

        saveMixed(
                "Qui sont les frères et sœurs de Romaisa ? / ¿Quiénes son los hermanos de Romaisa?",
                "Aimane, Chaima, Brahim, Fatema",
                "Un seul frère",
                "Deux sœurs",
                "Aucun"
        );

        saveMixed(
                "Quel est votre plat préféré et celui de votre partenaire ? / ¿Cuál es su comida favorita y la de su pareja?",
                "Viande aux pruneaux / Rfissa",
                "Couscous / Paella",
                "Tajine / Pizza",
                "Harira / Tortilla"
        );

        saveMixed(
                "Où aura lieu le mariage ? / ¿Dónde tendrá lugar la boda?",
                "À Cieza",
                "À Madrid",
                "À Casablanca",
                "À Paris"
        );

        saveMixed(
                "Quand et où vous êtes-vous rencontrés pour la première fois ? / ¿Cuándo y dónde se conocieron por primera vez?",
                "Le 7 octobre 2025 via une application",
                "À l’université",
                "Dans un café",
                "À un mariage"
        );

        saveMixed(
                "Qui a fait le premier pas ? / ¿Quién dio el primer paso?",
                "Les deux naturellement",
                "Réda",
                "Romaisa",
                "Aucun, cela s’est fait tout seul"
        );

        saveMixed(
                "À quelle date avez-vous décidé de vous marier ? / ¿En qué fecha decidieron casarse?",
                "Dès le premier jour",
                "Après quelques semaines",
                "Après plusieurs mois",
                "Après l’accord des familles"
        );

        saveMixed(
                "Qui a proposé le mariage ? / ¿Quién propuso el matrimonio?",
                "Les deux",
                "Réda",
                "Romaisa",
                "La famille"
        );

        saveMixed(
                "Quelle activité avez-vous faite la dernière fois ensemble ? / ¿Qué actividad hicieron la última vez juntos?",
                "Dîner ensemble",
                "Regarder un film",
                "Marcher dans un parc",
                "Jouer à un jeu"
        );

        saveMixed(
                "Où habite Réda actuellement ? / ¿Dónde vive Réda actualmente?",
                "Prilly depuis février 2025",
                "Lausanne depuis 2024",
                "Genève depuis 2023",
                "Zurich depuis 2022"
        );

        saveMixed(
                "Où habite Romaisa actuellement ? / ¿Dónde vive Romaisa actualmente?",
                "Fortuna depuis ses 26 ans",
                "Madrid depuis 2020",
                "Murcie depuis 2022",
                "Barcelone depuis 2023"
        );

        saveMixed(
                "Combien de pièces y a-t-il chez Réda ? / ¿Cuántas habitaciones tiene la vivienda de Réda?",
                "2 pièces",
                "3 pièces",
                "Studio",
                "4 pièces"
        );

        saveMixed(
                "Combien de pièces y a-t-il chez Romaisa ? / ¿Cuántas habitaciones tiene la vivienda de Romaisa?",
                "T6",
                "T4",
                "T5",
                "T3"
        );

        saveMixed(
                "Qui paie le loyer ou crédit ? / ¿Quién paga el alquiler o la hipoteca?",
                "Réda",
                "Romaisa",
                "Les deux",
                "Partagé selon les revenus"
        );

        saveMixed(
                "Comment partagez-vous les dépenses ? / ¿Cómo dividen los gastos del hogar?",
                "Réda paie",
                "Romaisa paie",
                "50/50",
                "Selon la situation"
        );

        saveMixed(
                "Qui fait le ménage ? / ¿Quién hace la limpieza?",
                "Les deux",
                "Réda",
                "Romaisa",
                "Une aide extérieure"
        );

        saveMixed(
                "Qui fait la cuisine ? / ¿Quién cocina?",
                "Les deux",
                "Réda",
                "Romaisa",
                "On commande souvent"
        );

        saveMixed(
                "Quel est le plat préféré de Réda ? / ¿Cuál es el plato favorito de Réda?",
                "Rfissa",
                "Couscous",
                "Harira",
                "Pastilla"
        );

        saveMixed(
                "Quel est le plat préféré de Romaisa ? / ¿Cuál es el plato favorito de Romaisa?",
                "Carne con ciruelas",
                "Paella",
                "Tajine",
                "Sopa"
        );

        saveMixed(
                "Quelle est la boisson préférée de Réda ? / ¿Cuál es su bebida favorita?",
                "Café",
                "Cappuccino",
                "Thé noir",
                "Chocolat chaud"
        );

        saveMixed(
                "Quelle est la boisson préférée de Romaisa ? / ¿Cuál es su bebida favorita?",
                "Café",
                "Thé",
                "Jus de fruits",
                "Eau"
        );

        saveMixed(
                "À quelle heure votre partenaire se lève-t-il/elle généralement ? / ¿A qué hora suele levantarse su pareja?",
                "6h30",
                "7h00",
                "8h00",
                "9h00"
        );

        saveMixed(
                "Quelle est la routine du matin de Réda ? / ¿Cuál es la rutina matutina de Réda?",
                "Douche → Prière → Café",
                "Café → Douche → Travail",
                "Sport → Douche → Prière",
                "Petit-déjeuner → Douche → Prière"
        );

        saveMixed(
                "Quelle est la routine du matin de Romaisa ? / ¿Cuál es la rutina matutina de Romaisa?",
                "Prière → Café → Douche",
                "Douche → Café → Prière",
                "Petit-déjeuner → Douche → Travail",
                "Prière → Douche → Thé"
        );

        saveMixed(
                "Quel est le métier de Réda ? / ¿Cuál es el trabajo de Réda?",
                "Ingénieur logiciel",
                "Professeur",
                "Comptable",
                "Médecin"
        );

        saveMixed(
                "Quel est le métier de Romaisa ? / ¿Cuál es el trabajo de Romaisa?",
                "Dentiste",
                "Infirmière",
                "Pharmacienne",
                "Secrétaire"
        );

        saveMixed(
                "Où travaille Réda ? / ¿Dónde trabaja Réda?",
                "Sword Group",
                "EPFL",
                "État de Vaud",
                "Freelance"
        );

        saveMixed(
                "Où travaille Romaisa ? / ¿Dónde trabaja Romaisa?",
                "Ne travaille pas actuellement",
                "Clinique dentaire",
                "Hôpital",
                "Centre médical"
        );

        saveMixed(
                "Quel est son horaire de travail ? / ¿Cuál es su horario de trabajo?",
                "9h-12h / 14h-17h",
                "8h-16h",
                "10h-18h",
                "Horaires variables"
        );

        saveMixed(
                "Connaissez-vous le nom de son employeur ? / ¿Conoce el nombre de su empleador?",
                "Sword Group",
                "EPFL",
                "Université",
                "Aucune idée"
        );

        saveMixed(
                "Quel moyen de transport utilise-t-il/elle pour aller au travail ? / ¿Qué medio usa para ir al trabajo?",
                "À pied",
                "Vélo",
                "Bus",
                "Voiture"
        );

        saveMixed(
                "Quelle est la date de naissance de Réda ? / ¿Cuál es la fecha de nacimiento de Réda?",
                "14/12/1990",
                "02/11/1991",
                "20/03/1990",
                "18/12/1992"
        );

        saveMixed(
                "Quelle est la date de naissance de Romaisa ? / ¿Cuál es la fecha de nacimiento de Romaisa?",
                "08/02/1998",
                "10/04/1999",
                "15/05/1997",
                "12/01/1996"
        );

        saveMixed(
                "Où est né Réda ? / ¿Dónde nació Réda?",
                "Libourne",
                "Casablanca",
                "Paris",
                "Rabat"
        );

        saveMixed(
                "Où est née Romaisa ? / ¿Dónde nació Romaisa?",
                "Huelva",
                "Madrid",
                "Valencia",
                "Granada"
        );

        saveMixed(
                "Quels sont les prénoms des parents de Réda ? / ¿Nombres de los padres de Réda?",
                "Driss & Rahma",
                "Anouar & Samira",
                "Ahmed & Khadija",
                "Mohamed & Aicha"
        );

        saveMixed(
                "Quels sont les prénoms des parents de Romaisa ? / ¿Nombres de los padres de Romaisa?",
                "Mohamed & Rachida",
                "Antonio & Maria",
                "Ahmed & Fatima",
                "Youssef & Halima"
        );

        saveMixed(
                "Réda a-t-il des frères et sœurs ? / ¿Tiene Réda hermanos?",
                "3 frères/sœurs",
                "2",
                "1",
                "Aucun"
        );

        saveMixed(
                "Romaisa a-t-elle des frères et sœurs ? / ¿Tiene Romaisa hermanos?",
                "4 frères/sœurs",
                "2",
                "1",
                "Aucun"
        );

        saveMixed(
                "Avez-vous déjà rencontré sa famille ? / ¿Ya conocieron a su familia?",
                "Oui",
                "Non",
                "Seulement une partie",
                "Pas encore mais bientôt"
        );

        saveMixed(
                "Comment votre famille a réagi au mariage ? / ¿Cómo reaccionó su familia al matrimonio?",
                "Très bien, toutes heureuses",
                "Quelques inquiétudes",
                "Indifférents",
                "Partagés"
        );

        saveMixed(
                "Quel est le dernier cadeau que vous lui avez offert ? / ¿Último regalo ofrecido?",
                "Collier",
                "Parfum",
                "Livre",
                "Fleurs"
        );

        saveMixed(
                "Quel est le dernier film que vous avez regardé ensemble ? / ¿Última película vista juntos?",
                "Aucun",
                "Une comédie",
                "Un film d’horreur",
                "Un documentaire"
        );

        saveMixed(
                "Quel est le hobby préféré de Réda ? / ¿Pasatiempo favorito de Réda?",
                "Programmation",
                "Sport",
                "Lecture",
                "Cuisine"
        );

        saveMixed(
                "Quel est le hobby préféré de Romaisa ? / ¿Pasatiempo favorito de Romaisa?",
                "Lire",
                "Peinture",
                "Jardinage",
                "Marche"
        );

        saveMixed(
                "Quel type de musique aime-t-il/elle ? / ¿Qué tipo de música le gusta?",
                "Musique spirituelle",
                "Pop",
                "Classique",
                "Rap"
        );

        saveMixed(
                "Quel est son artiste préféré ? / ¿Artista favorito?",
                "Artiste marocain",
                "Artiste espagnol",
                "Artiste international",
                "Aucun"
        );

        saveMixed(
                "Quelle est la taille de Réda ? / ¿Estatura de Réda?",
                "1m80",
                "1m75",
                "1m70",
                "1m85"
        );

        saveMixed(
                "Quelle est la taille de Romaisa ? / ¿Estatura de Romaisa?",
                "1m65",
                "1m70",
                "1m60",
                "1m75"
        );

        saveMixed(
                "Quelle est la couleur des yeux de Réda ? / ¿Color de ojos de Réda?",
                "Marron",
                "Marron foncé",
                "Noisette",
                "Noir"
        );

        saveMixed(
                "Quelle est la couleur des yeux de Romaisa ? / ¿Color de ojos de Romaisa?",
                "Marron foncé",
                "Marron clair",
                "Noisette",
                "Vert"
        );

        saveMixed(
                "À quelle heure dîne Réda ? / ¿A qué hora cena Réda?",
                "20h00",
                "21h00",
                "19h30",
                "Variable"
        );

        saveMixed(
                "À quelle heure dîne Romaisa ? / ¿A qué hora cena Romaisa?",
                "21h00",
                "22h00",
                "20h00",
                "Variable"
        );

        saveMixed(
                "Avez-vous un compte bancaire commun ? / ¿Tienen una cuenta conjunta?",
                "Non",
                "Oui",
                "En projet",
                "Plus tard"
        );

        saveMixed(
                "Avez-vous déjà voyagé ensemble ? / ¿Han viajado juntos?",
                "Pas encore",
                "Une fois",
                "Plusieurs fois",
                "En projet"
        );

        saveMixed(
                "Avez-vous des projets d’enfants ? / ¿Planes de tener hijos?",
                "Oui in shaa Allah",
                "Plus tard",
                "Non",
                "Nous ne savons pas encore"
        );

        saveMixed(
                "Où avez-vous passé votre dernier week-end ensemble ? / ¿Último fin de semana juntos?",
                "Chez l’un de vous",
                "À la mer",
                "À la montagne",
                "Pas encore d’occasion"
        );

        saveMixed(
                "Quelle marque de téléphone utilise Réda ? / ¿Qué marca usa Réda?",
                "Samsung",
                "iPhone",
                "Huawei",
                "Xiaomi"
        );

        saveMixed(
                "Quelle marque de téléphone utilise Romaisa ? / ¿Qué marca usa Romaisa?",
                "Samsung",
                "iPhone",
                "Oppo",
                "Xiaomi"
        );

        saveMixed(
                "Quelle série regarde-t-il/elle en ce moment ? / ¿Qué serie está viendo?",
                "Série turque",
                "Série espagnole",
                "Série américaine",
                "Ne regarde pas de séries"
        );

        saveMixed(
                "Qui fait les courses ? / ¿Quién hace las compras?",
                "Les deux",
                "Réda",
                "Romaisa",
                "Livraison"
        );

        saveMixed(
                "Qui choisit les restaurants quand vous sortez ? / ¿Quién elige los restaurantes?",
                "Les deux",
                "Réda",
                "Romaisa",
                "Selon l’envie"
        );

        saveMixed(
                "Dormez-vous du même côté du lit ? / ¿Duermen del mismo lado de la cama?",
                "Oui",
                "Non",
                "Pas encore",
                "On change souvent"
        );

        saveMixed(
                "Quelle marque de dentifrice utilise Réda ? / ¿Qué pasta dental usa Réda?",
                "Signal",
                "Colgate",
                "Sensodyne",
                "Aquafresh"
        );

        saveMixed(
                "Quelle marque de dentifrice utilise Romaisa ? / ¿Qué pasta dental usa Romaisa?",
                "Colgate",
                "Signal",
                "Oral B",
                "Sensodyne"
        );

        saveMixed(
                "Votre partenaire a-t-il une allergie ? / ¿Su pareja tiene alergias?",
                "Aucune",
                "Pollen",
                "Poussière",
                "Animaux"
        );

        saveMixed(
                "Quelle est la date prévue du mariage civil ? / ¿Fecha prevista de la boda civil?",
                "Mars",
                "Avril",
                "Mai",
                "Date à confirmer"
        );

        saveMixed(
                "Qui seront vos témoins ? / ¿Quiénes serán sus testigos?",
                "Père de Romaisa",
                "Mère de Réda",
                "Amis proches",
                "Pas encore décidé"
        );

        saveMixed(
                "Pourquoi souhaitez-vous vous marier ? / ¿Por qué desean casarse?",
                "Toutes les réponses",
                "Construire une famille",
                "L’amour",
                "Avancer dans la vie"
        );

        saveMixed(
                "À quelle fréquence voyez-vous la famille de votre partenaire ? / ¿Con qué frecuencia ven a su familia?",
                "Régulièrement",
                "Une fois par mois",
                "Rarement",
                "Cela dépend"
        );

        saveMixed(
                "Quelle est la dernière fête que vous avez célébrée ensemble ? / ¿Última celebración juntos?",
                "Demande en mariage",
                "Anniversaire",
                "Aid",
                "Nouvel an"
        );


        System.out.println(">>> 30 REAL questions inserted successfully !");
    }

    private void saveMixed(String question, String a, String b, String c, String d) {

        List<String> opts = new ArrayList<>();
        opts.add(a);
        opts.add(b);
        opts.add(c);
        opts.add(d);

        // La bonne réponse = A avant mélange
        String correct = a;

        // Mélange aléatoire
        Collections.shuffle(opts);

        // Nouvel index correct
        int correctIndex = opts.indexOf(correct);

        questionRepository.save(new Question(
                null,
                question,
                opts.get(0),
                opts.get(1),
                opts.get(2),
                opts.get(3),
                correctIndex
        ));
    }

}
