<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@page isELIgnored="false" %>

<script type="text/javascript">
    $(function () {
            $("#pictureName").textbox({
                width : 250,
                height : 25,
                required : true,
            });


        $("#bannerLink").textbox({
            width : 250,
            height : 25,
            required : true,
        });
        $("#pictureStatus").combobox({
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
        $('#picturePath').filebox({
            width : 250,
            height : 25,
            required : true,
            buttonText: '选择图片',
            buttonAlign: 'right',
            buttonIcon:"icon-add",
            accept:"image/*"

        })

    });

	
</script>


    <form method="post" action="" id="addPictureForm" enctype="multipart/form-data">
        <table align="center">
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr>
                <td>轮播图描述:</td>
                <td><input id="pictureName" name="pictureName"></td>
            </tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr>
                <td>图片跳转路径:</td>
                <td><input id="bannerLink" name="bannerLink"></td>
            </tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr>
                <td>轮播图状态:</td>
                <td>
                    <input id="pictureStatus" name="pictureStatus">
                </td>
            </tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr>
                <td>上传轮播图:</td>
                <td><input id="picturePath" name="pictureFile"></td>
            </tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr align="center">
                <td colspan="2">
                    <a id="enAddPictureForm">保存</a> &nbsp;&nbsp; <a id="unAddPictureForm">取消</a>
                </td>
            </tr>
        </table>





    </form>