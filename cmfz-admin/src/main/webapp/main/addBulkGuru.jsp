<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@page isELIgnored="false" %>

<script type="text/javascript">
    $(function () {
        $("#guruExeclFile").filebox({
            width: 250,
            height: 25,
            required : true,
            buttonText: '选择Excel',
            buttonAlign: 'right',
            buttonIcon:"icon-add",
            accept:"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel"
        });

    });

	
</script>


    <form method="post" action="" id="addBulkGuruForm" enctype="multipart/form-data">
        <table align="center">
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr>
                <td>批量导入上师信息:</td>
                <td><input id="guruExeclFile" name="guruExeclFile"/></td>
            </tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr><td> </td><td> </td></tr>
            <tr align="center">
                <td colspan="2">
                    <a id="enAddBulkGuruForm">确认导入</a> &nbsp;&nbsp; <a id="unAddBulkGuruForm">取消</a>
                </td>
            </tr>
        </table>





    </form>