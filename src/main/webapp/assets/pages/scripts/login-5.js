var Login = function() {


    var ajaxSubmit = function submitCheck(){
        $('.alert-danger', $('.login-form')).hide();
        var username=$("#username").val();
        var password=$("#password").val();
        var verifyCode=$("#verifyCode").val();
        var data={username:username,password:password,verifyCode:verifyCode};
        var url="/system/login";
        $.ajax({
            type: "POST",
            url: url,
            data: data,
            // contentType: "application/json",
            dataType: "json",
            success:function (result) {
                if(result.success){
                    location.href="/main/admin/index";
                }else{
                    $(".alert-danger").find("span").text(result.module);
                    $('.alert-danger', $('.login-form')).show();
                    console.log("error"+result.module);
                    $("#verify").attr("src","/code/captcha-image?timestamp="+new Date().getTime());  // 刷新验证码
                    $("#verifyCode").val("");
                }
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){
                alert('读取超时，请检查网络连接');
            }
        });
        return false;
    };

    var handleLogin = function() {

        $('.login-form').validate({
            focusInvalid: false, // do not focus the last invalid input
            rules: {
                username: {
                    required: true
                },
                password: {
                    required: true
                },
                verifyCode: {
                    required: true
                }
            },

            messages: {
                username: {
                    required: "用户名不能为空."
                },
                password: {
                    required: "密码不能为空."
                },
                verifyCode:{
                    required: "验证码不能为空."
                }
            },

            /*  invalidHandler: function(event, validator) { //display error alert on form submit
             $('.alert-danger', $('.login-form')).show();
             },*/
            highlight: function(element) { // hightlight error inputs
                $(element)
                    .closest('.form-control').addClass('has-error'); // set error class to the control group
            },

            success: function(label) {
                label.prev('.form-control').removeClass('has-error');
                label.remove();
            },

            errorPlacement: function(error, element) {
                error.insertAfter(element.closest('.form-control'));
            },

            submitHandler: function(form) {

                ajaxSubmit();

                //form.submit(); // form validation success, call ajax form submit
            }
        });

        $('.login-form input').keypress(function(e) {
            if (e.which == 13) {
                if ($('.login-form').validate().form()) {
                    //$('.login-form').submit(); //form validation success, call ajax form submit
                }
                return false;
            }
        });

        $("#verify").click(function(){
            $(this).attr("src","/code/captcha-image?timestamp="+new Date().getTime());
        });
    }




    return {
        //main function to initiate the module
        init: function() {

            handleLogin();

            // init background slide images
            $('.login-bg').backstretch([
                    "../assets/pages/img/login/bg1.jpg",
                    "../assets/pages/img/login/bg2.jpg",
                    "../assets/pages/img/login/bg3.jpg"
                ], {
                    fade: 1000,
                    duration: 8000
                }
            );


        }

    };

}();

jQuery(document).ready(function() {
    Login.init();
});