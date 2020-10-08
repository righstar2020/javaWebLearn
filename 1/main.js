function login() {
    var strExp = /^[a-z0-9]+$/
    var userName = document.getElementById("userName").value;
    var password = document.getElementById("password").value;
    if (strExp.test(password)) {
        if (strExp.test(userName) && searchUserFromCookie(userName, password)) {
            window.location.replace("right.html")


        } else
            alert("账号或密码错误")
    } else
        alert("信息有误")

}

function toSign() {
    window.location.replace("sign.html")
}



function sign() {
    var strExp = /^[a-z0-9]+$/
    var userName = document.getElementById("userName").value;
    var password = document.getElementById("password").value;
    var repassword = document.getElementById("repassword").value;
    if (strExp.test(password) && strExp.test(repassword)) {
        if (strExp.test(userName)) {
            if (password == repassword) {
                addUserToCookie(userName, password);
                window.location.replace("right.html");
            } else if (password == null)
                alert("密码不能为空")
            else
                alert("密码不一致")



        } else
            alert("用户名格式错误")
    } else
        alert("信息有误")

}
//添加用户
function addUserToCookie(user, pwd) {
    setCookie(user, pwd, 10) //10天过期
}

//查询用户
function searchUserFromCookie(user, pwd) {
    if (getCookie(user) == pwd)
        return true;

}

//cookie增加和查找
function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toGMTString();
    var str = cname + "=" + cvalue + "; " + expires + ';path=/;';
    document.cookie = str;

    console.log("cookie增加成功:" + str)
}
//查找
function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    if (ca[0] == "") alert("浏览器不支持cookie")
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i].trim();
        if (c.indexOf(name) == 0) return c.substring(name.length, c.length);

    }
    return "";
}



//封装get
function doGet(url, fun = null) {
    var httpRequest = new XMLHttpRequest(); //第一步：建立所需的对象
    httpRequest.setRequestHeader("Access-Control-Allow-Origin:", "*");
    httpRequest.open('GET', url, true); //第二步：打开连接  将请求参数写在url中  ps:"./Ptest.php?name=test&nameone=testone"
    httpRequest.send(); //第三步：发送请求  将请求参数写在URL中
    /**
     * 获取数据后的处理程序
     */
    httpRequest.onreadystatechange = function() {
        if (httpRequest.readyState == 4 && httpRequest.status == 200) {
            var json = httpRequest.responseText; //获取到json字符串，还需解析
            console.log(json);
            fun(json); //异步调用返回函数
        }
    };
}

//封装POST
function doPost(url, fun = null) {
    var httpRequest = new XMLHttpRequest(); //第一步：创建需要的对象
    httpRequest.open('POST', url, true); //第二步：打开连接
    httpRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); //设置请求头 注：post方式必须设置请求头（在建立连接后设置请求头）
    httpRequest.send('name=teswe&ee=ef'); //发送请求 将情头体写在send中
    /**
     * 获取数据后的处理程序
     */
    httpRequest.onreadystatechange = function() { //请求后的回调接口，可将请求成功后要执行的程序写在其中
        if (httpRequest.readyState == 4 && httpRequest.status == 200) { //验证请求是否发送成功
            var json = httpRequest.responseText; //获取到服务端返回的数据
            console.log(json);
            fun(json) //调用返回函数
        }
    };
}














//日期格式化
function dateFormat(fmt, date) {
    let ret;
    const opt = {
        "Y+": date.getFullYear().toString(), // 年
        "m+": (date.getMonth() + 1).toString(), // 月
        "d+": date.getDate().toString(), // 日
        "H+": date.getHours().toString(), // 时
        "M+": date.getMinutes().toString(), // 分
        "S+": date.getSeconds().toString() // 秒
            // 有其他格式化字符需求可以继续添加，必须转化成字符串
    };
    for (let k in opt) {
        ret = new RegExp("(" + k + ")").exec(fmt);
        if (ret) {
            fmt = fmt.replace(ret[1], (ret[1].length == 1) ? (opt[k]) : (opt[k].padStart(ret[1].length, "0")))
        };
    };
    return fmt;
}