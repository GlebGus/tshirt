window.onload = function() {
    var container = document.getElementById('container'); // Замените 'container' на ID вашего контейнера или элемента, в котором находятся данные
    container.addEventListener('wheel', function(e) {
        var delta = e.deltaY || e.detail || e.wheelDelta; // Получаем значение прокрутки колесика
        container.scrollTop += delta; // Прокручиваем контейнер на значение прокрутки
        e.preventDefault(); // Отменяем стандартное поведение прокрутки страницы
    });
};