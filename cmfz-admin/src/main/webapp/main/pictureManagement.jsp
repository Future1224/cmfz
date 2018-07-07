<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@page isELIgnored="false" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
<script type="text/javascript">
    $(function () {
        $('#picTable').datagrid({
            toolbar: "#tool",
            fit: true,
            url: "${pageContext.request.contextPath}/picture/showAll",
            columns: [[
                {field: "pictureId", title: "图片编号", width: 260},
                {field: "picturePath", title: "图片路径", width: 260},
                {field: "bannerLink", title: "跳转路径", width: 220},
                {field: "pictureName", title: "图片名字", width: 220},
                {
                    field: "pictureStatus", title: "轮播图状态", width: 140, styler: function (value, row, index) {
                        if (value == "展示中") {
                            return 'color:red';
                        }
                    }
                },
                {field: "pictureDate", title: "轮播图创建时间", width: 215},
                {
                    field: "hhh", title: "操作", width: 200, formatter: function (value, row, index) {
                        return "<a id=\"" + row.pictureId + "\" name=\"changePicture\" onclick=\"modifyPicture(this)\">修改</a>";
                    }
                }
            ]],
            singleSelect: true,
            pagination: true,
            pageSize: 10,
            pageList: [10, 15, 20, 25, 30],
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return "<img src=\"${pageContext.request.contextPath}/upload/picture/" + rowData.picturePath + "\" style=\"height:100px;width:120px;\"/>"
            },
            onLoadSuccess: function (data) {

                $("a[name='changePicture']").linkbutton({
                    iconCls: "icon-edit",
                })
            }

        });

        $("#addPicture").linkbutton({
            onClick: function () {
                $("#addPictureDialog").dialog({
                    title: "新增轮播图",
                    width: 450,
                    height: 270,
                    collapsible: true,
                    minimizable: true,
                    maximizable: true,
                    resizable: true,
                    closed: false,
                    cache: false,
                    href: "${pageContext.request.contextPath}/main/addPicture.jsp",
                    modal: true,
                    onLoad: function () {

                        $("#enAddPictureForm").linkbutton({
                            iconCls: "icon-add",
                            onClick: function () {
                                $("#addPictureForm").form("submit", {
                                    novalidate: true,
                                    url: "${pageContext.request.contextPath}/picture/uploadPicture",
                                    onSubmit: function () {
                                    },
                                    success: function (res) {
                                        var re = JSON.parse(res);
                                        if (re) {
                                            $.messager.show({
                                                title: '我的消息',
                                                msg: '添加成功,消息将在5秒后关闭。',
                                                timeout: 5000,
                                                showType: 'slide'
                                            });
                                            $("#picTable").datagrid("reload");
                                            $("#addPictureDialog").dialog("close");
                                        } else {
                                            $.messager.show({
                                                title: '我的消息',
                                                msg: '添加失败,消息将在5秒后关闭。',
                                                timeout: 5000,
                                                showType: 'slide'
                                            });
                                        }
                                    }
                                });
                            }
                        });


                        $("#unAddPictureForm").linkbutton({
                            iconCls: "icon-add",
                            onClick: function () {
                                $("#addPictureDialog").dialog("close");
                            }
                        });
                    },
                });
            },
        });


    });

    function modifyPicture(res) {

        $("#modifyPictureDialog").dialog({
            title: "修改轮播图信息",
            width: 450,
            height: 270,
            collapsible: true,
            minimizable: true,
            maximizable: true,
            resizable: true,
            closed: false,
            cache: false,
            href: "${pageContext.request.contextPath}/main/modifyPicture.jsp",
            modal: true,
            onLoad: function () {
                $.post("${pageContext.request.contextPath}/picture/showById", "pictureId=" + res.id, function (resp) {
                    console.log(resp)
                    $("#modifyPictureForm").form("load", resp);
                });
                $("#enModifyPictureForm").linkbutton({
                    iconCls: "icon-add",
                    onClick: function () {
                        $("#modifyPictureForm").form("submit", {
                            novalidate: true,
                            url: "${pageContext.request.contextPath}/picture/modifyPicture",
                            onSubmit: function () {
                            },
                            success: function (res) {
                                var re = JSON.parse(res);
                                if (re) {
                                    $.messager.show({
                                        title: '我的消息',
                                        msg: '修改成功,消息将在5秒后关闭。',
                                        timeout: 5000,
                                        showType: 'slide'
                                    });
                                    $("#picTable").datagrid("reload");
                                    $("#modifyPictureDialog").dialog("close");
                                } else {
                                    $.messager.show({
                                        title: '我的消息',
                                        msg: '修改失败,消息将在5秒后关闭。',
                                        timeout: 5000,
                                        showType: 'slide'
                                    });
                                }
                            }
                        });
                    }
                });
                $("#unModifyPictureForm").linkbutton({
                    iconCls: "icon-add",
                    onClick: function () {
                        $("#modifyPictureDialog").dialog("close");
                    }
                });
            }
        });
    }


</script>

<table id="picTable"></table>
<div id="tool">
    <a id="addPicture" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,height:35">新增轮播图</a>
    <a id="help" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true,height:35">帮助</a>
</div>
<div id="addPictureDialog"></div>
<div id="modifyPictureDialog"></div>