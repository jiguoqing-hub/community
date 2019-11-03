$(document).ready(function () {
    $('#publishForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            title: {
                validators: {
                    notEmpty: {
                        message: '标题不能为空'
                    },
                    stringLength: {
                        max: 25,
                        message: '标题不得超过25个字'
                    },
                }
            },
            description: {
                validators: {
                    notEmpty: {
                        message: '标题补充不能为空'
                    },
                }
            },
            tag: {
                validators: {
                    notEmpty: {
                        message: '标签不能为空'
                    },
                }
            }
        }
    });
$("#addQuestion").click(function () {
    //进行表单验证
    var flag = $('#publishForm').data('bootstrapValidator').isValid();
    if (flag) {
        //发送ajax请求
        $.ajax({
            url: '/publish',
            async: false,//同步，会阻塞操作
            type: 'POST',//PUT DELETE POST
            data: $('#publishForm').serialize(),
            dataType : "json",
            success: function (result) {
                if (result.code == 200 ) {
                    alert("发布成功！");
                } else {
                    alert("发布失败！");
                }
            }, error: function () {
                alert("发布失败！");
            }
        })
      }
   });
});

