<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@page isELIgnored="false" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
<script type="text/javascript">
    $(function () {
        $('#logTable').datagrid({
            toolbar: "#toolLog",
            fit: true,
            url: "${pageContext.request.contextPath}/log/showAllByPage",
            columns: [[
                {field: "logId", title: "日志编号", width: 260},
                {field: "adminName", title: "管理员姓名", width: 100},
                {field: "resource", title: "操作对象", width: 100},
                {field: "action", title: "操作类别", width: 110},
                {field: "message", title: "参数信息", width: 800},
                {field: "logDate", title: "操作时间", width: 180},
                {
                    field: "result", title: "轮播图状态", width: 140, styler: function (value, row, index) {
                        if (value == "error") {
                            return 'color:red';
                        }
                    }
                }
            ]],
            singleSelect: true,
            pagination: true,
            pageSize: 10,
            pageList: [10, 15, 20, 25, 30],
        });

        $("#reloadLog").linkbutton({
            onClick:function () {
                $('#logTable').datagrid("reload");
            }
        })

    });



</script>

<table id="logTable"></table>
<div id="toolLog">
    <a id="helpLog" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true,height:35">帮助</a>
    <a id="reloadLog" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true,height:35">刷新日志数据</a>
</div>
