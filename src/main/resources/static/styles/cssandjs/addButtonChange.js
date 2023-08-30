$(document).ready(function() {
    $(".addToCartButton").click(function(event) {
        event.preventDefault();
        var button = $(this);

        $.ajax({
            url: button.attr("href"),
            type: "POST",
            success: function(response) {
                button.text("Товар успешно добавлен в корзину");
                button.attr("disabled", true);
            }
        });
    });
});