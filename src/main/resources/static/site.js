var app = new Vue({
    el: '#table_measures',
    data: {
        page: 0,
        size: 40,
        response: null
    },
    methods: {
        load: function () {
            var vue = this;

            fetch('/api/ds/measures?page=' + vue.page + '&size=' + vue.size)
                .then(function (response) {
                    return response.json();
                })
                .then(function (json) {
                    vue.response = json;
                });
        }
    }
});

app.load();
setInterval(function () {
    app.load();
}, 1000);
