<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>

<body>
    <div style="height: 580px;padding:10px;background-image: linear-gradient(to top, #6fb0ff, #fffc9c)">
        <div>
            <form id="atl_fom" method="post">
                <p>文章标题：<input class="easyui-textbox" name="articleName" data-options="required:true" style="width: 200px"></p>
                <p>文章作者：<select id="sel"  class="easyui-combobox" name="guru.guruId"><option>--请选择--</option></select></p>
                <p>文章状态：<input class="easyui-switchbutton" name="articleStatus" data-options="width:70,onText:'上架中',offText:'已下架',checked:true, value:'on'"></p>
            </form>
        </div>
        <%--========================================================================================================--%>

        <div id="div1" class="toolbar">
        </div>
        <div style="padding: 5px 0; color: #ccc"></div>
        <div id="div2" class="text" style="background-color: white"> <!--可使用 min-height 实现编辑区域自动增加高度-->
            <p>请输入内容：</p>
        </div>

        <div style="float: right;margin-top: 7px">
            <a id="btn1"></a>
            <a id="btn2" style="margin-left: 20px;margin-right: 30px"></a>
        </div>

        <%--===================================================================================================--%>

        <script type="text/javascript" src="${pageContext.request.contextPath}/js/wangEditor.min.js"></script>
        <script type="text/javascript">
            var E = window.wangEditor;
            var editor = new E('#div1', '#div2');
            editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/article/uploadArticlePicture';
            editor.customConfig.uploadFileName = 'articlePictureFile'
            editor.create();

            document.getElementById('btn1').addEventListener('click', function () {
                textContent = editor.txt.html();
            }, false)

            $(function () {

                $('#btn1').linkbutton({
                    text:'创建文章',
                    iconCls:'icon-script_add',
                    onClick:function () {
                        $('#atl_fom').form('submit',{
                            url:"${pageContext.request.contextPath}/article/addArticle",
                            queryParams:{"articleIntro":textContent},
                            onSubmit:function(){
                                return $('#atl_fom').form('validate');
                            },
                            success:function (res) {
                                if(res=="noMasterError"){
                                    alert('请选择作者！');
                                    return;
                                }
                                if(res=="ok"){
                                    editor.txt.clear();
                                    $('#atl_fom').form('reset');
                                    $.messager.show({
                                        height:90,
                                        title:'我的消息',
                                        msg:'添加成功，此消息将在5s后关闭！',
                                        timeout:5000,
                                        showType:'slide',
                                    });
                                }else{
                                    $.messager.alert('错误提示！','添加失败，请重新尝试！','error');
                                }
                            }
                        })
                    }
                });
                $('#btn2').linkbutton({
                    text:'重置内容',
                    iconCls:'icon-clear',
                    onClick:function () {
                        editor.txt.clear()
                    }
                })


                $('#sel').combobox({
                    editable:false,
                    width:100,
                    url:"${pageContext.request.contextPath}/guru/searchAll",
                    valueField:'guruId',
                    textField:'guruName',
                });
            })
        </script>

    </div>
</body>

