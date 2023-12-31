
function autocomplete(inp, arr, arr2) {
    var currentFocus;
    inp.addEventListener("input", function (e) {
        var a, b, i, val = this.value;
        closeAllLists();
        if (!val) {
            return false;
        }
        currentFocus = -1;
        a = document.createElement("DIV");
        a.setAttribute("id", this.id + "autocomplete-list");
        a.setAttribute("class", "autocomplete-items");
        this.parentNode.appendChild(a);
        for (i = 0; i < arr.length; i++) {
            if (arr[i].toUpperCase().indexOf(val.toUpperCase()) > -1) {
                b = document.createElement("DIV");
                b.innerHTML = "<strong>" + arr[i].substr(0, val.length) + "</strong>";
                b.innerHTML += arr[i].substr(val.length);
                b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
                b.addEventListener("mouseover", function (e) {
                    removeActive(a.getElementsByTagName("div"));
                    this.classList.add("autocomplete-active");
                    this.style.backgroundColor = "blue";
                });
                b.addEventListener("click", function (e) {
                    inp.value = this.getElementsByTagName("input")[0].value;
                    var index = arr.indexOf(this.getElementsByTagName("input")[0].value);
                    if (inp.id === 'postalCode') {
                        document.getElementById('mailAddress').value = arr2[index];
                    } else if (inp.id === 'mailAddress') {
                        document.getElementById('postalCode').value = arr2[index];
                    }
                    closeAllLists();
                });
                a.appendChild(b);
            }
        }
    });
    inp.addEventListener("keydown", function (e) {
        var x = document.getElementById(this.id + "autocomplete-list");
        if (x) x = x.getElementsByTagName("div");
        if (e.keyCode == 13) {
            e.preventDefault();
            if (currentFocus > -1) {
                if (x) x[currentFocus].click();
                inp.blur();
            } else {
                var addressExists = false;
                for (var i = 0; i < arr.length; i++) {
                    if (arr[i].toUpperCase() === inp.value.toUpperCase()) {
                        addressExists = true;
                        break;
                    }
                }
                if (addressExists) {
                    var index = arr.indexOf(inp.value);
                    if (inp.id === 'postalCode') {
                        document.getElementById('mailAddress').value = arr2[index];
                    } else if (inp.id === 'mailAddress') {
                        document.getElementById('postalCode').value = arr2[index];
                    }
                    closeAllLists();
                }
            }
        } else if (e.keyCode == 38) {
            e.preventDefault();
            currentFocus--;
            addActive(x);
        } else if (e.keyCode == 40) {
            e.preventDefault();
            currentFocus++;
            addActive(x);
        }
    });

    function addActive(x) {
        if (!x) return false;
        removeActive(x);
        if (currentFocus >= x.length) currentFocus = 0;
        if (currentFocus < 0) currentFocus = (x.length - 1);
        x[currentFocus].classList.add("autocomplete-active");
        x[currentFocus].style.backgroundColor = "blue";
    }

    function removeActive(x) {
        for (var i = 0; i < x.length; i++) {
            x[i].classList.remove("autocomplete-active");
            x[i].style.backgroundColor = "";
        }
    }

    function closeAllLists(elmnt) {
        var x = document.getElementsByClassName("autocomplete-items");
        for (var i = 0; i < x.length; i++) {
            if (elmnt != x[i] && elmnt != inp) {
                x[i].parentNode.removeChild(x[i]);
            }
        }
    }

    document.addEventListener("click", function (e) {
        closeAllLists(e.target);
    });
}

var addresses = ["ул. Вокзальная 22 (Минск-Центр)",
    "ул. Московская 16",
    "ул. Сторожевская 8",
    "ул. Одинцова 113",
    "ул. Танка 36/2",
    "пр. Независимости 46",
    "ул. Маяковского 8",
    "ул. Жуковского 6/2",
    "пр. Независимости 20",
    "ул. Чеботарева 1/6",
    "ул. Советская 11",
    "пл. Привокзальная 3",
    "пр. Независимости 91",
    "ул. Я.Коласа 31",
    "ул. С.Ковалевской 61",
    "ул. Я.Мавра 33а",
    "ул. К.Маркса 38",
    "ул. Кунцевщина 35",
    "ул. Якубовского 32",
    "ул. Лобанка 109",
    "ул. пр. Победителей,123",
    "пр. Партизанский 107",
    "ул. Шаранговича 48",
    "пр. Независимости 103",
    "ул. Асаналиева 40/1",
    "ул. Есенина 10",
    "ул. Жилуновича 26",
    "ул. ул. Уманская, 55",
    "ул. Маяковского 164",
    "ул. Коммунистическая 3",
    "ул. Кирова 33",
    "ул. Славянская 4",
    "ул. Филимонова 45",
    "ул. Рыбалко 2",
    "ул. Козлова 6",
    "ул. Тарханова 11",
    "ул. Коржа 11",
    "ул. Уральская 16",
    "ул. Долгобродская 4",
    "ул. Брилевская 14",
    "ул. Беды 19",
    "ул. Рафиева 44",
    "пр. Дзержинского, 91",
    "пр. Независимости 95",
    "ул. Барамзиной 16",
    "ул. Наполеона Орды 23",
    "ул. Солтыса 189",
    "ул. Нестерова 51",
    "ул. Романовская Слобода 24",
    "ул. Кнорина 16",
    "пр. Независимости 10",
    "ул. Рафиева 93/4",
    "ул. Брыля, 30",
    "тр-т Старовиленский 28/1",
    "тер. аэропорта Минск-2",
    "ул. Жиновича  21",
    "ул. Героев 120 дивизии 9",
    "ул. ул.Гуртьева  7",
    "ул. Налибокская 36",
    "ул. Панченко 60",
    "ул. Вокзальная 22(МИНСК-60)",
    "ул. Каменногорская  3",
    "пр-т Победителей 123",
    "ул. Нёманская 35",
    "ул. Ландера 36а",
    "ул. Аэродромная 7",
    "ул. Ташкентская 16",
    "ул. Шпилевского 54",
    "б-р. Шевченко 17",
    "ул. Ванеева 18",
    "ул. Смолячкова 21",
    "ул. Академическая 1",
    "ул. Ольшевского 11",
    "ул. Берута 24/1",
    "ул. Бачило 12",
    "ул. Голодеда 49",
    "ул. Маршала Лосика 31",
    "ул. Кальварийская 44",
    "ул. Сердича 10",
    "пр. Рокоссовского 113",
    "ул. Славинского 45",
    "ул. Пулихова 19",
    "ул. Уманская 55",
    "тр-т Логойский 27",
    "пр. Пушкина 28",
    "ул. Ольшевского 57",
    "пр. Рокоссовского 33",
    "ул. Якубова 66/2",
    "ул. Голодеда 7",
    "ул. Слободская 15",
    "ул. Брестская 56/1",
    "ул. Богдановича 78",
    "ул. Малинина 28, к.5",
    "пр. Партизанский 147",
    "ул. Калиновского 55",
    "ул. Жудро 59",
    "пр. Партизанский 34/1",
    "ул. Корженевского 25",
    "ул. Красина 25 бл. А",
    "пр. Рокоссовского 49",
    "ул. Лучины 8",
    "тр-т. Логойский 1/1",
    "пр. Независимости 131/1",
    "ул. Кижеватова 80/1",
    "пр. газеты Правда 20",
    "пр. газеты Звязда 55",
    "ул. Шишкина 26",
    "ул. Карбышева 11а",
    "ул. Казинца 120",
    "ул. Притыцкого 56",
    "ул. Богдановича 53",
    "ул. Лынькова 59",
    "ул. Гинтовта 14",
    "пр. Победителей 21",
    "ул. Корженевского 14",
    "ул. Глебки 118",
    "ул. Мирошниченко 1",
    "ул. Бурдейного 13",
    "ул. Одинцова 36/1",
    "ул. Охотская 135",
    "ул. Корвата 36",
    "ул. Притыцкого 78",
    "ул. Руссиянова 9",
];
var indexes = ["200400", "220001", "220002", "220003", "220004", "220005", "220006",
    "220007", "220008", "220009", "220010", "220011", "220012", "220013", "220014",
    "220015", "220016", "220017", "220018", "220019", "220020", "220021", "220022",
    "220023", "220024", "220025", "220026", "220027", "220028", "220029", "220030",
    "220031", "220032", "220033", "220034", "220035", "220036", "220037", "220038",
    "220039", "220040", "220041", "220042", "220043", "220044", "220045", "220046",
    "220047", "220048", "220049", "220050", "220051", "220052", "220053", "220054",
    "220055", "220056", "220057", "220058", "220059", "220060", "220061", "220062",
    "220063", "220064", "220065", "220066", "220067", "220068", "220070", "220071",
    "220072", "220073", "220074", "220075", "220078", "220077", "220079", "220082",
    "220085", "220086", "220088", "220089", "220090", "220092", "220093", "220094",
    "220095", "220096", "220098", "220099", "220100", "220101", "220102", "220103",
    "220104", "220107", "220108", "220109", "220111", "220112", "220113", "220114",
    "220115", "220116", "220117", "220118", "220119", "220120", "220121", "220123",
    "220124", "220125", "220126", "220127", "220128", "220131", "220134", "220136",
    "220137", "220138", "220140", "220141"];
autocomplete(document.getElementById("postalCode"), indexes, addresses);
autocomplete(document.getElementById("mailAddress"), addresses, indexes);