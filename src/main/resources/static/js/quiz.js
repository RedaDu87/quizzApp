// Effet animation / vibration / highlight
// Ajoute des animations cute lors du clic sur une réponse
document.addEventListener("DOMContentLoaded", () => {
    const buttons = document.querySelectorAll(".answer-btn");

    buttons.forEach(btn => {
        btn.addEventListener("click", () => {
            // Petit effet heart-pop lorsqu’on clique
            const heart = document.createElement("div");
            heart.innerHTML = "💕";
            heart.classList.add("floating-heart-click");
            btn.appendChild(heart);

            setTimeout(() => heart.remove(), 800);
        });
    });
});

// Effet coeur qui s'envole
const style = document.createElement('style');
style.innerHTML = `
.floating-heart-click {
    position: absolute;
    right: 10px;
    top: -5px;
    font-size: 28px;
    animation: heartFly 0.8s ease forwards;
}

@keyframes heartFly {
    0% { opacity: 1; transform: translateY(0) scale(1); }
    100% { opacity: 0; transform: translateY(-30px) scale(1.5); }
}
`;
document.head.appendChild(style);
