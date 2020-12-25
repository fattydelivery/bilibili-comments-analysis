<%--
  Created by IntelliJ IDEA.
  User: Lannaie
  Date: 2020/12/25
  Time: 1:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html style="height: 100%">
<head>
    <meta charset="utf-8" http-equiv="refresh" content="10">
</head>
<body style="height: 100%; margin: 0" onload="second()">
<div id="container" style="height: 100%"></div>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts@4/dist/echarts.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts-gl@1/dist/echarts-gl.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts-stat@1/dist/ecStat.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts@4/dist/extension/dataTool.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts@4/map/js/china.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts@4/map/js/world.js"></script>
<script type="text/javascript" src="https://api.map.baidu.com/api?v=2.0&ak=PXCobsIpdChz8kcGWRFpzGufWt7hFHqi"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts@4/dist/extension/bmap.min.js"></script>
<script type="text/javascript">

    function second() {
        //1. 创建XMLHttpRequest对象
        xhr = new XMLHttpRequest();
        //2. 和服务器建立连接
        xhr.open("get", "HeatMapString", true);
        //3. 执行回调函数
        xhr.onreadystatechange = process;
        //4. 发送数据
        xhr.send(null);
    }

    function process() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var text = xhr.responseText;
            var s = text.split(",");
            var hours = s[0].split(" ");
            var index3 = s[1].split(" ");

            var dom = document.getElementById("container");
            var myChart = echarts.init(dom);
            var app = {};
            option = null;
            var days = [''];
            var data = new Array()
            for (var j = 0; j < index3.length; j++) {
                var m = Math.round(parseInt(index3[j])/100);
                data[j] = [0, j, m];
            }c
            data = data.map(function (item) {
                var n = item[2] || '-';
                return [item[1], item[0], n];
            });

            option = {
                tooltip: {
                    position: 'top'
                },
                animation: false,
                grid: {
                    height: '30%',
                    top: '15%'
                },
                xAxis: {
                    type: 'category',
                    data: hours,
                    splitArea: {
                        show: true
                    }
                },
                yAxis: {
                    type: 'category',
                    data: days,
                    splitArea: {
                        show: true
                    }
                },
                visualMap: {
                    min: 0,
                    max: 10,
                    calculable: true,
                    orient: 'horizontal',
                    left: 'center',
                    bottom: '25%'
                },
                series: [{
                    name: 'Punch Card',
                    type: 'heatmap',
                    data: data,
                    label: {
                        show: true
                    },
                    emphasis: {
                        itemStyle: {
                            shadowBlur: 10,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }]
            };
            if (option && typeof option === "object") {
                myChart.setOption(option, true);
            }
        }
        // else {
        //     alert("不可用")
        // }
    }
</script>
</body>
</html>
