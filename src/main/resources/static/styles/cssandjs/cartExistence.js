var addToCartButton = document.getElementById("addToCartButton");

// Проверка наличия товара в корзине
if (itemExists) {
    // Изменение текста и атрибутов кнопки
    addToCartButton.innerText = "In Cart";
    addToCartButton.setAttribute("disabled", "disabled");
    session.setAttribute("cartItems", cartItems);
    window.location.reload(); // обновление страницы
} else {
    // Создание ссылки на добавление товара в корзину
    var addToCartLink = document.createElement("a");
    addToCartLink.setAttribute("href", "/cart/add(tShirtid=" + tShirt.id + ")");
    addToCartLink.innerText = "Add to Cart";

    // Замена кнопки на ссылку
    addToCartButton.parentNode.replaceChild(addToCartLink, addToCartButton);
}