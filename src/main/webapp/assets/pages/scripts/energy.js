jQuery(document).ready(function() {
	var fxjl_bar = echarts.init(document.getElementById("fxjl_bar"));
	var bgcz_bar = echarts.init(document.getElementById("bgcz_bar"));
	var ktnh_bar = echarts.init(document.getElementById("ktnh_bar"));
	var qtnh_bar = echarts.init(document.getElementById("qtnh_bar"));

	var option = {
		tooltip: {
			trigger: "axis"
		},
		legend: {
			selected: {
				"房间A": true
			},
			data: ["房间A", "房间B", "房间C", "房间D"]
		},
		toolbox: {
			show: !0,
			feature: {
				restore: {
					show: !0
				},
				saveAsImage: {
					show: !0
				}
			}
		},
		calculable: !0,
		xAxis: [{
			type: "category",
			data: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"]
		}],
		yAxis: [{
			type: "value",
			splitArea: {
				show: !0
			}
		}],
		series: [{
			name: "房间A",
			type: "bar",
			data: [2, 4.9, 7, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20, 6.4, 3.3]
		}, {
			name: "房间B",
			type: "bar",
			data: [2, 4.9, 7, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20, 6.4, 3.3]
		}, {
			name: "房间C",
			type: "bar",
			data: [2, 4.9, 7, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20, 6.4, 3.3]
		}, {
			name: "房间D",
			type: "bar",
			data: [2.6, 5.9, 9, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6, 2.3]
		}]
	};
	fxjl_bar.setOption(option);
	bgcz_bar.setOption(option);
	ktnh_bar.setOption(option);
	qtnh_bar.setOption(option);

	function changeState(handler, option, mySelectSeries, state) {
		option.legend.selected[mySelectSeries] = state;
		handler.setOption(option, true);
		handler.restore();
	}

	$('.make-switch').on('switchChange.bootstrapSwitch', function(event, state) {
		var owner = $(this).attr('owner');
		var mySelectSeries = $(this).parent().parent().prev().text();
		var myOption;
		switch (owner) {
			case 'fxjl_bar':
				myOption = fxjl_bar.getOption();
				changeState(fxjl_bar, myOption, mySelectSeries, state);
				break;
			case 'bgcz_bar':
				myOption = bgcz_bar.getOption();
				changeState(bgcz_bar, myOption, mySelectSeries, state);
				break;
			case 'ktnh_bar':
				myOption = bgcz_bar.getOption();
				changeState(bgcz_bar, myOption, mySelectSeries, state);
				break;
			case 'qtnh_bar':
				myOption = qtnh_bar.getOption();
				changeState(qtnh_bar, myOption, mySelectSeries, state);
				break;
		}

	});

});