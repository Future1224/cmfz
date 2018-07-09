<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@page isELIgnored="false" %>

<script type="text/javascript">
    $(function () {
            $("#pictureName1").textbox({
                width : 250,
                height : 25,
                required : true,
            });


        $("#bannerLink1").textbox({
            width : 250,
            height : 25,
            required : true,
        });
        $("#pictureStatus1").combobox({
            width : 250,
            height : 25,
            panelHeight: 50,
            editable:false,
            required : true,
            value:"未展示",
            valueField: 'label',
            textField: 'value',
            data: [{
                label: '展示中',
                value: '展示'
            },{
                label: '未展示',
                value: '不展示'
            }],
        });

    });

	
</script>


    <form method="post" action="" id="modifyPictureForm" enctype="multipart/form-data">
        <table align="center">
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr>
                <td>轮播图描述:</td>
                <td><input id="pictureName1" name="pictureName"></td>
            </tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr>
                <td>图片跳转路径:</td>
                <td><input id="bannerLink1" name="bannerLink"></td>
            </tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr>
                <td>轮播图状态:</td>
                <td>
                    <input id="pictureStatus1" name="pictureStatus">
                </td>
            </tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr>
                <td><input id="picturePath1" name="picturePath" hidden="ture"></td>
                <td><input id="pictureDate1" name="pictureDate" hidden="ture"></td>
                <td><input id="pictureId1" name="pictureId" hidden="ture"></td>
            </tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr align="center">
                <td colspan="2">
                    <a id="enModifyPictureForm">修改</a>  &nbsp;&nbsp;<a id="unModifyPictureForm">取消</a>
                </td>
            </tr>
        </table>





    </form>