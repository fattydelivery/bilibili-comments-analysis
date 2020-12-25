<%--
  Created by IntelliJ IDEA.
  User: Lannaie
  Date: 2020/12/24
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>getWordCloud</title>
    <base href="<%=request.getContextPath()+"/"%>"/>
    <script src='https://cdn.bootcss.com/echarts/3.7.0/echarts.simple.js'></script>
    <script src='./echarts-wordcloud.js'></script>
    <script src='./json2.js'></script>
</head>
<body onload="first()">
<style>
    html, body, #main {
        width: 100%;
        height: 100%;
        margin: 0;
    }

</style>
<div id="main"></div>
<script type="text/javascript">
    function first() {
        //发送ajax请求
        //1. 创建XMLHttpRequest对象
        xhr = new XMLHttpRequest();
        //2. 和服务器建立连接
        xhr.open("get", "WordCloudString", true);
        //3. 执行回调函数
        xhr.onreadystatechange = process;
        //4. 发送数据
        xhr.send(null);
    }
    function process() {
        if(xhr.readyState==4&&xhr.status==200){
            var text = xhr.responseText;
            console.log("text:")
            console.log(text)
            var obj = JSON.parse(text);
            // var obj = JSON.parse('[{"name": "Lewis Hamilton","value": 555},{"name": "KXAN","value": 550},{"name": "Mary Ellen Mark","value": 462}]');
            for(var i=0; i<obj.length; i++){
                console.log(obj[i])
            }
            var chart = echarts.init(document.getElementById('main'));

            var option = {
                tooltip: {},
                series: [ {
                    type: 'wordCloud',
                    gridSize: 2,
                    sizeRange: [12, 50],
                    rotationRange: [-90, 90],
                    shape: 'pentagon',
                    width: 600,
                    height: 400,
                    drawOutOfBound: true,
                    textStyle: {
                        normal: {
                            color: function () {
                                return 'rgb(' + [
                                    Math.round(Math.random() * 160),
                                    Math.round(Math.random() * 160),
                                    Math.round(Math.random() * 160)
                                ].join(',') + ')';
                            }
                        },
                        emphasis: {
                            shadowBlur: 10,
                            shadowColor: '#333'
                        }
                    },
                    data:obj
                } ]
            };

            chart.setOption(option);

            window.onresize = chart.resize;
        }
        // else{
        //     alert("无法使用")
        // }
    }
</script>
<%--<button onclick="first()">请点击</button>--%>
</body>
</html>
