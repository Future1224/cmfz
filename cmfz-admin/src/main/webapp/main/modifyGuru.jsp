<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@page isELIgnored="false" %>

<script type="text/javascript">
    $(function () {
            $("#guruName1").textbox({
                width : 250,
                height : 25,
                required : true,
            });


            $("#guruIntro1").textbox({
                width : 250,
                height : 100,
                multiline:true,
                required : true,
            });

        $('#guruPhoto1').filebox({
            width : 250,
            height : 25,
            buttonText: '选择头像',
            buttonAlign: 'right',
            buttonIcon:"icon-add",
            accept:"image/*"

        })

    });

	
</script>


    <form method="post" action="" id="modifyGuruForm" enctype="multipart/form-data">
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
                <td>
                    <input id="guruName1" name="guruName">
                    <input id="guruId1" name="guruId" hidden="true">
                </td>
            </tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr>
                <td>上师简介:</td>
                <td><input id="guruIntro1" name="guruIntro"></td>
            </tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr>
                <td>上传轮播图:</td>
                <td><input id="guruPhoto1" name="guruPhotoFile"></td>
            </tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr align="center">
                <td colspan="2">
                    <a id="enModifyGuruForm">保存</a> &nbsp;&nbsp; <a id="unModifyGuruForm">取消</a>
                </td>
            </tr>
        </table>





    </form>