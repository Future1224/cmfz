<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@page isELIgnored="false" %>

<script type="text/javascript">
    $(function () {
            $("#guruName").textbox({
                width : 250,
                height : 25,
                required : true,
            });


            $("#guruIntro").textbox({
                width : 250,
                height : 100,
                multiline:true,
                required : true,
            });

        $('#guruPhoto').filebox({
            width : 250,
            height : 25,
            required : true,
            buttonText: '选择头像',
            buttonAlign: 'right',
            buttonIcon:"icon-add",
            accept:"image/*"

        })

    });

	
</script>


    <form method="post" action="" id="addGuruForm" enctype="multipart/form-data">
        <table align="center">
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr>
                <td>上师法名:</td>
                <td><input id="guruName" name="guruName"></td>
            </tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr>
                <td>上师简介:</td>
                <td><input id="guruIntro" name="guruIntro"></td>
            </tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr>
                <td>上传轮播图:</td>
                <td><input id="guruPhoto" name="guruPhotoFile"></td>
            </tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr align="center">
                <td colspan="2">
                    <a id="enAddGuruForm">保存</a> &nbsp;&nbsp; <a id="unAddGuruForm">取消</a>
                </td>
            </tr>
        </table>





    </form>