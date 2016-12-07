var dataProviderData = [{
    "date": "1",
    "distance": 227,
}, {
    "date": "2",
    "distance": 371,
}, {
    "date": "3",
    "distance": 433,
}, {
    "date": "4",
    "distance": 345,
}, {
    "date": "5",
    "distance": 386,
}, {
    "date": "6",
    "distance": 348,
    "townName": "New Orleans",
}, {
    "date": "7",
    "distance": 238,
    "townName": "Houston",
}, {
    "date": "8",
    "distance": 218,
}, {
    "date": "9",
    "distance": 349,
}, {
    "date": "10",
    "distance": 603,
}, {
    "date": "11",
    "distance": 603,
}, {
    "date": "12",
    "distance": 603,
}, {
    "date": "13",
    "distance": 603,
}, {
    "date": "14",
    "distance": 603,
}, {
    "date": "15",
    "distance": 603,
}, {
    "date": "16",
    "distance": 603,
}, {
    "date": "17",
    "distance": 603,
}, {
    "date": "18",
    "distance": 603,
}, {
    "date": "19",
    "distance": 534,

},{
    "date": "20",
    "distance": 603,
}, {
    "date": "21",
    "distance": 603,
}, {
    "date": "22",
    "distance": 603,

}, {
    "date": "23",
    "distance": 603,

}, {
    "date": "24",
    "distance": 603,
} ];

var ChartsAmcharts = function() {

    var initChartSample1 = function(data,container,graphTitles) {

        var graphs = [];
        $.each(graphTitles,function(){
            var graphTemplate = {
                "alphaField": "alpha",
                "balloonText": "[[value]] ",
                "dashLengthField": "dashLength",
                "fillAlphas": 0.7,
                "legendValueText": "[[value]] ",
                "type": "column",
                "valueField": "distance",
                "valueAxis": "distanceAxis"
            };
            graphTemplate.title = this;
            graphs.push(graphTemplate);
        })
        var configData = {
            "type": "serial",
            "theme": "light",

            "fontFamily": 'Open Sans',
            "color":    '#888888',

            "legend": {
                "equalWidths": false,
                "useGraphSettings": true,
                "valueAlign": "left",
                "valueWidth": 120
            },
            "dataProvider": data,
            "valueAxes": [{
                "id": "distanceAxis",
                "axisAlpha": 0,
                "gridAlpha": 0,
                "position": "left",
                "title": "数值"
            }],
            "graphs":graphs,
            "chartCursor": {
                "categoryBalloonDateFormat": "DD",
                "cursorAlpha": 0.1,
                "cursorColor": "#000000",
                "fullWidth": true,
                "valueBalloonsEnabled": false,
                "zoomable": false
            },
            "categoryField": "date",
            "categoryAxis": {
                "autoGridCount": false,
                "axisColor": "#555555",
                "gridAlpha": 0.1,
                "gridColor": "#FFFFFF",
                "gridCount": 50
            },
            "exportConfig": {
                "menuBottom": "20px",
                "menuRight": "22px",
                "menuItems": [{
                    "icon": App.getGlobalPluginsPath() + "amcharts/amcharts/images/export.png",
                    "format": 'png'
                }]
            }
        };

        var chart = AmCharts.makeChart(container, configData
        );
        $(container).closest('.portlet').find('.fullscreen').click(function() {
            chart.invalidateSize();
        });
    }

    return {
        //main function to initiate the module

        init: function(data,container,graphTitles) {
            initChartSample1(data,container,graphTitles);
        }

    };

}();

function getRandomData(){
    var myFillData = [];
    for(var i=0;i<24;i++)
    {
        var data = {};
        data.date = i+"";
        data.distance = Math.random()*10+60;
        myFillData.push(data);
    }
    ChartsAmcharts.init(myFillData,"chart_1",["一层照明能耗","二层照明能耗","辐射度"]);
    ChartsAmcharts.init(myFillData,"chart_2",["一层插座能耗","二层插座能耗"]);
    ChartsAmcharts.init(myFillData,"chart_3",["冷热源消耗","输配能耗","末端能耗"]);
    ChartsAmcharts.init(myFillData,"chart_6",["二楼光度实验室能耗"]);
}

jQuery(document).ready(function() {
    $('.mydate').datepicker({
        orientation:'bottom auto',
        language:"zh-CN"
    });
    getRandomData();
    setInterval(getRandomData, 2000);
});