<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
<script type="text/javascript">
    $(function () {
        $('#guruTable').datagrid({
            toolbar: "#toolGuru",
            fit: true,
            url: "${pageContext.request.contextPath}/guru/showAll",
            columns: [[
                {field: "guruId", title: "上师编号", width: 387},
                {field: "guruPhoto", title: "头像路径", width: 387},
                {field: "guruName", title: "上师法名", width: 387},
                {field: "guruIntro", title: "上师简介", width: 387,hidden:true},
                //判断是否拥有修改的权限
                <shiro:hasPermission name="guru:modify">
                {
                    field: "hhh", title: "操作", width: 387, formatter: function (value, row, index) {
                        return "<a id=\"" + row.guruId + "\" name=\"changeGuru\" onclick=\"modifyGuru(this)\">修改</a>";
                    }
                }
                </shiro:hasPermission>
            ]],
            singleSelect: true,
            pagination: true,
            pageSize: 10,
            pageList: [10, 15, 20, 25, 30],
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return "<table>\n" +
                    "    <tr>\n" +
                    "        <td rowspan=2 style=\"border:0\">\n" +
                    "            <img src=\"${pageContext.request.contextPath}/upload/guruPhoto/"+rowData.guruPhoto+"\" style=\"height:100px;width:120px;\"/>\n" +
                    "        </td>\n" +
                    "        <td style=\"border:0\">\n" +
                    "            <p>上师法名: "+rowData.guruName+"</p>\n" +
                    "            <p>上师简介: "+rowData.guruIntro+"</p>\n" +
                    "        </td>\n" +
                    "    </tr>\n" +
                    "</table>";
            },
            onLoadSuccess: function (data) {

                $("a[name='changeGuru']").linkbutton({
                    iconCls: "icon-edit",
                })
            }
        });

        $("#guruLike").searchbox({
            searcher: function (value, name) {
                $("#guruTable").datagrid({
                    queryParams: {
                        like: value,
                    },
                    url: "${pageContext.request.contextPath}/guru/"+name,
                });
            },
            menu: "#mm",
            prompt: "请输入搜索内容",
            width: 240,
            height: 35
        });


        $("#exportGuru").linkbutton({
            onClick : function () {
                window.location.href="${pageContext.request.contextPath}/guru/exportGuru";
            }
        })


        $("#addGuru").linkbutton({
            onClick: function () {
                $("#addGuruDialog").dialog({
                    title: "添加上师信息",
                    width: 450,
                    height: 320,
                    collapsible: true,
                    minimizable: true,
                    maximizable: true,
                    resizable: true,
                    closed: false,
                    cache: false,
                    href: "${pageContext.request.contextPath}/main/addGuru.jsp",
                    modal: true,
                    onLoad: function () {

                        $("#enAddGuruForm").linkbutton({
                            iconCls: "icon-add",
                            onClick: function () {
                                $("#addGuruForm").form("submit", {
                                    novalidate: true,
                                    url: "${pageContext.request.contextPath}/guru/addGuru",
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
                                            $("#guruTable").datagrid("reload");
                                            $("#addGuruDialog").dialog("close");
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
                        $("#unAddGuruForm").linkbutton({
                            iconCls: "icon-add",
                            onClick: function () {
                                $("#addGuruDialog").dialog("close");
                            }
                        });
                    },
                });
            },
        });













        $("#addBulkGuru").linkbutton({
            onClick: function () {
                $("#addBulkGuruDialog").dialog({
                    title: "添加上师信息",
                    width: 450,
                    height: 200,
                    collapsible: true,
                    minimizable: true,
                    maximizable: true,
                    resizable: true,
                    closed: false,
                    cache: false,
                    href: "${pageContext.request.contextPath}/main/addBulkGuru.jsp",
                    modal: true,
                    onLoad: function () {

                        $("#enAddBulkGuruForm").linkbutton({
                            iconCls: "icon-add",
                            onClick: function () {
                                $("#addBulkGuruForm").form("submit", {
                                    novalidate: true,
                                    url: "${pageContext.request.contextPath}/guru/addBulkGuru",
                                    onSubmit: function () {
                                    },
                                    success: function (res) {
                                        var re = JSON.parse(res);
                                        if (re) {
                                            $.messager.show({
                                                title: '我的消息',
                                                msg: '批量添加成功,消息将在5秒后关闭。',
                                                timeout: 5000,
                                                showType: 'slide'
                                            });
                                            $("#guruTable").datagrid("reload");
                                            $("#addBulkGuruDialog").dialog("close");
                                        } else {
                                            $.messager.show({
                                                title: '我的消息',
                                                msg: '批量添加失败,消息将在5秒后关闭。',
                                                timeout: 5000,
                                                showType: 'slide'
                                            });
                                        }
                                    }
                                });
                            }
                        });
                        $("#unAddBulkGuruForm").linkbutton({
                            iconCls: "icon-add",
                            onClick: function () {
                                $("#addBulkGuruDialog").dialog("close");
                            }
                        });
                    },
                });
            },
        });









    });

    function modifyGuru(res) {

        $("#modifyGuruDialog").dialog({
            title: "修改轮播图信息",
            width: 450,
            height: 320,
            collapsible: true,
            minimizable: true,
            maximizable: true,
            resizable: true,
            closed: false,
            cache: false,
            href: "${pageContext.request.contextPath}/main/modifyGuru.jsp",
            modal: true,
            onLoad: function () {
                $.post("${pageContext.request.contextPath}/guru/showById", "guruId=" + res.id, function (resp) {
                    console.log(resp)
                    $("#modifyGuruForm").form("load", resp);
                });
                $("#enModifyGuruForm").linkbutton({
                    iconCls: "icon-add",
                    onClick: function () {
                        $("#modifyGuruForm").form("submit", {
                            novalidate: true,
                            url: "${pageContext.request.contextPath}/guru/modifyGuru",
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
                                    $("#guruTable").datagrid("reload");
                                    $("#modifyGuruDialog").dialog("close");
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

<table id="guruTable"></table>
<div id="toolGuru">
    <%--判断是否拥有添加上师的权限--%>
    <shiro:hasPermission name="guru:add">
        <a id="addGuru" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,height:35">添加上师</a>&nbsp;&nbsp;
    </shiro:hasPermission>
    <a id="helpGuru" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true,height:35">帮助</a>&nbsp;&nbsp;
    <input id="guruLike" />
    <div id="mm" style="width:120px">
        <div data-options="name:'showLikeName',iconCls:'icon-ok'">上师法名</div>
    </div>&nbsp;&nbsp;
    <a id="exportGuru" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,height:35" >导出上师</a>&nbsp;&nbsp;

        <%--判断是否是root角色登录--%>
    <shiro:hasRole name="root">
    <a id="addBulkGuru" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,height:35" >批量添加上师</a>&nbsp;&nbsp;
    </shiro:hasRole>

</div>
<div id="addGuruDialog"></div>
<div id="modifyGuruDialog"></div>
<div id="addBulkGuruDialog"></div>



