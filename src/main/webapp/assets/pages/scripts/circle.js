
var configData1 = [{
		"date": "一月",
		"distance": 227,
		"townName": "New York",
		"townName2": "New York",
		"townSize": 25,
		"latitude": 40.71,
		"duration": 408
	}, {
		"date": "二月",
		"distance": 371,
		"townName": "Washington",
		"townSize": 14,
		"latitude": 38.89,
		"duration": 482
	}, {
		"date": "三月",
		"distance": 433,
		"townName": "Wilmington",
		"townSize": 6,
		"latitude": 34.22,
		"duration": 562
	}, {
		"date": "四月",
		"distance": 345,
		"townName": "Jacksonville",
		"townSize": 7,
		"latitude": 30.35,
		"duration": 379
	}, {
		"date": "五月",
		"distance": 480,
		"townName": "Miami",
		"townName2": "Miami",
		"townSize": 10,
		"latitude": 25.83,
		"duration": 501
	}, {
		"date": "六月",
		"distance": 386,
		"townName": "Tallahassee",
		"townSize": 7,
		"latitude": 30.46,
		"duration": 443
	}, {
		"date": "七月",
		"distance": 348,
		"townName": "New Orleans",
		"townSize": 10,
		"latitude": 29.94,
		"duration": 405
	}, {
		"date": "八月",
		"distance": 238,
		"townName": "Houston",
		"townName2": "Houston",
		"townSize": 16,
		"latitude": 29.76,
		"duration": 309
	}, {
		"date": "九月",
		"distance": 218,
		"townName": "Dalas",
		"townSize": 17,
		"latitude": 32.8,
		"duration": 287
	}, {
		"date": "十月",
		"distance": 349,
		"townName": "Oklahoma City",
		"townSize": 11,
		"latitude": 35.49,
		"duration": 485
	}, {
		"date": "十一月",
		"distance": 603,
		"townName": "Kansas City",
		"townSize": 10,
		"latitude": 39.1,
		"duration": 890
	}, {
		"date": "十二月",
		"distance": 534,
		"townName": "Denver",
		"townName2": "Denver",
		"townSize": 18,
		"latitude": 39.74,
		"duration": 810
	}];


var configData2 = [{
		"date": "一月",
		"distance": 227,
		"townName": "New York",
		"townName2": "New York",
		"townSize": 25,
		"latitude": 40.71,
		"duration": 408
	}, {
		"date": "二月",
		"distance": 371,
		"townName": "Washington",
		"townSize": 14,
		"latitude": 38.89,
		"duration": 482
	}, {
		"date": "三月",
		"distance": 433,
		"townName": "Wilmington",
		"townSize": 6,
		"latitude": 34.22,
		"duration": 562
	}, {
		"date": "四月",
		"distance": 345,
		"townName": "Jacksonville",
		"townSize": 7,
		"latitude": 30.35,
		"duration": 379
	}, {
		"date": "五月",
		"distance": 480,
		"townName": "Miami",
		"townName2": "Miami",
		"townSize": 10,
		"latitude": 25.83,
		"duration": 501
	}, {
		"date": "六月",
		"distance": 386,
		"townName": "Tallahassee",
		"townSize": 7,
		"latitude": 30.46,
		"duration": 443
	}, {
		"date": "七月",
		"distance": 348,
		"townName": "New Orleans",
		"townSize": 10,
		"latitude": 29.94,
		"duration": 405
	}, {
		"date": "八月",
		"distance": 238,
		"townName": "Houston",
		"townName2": "Houston",
		"townSize": 16,
		"latitude": 29.76,
		"duration": 309
	}, {
		"date": "九月",
		"distance": 218,
		"townName": "Dalas",
		"townSize": 17,
		"latitude": 32.8,
		"duration": 287
	}, {
		"date": "十月",
		"distance": 349,
		"townName": "Oklahoma City",
		"townSize": 11,
		"latitude": 35.49,
		"duration": 485
	}, {
		"date": "十一月",
		"distance": 603,
		"townName": "Kansas City",
		"townSize": 10,
		"latitude": 39.1,
		"duration": 890
	}, {
		"date": "十二月",
		"distance": 534,
		"townName": "Denver",
		"townName2": "Denver",
		"townSize": 18,
		"latitude": 39.74,
		"duration": 810
	}];

var configData3 = [{
		"date": "2015年",
		"distance": 227,
		"townName": "New York",
		"townName2": "New York",
		"townSize": 25,
		"latitude": 40.71,
		"duration": 408
	}, {
		"date": "2016年",
		"distance": 371,
		"townName": "Washington",
		"townSize": 14,
		"latitude": 38.89,
		"duration": 482
	}];




var graph1 = [{
				"alphaField": "alpha",
				"balloonText": "[[value]] miles",
				"dashLengthField": "dashLength",
				"fillAlphas": 0.7,
				"legendValueText": "[[value]] mi",
				"title": "2015年",
				"type": "column",
				"valueField": "distance",
				"valueAxis": "distanceAxis"
			}, {
				"alphaField": "alpha",
				"balloonText": "[[value]] miles",
				"dashLengthField": "dashLength",
				"fillAlphas": 0.7,
				"legendValueText": "[[value]] mi",
				"title": "2016年",
				"type": "column",
				"valueField": "latitude",
				"valueAxis": "latitudeAxis"
			}];

var graph2 = [{
				"alphaField": "alpha",
				"balloonText": "[[value]] miles",
				"dashLengthField": "dashLength",
				"fillAlphas": 0.7,
				"legendValueText": "[[value]] mi",
				"type": "column",
				"valueField": "distance",
				"valueAxis": "distanceAxis"
			}];

var graph3 = [{
			"alphaField": "alpha",
			"balloonText": "[[value]] miles",
			"dashLengthField": "dashLength",
			"fillAlphas": 0.7,
			"legendValueText": "[[value]] mi",
			"type": "column",
			"valueField": "distance",
			"valueAxis": "distanceAxis"
		}];

var mySelectHandler = function(){
   $("#secondType").children("option").addClass("hidden");
   $("#myTypeSelect").change(function(){
	   var choice = $("#myTypeSelect").prop('selectedIndex'); 
	   $("#secondType").children("option").each(function(){
	   		if($(this).attr('data-ref') != choice)
	   		{
	   			$(this).addClass("hidden");
	   		}else{
	   			$(this).removeClass("hidden");
	   		}
	   });
	});
}

var initDateRangePicker = function()
{
	$('#date-picker').daterangepicker({
	    "opens": "left"
	}, function(start, end, label) {
	  console.log("New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')");
	});
}

var ChartsAmcharts = function() {

	var initChartSample1 = function(data, container, graphs) {
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
			"graphs": graphs,
			"chartCursor": {
				"categoryBalloonDateFormat": "DD",
				"cursorAlpha": 0.1,
				"cursorColor": "#000000",
				"fullWidth": true,
				"valueBalloonsEnabled": false,
				"zoomable": false
			},
			"dataDateFormat": "YYYY-MM-DD",
			"categoryField": "date",
			"categoryAxis": {
				"parseDates": false,
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

		draw: function(data,container, graphs) {
			initChartSample1(data,container, graphs);
		}

	};

}();

jQuery(document).ready(function() {
	mySelectHandler();
	initDateRangePicker();
	ChartsAmcharts.draw(configData1, "chart_1", graph1);
	ChartsAmcharts.draw(configData3, "chart_3", graph3);
	ChartsAmcharts.draw(configData2, "chart_2", graph2);
    $("#myButton").click(function(){
    	var choice = $(".queryType:checked").val();
    	if(choice!="")
    	{
    		if(choice == "byYear")
    		{
    			$("#chart_1").addClass("hidden");	
    			$("#chart_3").removeClass("hidden");	
    		}else{
    			$("#chart_3").addClass("hidden");	
    			$("#chart_1").removeClass("hidden");	
    		}
    	}
    });
});