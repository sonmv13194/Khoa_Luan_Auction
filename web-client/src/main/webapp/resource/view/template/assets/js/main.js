///**
// * 
// */
//    $(document).ready(function () {
//        $('#loading').click(function () {
//            $.ajax({
//                type: 'POST',
//                contentType: 'application/json;charset=utf-8',
//                url: '/productAll',
//                dataType: 'json',
//                success: function (data) {
//                    alert(data);
////                    //lay 1 mang nhieu doi tuong
////                    $.each(data,function(key,value)
////                    {
////                        $(#result).append('<p>'+key+'Gia Tri :'+value.properties+'</br>');
////                    });
//
//                }
//            });
//        });
//    });
// 
//    $(function () {
//        $("#register-form").validate({
//
//            rules: {
//                // username: "required",
//                address: "required",
//                phone: {
//                    required: true,
//                    // pattern: true
//                },
//                birthday: {
//                    required: true
//                },
//                email: {
//                    required: true,
//                    email: true
//                },
//                password: {
//                    required: true,
//                    minlength: 5,
//                    maxlength: 20
//                },
//                confirm_password: {
//                    required: true,
//                    equalTo: "#password",
//                }
//            },
//
//            // Specify the validation error messages
//            messages: {
//                //  username: "Please enter your username",
//                address: "Please enter your address",
//                birthday: "Please enter your birthay",
//                phone: {
//                    required: "Please provide a phone",
//                    //  pattern:"\d{3}[\-]\d{3}[\-]\d{4}"
//                },
//                password: {
//                    required: "Please provide a password",
//                    minlength: "Your password must be at least 5 characters long",
//                    maxlength: "Your password must be at least than 20 characters long"
//                },
//                confirm_password: {
//                    required: "Please confirm password !"
//                },
//                email: "Please enter a valid email address",
//            },
//            submitHandler: function (form) {
//                form.submit();
//            }
//        });
//
//    });
//
//
//    //validate username is exits.
//    var username = $('#username').val();
//    $('#username').change(function () {
//        $.ajax({
//            url: "signin.jsp",
//            type: 'POST',
//            data: 'username=' + username,
//            success: function (result) {
//                if (result > 0) {
//                    // do something if username already exist
//                    //show that the username is available
//                    $('#username_availability_result').html(username + ' is not Available');
//                }
//                else {
//                    // do something if username doesn't exist
//                    //show that the username is NOT available
//
//                    $('#username_availability_result').html(username + ' is Available');
//                }
//            }
//        });
//    });