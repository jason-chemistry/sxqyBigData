$(function() {

	//init();
	//左上角时间
	setInterval(getTime,1000);

	//十分钟获取今日数据
	getTodayData();
	setInterval(getTodayData,600000);


	//十分钟获取预约等信息
	getDrugMessage();
	setInterval(getDrugMessage,600000);

	//十分钟获取预约情况
	getDepartment();
	setInterval(getDepartment,600000);
	//获取一周门诊
	getWeekMzCount();

	lisAndCheck();
	setInterval(lisAndCheck,600000);


	getDataMap();
	setInterval(getDataMap,600000);
	// setInterval(setClock,1000)
});

//今日数据
function getTodayData() {

	$.ajax({
		url:'http://localhost:9090/TodayData',//地址
		dataType:'json',//数据类型
		type:'GET',//类型
		timeout:2000,//超时
		//请求成功
		success:function(data,status){
			$(".checkPeople").html(data.checkPeople);
			$(".zyPeople").html(data.zyPeople);
			$(".inPeople").html(data.inPeople);
			$(".mzPeople").html(data.mzPeople);
		},
		//失败/超时
		error:function(XMLHttpRequest,textStatus,errorThrown){

		}
	})


}

//各类药物信息
function getDrugMessage() {
	$.ajax({
		url:'http://localhost:9090/MZVisits/DrugMessage',//地址
		dataType:'json',//数据类型
		type:'GET',//类型
		timeout:2000,//超时
		//请求成功
		success:function(data,status){
			$(".YiQuYao").html(data.yiQuYao);
			$(".WeiQuYao").html(data.weiQuYao);
			$(".DaiShoufei").html(data.daiShoufei);
			$(".YyCount").html(data.yyCount);
		},
		//失败/超时
		error:function(XMLHttpRequest,textStatus,errorThrown){

		}
	})
}

//各科室预约人数
function  getDepartment() {
	var names=[];
	var nums=[];
	$.ajax({
		url:'http://localhost:9090/MZVisits',//地址
		dataType:'json',//数据类型
		type:'GET',//类型
		timeout:2000,//超时
		//请求成功
		success:function(data,status){
			for(var i=0;i<data.length;i++){
				names.push(data[i].name.replace(/\s+/g,""));    //挨个取出类别并填入类别数组
				nums.push(data[i].count);
			}
			var lineChart4 = echarts.init(document.getElementById('lineChart4'));
			lineChart4.setOption({

				grid: {
					left:120
				},

				xAxis: {
					type: 'value',

					axisLine: {
						lineStyle: {
							color: '#FFF'

						}
					},

				},

				yAxis: {
					type: "category",

					data:names,
					axisLabel: {
						textStyle: {
							//文字样式
							color: "#fff",
							fontSize: "12",

						},
						show:true,					//---是否显示
						inside:false,				//---是否朝内
						rotate:0,					//---旋转角度
						margin: 8,
					},
					// 控制网格线是否显示
					splitLine: {
						//  改变轴线颜色
						lineStyle: {
							color: "rgba(0,0,0,0)"
						}
					},

					axisLine: {
						//隐藏y轴线
						show: false
					},


				},

				series: [
					{
						itemStyle: {

							normal: {

								//好，这里就是重头戏了，定义一个list，然后根据所以取得不同的值，这样就实现了，

								color: function(params) {

									// build a color map as your need.

									var colorList = [

										'#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',

										'#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',

										'#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'

									];

									return colorList[params.dataIndex]

								},

								//以下为是否显示，显示位置和显示格式的设置了

								label: {

									show: true,

									position: 'right',


								}

							}

						},
						type: 'bar',
						data: nums,
					}
				]
			});
		},
		//失败/超时
		error:function(XMLHttpRequest,textStatus,errorThrown){

		}
	})
}

//一周门诊人数
function getWeekMzCount() {
	var day=[];
	var count=[];
	$.ajax({
		url:'http://localhost:9090/MZVisits/WeekCount',//地址
		dataType:'json',//数据类型
		type:'GET',//类型
		timeout:2000,//超时
		//请求成功
		success:function(data,status){
			for(var i=data.length-1;i>=0;i--){
				day.push(data[i].day.replace(/\s+/g,""));    //挨个取出类别并填入类别数组
				count.push(data[i].count.replace(/\s+/g,""));
			}

			var colors = ['#5793f3', '#d14a61', '#675bba'];
			var lineChart1 = echarts.init(document.getElementById('lineChart1'));
			lineChart1.setOption({
				color:  ['#5793f3', '#d14a61', '#675bba'],
				grid: {
					x:'12%',
					y:'20%',
					height:'65%'
				},

				xAxis: [
					{
						type: 'category',
						axisTick: {
							alignWithLabel: true

						},
						axisLine: {
							onZero: false,
							lineStyle: {
								color: '#fff'
							}
						},
						axisPointer: {

						},
						axisLabel: {
							textStyle: {
								//文字样式
								color: "#fff",
								fontSize: "10"

							},

							show:true,     //---是否显示
							inside:false,    //---是否朝内
							rotate:0,     //---旋转角度
							margin: 8
						},
						data: day
					}

				],
				yAxis: [
					{
						type: 'value',
						axisLine: {
							onZero: false,
							lineStyle: {
								color: '#fff'
							}
						},
						axisLabel: {
							textStyle: {
								//文字样式
								color: "#fff",
								fontSize: "12"

							},
							show:true,     //---是否显示
							inside:false,    //---是否朝内
							rotate:0,     //---旋转角度
							margin: 8
						}
					}
				],
				series: [

					{
						name: '一周就诊人数',
						type: 'line',
						smooth: true,
						itemStyle : {
							normal : {
								color:'#FFFF00', //改变折线点的颜色
								lineStyle:{
									color:'#FFFF00' //改变折线颜色
								},
								label : {show: true}
							}
						},
						data:  count
					}

				]
			})
		},
		//失败/超时
		error:function(XMLHttpRequest,textStatus,errorThrown){

		}
	})


}

//今日各时间点（就诊、收费、取药、检验、检查）折线图
function getDataMap() {
	let sfCount=[];
	let lisCount=[];
	let qyCount=[];
	let mzCount=[];


	$.ajax({
		url:'http://localhost:9090/dataMap',//地址
		dataType:'json',//数据类型
		type:'GET',//类型
		timeout:2000,//超时
		//请求成功
		success:function(data,status){
			console.log(data['SFCOUNT']);
			console.log(data['QYCOUNT']);
			var colors = ['#5793f3', '#d14a61', '#675bba'];
			var lineChart2 = echarts.init(document.getElementById('lineChart2'));
			lineChart2.setOption({
				color:['#4472C5','#ED7C30','#80FF80','#FF8096','#800080'],
				legend: {
					top: "10%",
					data: ['就诊', '收费', '取药', '检验'],
					textStyle:{//图例文字的样式
						color:'#fff',
						fontSize:14
					}
				},
				grid: {
					left: '3%',
					right: '4%',
					top:'16%',
					height: '70%',
					containLabel: true
				},

				xAxis: {
					type: 'category',
					boundaryGap: false,
					data: ['8:00', '9:00','10:00','11:00','12:00','13:00', '14:00', '15:00', '16:00','17:00'],
					axisLine: {
						onZero: false,
						lineStyle: {
							color: '#fff'
						}
					},
					axisPointer: {

					},
					axisLabel: {
						textStyle: {
							//文字样式
							color: "#fff",
							fontSize: "10"

						},

						show:true,     //---是否显示
						inside:false,    //---是否朝内
						rotate:0,     //---旋转角度
						margin: 8
					},
				},
				yAxis: {
					type: 'value',
					axisLine: {
						onZero: false,
						lineStyle: {
							color: '#fff'
						}
					},
					axisPointer: {

					},
					axisLabel: {
						textStyle: {
							//文字样式
							color: "#fff",
							fontSize: "10"

						},

						show:true,     //---是否显示
						inside:false,    //---是否朝内
						rotate:0,     //---旋转角度
						margin: 8
					},
				},
				series: [
					{
						name: '就诊',
						type: 'line',

						data: data['MZCOUNT']
					},
					{
						name: '收费',
						type: 'line',

						data: data['SFCOUNT']
					},
					{
						name: '取药',
						type: 'line',

						data:data['QYCOUNT']
					},
					{
						name: '检验',
						type: 'line',
						data:data['LISCOUNT']
					},

				]
			})
		},
		//失败/超时
		error:function(XMLHttpRequest,textStatus,errorThrown){

		}
	});






}

function lisAndCheck() {
	var day=[];
	var count=[];
	$.ajax({
		url:'http://localhost:9090/dataMap/CheckAndLis',//地址
		dataType:'json',//数据类型
		type:'GET',//类型
		timeout:2000,//超时
		//请求成功
		success:function(data,status){
			var lis=data[0];
			var check=data[1];
			var colors = ['#C1232B','#B5C334'];
			var lineChart3 = echarts.init(document.getElementById('lineChart3'));
			lineChart3.setOption({
				color:colors,
				legend: {
					top: "10%",
					orient: 'horizontal',
					left: 'center',
					data: ['检验人次', '检查人次'],
					textStyle:{//图例文字的样式
						color:'#fff',
						fontSize:13
					}
				},
				series: [
					{
						name: '访问来源',
						type: 'pie',
						radius: '55%',
						center: ['50%', '55%'],
						data: [
							{value: lis, name: '检验人次'},
							{value: check, name: '检查人次'},

						],
						emphasis: {
							itemStyle: {
								shadowBlur: 10,
								shadowOffsetX: 0,
								shadowColor: 'rgba(0, 0, 0, 0.5)'
							}
						}
					}
				]
			})
		},
		//失败/超时
		error:function(XMLHttpRequest,textStatus,errorThrown){

		}
	})

}

function setClock() {
	let date = new Date();
	let Hour=date.getHours().toString();
	let Min=date.getMinutes().toString();
	let Sec=date.getSeconds().toString();

	if(Hour=='14' && Min=='20' && Sec=='0'){
		//获取数据，并设置定时器

	}

}


//开始以后去查九次 每次到几点的时间，如果是0的话就去掉


//获取时间
function getTime() {
	var  date = new Date();

	var dateDay = date.getDay();

	var week;
	if(dateDay == 1){
		week= '星期一'
	} else if(dateDay == 2){
		week= '星期二'
	} else if(dateDay == 3){
		week= '星期三'
	} else if(dateDay == 4){
		week= '星期四'
	} else if(dateDay == 5){
		week= '星期五'
	} else if(dateDay == 6){
		week= '星期六'
	} else {
		week='星期日'
	}
	var time1=dateFormat("YYYY年mm月dd日 HH:MM:SS", date);
	var times=time1+" "+week;
	$(".time").html(times);
}
function dateFormat(fmt, date) {
	var ret;
	const opt = {
		"Y+": date.getFullYear().toString(),        // 年
		"m+": (date.getMonth() + 1).toString(),     // 月
		"d+": date.getDate().toString(),            // 日
		"H+": date.getHours().toString(),           // 时
		"M+": date.getMinutes().toString(),         // 分
		"S+": date.getSeconds().toString()          // 秒
		// 有其他格式化字符需求可以继续添加，必须转化成字符串
	};
	for (var k in opt) {
		ret = new RegExp("(" + k + ")").exec(fmt);
		if (ret) {
			fmt = fmt.replace(ret[1], (ret[1].length == 1) ? (opt[k]) : (opt[k].padStart(ret[1].length, "0")))
		}
	}
	return fmt;
}